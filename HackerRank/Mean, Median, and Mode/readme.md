# Mean, Median, and Mode

## 문제

[Mean, Median, and Mode](https://www.hackerrank.com/challenges/s10-basic-statistics/problem) : 로그인 필요.

## 내 풀이

> JS

```js
function calculateMean(inputLength, inputNumbers) {
  const mean = inputNumbers.reduce((acc, cur) => acc + cur) / inputLength;

  return mean;
}

function calculateMedian(inputLength, inputNumbers) {
  let median;

  if (inputLength % 2 === 0) {
    median =
      (inputNumbers[inputLength / 2] + inputNumbers[inputLength / 2 - 1]) / 2;
  } else {
    median = inputNumbers[Math.round(inputLength / 2)];
  }

  return median;
}

function calculateMode(inputLength, inputNumbers) {
  let sortable;
  let obj = {};
  inputNumbers.map((num) => (obj[num] = 0));

  inputNumbers.map((num) => {
    if (String(num) in obj) {
      obj[String(num)]++;
    }
  });

  sortable = Object.entries(obj).sort(([, a], [, b]) => b - a);

  return sortable[0][0];
}

function processData(input) {
  //Enter your code here
  const inputSplit = input.split("\n");
  const inputLength = parseInt(inputSplit[0]);
  const inputNumbers = inputSplit[1]
    .split(" ")
    .map((num) => parseInt(num))
    .sort((a, b) => a - b);
  let mean, median, mode;

  // Mean Code
  mean = calculateMean(inputLength, inputNumbers);
  console.log(mean);
  // Median Code
  median = calculateMedian(inputLength, inputNumbers);
  console.log(median);
  // Mode Code
  mode = calculateMode(inputLength, inputNumbers);
  console.log(mode);
}
```

## 리뷰

여러 api를 사용해볼 수 있어서 좋았다. map, reduce가 필요한 부분에 적극적으로 사용하자.

> Object.entries() : [키, 값] 쌍을 담은 배열을 반환.

```
> mode를 코딩할 때, object를 배열로 만들고 만든 배열을 정렬할 때 유용하였다.
```

> obj 명령어(in)

```js
    if(String(num) in obj){...} // 해당 오브젝트 안에 해당 키가 있는가?
```
