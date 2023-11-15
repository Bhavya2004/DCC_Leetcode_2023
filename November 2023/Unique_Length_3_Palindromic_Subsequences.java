class Solution {
    public int countPalindromicSubsequence(String s) {
        List<Integer>[] positions = getPositions(s);
        int count = 0;
        for (int i = 0; i < positions.length; i++) {
            count += countPalindromes(i, positions);
        }
        return count;
    }

    private int countPalindromes(int i, List<Integer>[] positions) {
        int total = 0;
        if (positions[i] == null || positions[i].size() < 2) {
            return total;
        }
        int firstPos = positions[i].get(0), lastPos = positions[i].get(positions[i].size() - 1), position;
        if (firstPos + 1 == lastPos) {
            return total;
        }
        for (int j = 0; j < 26; j++) {
            position = findPosition(positions[j], firstPos + 1);
            total += (firstPos < position && position < lastPos ? 1 : 0);
        }
        return total;
    }

    private int findPosition(List<Integer> positions, int target) {
        if(positions == null) {
            return -1;
        }
        int low = 0, high = positions.size() - 1, pivot, element;
        while(low <= high) {
            pivot = low + (high - low) / 2;
            element = positions.get(pivot);
            if (target == element) {
                return target;
            } else if (target > element) {
                low = pivot + 1;
            } else {
                high = pivot - 1;
            }
        }
        if (low == positions.size()) {
            low--;
        }
        return positions.get(low);
    }

    private List<Integer>[] getPositions(String s) {
        List<Integer>[] positions = new List[26];
        int codePoint;
        for (int i = 0; i < s.length(); i++) {
            codePoint = s.charAt(i) - 'a';
            if (positions[codePoint] == null) {
                positions[codePoint] = new ArrayList<>();
            }
            positions[codePoint].add(i);
        }
        return positions;
    }
}