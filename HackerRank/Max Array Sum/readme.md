# Max Array Sum

## 문제

[Max Array Sum](https://www.hackerrank.com/challenges/max-array-sum/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dynamic-programming) : 로그인 필요.

## 내 풀이

- 풀지 못하였다...

## 다른분 풀이

> JS

```js
// Complete the maxSubsetSum function below.
function maxSubsetSum(arr) {
  if (arr.length === 0) return 0;
  arr[0] = Math.max(0, arr[0]);
  if (arr.length === 1) return arr[0];
  arr[1] = Math.max(arr[0], arr[1]);
  for (let i = 2; i < arr.length; i++) {
    arr[i] = Math.max(arr[i - 1], arr[i - 2] + arr[i]);
  }
  return arr[arr.length - 1];
}
```

## 리뷰

고민했던 부분은 성능과 늘어나는 부분 집합의 수 였고,

고민한 시간이 너무 길어 어쩔 수 없이 다른분의 풀이를 보고 이해하기로 하였다.

해당 문제를 찾아보니 Kadane's algorithm을 사용하는 것으로 알게 되었다.

우선 Kadane's algorithm을 이해하기 전에 Dynamic Programming을 먼저 이해하려고 한다.

```
Dynamic Programming이란, 간단히 말해서 값을 저장해 두었다가 재사용하는 기법이다.

1+1+1+1+1 문제의 답은 5다. 그럼 여기에 +1을 더하면 무엇일까?

다시 1+1+1+1+1을 하고 +1을 해야할까? 아니다. 그저 이전에 나온 결과에 1을 더하면 쉽게 구할 수 있다.

이처럼 이전에 사용한 값을 저장해두었다가 재사용하는 것을 다이나믹 프로그래밍이라고 하며, 풀어서 말하면 '시간을 절약하기 위해 어떤 것을 기억하는 프로그래밍'이다.
```

그럼 다시 Kadane's algorithm으로 돌아와서 이해하면

해당 알고리즘은 간단하게 말해서 현재 값에 이전 값와 현재 값 중 더 큰 값을 넣어주는 알고리즘이다.

위 문제에서 보자면 if문과 명령어를 통해 index의 0, 1의 값을 미리 처리를 해두고

index 2부터 이전 값과 이이전 값+현재 값을 max로 비교한 뒤에 더 큰 값을 현재값에 넣어준다.

이처럼 수행하게되면 현재에 더해줬던 값이 이전 값으로 재사용되므로 불필요한 반복을 줄일 수 있다.

loop가 끝나면 배열의 마지막 값은 가장 큰 부분 집합이 된다.

[[참고사이트 - 티스토리 블로그]](https://sustainable-dev.tistory.com/23)

[[참고사이트 - 위키피디아]](https://en.wikipedia.org/wiki/Maximum_subarray_problem)
