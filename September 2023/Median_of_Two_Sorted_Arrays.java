import java.util.ArrayList;
import java.util.List;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> merged = mergeArrays(nums1, nums2);
        int length = merged.size();
        
        if (length % 2 == 0) {
            int mid = length / 2;
            return (merged.get(mid - 1) + merged.get(mid)) / 2.0;
        } else {
            int mid = length / 2;
            return merged.get(mid);
        }
    }
    
    public List<Integer> mergeArrays(int[] nums1, int[] nums2) {
        List<Integer> merged = new ArrayList<>();
        int i = 0, j = 0;
        
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                merged.add(nums1[i]);
                i++;
            } else {
                merged.add(nums2[j]);
                j++;
            }
        }
        
        while (i < nums1.length) {
            merged.add(nums1[i]);
            i++;
        }
        
        while (j < nums2.length) {
            merged.add(nums2[j]);
            j++;
        }
        
        return merged;
    }
}
