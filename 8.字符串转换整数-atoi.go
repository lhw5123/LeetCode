package main

import (
	"math"
	"strings"
)

/*
 * @lc app=leetcode.cn id=8 lang=golang
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
func myAtoi(s string) int {
	return convert(clean(s))
}

func clean(s string) (sign int, abs string) {
	s = strings.TrimSpace(s)
	if s == "" {
		return
	}

	switch s[0] {
	case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9':
		sign, abs = 1, s
	case '+':
		sign, abs = 1, s[1:]
	case '-':
		sign, abs = -1, s[1:]
	default:
		abs = ""
		return
	}

	for i, b := range abs {
		if b < '0' || b > '9' {
			abs = abs[:i]
			break
		}
	}

	return
}

func convert(sign int, absStr string) int {
	absNum := 0
	for _, b := range absStr {
		absNum = absNum*10 + int(b-'0')
		// 溢出检查
		switch {
		case sign == 1 && absNum > math.MaxInt32:
			return math.MaxInt32
		case sign == -1 && absNum*sign < math.MinInt32:
			return math.MinInt32
		}
	}
	return sign * absNum
}
