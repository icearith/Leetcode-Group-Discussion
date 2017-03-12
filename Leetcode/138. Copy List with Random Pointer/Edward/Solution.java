public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        RandomListNode newHead = null;
        RandomListNode indicator = newHead;

        HashMap<Integer, List<RandomListNode>> randomMapping = new HashMap<>();
        // label to node
        HashMap<Integer, RandomListNode> labelMapping = new HashMap<>();

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
            labelMapping.put(indicator.label, indicator);

            // clear random list for itself
            List<RandomListNode> itsList = randomMapping.get(indicator.label);
            if (itsList != null) {
                for (RandomListNode node : itsList) {
                    node.random = indicator;
                }
                itsList.clear();
            }

            // handle it's random
            if (head.random != null) {
                Integer randomLabel = head.random.label;
                RandomListNode randomNode = labelMapping.get(randomLabel);
                // set random or cache it
                if (randomNode != null) {
                    indicator.random = randomNode;
                } else {
                    // add it self to random mapping
                    List<RandomListNode> randomList = randomMapping.get(randomLabel);
                    if (randomList != null) {
                        randomList.add(indicator);
                    } else {
                        randomList = new ArrayList<>();
                        randomList.add(indicator);
                        randomMapping.put(randomLabel, randomList);
                    }
                }
            }

            head = head.next;
        } while (head != null);

        return newHead;
    }
}

