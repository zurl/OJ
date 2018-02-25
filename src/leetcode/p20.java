package leetcode;

import java.util.Stack;

public class p20 {

    public boolean isPair(char lhs, char rhs){
        if(lhs == '(' && rhs == ')') return true;
        if(lhs == '[' && rhs == ']') return true;
        if(lhs == '{' && rhs == '}') return true;
        return false;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++){
            if( chars[i] == '(' || chars[i] == '{' || chars[i] == '['){
                stack.push(chars[i]);
            }
            else{
                if( stack.empty() || !isPair(stack.pop(),chars[i]) ){
                    return false;
                }
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        p20 a = new p20();
        System.out.println(a.isValid("()[]{}"));
        System.out.println(a.isValid("([)]"));

    }
}
