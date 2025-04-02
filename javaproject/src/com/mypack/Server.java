import java.io.*;
import java.net.*;
    public class Server {
        int port = 8080;
        private ServerSocket serverSocket=new ServerSocket(port);
        public void run(){
            while(true){
                try{
                    System.out.println("Waiting for connection...,part is"+ serverSocket.getLocalPort());
                    
                }
            }

        }
        public static void main(String[] args)  {


        }
    }