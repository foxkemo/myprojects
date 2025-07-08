package com.design;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Tools {
	public static void createLogFile(String logPath) throws Exception {
		File logFile=new File(logPath);
		if(logFile.createNewFile()) {
			System.out.println("Successfully created the log file ,the log path :"+ logPath );
		}else if(logFile.isDirectory()){
			System.out.println("Can't create the log file , because directory already exist ,tring to fix... ");
			logFile.delete();
			if(logFile.createNewFile()) {
				System.out.println("Success!");}
			else{
			System.out.println("Failed");
			System.exit(0);
			}
		}else if(logFile.isFile())
			System.out.println("Can't create the log file , because file already exist ,tring to fix... ");
			logFile.delete();
			if(logFile.createNewFile()) {
				System.out.println("Success!");}
			else{
			System.out.println("Failed");
			System.exit(0);
			}
		}
	public static void writeToLogFile(String message,OutputStream os) throws IOException {
		LocalDateTime ldt1 =LocalDateTime.now();
		
		//DateTimeFormatter fmt=DateTimeFormatter.ofPattern("yyyy-MM-dd-EE hh:mm:ss");
		//LocalDateTime dt2 = dt.plusDays(5).minusHours(3); manner to change the DataTime
		
		ZonedDateTime zdt = ldt1.atZone(ZoneId.of("Asia/Shanghai"));
		DateTimeFormatter fmt=DateTimeFormatter.ofPattern("yyyy-MM-dd-EE hh:mm:ss z",Locale.ENGLISH);
		String now = fmt.format(zdt);
		os.write((now +" "+ message +"\n").getBytes("UTF-8"));
		
		//LocalDateTime ldt2 =zdt.toLocalDateTime();
		//ZonedDateTime zdt2 = zbj.withZoneSameInstant(ZoneId.of("America/New_York"));
		
		
		
	}
}
