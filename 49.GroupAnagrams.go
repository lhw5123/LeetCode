func groupAnagrams(strs []string) [][]string {
	record, res := map[string][]string{}, [][]string{}

	for _, s := range strs {
		sBytes := []rune(s)
		sort.Sort(sortRunes(sBytes))
		sortedStrs := record[string(sBytes)]
		sortedStrs = append(sortedStrs, s)
		record[string(sBytes)] = sortedStrs
	}

	for _, v := range record {
		res = append(res, v)
	}

	return res
}

type sortRunes []rune

func (s sortRunes) Less(i, j int) bool {
	return s[i] < s[j]
}

func (s sortRunes) Swap(i, j int) {
	s[i], s[j] = s[j], s[i]
}

func (s sortRunes) Len() int {
	return len(s)
}
