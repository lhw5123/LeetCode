package main

import (
	"fmt"
	"sync"
)

// 使用两个 coroutine 交替打印序列，一个打印数字，一个打印字母。
func main() {
	letter, number := make(chan bool), make(chan bool)
	wait := sync.WaitGroup{}

	go func() {
		i := 1
		for {
			select {
			case <-number:
				fmt.Print(i)
				i++
				letter <- true // 表示应该输出字母了
				break
			default:
				break
			}
		}
	}()

	wait.Add(1)

	go func(wait *sync.WaitGroup) {
		str := "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
		i := 0
		for {
			switch {
			case <-letter:
				if i >= len(str) {
					wait.Done() // 输出了所有字母
					return
				}

				fmt.Print(str[i : i+1])
				i++
				number <- true
				break
			default:
				break
			}
		}
	}(&wait)

	number <- true // 从输出数字开始
	wait.Wait()
	fmt.Printf("\n done")
}
