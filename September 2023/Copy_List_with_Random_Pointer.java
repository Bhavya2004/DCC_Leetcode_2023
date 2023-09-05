/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> nodeMap = new HashMap<>();
        Node originalHead = head, previousMappedNode = null, currentMappedNode;
        int[] val = new int[1], randomVal = new int[1];
        while(head != null) {
            val[0] = head.val;
            currentMappedNode = nodeMap.computeIfAbsent(head, k -> new Node(val[0]));
            if (previousMappedNode != null) {
                previousMappedNode.next = currentMappedNode;
            }
            if (head.random != null && currentMappedNode.random == null) {
                randomVal[0] = head.random.val;
                currentMappedNode.random = nodeMap.computeIfAbsent(head.random, k -> new Node(randomVal[0]));
            }
            previousMappedNode = currentMappedNode;
            head = head.next;
        }
        return nodeMap.get(originalHead);
    }
}