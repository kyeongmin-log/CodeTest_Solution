# 2D Arrays

## 문제

[2D Arrays](https://www.hackerrank.com/challenges/30-2d-arrays/problem) : 로그인 필요.

## 내 풀이

> JS

```js
function arraySum(arr) {
  const arrayLength = arr.length - 2;
  let sum = 0;
  let result;

  for (let i = 0; i < arrayLength; i++) {
    for (let j = 0; j < arrayLength; j++) {
      sum =
        arr[i][j] +
        arr[i][j + 1] +
        arr[i][j + 2] +
        arr[i + 1][j + 1] +
        arr[i + 2][j] +
        arr[i + 2][j + 1] +
        arr[i + 2][j + 2];
      if (sum > result || (i === 0 && j === 0)) {
        result = sum;
      }
    }
  }

  return result;
}

function main() {
  let result;
  let arr = Array(6);

  for (let i = 0; i < 6; i++) {
    arr[i] = readLine()
      .split(" ")
      .map((arrTemp) => parseInt(arrTemp, 10));
  }

  result = arraySum(arr);

  console.log(result);
}
```

## 다른 사람 풀이

> Java

```java
int sum[] = new int[16];
    int h = 0;
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
            sum[h] = arr[i][j] + arr[i][j+1] + arr[i][j+2]
                    + arr[i+1][j+1] + arr[i+2][j] + arr[i+2][j+1]
                    + arr[i+2][j+2];
            h++;
        }
    }
    Arrays.sort(sum);
    System.out.println(sum[15]);
```

## 리뷰

처음 문제를 풀 때 result 값을 0으로 초기화하고 풀었다. 테스트 케이스를 돌려보니 당연히 에러가 나왔다. -값이 나올 수도 있는데 0이랑 비교하니 당연히 결과가 0이 나왔다. 무언가를 더하는 문제에서는 -값도 나온다는 걸 생각하자.
