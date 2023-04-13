class Solution {
    int[] arr;
    HashSet<List<Integer>> hashSet = new HashSet<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        arr = nums;
        List<Integer> arrayList = new ArrayList<>();
        recursion(arrayList,0);
        List<List<Integer>> result = new ArrayList<>(hashSet);
        return result;
    }

    public void recursion(List<Integer> arrayList, int index){
        if(arrayList.size()>=2) hashSet.add(new ArrayList(arrayList));

        for(int i = index;i<arr.length;i++){
            if(arrayList.size() == 0 || arr[i]>= arrayList.get(arrayList.size()-1)){
                arrayList.add(arr[i]);
                recursion(arrayList,i+1);
                arrayList.remove(arrayList.size()-1);
            }
        }

    }
}