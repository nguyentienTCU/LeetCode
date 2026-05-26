"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        map = collections.defaultdict(lambda: Node(0))
        map[None] = None

        cur = head
        while cur:
            map[cur].val = cur.val
            map[cur].next = map[cur.next]
            map[cur].random = map[cur.random]
            cur = cur.next

        return map[head]