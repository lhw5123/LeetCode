// 判断字符串是否所有的字符都不同
func isUniqueStr(s string) bool {
	if strings.Count(s, "") > 3000 {
		return false
	}

	for k, v := range s {
		if v > 127 {
			return false
		}
		// strings.Index return the index of the first instance of substr in s,
		// or -1 if substr is not present in s.
		if strings.Index(s, string(v)) != k {
			return false
		}
	}
	return true
}