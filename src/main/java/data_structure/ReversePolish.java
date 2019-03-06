package data_structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class Operation {
    private static final int ADDITION=1;
    private static final int SUBTRACTION=1;
    private static final int MULTIPLICATION=2;
    private static final int DIVISION=2;

    public static int getValue(String operation){
        int result;
        switch (operation){
            case "+":
                result=ADDITION;
                break;
            case "-":
                result=SUBTRACTION;
                break;
            case "*":
                result=MULTIPLICATION;
                break;
            case "/":
                result=DIVISION;
                break;
            default:
//                System.out.println("不存在该运算符");
                result=0;
        }
        return result;
    }
}



public class ReversePolish {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入运算表达式:");
        String expressionStr=sc.nextLine();
//        System.out.println(expressionStr);
        List<String> zx= toInfixExpression(expressionStr);
        List<String> rpn=parseSuffixExpression(zx);
        StringBuilder rpnStr= new StringBuilder();
        for(String str:rpn){
            rpnStr.append(str).append(" ");
        }
        System.out.println(rpnStr);

        System.out.println("计算结果:"+ calculate(rpn));
    }

    private static List<String> toInfixExpression(String s) {
        List<String> ls = new ArrayList<>();//存储中序表达式
        int i = 0;
        StringBuilder str;
        char c;
        do {
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                ls.add("" + c);
                i++;
            } else {
                str = new StringBuilder();
                while (i < s.length() && s.charAt(i) >= 48
                        && (c = s.charAt(i)) <= 57) {
                    str.append(c);
                    i++;
                }
                ls.add(str.toString());
            }

        } while (i < s.length());
        return ls;
    }


    private static List<String> parseSuffixExpression(List<String> ls) {
        Stack<String> s1=new Stack<>();
        List<String> lss = new ArrayList<>();
        for (String ss : ls) {
            if (ss.matches("\\d+")) {
                lss.add(ss);
            } else if (ss.equals("(")) {
                s1.push(ss);
            } else if (ss.equals(")")) {

                while (!s1.peek().equals("(")) {
                    lss.add(s1.pop());
                }
                s1.pop();
            } else {
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(ss)) {
                    lss.add(s1.pop());
                }
                s1.push(ss);
            }
        }
        while (s1.size() != 0) {
            lss.add(s1.pop());
        }
        return lss;
    }

    private static int calculate(List<String> ls) {
        Stack<String> s=new Stack<>();
        for (String str : ls) {
            if (str.matches("\\d+")) {
                s.push(str);
            } else {
                int b = Integer.parseInt(s.pop());
                int a = Integer.parseInt(s.pop());
                int result=0;
                switch (str) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    case "/":
                        result = a / b;
                        break;
                }
                s.push("" + result);
            }
        }
        System.out.println(s.peek());
        return Integer.parseInt(s.pop());
    }
}