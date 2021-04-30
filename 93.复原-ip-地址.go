/*
 * @lc app=leetcode.cn id=93 lang=golang
 *
 * [93] 复原IP地址
 */

// @lc code=start
const SegCount = 4

func restoreIpAddresses(s string) []string {
	if s == "" {
		return []string{}
	}

	var ans []string
	segments := make([]int, SegCount)
	dfs(s, 0, 0, &segments, &ans)
	return ans
}

func dfs(s string, segIndex, segStart int, segments *[]int, ans *[]string) {
	if segIndex == SegCount {
		if segStart == len(s) {
			ipAddr := strconv.Itoa((*segments)[0])
			for i := 1; i < SegCount; i++ {
				ipAddr += fmt.Sprintf(".%d", (*segments)[i])
			}
			*ans = append(*ans, ipAddr)
		}
		return
	}

	if segStart == len(s) {
		return
	}

	if s[segStart] == '0' {
		(*segments)[segIndex] = 0
		dfs(s, segIndex+1, segStart+1, segments, ans)
		return
	}

	addr := 0
	for segEnd := segStart; segEnd < len(s); segEnd++ {
		addr = addr*10 + int(s[segEnd]-'0')
		if addr <= 0 || addr > 255 {
			break
		}

		(*segments)[segIndex] = addr
		dfs(s, segIndex+1, segEnd+1, segments, ans)
	}
}

// @lc code=end

