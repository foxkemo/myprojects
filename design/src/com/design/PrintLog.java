//Just a InputStream test.

package com.design;
import java.io.*;
import java.nio.charset.StandardCharsets;
public class PrintLog {
	public static void main(String[] args) throws Exception {
		File logFile = new File(DesignTest.logPath);
		if(logFile.isFile()) {
		//First method
			byte[] inputArray=new byte[100];
			InputStream is = new FileInputStream(logFile);
			int num =is.read(inputArray);
			// String testStr=inputArray.toString();
			// Wrong way to switch, because testStr will be a string of array items.
			String testStr= new String(inputArray,StandardCharsets.UTF_8);
			System.out.println("FileInputStream manner to read the file");
			System.out.println("\""+testStr+"\"");
			System.out.println("The byte number of the testStr is "+ num);			
			is.close();
		//Second method
			System.out.println("FileReader manner to read the file");
			Reader myReader= new FileReader(logFile,StandardCharsets.UTF_8);
			char[] buffer=new char[1000];
			num = myReader.read(buffer);
			//testStr=buffer.toString();	wrong manner because it is the address of buffer , shallow copy?	
			testStr=new String(buffer);
			System.out.println("\""+testStr+"\"");
			System.out.println("The character number of the testStr is "+ num);			
			myReader.close();
			}		
	}
}
