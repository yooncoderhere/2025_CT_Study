import sys

class Solution(object):
    def findRadius(self, houses, heaters):
        houses.sort()
        heaters.sort()

        p = 0
        min_value = 0

        for house in houses:
            while p < len(heaters) - 1 and abs(heaters[p + 1] - house) <= abs(heaters[p] - house):
                p += 1
            min_value = max(min_value, abs(heaters[p] - house))

        return (min_value)
