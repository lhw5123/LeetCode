import (
	"strconv"
	"strings"
)

/*
 * @lc app=leetcode.cn id=468 lang=golang
 *
 * [468] 验证IP地址
 */

// @lc code=start
func validIPAddress(IP string) string {
	if strings.Count(IP, ".") == 3 {
		return validIPv4(IP)
	} else if strings.Count(IP, ":") == 7 {
		return validIPv6(IP)
	} else {
		return "Neither"
	}
}

func validIPv4(IP string) string {
	segments := strings.Split(IP, ".")
	if len(segments) != 4 {
		return "Neither"
	}

	for _, seg := range segments {
		if len(seg) == 0 {
			return "Neither"
		}

		// 不能有前导 0
		if string(seg[0]) == "0" && len(seg) > 1 {
			return "Neither"
		}

		num, err := strconv.Atoi(seg)
		if err != nil {
			return "Neither"
		}

		if num < 0 || num > 255 {
			return "Neither"
		}
	}

	return "IPv4"
}

func validIPv6(IP string) string {
	segments := strings.Split(IP, ":")
	if len(segments) != 8 {
		return "Neither"
	}

	for _, seg := range segments {
		if len(seg) == 0 || len(seg) > 4 {
			return "Neither"
		}

		for _, ch := range seg {
			s := string(ch)
			if (s >= "0" && s <= "9") || (s >= "A" && s <= "F") || (s >= "a" && s <= "f") {
				continue
			} else {
				return "Neither"
			}
		}
	}

	return "IPv6"
}

// @lc code=end

