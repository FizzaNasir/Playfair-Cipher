import java.util.ArrayList;
import java.util.*;
public class PlayfairDec {
        static ArrayList<Character> Cipher = new ArrayList<Character>();
        public static ArrayList<Character> DataDecryption(int er1, int ec1, int er2, int ec2,  char [][] Matrix ){

            if(ec1==ec2)//elements are in same column
            {
                SameColumnElementsEnc(er1, ec1, er2, ec2, Cipher, Matrix);
            }
            else if(er1==er2)//elements are in same column
            {
                SameRowElementsDec(er1, ec1, er2, ec2, Cipher, Matrix);
            }
            else{
                DiffRowColElementsDec(er1, ec1, er2, ec2, Cipher, Matrix);
            }
            return Cipher;
        }

        public static void SameColumnElementsEnc(int er1, int ec1, int er2, int ec2, ArrayList<Character> cipher,  char [][] Matrix ){
            if(er1==0)// element1 is the first element of column
            {
                cipher.add(Matrix[4][ec1]);
                cipher.add(Matrix[er2-1][ec2]);
            }
            else if(er2==0)// element2 is the first element of column
            {
                cipher.add(Matrix[er1-1][ec1]);
                cipher.add(Matrix[4][ec2]);
            }
            else{
                cipher.add(Matrix[er1-1][ec1]);
                cipher.add(Matrix[er2-1][ec2]);
            }
        }

        public static void DiffRowColElementsDec(int er1, int ec1, int er2, int ec2, ArrayList<Character> cipher,  char [][] Matrix){
            cipher.add(Matrix[er1][ec2]);
            cipher.add(Matrix[er2][ec1]);
        }


        public static void SameRowElementsDec(int er1, int ec1, int er2, int ec2, ArrayList<Character> cipher,  char [][] Matrix ){
            if(ec1==0)// element1 is the first element of row
            {
                cipher.add(Matrix[er1][4]);
                cipher.add(Matrix[er2][ec2-1]);
            }
            else if(ec2==0)// element2 is the first element of row
            {cipher.add(Matrix[er1][ec1-1]);
                cipher.add(Matrix[er2][4]);
            }
            else{
                cipher.add(Matrix[er1][ec1-1]);
                cipher.add(Matrix[er2][ec2-1]);
            }
        }

    }
