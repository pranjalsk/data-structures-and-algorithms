# from tester3 import *
# =============================================================================


class SinglyLinkedNode(object):
    def __init__(self, item=None, next_link=None):
        super(SinglyLinkedNode, self).__init__()
        self._item = item
        self._next = next_link

    @property
    def item(self):
        return self._item

    @item.setter
    def item(self, item):
        self._item = item

    @property
    def next(self):
        return self._next

    @next.setter
    def next(self, next):
        self._next = next

    def __repr__(self):
        return repr(self.item)


class SinglyLinkedList(object):
    def __init__(self):
        super(SinglyLinkedList, self).__init__()
        self._head = None
        self._size = 0

    def __len__(self):
        return self._size

    def __iter__(self):
        current = self._head
        while current is not None:
            yield current.item
            current = current.next

    def __contains__(self, item):
        current = self._head
        is_contains = False
        while (current is not None) and (not is_contains):
            if current.item is not item:
                current = current.next
            else:
                is_contains = True
        return is_contains

    def remove(self, item):
        current = self._head
        tailer = self._head
        if self.__contains__(item):
            if current.item is item:
                self._head = current.next
            else:
                while current.item is not item:
                    tailer = current
                    current = current.next
                tailer.next = current.next
            self._size -= 1
            return True
        else:
            return False

    def prepend(self, item):
        if (self._head is None):
            node = SinglyLinkedNode(item)
            self._head = node
        else:
            node = SinglyLinkedNode(item)
            node.next = self._head
            self._head = node
        self._size += 1
        return True

    def __repr__(self):
        s = "List:" + "->".join([str(item) for item in self])
        return s

# =============================================================================


class BinaryTreeNode(object):
    def __init__(self, data=None, left=None, right=None, parent=None):
        super(BinaryTreeNode, self).__init__()
        self.data = data
        self.left = left
        self.right = right
        self.parent = parent


class BinarySearchTreeDict(object):
    def __init__(self):
        super(BinarySearchTreeDict, self).__init__()
        self.size = 0
        self.root = None
        self._node_dict = {}

    def actual_height(self, node):
        if node is None:
            return -1
        else:
            l = self.actual_height(node.left)
            r = self.actual_height(node.right)
            return 1 + max(l, r)

    @property
    def height(self):
        node = self.root
        return self.actual_height(node)

    def inorder_helper(self, node):
        if node is None:
            raise StopIteration
        else:
            for key in self.inorder_helper(node.left):
                yield key
            yield node.data[0]
            for key in self.inorder_helper(node.right):
                yield key

    def inorder_keys(self):
        node = self.root
        return self.inorder_helper(node)

    def preorder_helper(self, node):
        if node is None:
            raise StopIteration
        else:
            yield node.data[0]
            for key in self.preorder_helper(node.left):
                yield key
            for key in self.preorder_helper(node.right):
                yield key

    def preorder_keys(self):
        node = self.root
        return self.preorder_helper(node)

    def postorder_helper(self, node):
        if node is None:
            raise StopIteration
        else:
            for key in self.postorder_helper(node.left):
                yield key
            for key in self.postorder_helper(node.right):
                yield key
            yield node.data[0]

    def postorder_keys(self):
        node = self.root
        return self.postorder_helper(node)

    def inorder_keys_values_helper(self, node):
        if node is None:
            raise StopIteration
        else:
            for key in self.inorder_keys_values_helper(node.left):
                yield key
            yield node.data
            for key in self.inorder_keys_values_helper(node.right):
                yield key

    def _items(self):
        node = self.root
        for element in self.inorder_keys_values_helper(node):
            yield element

    def __getitem__(self, key):
        node = self.root
        if node is None:
            return None
        else:
            while node is not None:
                if node.data[0] is key:
                    return node.data[1]
                elif key < node.data[0]:
                    node = node.left
                elif key > node.data[0]:
                    node = node.right

    def __setitem__(self, key, value):
        if key is None:
            return False
        if self.__contains__(key):
            self._node_dict[key] = value
        else:
            if self.root is None:
                self.root = BinaryTreeNode([key, value])
                self._node_dict[key] = value
                self.size += 1
            else:
                node = self.root
                while node is not None:
                    if key <= node.data[0]:
                        if node.left is None:
                            node.left = BinaryTreeNode([key, value])
                            node.left.parent = node
                            self._node_dict[key] = value
                            break
                        else:
                            node = node.left
                    if key > node.data[0]:
                        if node.right is None:
                            node.right = BinaryTreeNode([key, value])
                            node.right.parent = node
                            self._node_dict[key] = value
                            break
                        else:
                            node = node.right
                self.size += 1
        return True

    def __treemin(self, x):
        while x.left is not None:
            x = x.left
        return x

    def __transplant(self, u, v):
        if u.parent is None:
            self.root = v
        elif u is u.parent.left:
            u.parent.left = v
        else:
            u.parent.right = v
        if v is not None:
            v.parent = u.parent

    def __delitem(self, key):
        x = self.root

        while x is not None:
            if x.data[0] is key:
                break
            elif key < x.data[0]:
                x = x.left
            elif key > x.data[0]:
                x = x.right

        if x is not None and self.__contains__(key):
            if x.left is None:
                self.__transplant(x, x.right)

            elif x.right is None:
                self.__transplant(x, x.left)

            else:
                y = self.__treemin(x.right)
                if y.parent is not x:
                    self.__transplant(y, y.right)
                    y.right = x.right
                    y.right.parent = y
                self.__transplant(x, y)
                y.left = x.left
                y.left.parent = y
            self._node_dict.pop(key)
            self.size -= 1
            return True
        else:
            return False

    def __delitem__(self, key):
        return self.__delitem(key)

    def __contains__(self, key):
        node = self.root
        is_contains = False
        if node is None:
            return is_contains
        else:
            while node is not None and (not is_contains):
                if node.data[0] is key:
                    is_contains = True
                elif key < node.data[0]:
                    node = node.left
                elif key > node.data[0]:
                    node = node.right
            return is_contains

    @property
    def length(self):
        return self.size

    def __len__(self):
        return self.length

    def _repr_(self):
        i = "Inorder:" + \
            "->".join([str(item) for item in self.inorder_keys()])
        p = "Preorder:" + \
            "->".join([str(item) for item in self.preorder_keys()])
        return [i, p]

    def display(self):
        return self._repr_()

