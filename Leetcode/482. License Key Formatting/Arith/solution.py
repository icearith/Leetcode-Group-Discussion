class Solution(object):
    def __init__(self):
        self.result = ''
        self.count = 0
    def _insert_char(self, K, c):


        if c == '-':
            return

        c = c.upper()
        if self.count == K:
            self.count = 0
            self.result = '-' + self.result

        self.result = c + self.result
        self.count = self.count + 1

    def licenseKeyFormatting(self, S, K):
        """
        :type S: str
        :type K: int
        :rtype: str
        """

        for i in reversed(range(len(S))):
            self._insert_char(K, S[i])

        return self.result


s = Solution()
print(s.licenseKeyFormatting('2-4A0r7-4k', 3) )
s = Solution()
print(s.licenseKeyFormatting('2-4A0r7-4k', 4) )
