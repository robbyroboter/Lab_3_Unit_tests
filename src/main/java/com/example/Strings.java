package com.example;

public class Strings {
//    public static void main(String[] argv){
////        char [][] dataOne= new char[2][2];
////        dataOne[0][0]='f';
////        dataOne[0][1]='*';
////        dataOne[1][0]='f';
////        dataOne[1][1]='-';
////
//    }

    public static int countArgs(char[][] array){
        int count = 0;
        for (int i=0;i<2;i++){
            for (int j=0;j<2;j++){
                if (array[i][j]== '+'| array[i][j]== '-' | array[i][j]== '*') count++;
            }
        }
        return count;
    }

    public static String change(String s){
        int count;
        StringBuilder sBuf=new StringBuilder(s);

        for (int i=sBuf.length()-2;i>=0;i--){
            if ((sBuf.charAt(i)=='О') || (sBuf.charAt(i)=='З') && (sBuf.charAt(i+1)=='О') || (sBuf.charAt(i+1)=='А') && (sBuf.charAt(i+2)=='О')){
                count=i+4;
                while (sBuf.charAt(count)!='»') count++;
                sBuf.replace(i+4, count+1, "«фирма»");
            }
        }
        return String.valueOf(sBuf);
    }

}
