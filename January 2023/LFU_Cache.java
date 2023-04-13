class LFUCache {

    final int capacity;  //total capacity of LFU Cache
    int currSize;   //curr size of LFU Cache
    int minFrequency;    //minimum freq of the entire LFU Cache
    Map<Integer, DLLNode> cache;    //HashMap containing key to node mapping, storing all nodes by their keys
    Map<Integer, DoubleLinkedList> frequencyMap;    //HashMap containing key to LL mapping, storing all DLL by their frequencies


    public LFUCache(int capacity) 
    {
        this.capacity = capacity;
        this.currSize = 0;
        this.minFrequency = 0;

        this.cache = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }
    //getting node value by key, and then updating node frequency and relocating that node 
    public int get(int key) 
    {
        DLLNode currNode = cache.get(key);
        if(currNode == null)
        {
            return -1;
        }
        updateNode(currNode);
        return currNode.val;
    }

    /* adding new node into LFU cache and DLL -->
        1. if LFU has input key, update node value and node pos in list
        2. if LFU cache does not have input key,
            a) if LFU cache does not have enough space --> remove the LRU node in min frequency list and then add new node
            b) if LFU cache have enough space, add new node directly
    */
    
    public void put(int key, int value) 
    {
        //always check for the cache capacity
        if(capacity == 0)
        {
            return;
        }

        if(cache.containsKey(key))
        {
            DLLNode currNode = cache.get(key);
            currNode.val = value;
            updateNode(currNode);
        }
        else
        {
            currSize++;
            if(currSize > capacity)
            {
                //getting minimum freq list
                DoubleLinkedList minFreqList = frequencyMap.get(minFrequency);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
                currSize--;
            }
            //changing min frequency back to 1 because of adding new node
            minFrequency = 1;
            DLLNode newNode = new DLLNode(key, value);

            //getting the list with frequency 1, and adding new node into the list, and into LFU cache
            DoubleLinkedList curList = frequencyMap.getOrDefault(1, new DoubleLinkedList());
            curList.addNode(newNode);
            frequencyMap.put(1, curList);
            cache.put(key, newNode);
        }
    }

    public void updateNode(DLLNode currNode)
    {
        int currFreq = currNode.frequency;
        DoubleLinkedList curList = frequencyMap.get(currFreq);
        curList.removeNode(currNode);

        //if current list(last list ) which has lowest frequency and current node is the only node in that list , remove the entire list and then increase min frequency value by 1
        if (currFreq == minFrequency && curList.listSize == 0) {
            minFrequency++;
        }

        currNode.frequency++;
        //adding current node to another list has current frequency + 1,
        //if we do not have the list with this frequency, initialize it
        DoubleLinkedList newList = frequencyMap.getOrDefault(currNode.frequency, new DoubleLinkedList());
        newList.addNode(currNode);
        frequencyMap.put(currNode.frequency, newList);



    }

    class DLLNode 
    {
        int key;
        int val;
        int frequency;
        DLLNode prev;
        DLLNode next;

        public DLLNode(int key, int val) 
        {
            this.key = key;
            this.val = val;
            this.frequency = 1;
        }
    }

    class DoubleLinkedList 
    {
        int listSize;
        DLLNode head;
        DLLNode tail;
        public DoubleLinkedList() 
        {
            this.listSize = 0;
            this.head = new DLLNode(0, 0);
            this.tail = new DLLNode(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        //adding new node into head of list and increasing list size by 1 
        public void addNode(DLLNode currNode) {
            DLLNode nextNode = head.next;
            currNode.next = nextNode;
            currNode.prev = head;
            head.next = currNode;
            nextNode.prev = currNode;
            listSize++;
        }

        //removing input node and decreasing list size by 1
        public void removeNode(DLLNode currNode) {
            DLLNode prevNode = currNode.prev;
            DLLNode nextNode = currNode.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            listSize--;
        }

    }

}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */