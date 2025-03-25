package com.mypack;
import java.util.Scanner;
import com.mypack.Test;
public class Main {
  public static void main(String[] args){
    System.out.println("hello ,input your choice(1,2,3) to run test(1,2,3) method");
    int choice;
    Scanner scan=new Scanner(System.in);
    choice=scan.nextInt();
    switch (choice){
      case 1:
      Test.test1();
      break;
      case 2:
      Test.test2();
      break;
      case 3:
      Test.test3();
      break;
      default:
      System.out.println("invalid input");
    }


  }
}
