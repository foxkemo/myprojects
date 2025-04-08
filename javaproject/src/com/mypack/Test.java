package com.mypack;
import java.util.Scanner;
import java.util.regex.*;
import com.mypack.*;
public class Test{
    static Scanner scanner =new Scanner(System.in);
    static void test1 (){
      System.out.println("循环输入测试hasNext方法");
      while (scanner.hasNext()) {
      String data = scanner.next();
      System.out.println("输入: " + data);
      if (data.equals("exit")) break; // 输入 "exit" 退出
      }
      scanner.close();
    }
    static void test2 (){
      System.out.println("正则表达式&字符串匹配测试");
      Pattern p=Pattern.compile("([0,1]\\d|2[0-3])+(:[0-5]\\d)+(:[0-5]\\d)");
      Matcher m=p.matcher("13:11:23");
      if(m.matches()){
          int i=m.groupCount();
          for(int j=0;j<=i;j++){
            System.out.printf("group%d=" + m.group(j) +"\n",j );
          }
      }

    }
    static void test3 (){
      System.out.println("test3：多线程测试");
//      ThreadTest.start();
//      Find myfind=new Find();
    }
    static void test4 (){
      System.out.println("String 测试");
      StringOperate.test();
    }
}
