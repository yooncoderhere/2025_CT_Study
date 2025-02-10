class Solution(object):
    def longestConsecutive(self, nums):
        if not nums:
            return 0

        num = set(nums)
        longest_streak = 0

        for i in num:
            if i - 1 not in num:
                current_num = i
                current_streak = 1

                while current_num + 1 in num:
                    current_num += 1
                    current_streak += 1

                longest_streak = max(longest_streak, current_streak)

        return longest_streak