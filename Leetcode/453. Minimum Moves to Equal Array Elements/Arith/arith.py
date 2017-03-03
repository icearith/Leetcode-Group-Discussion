class Solution(object):
    def minMoves(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums.sort()
        result = 0
        for v in reversed(nums):
            if nums[0] == v:
                break
            result += (v - nums[0])

        return result
