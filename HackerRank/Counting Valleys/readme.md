# Counting Valleys

## 문제

[Counting Valleys](https://www.hackerrank.com/challenges/counting-valleys/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup) : 로그인 필요.

## 내 풀이

> JS

```js
function countingValleys(steps, path) {
  let depth = 0;
  let valley = 0;
  let upDown = "";

  for (let i = 0; i < steps; i++) {
    if (path[i] === "U") depth += 1;
    else depth -= 1;

    if (depth > 0) {
      upDown = "up";
    } else if (depth < 0) {
      upDown = "down";
    }

    if (depth === 0 && upDown === "down") {
      valley += 1;
    }
  }

  return valley;
}
```

## 다른 사람 풀이

> Python

```python
height = 0
prev_height = 0
cnt = 0
n = input()
s = raw_input().strip()
for i in range(len(s)):
    if (s[i] == 'U'):
        height += 1
    elif s[i] == 'D':
        height -= 1
    if height == 0 and prev_height < 0:
        cnt += 1
    prev_height = height
print cnt
```

## 리뷰

다른 사람의 풀이를 보면 이전 높이를 저장하는 변수를 만들어서 계곡의 수를 카운트할 때 이전 높이가 0 미만이라면 카운트할 수 있게 작성한 것을 볼 수 있었다.

내 코드에서

```js
if (depth > 0) {
  upDown = "up";
} else if (depth < 0) {
  upDown = "down";
}
```

이 부분을 1줄로 줄일 수 있고 if문을 사용하지 않을 수 있었다.
다음에 이와 같은 문제가 있다면 이전 값을 고려하여 코딩하자.

[수정]

```js
function countingValleys(steps, path) {
  let depth = 0;
  let valley = 0;
  let prev_depth = 0;

  for (let i = 0; i < steps; i++) {
    if (path[i] === "U") depth += 1;
    else depth -= 1;
    if (depth === 0 && prev_depth < 0) {
      valley += 1;
    }
    prev_depth = depth;
  }

  return valley;
}
```
