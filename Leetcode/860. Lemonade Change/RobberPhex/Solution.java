import java.util.Scanner;
import java.util.Stack;

class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] state = new int[21];
        for(int cur: bills){
            switch (cur){
                case 5:
                    state[5]++;
                    break;
                case 10:
                    if(state[5]>0){
                        state[5]--;
                        state[10]++;
                        break;
                    }else {
                        return false;
                    }
                case 20:
                    cur-=5;
                    if(state[10]>0){
                        state[10]--;
                        cur-=10;
                    }
                    if(state[5]>=cur/5){
                        state[5]-=cur/5;
                        state[20]++;
                        break;
                    }else{
                        return false;
                    }
                default:
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean res = new Solution().lemonadeChange(new int[]{5,5,5,5,10,5,10,10,10,20});
        System.out.println(res);
    }
}