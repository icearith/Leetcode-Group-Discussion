/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int min = 0, max = n;
        while (min < max) {
            int mid = (int) (((long)min + max) / 2);
            if (isBadVersion(mid))
                max = mid;
            else
                min = mid + 1;
        }
        return (int) (((long)min + max) / 2);
    }
/*
    public static void main(String[] args) {
        Solution obj = new Solution();
        int res;

        VersionControl.firstBad = 1702766719;
        res = obj.firstBadVersion(2126753390);
        System.out.println(res);
    }
    */
}