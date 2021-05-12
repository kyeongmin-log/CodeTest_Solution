# Repeated String

## 문제

[Repeated String](https://www.hackerrank.com/challenges/repeated-string/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup) : 로그인 필요.

## 풀이

> parametar and retrun description

```
/*
 * Complete the 'repeatedString' function below.
 *
 * The function is expected to return a LONG_INTEGER.
 * The function accepts following parameters:
 *  1. STRING s
 *  2. LONG_INTEGER n
 */
```

> by oneself : fail (2 hours time limit)

```js
function repeatedString(s, n) {
  // Write your code here
  let count;
  let repeatedStr = [];

  s = s.split("");
  while (repeatedStr.length != n) {
    s.map((ch) => {
      if (repeatedStr.length !== n) repeatedStr.push(ch);
    });
  }

  return repeatedStr.filter((ch) => ch === "a").length;
}
```

> others code reference

```js
function repeatedString(s, n) {
  // Write your code here
  const remainder = n % s.length;
  let count = 0;
  let remainderA = 0;

  for (let i = s.length; i-- > 0; ) {
    if (s.charAt(i) === "a") {
      count++;
      if (i < remainder) remainderA++;
    }
  }

  return ((n - remainder) / s.length) * count + remainderA;
}
```

## 리뷰

> 내 코드의 문제

우선 내가 짠 코드를 돌리면 n = 10^12일 경우의 테스트 케이스가 돌아가지 않는다.

JS에서 문자열에 10^12의 문자를 담지 못하기에 발생하는 문제였다.

2시간동안 고민해보았지만 해결하지 못하여 다른 분의 코드를 분석한 뒤 코드를 작성하였다.

> 해결방안

다른 분의 코드에서 중요한 건 반복된 문자열을 굳이 만들 필요가 없다는 것.

n을 s.length로 나누어 나머지를 구한다.

이는 부분 반복된 부분을 구하기 위해서다.

> 예를 들어, aba를 10까지 반복하면 abaabaabaa가 되는데 여기서 문자열 s의 반복이 3번되고 마지막 aba문자열에서 첫번째 인덱스만 반복된 것을 볼 수 있다. 이러한 부분에서 a의 여부를 알기위해 구해놓는다.

이후 loop문을 통해 문자열 s에서 a값을 count한다. 부분 반복된 문자열에서 찾은 a의 값은 remainderA에서 센다.

마지막으로, return 부분에서 ((n - remainder) / s.length) 통해 **반복 횟수**를 구할 수 있으며,

(반복횟수\*count)를 통해 반복된 문자열에서 a값을 찾을 수 있고

부분 반복된 부분에서 a를 센 remainderA를 더하여 return한다.
