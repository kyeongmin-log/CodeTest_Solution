# Two Strings

## 문제

[Two Strings](https://www.hackerrank.com/challenges/two-strings/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps) : 로그인 필요.

## 내 풀이

> JS

```js
/*
 * Complete the 'twoStrings' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts following parameters:
 *  1. STRING s1
 *  2. STRING s2
 */

function twoStrings(s1, s2) {
  // Write your code here
  let map = {};
  s1 = Array.from(s1);
  s2 = Array.from(s2);

  for (let key of s1) {
    map[key] = 0;
  }
  for (let key of s2) {
    if (key in map) {
      return "YES";
    }
  }
  return "NO";
}
```

## 리뷰

Hash Tables-Ransom Note과 유사한 문제여서 크게 어렵지 않았다.

+)

```js
// map(object)에서 key 확인
console.log([key값] in map); //true or false

// map(object)에서 value 확인
console.log(Object.values(map).includes([value값])); //true or false
```

+) 코드 리뷰 진행 후 코드 변경

> 변경 전

```js
for (let key of s1) {
  map[key] = (map[key] || 0) + 1;
}
for (let key of s2) {
  if (key in map) {
    map[key] = true;
  }
}

return Object.values(map).includes(true) ? "YES" : "NO";
```

> 변경 후

```js
for (let key of s1) {
  map[key] = 0;
}
for (let key of s2) {
  if (key in map) {
    return "YES";
  }
}
return "NO";
```

Hash Tables-Ransom Note의 영향을 너무 받았던 거 같다.

굳이 1을 더할 필요도 없고 key의 value값을 true로 바꿀 필요도 없었다.

map keys안에 s2의 key값이 있다면 "YES"를 return 없다면 "NO"를 return한다.
필요없는 반복을 하지 말자.
