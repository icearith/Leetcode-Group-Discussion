public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode copyList = null;

        RandomListNode originIndicator = head;
        RandomListNode copyIndicator = null;

        List<Integer> labelList = new ArrayList<>();
        List<Integer> randomMappingList = new ArrayList<>();
        List<RandomListNode> copiedNodes = new ArrayList<>();

        // copy all the values first
        do {
            if (originIndicator.random != null) {
                randomMappingList.add(originIndicator.random.label);
            } else {
                randomMappingList.add(null);
            }

            if (copyIndicator == null) {
                copyList = copyIndicator = new RandomListNode(originIndicator.label);
            } else {
                copyIndicator.next = new RandomListNode(originIndicator.label);
                copyIndicator = copyIndicator.next;
            }

            labelList.add(originIndicator.label);
            copiedNodes.add(copyIndicator);

            originIndicator = originIndicator.next;
        } while(originIndicator != null);

        // set all the correct random value
        copyIndicator = copyList;
        for (int i = 0; i < copiedNodes.size(); i++) {
            Integer randomLabel = randomMappingList.get(i);
            if (randomLabel == null) {
                continue;
            }
            int randomIndex = labelList.indexOf(randomLabel);
            copiedNodes.get(i).random = copiedNodes.get(randomIndex);
        }

        return copyList;
    }
}

