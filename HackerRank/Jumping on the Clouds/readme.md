# Jumping on the Clouds

## 문제

[Jumping on the Clouds](https://www.hackerrank.com/challenges/30-2d-arrays/problem) : 로그인 필요.

## 내 풀이

> JS

```js
/* 
  #param c(dataType array) : ex) [0,0,1,0,1,0]
  #return integer  
*/
function jumpingOnClouds(c) {
  // Write your code here
  let count = 0;

  for (let i = 0; i < c.length; i++) {
    if (c[i] !== 1) {
      if (c[i] === c[i + 2]) {
        i += 1;
        count++;
      } else if (c[i] === c[i + 1]) {
        count++;
      }
    }
  }

  return count;
}
```

## 리뷰

점프는 1번에서 2번만 가능하므로,

(공통) 현재 구름이 적운이 아닐 때

1. 현재 구름과 2번 점프했을 때 구름이 같다면 카운트를 센다.

2. 현재 구름과 2번 점프했을 때 구름이 다르지만 1번 점프했을 때 구름과 같다면 카운트를 센다.

defalut. 위에 해당 사항이 없다면 1~2번 점프한 구름이 적운이므로 다음 구름으로 비교한다.