# =============================================================================


class SinglyListNode(object):
    def __init__(self, key=None, value=None, next=None):
        super(SinglyListNode, self).__init__()
        self.key = key
        self.value = value
        self.next = next


class ChainedHashDict(object):
    def __init__(self, bin_count=10, max_load=0.7, hashfunc=hash):
        super(ChainedHashDict, self).__init__()
        self._bin_count = bin_count
        self.max_load = max_load
        self._hashFunc = hashfunc
        self.hashedList = [SinglyListNode() for i in range(bin_count)]
        self.size = 0
        self._head = None
        self.len = self.__len__()

    @property
    def load_factor(self):
        return float(self.size) / float(self.bin_count)

    @property
    def bin_count(self):
        return self._bin_count

    def rebuild(self, bincount):
        new_hashed_list = self.hashedList
        self._bin_count = bincount
        self.hashedList = [SinglyListNode() for i in range(self._bin_count)]
        self.size = 0
        for i in range(len(new_hashed_list)):
            if new_hashed_list[i].key is not None:
                ptr = new_hashed_list[i]
                while ptr is not None:
                    self.__setitem__(ptr.key, ptr.value)
                    ptr = ptr.next

    def __getitem__(self, key):
        if key is not None:
            index = self._hashFunc(key) % self._bin_count
            if self.__contains__(key):
                ptr = self.hashedList[index]
                while ptr is not None:
                    if ptr.key == key:
                        break
                    else:
                        ptr = ptr.next
                return ptr.value
            else:
                return None
        else:
            return None

    def __setitem__(self, key, value):

        if self.load_factor > self.max_load:
            self.rebuild(self.bin_count * 2)

        if key is not None:
            index = self._hashFunc(key) % self._bin_count
            ptr = self.hashedList[index]

            if self.__contains__(key):
                while ptr.key is not key:
                    ptr = ptr.next
                ptr.value = value
            else:
                if ptr.key is None:
                    node = SinglyListNode(key, value)
                    self.hashedList[index] = node
                else:
                    node = SinglyListNode(key, value)
                    node.next = self.hashedList[index]
                    self.hashedList[index] = node
                self.size += 1
                return True
        else:
            return False

    def __delitem__(self, key):
        if key is not None:
            if self.__contains__(key):
                index = self._hashFunc(key) % self._bin_count
                tailer = self.hashedList[index]
                ptr = self.hashedList[index]
                if self.hashedList[index].key == key:
                    self.hashedList[index] = None
                else:
                    while ptr is not None:
                        if ptr.key == key:
                            break
                        tailer = ptr
                        ptr = ptr.next
                    tailer.next = ptr.next
                self.size -= 1
                return True
            else:
                return False
        else:
            return False

    def __contains__(self, key):
        is_contains = False
        index = self._hashFunc(key) % self._bin_count
        if key is not None:
            ptr = self.hashedList[index]
            while ptr is not None:
                if ptr.key == key:
                    is_contains = True
                    break
                else:
                    ptr = ptr.next
        return is_contains

    def __len__(self):
        return self.size

    def __iter__(self, s):
        ptr = self.hashedList[s]
        while ptr:
            yield [ptr.key, ptr.value]
            ptr = ptr.next

    def __repr__(self):
        index = 0
        for i in self.hashedList:
            yield index
            yield "list:"
            if i.key is not None:
                if i.next:
                    s = self._hashFunc(i.key) % self._bin_count
                    yield "->".join(str(r) for r in self.__iter__(s))
                else:
                    yield [i.key, i.value]
                index += 1
            else:
                index += 1
            yield "\n"

    def display(self):
        ans = "".join([str(i) for i in self.__repr__()])
        return ans

