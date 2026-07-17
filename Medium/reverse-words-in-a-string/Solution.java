class Solution {
    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder word = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                if (word.length() > 0) {
                    stack.push(word.toString());
                    word.setLength(0);
                }
            } else {
                word.append(ch);
            }
        }

        if (word.length() > 0) {
            stack.push(word.toString());
        }

        StringBuilder ans = new StringBuilder();

        while (!stack.isEmpty()) {
            ans.append(stack.pop());

            if (!stack.isEmpty()) {
                ans.append(" ");
            }
        }

        return ans.toString();
    }
}