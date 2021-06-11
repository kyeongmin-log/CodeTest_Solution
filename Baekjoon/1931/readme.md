# 회의실 배정

## 문제

[회의실 배정](https://www.acmicpc.net/problem/1931)

## 내 풀이

> JS

```js
function solution(arr) {
  //회의가 없거나 하나인 경우
  if (arr.length === 0) return 0;
  if (arr.length === 1) return 1;

  arr.sort((a, b) => a[1] - b[1] || a[0] - b[0]);
  let end = arr[0][1]; //정렬된 값에서 첫번째 종료값
  let cnt = 1; //회의가 1개 이상은 있으므로 1로 초기화

  for (let i = 1; i < arr.length; i++) {
    if (arr[i][0] >= end) {
      //현재 회의에서 끝나는 시간보다 시작 시간이 같거나 큰 회의를 찾음
      end = arr[i][1]; //end값을 찾은 회의에 끝나는 시간으로 대입
      cnt++;
    }
  }

  return cnt;
}

(function main() {
  const arr = [[1, 4],[3, 5],[0, 6],[5, 7],[3, 8],[5, 9],[6, 10],[8, 11],[8, 12],[2, 13],[12, 14],[4, 7],[2, 8]]; //prettier-ignore
  const arr2 = [[1,2],[2,4],[2,2]]; //prettier-ignore
  const arr3 = [[1,4],[2,6],[4,7]]; //prettier-ignore
  const result = solution(arr);
  const result2 = solution(arr2);
  const result3 = solution(arr3);
  //TestCase
  console.log(result === 4);
  console.log(result2 === 3);
  console.log(result3 === 2);
})();
```

## 리뷰

고민했던 부분은 정렬을 어떤 식으로 하나였다.

처음에는 회의 시작 시간으로 정렬을 했으나 [0, 6],[3, 8],[2, 13]

이런 값처럼 회의 시작 시간은 빠르지만 회의를 너무 오래하기에 회의실을 최대로 배정할 수 없는 문제가 생겼다.

문제를 해결하기위해 회의가 끝나는 시간으로 생각해보니 끝나는 시간이 빠를수록 다음 회의를 진행할 수 있기에

회의 끝나는 시간을 기준으로 정렬을 하여 문제를 해결하였다.
