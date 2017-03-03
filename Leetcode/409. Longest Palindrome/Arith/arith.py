"""Longest Palindrome"""

class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """
        characters = {}
        for k in s:
            if k not in characters:
                characters[k] = 1
            else:
                characters[k] += 1

        odd = 0
        result = 0
        for k, v in characters.iteritems():
            if 0 == v % 2:
                result += v
            else:
                odd = v
                result += (v - 1)

        if odd != 0:
            result += 1

        return result

s = Solution()
print s.longestPalindrome("")
