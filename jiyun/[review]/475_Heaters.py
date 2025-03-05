import bisect

#이분 탐색은 보통 어떤 값의 최솟값 또는 최댓값을 구하는 문제
#1. 각 집마다 가장 가까운 히터를 찾음 
#2. 그 집에서 가장 가까운 히터까지의 거리 중 최대 거리를 "최소화"
#완전 탐색은 모든 집마다 모든 히터와의 거리를 구해야 하기 때문에 비효율적

def findRadius(houses, heaters):
    houses.sort()   # 집과 히터를 정렬
    heaters.sort()
    max_radius = 0  

    for house in houses:
        # 현재 집 위치를 기준으로 heaters 배열에서 이분 탐색 수행
        idx = bisect.bisect_left(heaters, house)
        
        # 가장 가까운 히터와의 거리 계산
        left_dist = abs(house - heaters[idx - 1]) if idx > 0 else float('inf')
        right_dist = abs(house - heaters[idx]) if idx < len(heaters) else float('inf')
        min_dist = min(left_dist, right_dist)

        # 최대 반경 갱신
        max_radius = max(max_radius, min_dist)

    return max_radius
