class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> l = new ArrayList<>();
        String pu = "Push";
        String po = "Pop";
        int j = 1;
        for( int e : target ){
            if(e == j) {
                l.add(pu);
                j++;
            }
            else{
                int k = (e - j);
                while(k-- > 0) l.add(pu);
                k = (e-j);
                while(k-- > 0) l.add(po);
                j = e+1;
                l.add(pu);
            }
        }
        return l;
    }
}