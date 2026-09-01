class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        String op = "";
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("/")
                || tokens[i].equals("*")) {
                op = tokens[i];
            }
            if (op.equals("")) {
                stack.push(Integer.parseInt(tokens[i]));
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                if (op.equals("+")) {
                    stack.push(num1 + num2);
                } else if (op.equals("-")) {
                    stack.push(num2 - num1);
                } else if (op.equals("*")) {
                    stack.push(num1 * num2);
                } else if (op.equals("/")) {
                    stack.push(num2 / num1);
                }
            }
            op = "";
        }
        // if (!stack.isEmpty()) {
        //     int num1 = stack.pop();
        //     int num2 = stack.pop();
        //     if (op.equals("+")) {
        //         stack.push(num1 + num2);
        //     } else if (op.equals("-")) {
        //         stack.push(num2 - num1);
        //     } else if (op.equals('*')) {
        //         stack.push(num1 * num2);
        //     } else if (op.equals("/")) {
        //         stack.push(num2 / num1);
        //     }
        // }
        return stack.peek();
    }
}
