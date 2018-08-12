class Solution {
    public static boolean validUtf8(int[] data) {
        if (data == null) {
            return false;
        }

        int followingCheck = 0;

        for (int c : data) {
            if (followingCheck == 0) {
                int size = getSize(c);
                if (size < 0) {
                    return false;
                }
                followingCheck = size - 1;
            } else {
                if ((c & 0b11000000) == 0b10000000) {
                    followingCheck--;
                } else {
                    return false;
                }
            }
        }

        return followingCheck == 0;
    }

    private static int getSize(int c) {
        if ((c & 0b10000000) == 0b00000000) {
            return 1;
        }
        if ((c & 0b11100000) == 0b11000000) {
            return 2;
        }
        if ((c & 0b11110000) == 0b11100000) {
            return 3;
        }
        if ((c & 0b11111000) == 0b11110000) {
            return 4;
        }
        return -1;
    }
}
