# Sales by Match

## 문제

[Sales by Match](https://www.hackerrank.com/challenges/sock-merchant/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup) : 로그인 필요.

## 내 풀이

```java script
function sockMerchant(n, ar) {
    let count = 0;

    for(let i=0;i<n;i++){
        // 유효범위 외에 수는 미리 종료시킨다.
        if(ar[i] < 1 || ar[i] > 100){
            continue;
        }
        for(let j=i+1;j<n;j++){
            // 같은 숫자가 나오면 해당 값을 0으로 바꾸고 해당 루프를 멈춘다.
            if(ar[i] == ar[j]){
                count++;
                ar[i] = 0;
                ar[j] = 0;
                break;
            }
        }
    }

    return count;
}
```

## 다른 사람 풀이

### sort 사용

```java script
function sockMerchant(n, ar) {
var res = 0;
    ar.sort();
    for(let i=0; i<n;i++){
        if(ar[i] == ar[i+1]){
            i++; //같은 값이면 하나를 증가시킴.
            res++;
           }
    }
return res;
}
```

## 리뷰

- 다른 사람의 풀이를 보면 sort()를 이용하여 정렬하고 현재 값과 다음 값이 같으면 i값을 증가시켜 넘긴다. 이렇게 하면 loop문을 하나 줄일 수 있다.

  - array api를 적극적으로 활용해보자.
  - 하나의 loop문으로 풀 수 있는 지 고민해보자.

- 내가 작성한 코드의 수를 좀 더 줄일 수 있었다는 생각이 들었다.
  - continue가 필요한가?
  - ar[i]는 이미 지나간 수인데 굳이 0을?

```java script
//수정
function sockMerchant(n, ar) {
    let count = 0;

    for(let i=0;i<n;i++){
        if(!(ar[i] < 1 || ar[i] > 100)){
            for(let j=i+1;j<n;j++){
                if(ar[i] == ar[j]){
                    count++;
                    ar[j] = 0;
                    break;
                }
            }
        }
    }

    return count;
}
```

불필요한 continue와 변수 대입을 제거하였다.
