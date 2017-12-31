package DataStructure;

import com.example.QueueWithTwoStacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by AiYeSus on 12/11/2017.
 */

public class NestedBracket {

    public static void main(String[] args) {
        // Check for properly paired open/close bracket in string
        // Use stack ( FILO ) store open brackets, a queue ( from two stacks ) to store close bracket
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        Stack<Character> OpenBracketStack = new Stack();
        QueueWithTwoStacks<Character> CloseBracketQueue = new QueueWithTwoStacks();

        char[] chArr = s.toCharArray();
        char ch1, ch2;
        List<Character> OpenBracketList = new ArrayList<Character>(Arrays.asList('(', '{', '['));
        List<Character> CloseBracketList = new ArrayList<Character>(Arrays.asList(')', '}', ']'));
        int sz = chArr.length;
        boolean nested = true;
        for(int i=0; i < sz; i++) {
            if ( OpenBracketList.contains( chArr[i] ) ) {
                OpenBracketStack.push( chArr[i] );
            }
            if ( CloseBracketList.contains( chArr[i] ) ) {
                ch1 = OpenBracketStack.pop();
                ch2 = chArr[i];
                if ( ( ch1 == '(' && ch2 == ')') || ( ch1 == '[' && ch2 == ']') ||
                        ( ch1 == '{' && ch2 == '}') ) continue;
                else nested = false;
            }
        }

        if ( OpenBracketStack.size() > 0 ) nested = false;
        System.out.println("nested ? " + ((nested == true) ? "1" :"0" ));
    }
}
