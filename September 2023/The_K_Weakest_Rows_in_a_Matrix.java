import java.util.*;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        
        // Create an array to store the strength of each row
        int[] strength = new int[m];
        
        // Calculate the strength of each row
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    strength[i]++;
                } else {
                    break;
                }
            }
        }
        
        // Create a list of row indices and sort it based on strength
        List<Integer> rowIndices = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            rowIndices.add(i);
        }
        Collections.sort(rowIndices, (a, b) -> {
            if (strength[a] == strength[b]) {
                return a - b;
            }
            return strength[a] - strength[b];
        });
        
        // Get the first k elements from the sorted list
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = rowIndices.get(i);
        }
        
        return result;
    }
}