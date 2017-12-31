package java8test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by AiYeSus on 10/22/2017.
 */

public class ReadFileTest {
    // Test Java8 FileReader
    public static void main() {
        try {
            BufferedReader bfrdr = new BufferedReader(new FileReader("input8.dat"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Need java.io.inputStream as parameter
/*
        BufferedReader bfrdr = new BufferedReader(new InputStreamReader("input8.dat"));

        // Need java.io.Reader
        BufferedReader bf = new BufferedReader(new File("input8.dat"));

        // Wrong parameter type for constructor
        BufferedReader bufrdr = new BufferedReader("input8.dat");
*/

        try (
            FileReader inputStream = new FileReader("input8.dat")) {
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
