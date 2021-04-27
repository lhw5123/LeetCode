import (
	"fmt"
	"strconv"
)

/*
 * @lc app=leetcode.cn id=93 lang=golang
 *
 * [93] 复原IP地址
 */

// @lc code=start

const SEG_COUNT = 4

var (
	ans      []string
	segments []int
)

func restoreIpAddresses(s string) []string {
	if s == "" {
		return []string{}
	}

	segments = make([]int, SEG_COUNT)
	ans = []string{}
	dfs(s, 0, 0)
	return ans
}

// 处理一个块，从 segStart 到 s 结束。
func dfs(s string, segIndex, segStart int) {
	if segIndex == SEG_COUNT {
		if segStart == len(s) {
			ipAddr := strconv.Itoa(segments[0])
			for i := 1; i < SEG_COUNT; i++ {
				ipAddr += fmt.Sprintf(".%d", segments[i])
			}
			ans = append(ans, ipAddr)
		}
		return
	}

	if segStart == len(s) {
		return
	}

	// 如果以 0 开头，那这个区块就只能是“0”了。
	if s[segStart] == '0' {
		segments[segIndex] = 0
		dfs(s, segIndex+1, segStart+1)
	}

	addr := 0
	for segEnd := segStart; segEnd < len(s); segEnd++ {
		addr = addr*10 + int(s[segEnd]-'0')
		if addr > 0 && addr <= 255 {
			segments[segIndex] = addr
			dfs(s, segIndex+1, segEnd+1)
		} else {
			break
		}
	}
}
