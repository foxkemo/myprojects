package com.mypack;
import java.util.regex.*;
import java.util.Scanner;
public final class StringOperate{
  private static String str1="   \n \r taokunkun1@icloud.com";
  private static String mailAddr=str1.trim();
  private static String pattern="[a-z|A-Z|0-9]+@[a-z|A-Z|0-9]+\\.com";
  private static String farmatStr="your email is %s";
  public static void test(){
    System.out.printf("str1 is %s \nmailAddr is %s\npattern is %s\n格式串 %s\n\n格式化后的Str is :\n%s\n",str1,mailAddr,pattern,farmatStr,farmatStr.formatted(mailAddr));




  }
enum Weekday {
  MON(1),TUE(2),WED(3),THU(4),FRI(5),SAT(6),SUN(0);
  int dayvalue;
  Weekday(int value){
    this.dayvalue=value;
  }


}



}
