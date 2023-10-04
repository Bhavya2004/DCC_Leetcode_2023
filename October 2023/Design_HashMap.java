class MyHashMap {
    List<Integer> l = new ArrayList<>();
    public MyHashMap() {
        for( int i = 0 ; i <= 1000000 ; i++ ){
            l.add(-1);
        }
    }
    
    public void put(int key, int value) {
        l.set(key,value);
    }
    
    public int get(int key) {
        return l.get(key);
    }
    
    public void remove(int key) {
        l.set(key,-1);
    }
}