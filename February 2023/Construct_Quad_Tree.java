// Understanding Question:
// 1.first consider the full grid.if all the values are same take isleaf to 1 and return whole grid as ans.
// if all the value are different,set isleaf to 0.
// 2.Now when isleaf is 0 we can set val to either 0 or 1.After setting the value of val,divide the grid into 4 cells(top left,top right,bottom left,bottom right)each of equal size.
// 3.now repeat the same process in all the 4 cells individually i.e. if all the values are same,set isleaf to 1 and value to 1/0 acc to grid made and return itself and if all the values are not same divide that cell into 4 cells and set isleaf to 0 and val to 0/1.
// 4.finally return the ans from top to bottom and left to right level wise in the format [value of isleaf,value of val]
class Solution {
    public Node construct(int[][] grid) {
       return constructHelper(grid, 0, 0, grid.length);
    }

    private Node constructHelper(int[][] grid, int x, int y, int size) {
    if (size == 1) {
        return new Node(grid[x][y] == 1, true, null, null, null, null);
    }
    Node topLeft = constructHelper(grid, x, y, size/2);
    Node topRight = constructHelper(grid, x, y+size/2, size/2);
    Node bottomLeft = constructHelper(grid, x+size/2, y, size/2);
    Node bottomRight = constructHelper(grid, x+size/2, y+size/2, size/2);
    if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf
            && topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val) {
        return new Node(topLeft.val, true, null, null, null, null);
    } else {
        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}
}