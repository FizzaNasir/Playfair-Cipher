import java.util.*;
class PlayfairEnc {
    static ArrayList<Character> Cipher = new ArrayList<Character>();
public static ArrayList<Character> DataEncryption(int er1, int ec1, int er2, int ec2,  char [][] Matrix ){

    if(ec1==ec2)//elements are in same column
    {
        SameColumnElementsEnc(er1, ec1, er2, ec2, Cipher, Matrix);
    }
    else if(er1==er2)//elements are in same column
    {
        SameRowElementsEnc(er1, ec1, er2, ec2, Cipher, Matrix);
    }
    else{
        DiffRowColElementsEnc(er1, ec1, er2, ec2, Cipher, Matrix);
    }
    return Cipher;
}

public static void SameColumnElementsEnc(int er1, int ec1, int er2, int ec2, ArrayList<Character> cipher,  char [][] Matrix ){
    if(er1==4)// element1 is the last element of column
    {
     cipher.add(Matrix[0][ec1]);
     cipher.add(Matrix[er2+1][ec2]);
    }
    else if(er2==4)// element2 is the last element of column
    {
     cipher.add(Matrix[er1+1][ec1]);
     cipher.add(Matrix[0][ec2]);
    }
    else{
        cipher.add(Matrix[er1+1][ec1]);
        cipher.add(Matrix[er2+1][ec2]);
    }
}

public static void DiffRowColElementsEnc(int er1, int ec1, int er2, int ec2, ArrayList<Character> cipher,  char [][] Matrix){
    cipher.add(Matrix[er1][ec2]);
    cipher.add(Matrix[er2][ec1]);
}


public static void SameRowElementsEnc(int er1, int ec1, int er2, int ec2, ArrayList<Character> cipher,  char [][] Matrix ){
        if(ec1==4)// element1 is the last element of row
        {
            cipher.add(Matrix[er1][0]);
            cipher.add(Matrix[er2][ec2+1]);
        }
        else if(ec2==4)// element2 is the last element of row
        {cipher.add(Matrix[er1][ec1+1]);
            cipher.add(Matrix[er2][0]);
        }
        else{
            cipher.add(Matrix[er1][ec1+1]);
            cipher.add(Matrix[er2][ec2+1]);
        }
    }
    public static void main(String []args){
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

//        while(j<msg.length()/2)
//        for(int r=0; r<5; r++){
//            for(int c=0; c<5; c++){
//                if(Matrix[r][c]==msg.charAt(i)){
//                    ER1=r; EC1=c;
//                    findE1=true; }
//
//                if(Matrix[r][c]==msg.charAt(i+1)){
//                    ER2=r; EC2=c;
//                    findE2=true;
//                }
//                if(findE1 && findE2) {
//                    Cipher = DataEncryption(ER1, EC1, ER2, EC2, Matrix);
//                }
//                i++;
//            } //end of inner for loop
//        } //end of outer for loop
//        j++;
//MEAT
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
              Cipher = DataEncryption(ER1, EC1, ER2, EC2, Matrix);

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