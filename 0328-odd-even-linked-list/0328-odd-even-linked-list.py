# Definition for singly-linked list.
from typing import Optional
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def oddEvenList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        odd_dummy = ListNode(0,None)
        odd_current = odd_dummy

        even_dummy = ListNode(0,None)
        even_current = even_dummy

        is_odd = True
        # 홀수 노드
        while head:
            if is_odd :
                odd_current.next = head
                head = head.next
                odd_current = odd_current.next
                is_odd = False

            elif not is_odd:
                even_current.next = head
                even_current = even_current.next
                head = head.next
                is_odd = True


        even_current.next = None
        odd_current.next = even_dummy.next

        return odd_dummy.next

def printLinkedList(head):
    while head:
        print(head.val, end=" ")
        head = head.next
    print()

def test_oddEvenList():
    solution = Solution()

    # 테스트 케이스 1
    head1 = ListNode(1)
    head1.next = ListNode(2)
    head1.next.next = ListNode(3)
    head1.next.next.next = ListNode(4)
    head1.next.next.next.next = ListNode(5)

    print("Original List:")
    printLinkedList(head1)

    reordered_head1 = solution.oddEvenList(head1)
    print("Reordered List:")
    printLinkedList(reordered_head1)
    # 출력: 1 3 5 2 4

    # 테스트 케이스 2
    head2 = ListNode(2)
    head2.next = ListNode(1)
    head2.next.next = ListNode(3)
    head2.next.next.next = ListNode(5)
    head2.next.next.next.next = ListNode(6)
    head2.next.next.next.next.next = ListNode(4)
    head2.next.next.next.next.next.next = ListNode(7)

    print("Original List:")
    printLinkedList(head2)

    reordered_head2 = solution.oddEvenList(head2)
    print("Reordered List:")
    printLinkedList(reordered_head2)
    # 출력: 2 3 6 7 1 5 4

if __name__ == "__main__":
    test_oddEvenList()