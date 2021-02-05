/*
 * @lc app=leetcode.cn id=803 lang=golang
 *
 * [803] 打砖块
 */

// @lc code=start
// tag: 并查集
// TODO
func hitBricks(grid [][]int, hits [][]int) []int {
	if len(hits) == 0 {
		return []int{}
	}

	m := len(grid)    // rows
	n := len(grid[0]) // columns

	for _, hit := range hits {
		grid[hit[0]][hit[1]] = 0
	}

	size := m * n
	uf := UnionFind{}
	uf.Init(size + 1)

	// 将下标为 0 的这一行的砖块与「屋顶」相连
	for j := 0; j < n; j++ {
		if grid[0][j] == 1 {
			uf.Union(j, size)
		}
	}

	for i := 1; i < m; i++ {
		for j := 0; j < n; j++ {
			if grid[i][j] == 1 {
				if grid[i-1][j] == 1 {
					uf.Union(getIndex(i-1, j, n), getIndex(i, j, n))
				}
				if grid[i][j-1] == 1 {
					uf.Union(getIndex(i, j-1, n), getIndex(i, j, n))
				}
			}
		}
	}

	hitsLen := len(hits)
	result := make([]int, hitsLen)
	directions := [][]int{[]int{0, 1}, []int{1, 0}, []int{-1, 0}, []int{0, -1}}
	for i := hitsLen - 1; i >= 0; i-- {
		x := hits[i][0]
		y := hits[i][1]

		if grid[x][y] == 0 {
			continue
		}

		origion := uf.GetSize(size)

		if x == 0 {
			uf.Union(y, size)
		}

		for _, direction := range directions {
			newX := x + direction[0]
			newY := y + direction[1]

			if inArea(grid, newX, newY) && grid[newX][newY] == 1 {
				uf.Union(getIndex(x, y, n), getIndex(newX, newY, n))
			}
		}

		current := uf.GetSize(size)
		if current-origion-1 > 0 {
			result[i] = current - origion - 1
		}
		grid[x][y] = 1
	}

	return result
}

func inArea(grid [][]int, x, y int) bool {
	return x >= 0 && x < len(grid) && y >= 0 && y < len(grid[0])
}

// 二维坐标转成一维坐标
func getIndex(x, y int, cols int) int {
	return x*cols + y
}

type UnionFind struct {
	// 结点 x 的父结点是 parent[x]
	parent []int
	// 以当前结点为根结点的子树的结点总数
	size  []int
	count int
}

func (uf *UnionFind) Init(n int) {
	uf.count = n
	uf.parent = make([]int, n)
	uf.size = make([]int, n)
	for i := range uf.parent {
		uf.parent[i] = i
		uf.size[i] = 1
	}
}

// find the root of {p}.
func (uf *UnionFind) Find(p int) int {
	if p != uf.parent[p] {
		uf.parent[p] = uf.Find(uf.parent[p])
	}
	return uf.parent[p]
}

func (uf *UnionFind) Union(p, q int) {
	proot := uf.Find(p)
	qroot := uf.Find(q)
	if proot == qroot {
		return
	}

	uf.parent[proot] = qroot
	uf.size[qroot] += uf.size[proot]
}

func (uf *UnionFind) GetSize(x int) int {
	root := uf.Find(x)
	return uf.size[root]
}
