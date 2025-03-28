package com.mypack;
import java.util.Scanner;
public class Find{
  Scanner scan=new  Scanner(System.in);
  int[] arr=new int[10];
   Find(){
    int i=0;
    try {
      while (scan.hasNextLine()){
        while(scan.hasNextInt()){
          arr[i++]=scan.nextInt();
        }
      }
    }
    catch(ArrayIndexOutOfBoundsException e){
        System.out.println("input out of range");
      }

  }

}
