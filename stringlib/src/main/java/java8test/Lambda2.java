package java8test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by AiYeSus on 10/27/2017.
 */
interface SelectString {
    boolean select(MyString s);
}

class MyString {
    String str;
    @Override
    public String toString() {return str;}
    MyString(String s) {str = s;}
}

class Lambda2 {
    static List<MyString> list = Arrays.asList(new MyString("CAR"), new MyString("TRUCK"));

    public static void printSelectedString(SelectString selectString) {
        for(MyString s : list) {
            if(selectString.select(s))
                System.out.println( s );
        }
    }

    public static void main(String argv[]) {
        // printSelectedString( s -> return s.str.charAt(0) == 'C');
        printSelectedString( s -> s.str.charAt(0) == 'C');

        printSelectedString( new SelectString() {
            @Override
            public boolean select(MyString s) {return s.str.length() < 4;}
        });
    }
}
