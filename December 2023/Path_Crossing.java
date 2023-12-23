class Solution {
    public boolean isPathCrossing(String path) {
        int x = 0, y = 0;
    Set<String> visited = new HashSet<>();
    visited.add(x + "," + y);

    for (char direction : path.toCharArray()) {
        if (direction == 'N') {
            y++;
        } else if (direction == 'S') {
            y--;
        } else if (direction == 'E') {
            x++;
        } else if (direction == 'W') {
            x--;
        }

        String coordinate = x + "," + y;
        if (visited.contains(coordinate)) {
            return true;
        }
        visited.add(coordinate);
    }

    return false;
    }
}