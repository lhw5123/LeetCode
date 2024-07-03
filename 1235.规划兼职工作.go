/*
 * We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].
 * You're given the startTime, endTime and profit arrays,
 * return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.
 * If you choose a job that ends at time X you will be able to start another job that starts at time X.
 *
 * Example:
 * Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
 * Output: 120
 * Explanation: The subset chosen is the first and fourth job.
 * Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.
 */

func jobScheduling(startTime []int, endTime []int, profit []int) int {
	n := len(startTime)
	jobs := make([][]int, n)
	for i := 0; i < n; i++ {
		jobs[i] = []int{startTime[i], endTime[i], profit[i]}
	}
	// sort by end time
	sort.Slice(jobs, func(i, j int) bool {
		return jobs[i][1] < jobs[j][1]
	})

	dp := [][]int{{0, 0}}

	for _, job := range jobs {
		start, end, profit := job[0], job[1], job[2]
		i := bisec(dp, start)
		newProfit := dp[i-1][1] + profit
		if newProfit > dp[len(dp)-1][1] {
			dp = append(dp, []int{end, newProfit})
		}
	}

	return dp[len(dp)-1][1]
}

func bisec(arr [][]int, target int) int {
	low, high := 0, len(arr)

	for low < high {
		mid := low + (high-low)/2
		if arr[mid][0] > target {
			high = mid
		} else {
			low = mid + 1
		}
	}

	return low
}

