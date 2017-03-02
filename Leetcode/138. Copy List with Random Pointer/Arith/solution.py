# Definition for singly-linked list with a random pointer.
class RandomListNode(object):

    def __init__(self, x):
        self.label = x
        self.next = None
        self.random = None


# Start of solution
class Solution(object):

    def copyRandomList(self, head):
        node = head
        m = {}
        while node != None:
            m[node] = RandomListNode(node.label)
            node = node.next

        node = head
        while node != None:
            m[node].next = None if node.next == None else m[node.next]
            m[node].random = None if node.random == None else m[node.random]
            node = node.next

        return None if head == None else m[head]
