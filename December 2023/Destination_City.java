import java.util.*;

class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> outgoingCities = new HashSet<>();
        for (List<String> path : paths) {
            outgoingCities.add(path.get(0));
        }
        for (List<String> path : paths) {
            if (!outgoingCities.contains(path.get(1))) {
                return path.get(1);
            }
        }
        return "";
    }
}
