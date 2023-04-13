class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer,Integer> difficultyFreq = new HashMap<>();

        for(int task:tasks){
            difficultyFreq.put(task,difficultyFreq.getOrDefault(task,0)+1);
        }

        int ans=0;
        for(Map.Entry<Integer,Integer> entry:difficultyFreq.entrySet()){
            int freq=entry.getValue();
            if(freq==1){
                return -1;
            }
            //2X+3Y=freq
            if(freq %3 != 0){
                ans+=freq/3+1;
            }
            else{
                ans+=freq/3;
            }
        }
        return ans;
    }
}