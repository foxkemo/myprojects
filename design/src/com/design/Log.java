package com.design;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Log implements AutoCloseable {
		String path;
		OutputStream os;
		InputStream is;
		Log(String path) throws Exception{
			this.path=path;
			Tools.createLogFile(this.path);
			this.is = new FileInputStream(this.path);
			this.os =new FileOutputStream(this.path);		
		}
		@Override
		public void close() throws IOException {
			is.close();
			os.close();
		}
	}
//try-with-resources manner 

