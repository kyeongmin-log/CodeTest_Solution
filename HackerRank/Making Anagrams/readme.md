# Making Anagrams

## 문제

[Making Anagrams](https://www.hackerrank.com/challenges/ctci-making-anagrams/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings) : 로그인 필요.

## 내 풀이

> JS

```js
/*
 * Complete the 'makeAnagram' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. STRING a
 *  2. STRING b
 */

function makeAnagram(a, b) {
  let map = {};
  let sum = 0;

  for (let key of a) {
    map[key] = (map[key] || 0) + 1;
  }
  for (let key of b) {
    map[key] = (map[key] || 0) - 1;
  }
  for (let key in map) {
    if (map[key] !== 0) {
      sum += Math.abs(map[key]);
    }
  }

  return sum;
}
```

## 리뷰

해시 맵을 사용하여 해결하였다. 문자 비교 문제가 나올 시 해시 맵을 떠올려보자.
