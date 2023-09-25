class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        for( char c : t.toCharArray() ){
            map1.put( c , map1.getOrDefault( c , 0 ) + 1 );
        }

        for( char c : s.toCharArray() ){
            map2.put( c , map2.getOrDefault( c , 0 ) + 1 );
        }

        for( char key : map1.keySet() ){
            if( !map2.containsKey( key ) ) return key;
            else if(  map2.get(key) != map1.get(key) ) return key;
        }

        return '0';
    }
}