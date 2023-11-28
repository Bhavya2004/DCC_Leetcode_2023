class Solution {
    public int numberOfWays(String corridor) {

        char[] array = corridor.toCharArray();
        int chairs = 0;
        long result = 1;

        for (int i = 0; i < array.length; i++) {

            
            if (array[i] == 'S') {
                chairs++;

                
                while (++i < array.length && array[i] != 'S');
                if (i < array.length && array[i] == 'S') {
                    chairs++;
                }


                
                int divisions = 1;
                while (++i < array.length && array[i] != 'S') {
                    divisions++;
                }

                           
                if (divisions > 1 && i < array.length) {
                    result = (result * divisions) % 1000000007;
                }
                i--;
            }
        }

        return (chairs != 0 && chairs % 2 == 0) ? (int) result : 0;
    }
}