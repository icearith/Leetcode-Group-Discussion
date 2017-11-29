class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.length() <= 1)
            return true;
        char first = word.charAt(0);
        char second = word.charAt(1);
        if (Character.isLowerCase(second))
            return allIsLower(word);
        if (Character.isLowerCase(first))
            return false;
        else
            return allIsUpper(word);
    }

    private boolean allIsLower(String word) {
        for (int i = 2; i < word.length(); i++)
            if (!Character.isLowerCase(word.charAt(i)))
                return false;
        return true;
    }

    private boolean allIsUpper(String word) {
        for (int i = 2; i < word.length(); i++)
            if (!Character.isUpperCase(word.charAt(i)))
                return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().detectCapitalUse("USA"));
        System.out.println(new Solution().detectCapitalUse("FlaG"));
    }
}