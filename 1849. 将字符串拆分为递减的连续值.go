func splitString(s string) bool {
	if len(s) < 2 {
		return false
	}

	var t int64
	for i := 0; i < len(s)-1; i++ {
		t = t*10 + int64(s[i]-'0')
		if dfs(s, i+1, t-1) {
			return true
		}
	}

	return false
}

func dfs(s string, index int, target int64) bool {
	if index == len(s) {
		return true
	}

	var t int64
	for i := index; i < len(s); i++ {
		t = t*10 + int64(s[i]-'0')
		if t == target {
			if target == 0 {
				return dfs(s, i+1, 0)
			}
			return dfs(s, i+1, t-1)
		} else if t > target {
			return false
		}
	}

	return false
}