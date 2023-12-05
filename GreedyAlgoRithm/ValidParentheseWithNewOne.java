class Solution {
    public boolean checkValidString(String s) {
        if (s.length() == 1 && s.charAt(0) != '*') {
            return false;
        }
        int leftmin = 0;
        int leftmax = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftmin++;
                leftmax++;
            } else if (s.charAt(i) == ')') {
                leftmin = leftmin - 1;
                leftmax = leftmax - 1;
            } else {
                leftmin = leftmin - 1;
                leftmax = leftmax + 1;
            }
            if (leftmin < 0) {
                leftmin = 0;
            }
            if (leftmax < 0) {
                return false;
            }
        }
        System.out.println(leftmin);
        return leftmin == 0;
    }
}