public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        RandomListNode newHead = null;
        RandomListNode indicator = newHead;

        // random nodes mapping
        HashMap<RandomListNode, List<RandomListNode>> randomMapping = new HashMap<>();
        // origin node to new node
        HashMap<RandomListNode, RandomListNode> nodeMapping = new HashMap<>();

        do {
            // copy the value first
            if (newHead == null) {
                //first element
                indicator = newHead = new RandomListNode(head.label);
            } else {
                indicator.next = new RandomListNode(head.label);
                indicator = indicator.next;
            }

            // add itself to label mapping
            nodeMapping.put(head, indicator);

            // clear random list for itself
            List<RandomListNode> itsList = randomMapping.get(head);
            if (itsList != null) {
                for (RandomListNode node : itsList) {
                    node.random = indicator;
                }
                itsList.clear();
            }

            // handle it's random
            if (head.random != null) {
                RandomListNode randomNode = nodeMapping.get(head.random);
                // set random or cache it
                if (randomNode != null) {
                    indicator.random = randomNode;
                } else {
                    // add it self to random mapping
                    List<RandomListNode> randomList = randomMapping.get(head.random);
                    if (randomList != null) {
                        randomList.add(indicator);
                    } else {
                        randomList = new ArrayList<>();
                        randomList.add(indicator);
                        randomMapping.put(head.random, randomList);
                    }
                }
            }

            head = head.next;
        } while (head != null);

        return newHead;
    }
}

