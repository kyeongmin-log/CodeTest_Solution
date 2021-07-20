# Insert a node at a specific position in a linked list

## 문제

[Insert a node at a specific position in a linked list](https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=linked-lists) : 로그인 필요.

## 내 풀이

> JS

```js
/*
 *
 * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
 * The function accepts following parameters:
 *  1. INTEGER_SINGLY_LINKED_LIST llist
 *  2. INTEGER data
 *  3. INTEGER position
 */

/*
 * For your reference:
 *
 * SinglyLinkedListNode {
 *     int data;
 *     SinglyLinkedListNode next;
 * }
 *
 */

function insertNodeAtPosition(llist, data, position) {
  // Write your code here
  let head = llist;
  let i = 0;

  while (head.next != null) {
    if (i === position - 1) {
      const newNode = new SinglyLinkedListNode(data);
      newNode.next = head.next;
      head.next = newNode;
    }
    head = head.next;
    i++;
  }

  return llist;
}
```

# 리뷰

얕은 복사를 한 데이터에서 값을 변경하면 기존 파일의 값도 변경된다.

이를 이용하여 연결리스트 중간에 값을 넣을 수 있다.

풀면서 느낀 건 마지막 원소를 참조한다면 큐로 만들 수 있을 거 같다.
