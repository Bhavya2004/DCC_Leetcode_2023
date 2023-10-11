class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] viewedBloomedFlowers = new int[people.length];
        Arrays.sort(flowers, Comparator.comparingInt(a -> a[0]));
        int[][] sortedPeople = getSortedPeople(people);
        PriorityQueue<Integer> bloomedFlowers = new PriorityQueue<>(Comparator.comparingInt(a -> flowers[a][1]));
        int fIndex = 0, pIndex = 0;
        while (pIndex < people.length) {
            while (fIndex < flowers.length && flowers[fIndex][0] <= sortedPeople[pIndex][0]) {
                bloomedFlowers.add(fIndex);
                fIndex++;
            }
            while (!bloomedFlowers.isEmpty() && flowers[bloomedFlowers.peek()][1] < sortedPeople[pIndex][0]) {
                bloomedFlowers.poll();
            }
            viewedBloomedFlowers[sortedPeople[pIndex][1]] = bloomedFlowers.size();
            pIndex++;
        }
        return viewedBloomedFlowers;
    }

    private int[][] getSortedPeople(int[] people) {
        int[][] sortedPeople = new int[people.length][2];
        for (int i = 0; i < people.length; i++) {
            sortedPeople[i][0] = people[i];
            sortedPeople[i][1] = i;
        }
        Arrays.sort(sortedPeople, Comparator.comparingInt(a -> a[0]));
        return sortedPeople;
    }
}