func findAnagrams(s string, p string) []int {
	var (
		freq = [256]int{}
		res  = []int{}
	)

	if len(s) == 0 || len(s) < len(p) {
		return res
	}

	for i := 0; i < len(p); i++ {
		freq[p[i]-'a']++
	}
	left, right, count := 0, 0, len(p)

	for right < len(s) {
		if freq[s[right]-'a'] >= 1 {
			count--
		}
		freq[s[right]-'a']--
		right++

		if count == 0 {
			res = append(res, left)
		}

		if right-left == len(p) {
			if freq[s[left]-'a'] >= 0 {
				count++
			}
			freq[s[left]-'a']++
			left++
		}
	}

	return res
}
