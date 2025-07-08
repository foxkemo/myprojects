//Just a test program ,every execution will update all the resources;  
package com.design;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class DesignTest {
	public static String serverIp="localhost";
	public static int port=5678;
	public static String logPath="./log.txt";
	static void run(InputStream is,OutputStream os) throws Exception{
		var writer = new BufferedWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8));
        var reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
        Scanner scanner=new Scanner(System.in);
        System.out.println("[server] " + reader.readLine());
        for (;;) {
        	String message=">>> ";
            System.out.print(message);// 打印提示
            String s = scanner.nextLine(); // 读取一行输入
            writer.write(s);
            writer.newLine();
            writer.flush();
            String resp = reader.readLine();
            System.out.println("<<< " + resp);
            if (resp.equals("bye")) {
                break;
            }
            }
	}
	public static void main (String args[]) throws Exception {
		try(Log log = new Log(logPath)){
		String message = "Successfully created the log file";
		Tools.writeToLogFile(message,log.os);
		//Client socket object is below
		Socket server= new Socket(serverIp,port);
		try(InputStream serverInputStream =server.getInputStream()){
			try(OutputStream serverOutputStream =server.getOutputStream()){
				run(serverInputStream,serverOutputStream);
			}
		}
		server.close();
		System.out.println("exit");
		}
		}
	}
	
	

