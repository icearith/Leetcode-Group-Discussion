package main

import "fmt"

func isPalindrome(x int) bool {
	if x < 0 || (x != 0 && x%10 == 0) {
		return false
	}
	var rev = 0

	for x > rev {
		rev = rev*10 + x%10
		x = x / 10
	}

	return (x == rev) || (x == rev/10)
}

func main() {
	fmt.Println(isPalindrome(121), "should be True")
	fmt.Println(isPalindrome(10), "should be False")
	fmt.Println(isPalindrome(101), "should be True")
}