# =============================================================================


class OpenAddressHashDict(object):
    def __init__(self, bin_count=10, max_load=0.7, hashfunc=hash):
        super(OpenAddressHashDict, self).__init__()
        self._bin_count = bin_count
        self.max_load = max_load
        self._hashFunc = hashfunc
        self.size = 0
        self.len = self.__len__()
        self.hashedList = [[] for i in range(self._bin_count)]

    @property
    def load_factor(self):
        return float(self.size) / float(self._bin_count)

    @property
    def bin_count(self):
        return self._bin_count

    def rebuild(self, bincount):
        new_hashed_list = self.hashedList
        self._bin_count = bincount
        self.hashedList = [[] for i in range(self._bin_count)]
        self.size = 0
        for i in range(len(new_hashed_list)):
            if new_hashed_list[i]:
                self.__setitem__(new_hashed_list[i][0], new_hashed_list[i][1])

    def __getitem__(self, key):
        if key is not None:
            index = self._hashFunc(key) % self._bin_count
            while self.hashedList[index]:
                if self.hashedList[index][0] is key:
                    return self.hashedList[index][1]
                else:
                    index += 1
        else:
            return None

    def __setitem__(self, key, value):

        if self.load_factor > self.max_load:
            self.rebuild(self.bin_count * 2)

        if key is not None:
            index = self._hashFunc(key) % self._bin_count

            if self.__contains__(key):
                if self.hashedList[index][0] is key:
                    self.hashedList[index][1] = value
                else:
                    index += 1
            else:
                if not self.hashedList[index]:
                    self.hashedList[index] = [key, value]
                else:
                    while self.hashedList[index]:
                        if self.hashedList[index][0] is -1:
                            break
                        index += 1
                    self.hashedList[index] = [key, value]
                self.size += 1
                return True
        else:
            return False

    def __delitem(self, key):
        if key is not None:
            if self.__contains__(key):
                index = self._hashFunc(key) % self._bin_count
                if self.hashedList[index][1] == key:
                    self.hashedList[index][0] = -1
                else:
                    while self.hashedList[index]:
                        if self.hashedList[index][0] == key:
                            self.hashedList[index][0] = -1
                        else:
                            index += 1
                self.size -= 1
                return True
            else:
                return False
        else:
            return False

    def __delitem__(self, key):
        return self.__delitem(key)

    def __contains__(self, key):
        is_contains = False
        index = self._hashFunc(key) % self._bin_count
        if key is not None:
            while self.hashedList[index]:
                if self.hashedList[index][0] is key:
                    is_contains = True
                    break
                else:
                    index += 1
        return is_contains

    def __len__(self):
        return self.size

    def __repr__(self):
        index = 0
        for i in self.hashedList:
            yield "bin "
            yield index
            yield ": "
            if i:
                yield \
                    [self.hashedList[index][0], str(self.hashedList[index][1])]
            else:
                yield [None, None]
            yield "\n"
            index += 1

    def display(self):
        result = "".join([str(i) for i in self.__repr__()])
        return result


def terrible_hash(bin):
    """A terrible hash function that can be used for testing.

    A hash function should produce unpredictable results,
    but it is useful to see what happens to a hash table when
    you use the worst-possible hash function.  The function
    returned from this factory function will always return
    the same number, regardless of the key.

    :param bin:
        The result of the hash function, regardless of which
        item is used.

    :return:
        A python function that can be passed into the constructor
        of a hash table to use for hashing objects.
    """
    def hashfunc(item):
        return bin
    return hashfunc

# =============================================================================


def main():
    # testFunc()
    pass


if __name__ == '__main__':
    main()
