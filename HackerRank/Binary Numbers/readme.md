# Binary Numbers

## 문제

[Binary Numbers](https://www.hackerrank.com/challenges/30-binary-numbers/problem) : 로그인 필요.

## 내 풀이

> JS

```js
function createBinary(n) {
  let binary = [];
  let temp;

  while (n != 0) {
    temp = n % 2;
    binary.push(temp);
    n = parseInt(n / 2);
  }

  return binary;
}

function countConsecutiveOnes(binary) {
  let count = 0;
  let result = 0;

  binary.map((element) => {
    if (element === 1) {
      count += 1;
    } else {
      count = 0;
    }
    if (count > result) {
      result = count;
    }
  });

  return result;
}

function main() {
  const n = parseInt(readLine(), 10);

  const binary = createBinary(n);
  const result = countConsecutiveOnes(binary);

  console.log(result);
}
```

## 리뷰

JS의 숫자는 실수로 구분하기에 값을 나눌 경우 0,1 사이의 소수값이 계속 나오는 것을 알 수 있었다. parseInt() 함수를 사용하여 이를 해결하였지만 타입스크립트를 통해 데이터 타입을 미리 지정할 수 있었다면 좀더 가독성을 향샹시켰을 것이다. JS를 좀 더 배우고 리액트와 타입스크립트를 배워야겠다.

+(난 왜 JS로 자료구조와 알고리즘을 공부할까?)

> JS로 푸는 이유 : JS로 풀며 JS를 적극적으로 연습하자. 여러 함수와 api를 적극 활용해보자.
