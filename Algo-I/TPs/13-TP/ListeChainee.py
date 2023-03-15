class Node:
    def __init__(self, data, next):
        self.data = data
        self.next = next


class ListeChainee:
    def __init__(self, elements=None):
        """Construct the linked-list. Optionally pre-filled with the given list of elements."""
        self.head = None
        self.tail = None
        self.size = 0
        if elements is not None:
            for elem in elements:
                self.insert(elem)

    def permutation(self):
        """Swap consecutive elements two by two."""
        pass

    def insert(self, element):
        """Insert the given element at the end of the list."""
        node = Node(element, None)
        self.size += 1
        if self.head is None:
            self.head = node
            self.tail = node
            return
        self.tail.next = node
        self.tail = node

    def __str__(self):
        res = ""
        node = self.head
        while node is not None:
            res += str(node.data) + " -> "
            if node == self.tail:
                res += "*"
            node = node.next
        return res


if __name__ == "__main__":
    import random

    n = random.randint(0, 10)
    points = [random.randint(0, 100) for _ in range(n)]
    lst = ListeChainee(points)
    print("List before permutation:")
    print(lst)
    lst.permutation()
    print("List after permutation:")
    print(lst)
