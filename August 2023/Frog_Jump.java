class Solution {
    public boolean canCross(int[] stones) {
        HashMap<Integer,HashSet<Integer>> map=new HashMap();
        int n=stones.length;

        for(int i=0;i<n;i++){
            map.put(stones[i],new HashSet<Integer>());
        }
        map.get(stones[0]).add(0);

        for(int i=0;i<n;i++){
            int stone=stones[i];
            HashSet<Integer> set=map.get(stone);

            for(int val:set){
                if(map.containsKey(stone+val-1)){
                    if(val-1>0){
                        map.get(stone+val-1).add(val-1);
                    }
                }
                if(map.containsKey(stone+val)){
                    if(val>0){
                        map.get(stone+val).add(val);
                    }
                }
                if(map.containsKey(stone+val+1)){
                    map.get(stone+val+1).add(val+1);
                }
            }
        }

        if(map.get(stones[n-1]).size()>0){
            return true;
        }
        else{
            return false;
        }
    }
}