# Hash Tables: Ransom Note

## 문제

[Hash Tables: Ransom Note](https://www.hackerrank.com/challenges/ctci-ransom-note/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps) : 로그인 필요.

## 내 풀이

> JS (Fail : Time Limit)

```js
/*
 * Complete the 'checkMagazine' function below.
 *
 * The function accepts following parameters:
 *  1. STRING_ARRAY magazine
 *  2. STRING_ARRAY note
 */
function checkMagazine(magazine, note) {
  let count = 0;

  note.map((element) => {
    for (let i = 0; i < magazine.length; i++) {
      if (element === magazine[i]) {
        magazine[i] = null;
        count++;
        break;
      }
    }
  });

  note.length === count ? console.log("Yes") : console.log("No");
}
```

## 다른 사람 풀이

> JS

```js
function checkMagazine(magazine, note) {
  let map = {};
  let isReplicable = true;
  // magazine배열을 object로 초기화한다.
  // (map[i] || 0) + 1 : 해당 키를 i로 지정하고 해당 키의 값이 없다면 0으로 초기화 후 1을 더하고, 값이 있다면(즉, 동일한 단어가 나온다면) 값을 가져와 1을 더한다.
  for (let i of magazine) {
    map[i] = (map[i] || 0) + 1;
  }
  // note 배열에 있는 값을 가져와 위에 동일한 작업을 진행하는데 여기서는 1을 빼준다. 즉, magazine에 없는 단어라면 초기값은 -1.
  for (var i of note) {
    map[i] = (map[i] || 0) - 1;
  }
  // if (map[i] < 0){...} : map[i]이 0미만이라면 magazine 배열에 note 배열의 값이 포함되지 않거나, 더 많은 단어를 가지고 있다는 의미이므로 isReplicable(복제 여부)의 값을 false로 바꾼 뒤 break한다.
  for (var i in map) {
    if (map[i] < 0) {
      isReplicable = false;
      break;
    }
  }

  console.log(isReplicable ? "Yes" : "No");
}
```

## 리뷰

문제에도 Hash Tables을 사용하라고 했지만 바보같이도 loop문을 이용해서만 풀려고 했다. 결국, Time Limit 문구를 보게 됐다. 특정값을 찾을 때는 키와 값을 갖는 Hash Tables의 속도가 상당히 빠르다라는 걸 알고 있었으나 사용할 줄 몰랐다. 다음엔 꼭 생각하고 사용하자.

### +)

```js
note.length === count ? console.log("Yes") : console.log("No"); //(X)
console.log(note.length === count ? "Yes" : "No"); //(O)
```
