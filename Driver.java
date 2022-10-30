import java.util.ArrayList;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

 public class Driver {

     public static void main(String[] args){
        String ch= InputChecks.InputChoice();
        String key= InputChecks.InputKeyword();
        ArrayList<Character> Cipher = new ArrayList<Character>();
        boolean findE1=false;
        boolean findE2=false;
        int EC1=0, EC2=0, ER1=0, ER2=0;
        int j=0, i=0, l=1;
        String msg=InputChecks.InputMsg();
        char [][] Matrix= InputChecks.CreateMatrix(key);

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
            if(Objects.equals(ch, "E") || Objects.equals(ch, "e")) {
                Cipher = PlayfairEnc.DataEncryption(ER1, EC1, ER2, EC2, Matrix);
            }
            else if(Objects.equals(ch, "D") || Objects.equals(ch, "d")){
                Cipher = PlayfairDec.DataDecryption(ER1, EC1, ER2, EC2, Matrix);
            }

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
