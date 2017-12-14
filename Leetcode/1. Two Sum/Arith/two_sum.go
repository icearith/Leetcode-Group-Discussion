package main

import (
	"fmt"
)

func twoSum(nums []int, target int) []int {
	m := make(map[int]int)
	for index, element := range nums {
		fmt.Println(index, element)
		complement := target - element
		index_c, exists := m[complement]
		if exists {
			return []int{index_c, index}
		}
		m[element] = index
	}

	return nil
}

func main() {
	var nums = []int{1, 2, 3}
	var target int = 3
	r := twoSum(nums, target)
	fmt.Println(r)
}
