# 1. Two Sum

## 문제

https://leetcode.com/problems/two-sum/

## 내 풀이

```java
    public int[] twoSum(int[] nums, int target) {
        int[] output = null;

        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j] == target){
                    output = new int[2];
                    output[0] = i;
                    output[1] = j;
                }
            }
        }

        if(output == null){
            return null;
        }
        else{
            return output;
        }
    }
```

## 사이트 풀이

### 1. Brute Force(무차별 대입)

```java
public int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] == target - nums[i]) {
                return new int[] { i, j };
            }
        }
    }
    throw new IllegalArgumentException("No two sum solution");
}
```

### 2. Two-pass Hash Table

```java
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        map.put(nums[i], i);    //  해시 맵에 index value을 key로, index key를 value로 put한다.
    }
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];  //  target에서 nums[i]를 빼서 complement에 대입.
        if (map.containsKey(complement) && map.get(complement) != i) { //   complement 키 값이 해당 map안에 있고 해당 키의 값을 get했을 때 동일한 index가 아닌지 비교한다.
            return new int[] { i, map.get(complement) };    //  위 조건에 만족한다면 해당 index와 complement의 값(nums index값)을 int[]로 return 한다.
        }
    }
    throw new IllegalArgumentException("No two sum solution");  //  method에 부적절한 argument가 전달되었음을 나타내기 위해 발생.
}
```

### 3. One-pass Hash Table

```java
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement)) {
            return new int[] { map.get(complement), i };
        }
        map.put(nums[i], i);
    }
    throw new IllegalArgumentException("No two sum solution");
}
```

## 리뷰

```java
throw new IllegalArgumentException("No two sum solution");
```

- 내 방식에 비해 해당 방식이 좀 더 간결한 예외값 처리가 가능하다. (써먹자!)
- 해시 테이블에 대해 익숙하지가 않다. 해시 테이블을 쓰자는 생각도 못했다. (해시 테이블 공부.)

## 해시 테이블(hash table), 해시 맵(hash map)

![img](https://upload.wikimedia.org/wikipedia/commons/thumb/7/7d/Hash_table_3_1_1_0_1_0_0_SP.svg/220px-Hash_table_3_1_1_0_1_0_0_SP.svg.png)

< 출처 : https://ko.wikipedia.org/wiki/%ED%95%B4%EC%8B%9C_%ED%85%8C%EC%9D%B4%EB%B8%94 >

- 키를 값에 매핑할 수 있는 구조인, 연관 배열 추가에 사용되는 자료 구조

### 2. Hash Table 코드 분석

Map<Integer, Integer> map = new HashMap<>(); : hash map <Integer, Integer> 생성

map.containsKey(Object key) : 지정된 객체가 해시 테이블의 키인가 어떤가를 판정합니다.

map.get(Object key) : 지정된 키에 맵핑 되고 있는 해시 테이블의 값을 리턴합니다.

map.put(K key, V value) : 해시 테이블에 대해, 지정된 key를, 지정된 value에 맵 합니다.

- 인덱스 값을 해시 키로 만들고 인덱스를 해시 값으로 만든다.
