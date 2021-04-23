import container/list

// 给定编号从 0 到 n-1 的 n 个节点和一个无向边列表（每条边都是一对节点），
// 请编写一个函数来计算无向图中连通分量的数目。
func CountComponents(n int, edges [][]int) int {
	// 1. 构建图
	adj := make([int]*List, n)
	for i := 0; i < n; i++ {
		adj[i] = list.New()
	}
	// 2. 无向图，所以需要添加双向引用
	for _, edge := range edges {
		adj[edge[0]].PushBack(edge[1])
		adj[edge[1]].PushBack(edge[0])
	}
}

func bfs(adj [int][]int, u int, visited []bool) {
	queue := new(list)
}
