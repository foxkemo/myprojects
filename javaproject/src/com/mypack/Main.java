package com.mypack;
import java.util.Scanner;
import com.mypack.Test;
public class Main {
  public static void main(String[] args){
    System.out.println("hello ,input your choice(1,2,3,4) to run test(1,2,3,4) method");
    int choice;
    Scanner scan=new Scanner(System.in);
/* System.in 构造参数 不可少 */
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
      case 4:
      Test.test4();
      break;
      default:
      System.out.println("invalid input");
      break;
    }


  }
}
