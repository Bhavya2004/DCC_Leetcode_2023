class MyHashSet:

    def __init__(self):
        self.a=[0]*2**20  # array of size 2^20 with all elements set to 0
        
    def add(self, key: int) -> None:
        self.a[key]=1

    def remove(self, key: int) -> None:
        self.a[key]=0

    def contains(self, key: int) -> bool:
        return self.a[key]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)