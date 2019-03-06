package data_structure;

import java.util.ArrayDeque;

public class ReversePolishNotation {
    private String ex;
    private String[] infix = new String[100];
    private String[] postfix = new String[100];

    private void exSplit() {
        int len = 0;
        for (int i = 0; i < ex.length(); i++) {
            char c = ex.charAt(i);
            int startIndex = i;
            if (c == '-' && (i == 0 || ex.charAt(i - 1) < '0' || ex.charAt(i - 1) > '9')) {
                do {
                    i++;
                    if (i == ex.length()) {
                        break;
                    }
                    c = ex.charAt(i);
                } while ((c >= '0' && c < '9') || c == '.');
                infix[len] = ex.substring(startIndex, i);
                len++;
                i--;
                continue;
            }

            if (c >= '0' && c < '9') {
                do {
                    i++;
                    if (i == ex.length()) {
                        break;
                    }
                    c = ex.charAt(i);
                } while ((c >= '0' && c <= '9') || c == '.');
                infix[len] = ex.substring(startIndex, i);
                len++;
                i--;
                continue;
            }
            infix[len] = ex.substring(startIndex, startIndex + 1);
            len++;
        }
    }

    private void infixToPostfix() {
        this.exSplit();
        ArrayDeque<String> stack = new ArrayDeque<>();

        int i = 0;
        for (String str : infix) {
            if (str == null) {
                while (stack.peekFirst() != null) {
                    postfix[i++] = stack.pop();
                }
                break;
            }

            if (!str.equals("(") && !str.equals(")") && !str.equals("+") && !str.equals("-") && !str.equals("*") && !str.equals("/"))
                postfix[i++] = str;
            else {
                String topStr = stack.peekFirst();
                if (topStr == null) {
                    stack.push(str);
                    continue;
                }

                switch (str) {
                    case ")": {
                        while (!stack.peekFirst().equals("(")) {
                            postfix[i++] = stack.pop();
                        }
                        stack.pop();
                        break;
                    }
                    case "*": {
                        while (topStr.equals("*") || topStr.equals("/")) {
                            postfix[i++] = stack.pop();
                            topStr = stack.peekFirst();
                            if (topStr == null) {
                                break;
                            }
                        }
                        break;
                    }
                    case "/": {
                        while (topStr.equals("*") || topStr.equals("/")) {
                            postfix[i++] = stack.pop();
                            topStr = stack.peekFirst();
                            if (topStr == null) {
                                break;
                            }
                        }
                        break;
                    }
                    case "+": {
                        while (topStr.equals("*") || topStr.equals("/") || topStr.equals("+") || topStr.equals("-")) {
                            postfix[i++] = stack.pop();
                            topStr = stack.peekFirst();
                            if (topStr == null) {
                                break;
                            }
                        }
                        break;
                    }
                    case "-": {
                        while (topStr.equals("*") || topStr.equals("/") || topStr.equals("+") || topStr.equals("-")) {
                            postfix[i++] = stack.pop();
                            topStr = stack.peekFirst();
                            if (topStr == null) {
                                break;
                            }
                        }
                        break;
                    }
                }

                if (!str.equals(")"))
                    stack.push(str);
            }

        }
    }

    private double calculate(String ex) {
        this.ex = ex;
        this.infixToPostfix();
        ArrayDeque<Double> stack = new ArrayDeque<>();
        double popFirst, popSecond;

        for (String str : postfix) {
            if (str == null)
                break;

            if (!str.equals("(") && !str.equals(")") && !str.equals("+") && !str.equals("-") && !str.equals("*") && !str.equals("/"))
                stack.push(Double.parseDouble(str));
            else {
                switch (str) {
                    case "*": {
                        popFirst = stack.pop();
                        popSecond = stack.pop();
                        stack.push(popSecond * popFirst);
                        break;
                    }
                    case "/": {
                        popFirst = stack.pop();
                        popSecond = stack.pop();
                        stack.push(popSecond / popFirst);
                        break;
                    }
                    case "+": {
                        popFirst = stack.pop();
                        popSecond = stack.pop();
                        stack.push(popSecond + popFirst);
                        break;
                    }
                    case "-": {
                        popFirst = stack.pop();
                        popSecond = stack.pop();
                        stack.push(popSecond - popFirst);
                        break;
                    }
                }
            }
        }
        return stack.pop();
    }

    private void outPostfix() {
        for (String str : postfix) {
            if (str == null) {
                break;
            }
            System.out.print(str + " ");
        }
    }

    public static void main(String[] args) {
        ReversePolishNotation rpn = new ReversePolishNotation();
//        System.out.println("计算结果: " + rpn.calculate("-1.23+2*(3.14+0+4.1*1*(-2*5+20)+3+3)*4--2.34"));
        System.out.println(rpn.calculate("2*(2*(2-3))-4"));
        System.out.print("后缀表达式：");
        rpn.outPostfix();
    }
}
