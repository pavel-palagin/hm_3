import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class hm_3 {
    public static void main(String[] args) {
        newData();

    }

    public static void newData(){
        Scanner in = new Scanner(System.in);
        System.out.println("Input your lastname, name, surname, phone: ");

        String str = in.nextLine();
        String[] newStr = str.split(" ");

        String nameFile = newStr[0];

        isDigit(newStr[3]);
        checkEmpty(str);
        checkFull(newStr);
        createFile(nameFile, str);


    }
    private static void isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            System.out.println("Wrong format");
        }
    }

    private static void checkEmpty(String s) throws RuntimeException {
        try {
            if(s == "" || s == " "){
                throw new RuntimeException();
            }
        }catch (Exception e){
            System.out.println("Cant input empty line");
        }
    }

    private static void checkFull(String[] s) throws RuntimeException {
        try{
            if (s.length < 4) {
                throw new RuntimeException();

            }
        }catch (Exception e){
            System.out.println("Your haven't entered all data");
        }
    }


    private static void createFile(String nameFile, String s){
        File file = new File(nameFile);
        try{
            BufferedWriter writter = new BufferedWriter(new FileWriter(file,true));
            writter.write(s + "\n");
            writter.close();
        }catch(IOException e){
            e.printStackTrace();

        }
    }

}
