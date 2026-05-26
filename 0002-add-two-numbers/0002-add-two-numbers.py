# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        carry = 0
        dummy = ListNode(0)
        cur = dummy

        while l1 or l2 or carry > 0:
            firstVal = l1.val if l1 != None else 0
            secondVal = l2.val if l2 != None else 0
            sum = firstVal + secondVal + carry
            cur.next = ListNode(sum%10)

            cur = cur.next
            carry = sum //10
            if l1 != None:
                l1 = l1.next
            if l2 != None:
                l2 = l2.next

        return dummy.next