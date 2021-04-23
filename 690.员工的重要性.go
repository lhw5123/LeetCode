/*
 * @lc app=leetcode.cn id=690 lang=golang
 *
 * [690] 员工的重要性
 */

// @lc code=start
/**
 * Definition for Employee.
 * type Employee struct {
 *     Id int
 *     Importance int
 *     Subordinates []int
 * }
 */

func getImportance(employees []*Employee, id int) int {
	employeeMap := make(map[int]*Employee)
	for _, v := range employees {
		employeeMap[v.Id] = v
	}

	queue := []*Employee{employeeMap[id]}
	count := 0
	for len(queue) > 0 {
		front := queue[0]
		queue = queue[1:]
		count += front.Importance
		for _, id := range front.Subordinates {
			queue = append(queue, employeeMap[id])
		}
	}

	return count
}

// @lc code=end

