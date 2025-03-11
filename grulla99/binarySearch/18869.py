import sys
from collections import defaultdict

input = sys.stdin.readline

m, n = map(int, input().split())
universe = defaultdict(int)

for _ in range(m):
    planet = list(map(int, input().split()))

    sortedPlanet = sorted(list(set(planet)))

    rank = {sortedPlanet[i] : i for i in range(len(sortedPlanet))}
    v = tuple([rank[i] for i in planet])
    universe[v] += 1

sum = 0

for i in universe.values():
    sum += (i * (i-1)) // 2

print(sum)
