import java.util.ArrayList;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

 public class Driver {

    public static String InputChoice(){
        String choice;
        while(true) {
            System.out.print("Press E for encryption and D for dec");
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
            System.out.print("Note: The keyword should not contain 'J', duplicate alphabetic characters, numbers or symbols");
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

    public static void main(String[] args){
        String ch=InputChoice();
        String key=InputKeyword();
        ArrayList<Character> Cipher = new ArrayList<Character>();
        Boolean findE1=false;
        Boolean findE2=false;
        int EC1=0, EC2=0, ER1=0, ER2=0;

        int j=0, i=0, l=1;
        String msg="FAIZAL";
        char [][] Matrix= {{'M', 'O', 'N', 'A', 'R'},
                {'C', 'H', 'Y', 'D', 'E'},
                {'F', 'G', 'I', 'K', 'L'},
                {'P', 'Q', 'R', 'S', 'T'},
                {'U', 'V', 'W', 'X', 'Z'}};

        while(j<msg.length()/2){
            while(!findE1 && !findE2)
            {
                for(int r=0; r<5; r++)
                {
                    for(int c=0; c<5; c++){
                        if(Matrix[r][c]==msg.charAt(i)){
                            ER1=r; EC1=c;
                            findE1=true;
                        }
                        else if(Matrix[r][c]==msg.charAt(i+1)){
                            ER2=r; EC2=c;
                            findE2=true;
                        }
                    }
                }
            }
            Cipher = PlayfairEnc.DataEncryption(ER1, EC1, ER2, EC2, Matrix);

            findE1=false;
            findE2=false;
            i+=2;
            j++;
        }
        System.out.println("The encrypted text is: " );
        for(int k=0; k<Cipher.size();k++){
            System.out.print( Cipher.get(k));
        }
    }


}
