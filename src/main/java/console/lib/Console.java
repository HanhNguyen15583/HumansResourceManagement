package console.lib;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Console {
    public static String getInputKeyboard(String prompt){
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(prompt);
        System.out.flush();
        try{
            return stdin.readLine();
        } catch (Exception e){
            return "Error: " + e.getMessage();
        }
    }

}
