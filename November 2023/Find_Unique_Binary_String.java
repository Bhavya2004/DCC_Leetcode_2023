
import java.util.*;

class Find_Unique_Binary_String {
    public String findDifferentBinaryString(String[] nums) {
        Set<String> set = new HashSet<>();
        for (String num : nums) {
            set.add(num);
        }
        int n = nums.length;
        for (int i = 0; i < (1 << n); i++) {
            String binary = Integer.toBinaryString(i);
            while (binary.length() < n) {
                binary = "0" + binary;
            }
            if (!set.contains(binary)) {
                return binary;
            }
        }
        return "";
    }
}
