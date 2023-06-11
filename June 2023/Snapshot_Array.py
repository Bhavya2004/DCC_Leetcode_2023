class SnapshotArray:

    def __init__(self, length: int):
        self.a=[[[-1,0]]for _ in range(length)]
        self.index = 0

    def set(self, index: int, val: int) -> None:
        self.a[index]+=[[self.index, val]]
        

    def snap(self) -> int:
        self.index += 1
        return self.index-1
        

    def get(self, index: int, snap_id: int) -> int:
        return self.a[index][bisect_right(self.a[index],[snap_id+1])-1][1]
        


# Your SnapshotArray object will be instantiated and called as such:
# obj = SnapshotArray(length)
# obj.set(index,val)
# param_2 = obj.snap()
# param_3 = obj.get(index,snap_id)