package com.github.leostep.leetcode;

public class StringToInteger {
    public static int myAtoi(String s) {
        boolean isNegative = false;
        boolean numStarted = false;
        boolean signFound = false;
        boolean leadingZeroAllowed = true;
        StringBuilder numberBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!numStarted && ' ' == c) {
                continue;
            }
            numStarted = true;
            if (!signFound && '+' == c) {
                signFound = true;
                continue;
            }
            if (!signFound && '-' == c) {
                signFound = true;
                isNegative = true;
                continue;
            }
            if (Character.isDigit(c)) {
                if (!signFound) {
                    signFound = true;
                }
                if ('0' == c && leadingZeroAllowed) {
                    continue;
                }
                leadingZeroAllowed = false;
                numberBuilder.append(c);
                continue;
            }
            break;
        }
        if (numberBuilder.isEmpty()) {
            return 0;
        }
        if (isNegative) {
            return compareWithLimitValue("-" + numberBuilder, Integer.MIN_VALUE);
        }
        return compareWithLimitValue(numberBuilder.toString(), Integer.MAX_VALUE);
    }

    private static int compareWithLimitValue(String num, int limit) {
        String limitString = String.valueOf(limit);
        if (num.length() > limitString.length()) {
            return limit;
        }
        if (num.length() == limitString.length()) {
            for (int i = 0; i < num.length(); i++) {
                if (num.charAt(i) > limitString.charAt(i)) {
                    return limit;
                }
                if (num.charAt(i) < limitString.charAt(i)) {
                    break;
                }
            }
        }
        return Integer.parseInt(num);
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("1095502006p8"));
    }
}
