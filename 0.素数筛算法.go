package main

// 埃拉托斯特尼素数筛选法
// 算法描述：先用最小的素数 2 去筛，把 2 的倍数筛除；
// 下一个未筛除的数就是素数（这里是 3），然后再筛除 3 的倍数......
// 这样不断重复下去，知道筛完为止。
func main() {
	in := make(chan int)
	go Generate(in)
	// 输出 10 个素数
	for i := 0; i < 10; i++ {
		prime := <-in
		print(prime, "\n")
		out := make(chan int)
		// 筛选 10 轮，每经过一轮的筛选就能得到 1 个素数
		go Filter(in, out, prime)
		in = out
	}
}

func Generate(ch chan<- int) {
	for i := 2; ; i++ {
		ch <- i
	}
}

func Filter(in <-chan int, out chan<- int, prime int) {
	for {
		i := <-in
		if i%prime != 0 {
			out <- i
		}
	}
}
