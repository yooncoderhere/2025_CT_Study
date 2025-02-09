var longestConsecutive = function (nums) {
    // 정렬
    nums.sort((a, b) => a - b);

    let cnt = 1; //연속된 시퀀스 길이 확인
    let max = 0; //가장 긴 시퀀스 길이 저장 변수

    for (let i = 1; i < nums.length; i++) {
        if (nums[i] === nums[i - 1]) continue; //두 숫자가 같은 경우 continue
        if (nums[i - 1] + 1 === nums[i]) {
            //연속된 경우
            cnt++; //cnt 1 증가
        } else {
            max = Math.max(max, cnt); // max와 min 비교
            cnt = 1; //cnt 초기화
        }
    }
    //마지막까지 증가되는 경우 max가 업데이트되지 않으므로 한 번 더 업데이트트
    return Math.max(max, cnt);
};

console.log(longestConsecutive([0, 3, 7, 2, 5, 8, 4, 6, 0, 1]));
