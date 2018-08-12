class Solution {
    public boolean validUtf8(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int cnt = 0;
            if ((data[i] & 240) == 240 && (data[i] & 8) == 0) {
                cnt = 3;
            } else if ((data[i] & 224) == 224 && (data[i] & 16) == 0) {
                cnt = 2;
            } else if ((data[i] & 192) == 192 && (data[i] & 32) == 0) {
                cnt = 1;
            } else if ((data[i] & 128) != 0) {
                return false;
            }
            while (cnt > 0) {
                if (i + 1 < data.length && (data[i + 1] & 128) == 128 && (data[i + 1] & 64) == 0) {
                    cnt--;
                    i++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean res = new Solution().validUtf8(new int[]{197, 130, 1});
        System.out.println(res);
        res = new Solution().validUtf8(new int[]{235, 140, 4});
        System.out.println(res);
        res = new Solution().validUtf8(new int[]{255});
        System.out.println(res);
    }
}