package com.example.datatructure.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        //9 3 1 - 3 * + 10 2 / +
        String s = "9 3 1 - 3 * + 10 2 / +";
        List<String> listString = getListString(s);
        System.out.println(calculate(listString));
    }


    /**
     * 将逆波兰表达式字符串，转为集合
     * @param suffix
     * @return
     */
    public static List<String> getListString(String suffix){
        String[] split = suffix.split(" ");
        List<String> strings = Arrays.asList(split);
        return strings;
    }


    /**
     * 计算逆波兰表达式并返回结果
     * @param list
     * @return
     */
    public static int calculate(List<String> list){
        Stack<String> stack = new Stack<>();
        for (String s : list) {
            //判断是数字还是运输符号
            if (s.matches("\\d+")){
                //数字
                stack.push(s);
            }else {
                int s2 = Integer.parseInt(stack.pop());
                int s1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (s.equals("+")){
                    res = s1 + s2;
                }
                else if (s.equals("-")){
                    res = s1 - s2;
                }
                else if (s.equals("*")){
                    res = s1 * s2;
                }
                else if (s.equals("/")){
                    res = s1 / s2;
                }
                System.out.println(res);
                stack.push(""+res);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
