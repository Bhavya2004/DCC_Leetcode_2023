class Solution(object):
    def diagonalSum(self, mat):
        """
        :type mat: List[List[int]]
        :rtype: int
        """
        n=len(mat)
        return sum(mat[i][i]*(i!=~i+n)+mat[i][~i]for i in range(n))

# The first term, mat[i][i]*(i!=~i+n), computes the element on the primary diagonal, but only if it is not also on the secondary diagonal. The expression i!=~i+n is equivalent to i!=n-i-1, which is true for all i except the center element of odd-sized matrices. In other words, it skips the center element if the matrix has an odd size.

# The second term, mat[i][~i], computes the element on the secondary diagonal, but only if it is not also on the primary diagonal. The expression ~i is equivalent to -i-1, so mat[i][~i] accesses the element at row i and column n-i-1. The condition i+j==n-1 is true for all elements on the secondary diagonal, and the extra condition i!=j excludes the center element if the matrix has an odd size.