import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class InputChecks {
    public static String InputChoice(){
        String choice;
        while(true) {
            System.out.print("Press E for encryption and D for dec: ");
            Scanner sc = new Scanner(System.in);
            choice = sc.next();
            if(Objects.equals(choice, "E") || Objects.equals(choice, "e") || Objects.equals(choice, "D") || Objects.equals(choice, "d")){
                break;
            }
        }
        return choice;
    }

    public static String InputKeyword(){
        String key, refKey;
        while(true) {
            System.out.println("Please enter the keyword.");
            System.out.print("Note: The keyword should not contain 'J', duplicate alphabetic characters, numbers or symbols: ");
            Scanner sc = new Scanner(System.in);
            key = sc.nextLine();
            refKey= key.replaceAll("\\s","").toUpperCase();

            if(!(refKey.contains("J")) && !DetectDuplicate(refKey) && refKey.matches("[a-zA-Z]+")){
                break;
            }
        }
        return refKey;
    }

    public static boolean DetectDuplicate(String key){
        Set<Character> hash_set = new HashSet<Character>();
        for(int i=0; i<key.length();i++){
            hash_set.add(key.charAt(i));
        }

        if(hash_set.size()<key.length()){ return true;}
        else{return false;}
    }

    public static char[][] CreateMatrix(String key){
        int ascii=65, k=0;
        char [][] matrix = new char[5][5];
        for(int i=0; key.length()<25; i++){
            if(ascii!=74 && !(key.contains(String.valueOf((char)ascii))))
            { key=key+(char)ascii;
                ascii++;}
            else{ascii++;}
        }
        for(int i=0; i< 5; i++){
            for(int j=0; j< 5; j++){
                matrix[i][j]= key.charAt(k);
                k++;
            }
        }
        return matrix;
    }

    public static String InputMsg(){
        String msg="";
        String refmsg="";
        while(true) {
            System.out.print("Enter your message for enc/dec: ");
            Scanner sc = new Scanner(System.in);
            msg = sc.nextLine().replaceAll("\\s","").toUpperCase();
            if(msg.length()%2!=0){
                msg+='Z';
            }
            for(int i=0; i<msg.length()-1; i++){
                if(msg.charAt(i)== msg.charAt(i+1)){
                    refmsg=msg.substring(0, i) + 'X' + msg.substring(i+1);
                }
            }
            break;
        }
        return refmsg;
    }

}
