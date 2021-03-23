# 9. Palindrome Number

## 문제

https://leetcode.com/problems/palindrome-number/

## 내 풀이

```java
    class Solution {
    public boolean isPalindrome(int x) {
        int pop,rev=0;
        int origin=x;

        if (x < 0 || x < -Math.pow(2,31) || (x > Math.pow(2,31)-1)) return false;

        while(x != 0){
            pop = x % 10;
            x /= 10;
            rev = rev * 10 + pop;
        }

        if(origin == rev){
            return true;
        }else{
            return false;
        }
    }
}
```

## 사이트 풀이(C#)

```C#
public class Solution {
    public bool IsPalindrome(int x) {
        // Special cases:
        // As discussed above, when x < 0, x is not a palindrome.
        // Also if the last digit of the number is 0, in order to be a palindrome,
        // the first digit of the number also needs to be 0.
        // Only 0 satisfy this property.
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
        // For example when the input is 12321, at the end of the while loop we get x = 12, revertedNumber = 123,
        // since the middle digit doesn't matter in palidrome(it will always equal to itself), we can simply get rid of it.
        return x == revertedNumber || x == revertedNumber/10;
    }
}
```

## 리뷰

이전 단계인 7. Reverse Integer은 풀지 못하여 사이트에 나온 솔루션을 배워 9. Palindrome Number을 풀었다.

공부한 내용은

```
pop = x % 10;
rev = rev * 10 + pop;
x /= 10;
```

이 부분이며, 이 부분을 통해 revers된 int 값을 얻을 수 있었다.

위 내용은 사이트 풀이를 적용하면

```
rev = rev * 10 + x % 10;
x /= 10;
```

으로 변수 한 개와 코드 1줄을 줄일 수 있다.
