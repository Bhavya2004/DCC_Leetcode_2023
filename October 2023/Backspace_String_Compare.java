class Solution {
    public boolean backspaceCompare(String s, String t) {

        StringBuilder ns = new StringBuilder();

        Stack<Character> st = new Stack<>();
        
        for( int i = 0 ; i < s.length() ; i++ ){
            if( st.isEmpty() && s.charAt(i) == '#' ) continue;
            if( s.charAt(i) != '#' || st.isEmpty()  ) st.push(s.charAt(i));
            else st.pop();
        }

        while( !st.isEmpty() ){
            ns.append(st.pop()+"");
        }

        StringBuilder nt = new StringBuilder();
        
        for( int i = 0 ; i < t.length()  ; i++ ){
            if( st.isEmpty() && t.charAt(i) == '#' ) continue;
            if( t.charAt(i) != '#' || st.isEmpty() ) st.push(t.charAt(i));
            else st.pop();
        }

        while( !st.isEmpty() ){
            nt.append(st.pop()+"");
        }

        return ns.toString().equals(nt.toString());

    }
}