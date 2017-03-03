class Node(object):
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None
        self.previous = None
class LRUCache(object):

    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.capacity = capacity - 1
        self.cache = dict()
        self.head = Node(0, 0)
        self.tail = Node(0, 0)
        self.head.previous = None
        self.head.next = self.tail
        self.tail.previous = self.head
        self.tail.next = None

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        if key in self.cache:
            node = self.cache[key]
            self._remove(node)
            self._add(node)

            return node.value
        else:
            return -1


    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: void
        """
        if key in self.cache:
            self.cache[key].value = value
            self._remove(self.cache[key])
            self._add(self.cache[key])
        else:
            if len(self.cache) > self.capacity:
                node_to_remove = self.tail.previous
                self._remove(node_to_remove)
                del self.cache[node_to_remove.key]

            new_node = Node(key, value)
            self.cache[key] = new_node
            self._add(new_node)

    def _remove(self, node):
        node.previous.next = node.next
        node.next.previous = node.previous


    def _add(self, node):
        node.next = self.head.next
        self.head.next.previous = node
        self.head.next = node
        node.previous = self.head



# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)

obj = LRUCache(2)
obj.put(1, 1)
obj.put(2, 2)
print(obj.get(1))
obj.put(3, 3)
print(obj.get(2))
obj.put(4, 4)
print(obj.get(1))
print(obj.get(3))
print(obj.get(4))
