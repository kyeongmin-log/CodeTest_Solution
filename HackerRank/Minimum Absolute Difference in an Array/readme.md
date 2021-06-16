# Minimum Absolute Difference in an Array

## 문제

[Minimum Absolute Difference in an Array](https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms) : 로그인 필요.

## 내 풀이

> return value and prameter value description

```
/*
 * Complete the 'minimumAbsoluteDifference' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts INTEGER_ARRAY arr as parameter.
 */
```

> JS : first(Time Limit)

```js
function minimumAbsoluteDifference(arr) {
  const copyArr = [...arr];
  const [arrLength, copyLegth] = [arr.length - 1, copyArr.length - 1];
  let result, min;

  arr.sort((a, b) => a - b);
  copyArr.sort((a, b) => b - a);

  for (let i = 0; i < arrLength; i++) {
    for (let j = 0; j < copyLegth - i; j++) {
      result = Math.abs(arr[i] - copyArr[j]);
      if (min > result || (i === 0 && j === 0)) min = result;
    }
  }

  return min;
}
```

> JS : second(good)

```js
function minimumAbsoluteDifference(arr) {
  const arrLength = arr.length - 1;
  const result = [];

  arr.sort((a, b) => a - b);

  for (let i = 0; i < arrLength; i++) {
    result.push(Math.abs(arr[i] - arr[i + 1]));
  }

  result.sort((a, b) => a - b);

  return result[0];
}
```

## 리뷰

처음에는 배열을 하나 복사하여

하나는 오름차순, 하나는 내림차순으로 정렬한 뒤

오름차순에서 내림차순의 값을 빼줬다.

결과는 맞았으나 double loop여서 시간이 너무 오래걸렸다.

시간 이슈를 해결하기 위해 생각해보니 결과값이 절대값이므로

인접한 두 수의 결과값이 가장 작은 걸 가져오면 되겠다는 생각이 들어

오름차순으로 정렬한 배열을 이용하여 두번째와 같이 해결하였다.
