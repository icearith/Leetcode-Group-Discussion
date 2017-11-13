import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> lexicalOrder(int max) {
        List<Integer> list = new ArrayList<>(max);
        int cur = 1;
        for (int i = 0; i < max; i++) {
            list.add(cur);
            if (cur * 10 <= max)
                cur *= 10;
            else {
                if (cur >= max)
                    cur /= 10;
                cur++;
                while (cur % 10 == 0)
                    cur /= 10;
            }
        }

        return list;
    }

    public static void main(String[] args) {
        List<Integer> res = new Solution().lexicalOrder(234);
        for (int e : res) {
            System.out.println(e);
        }
    }
}
