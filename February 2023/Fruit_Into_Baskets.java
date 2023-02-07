class Solution1 {
    public int totalFruit(int[] fruits) {
        int[] counts = new int[fruits.length];
        int max = 0;
        int currMax = 0;
        int typeCount = 0;
        int start = 0;
        
        for(int i = 0; i < fruits.length; i++) {
            if(counts[fruits[i]] == 0) typeCount++;
            counts[fruits[i]]++;
            currMax++;
            
            while(typeCount > 2 && start < i) {
                counts[fruits[start]]--;
                if(counts[fruits[start]] == 0) typeCount--;
                start++;
                currMax--;
            }
            
            max = Math.max(max, currMax);
        }
        
        return max;
    }
}