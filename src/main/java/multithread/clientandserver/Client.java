package multithread.clientandserver;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private Socket socket;

    public Client(){
        try {
            socket = new Socket("localhost", 8088);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class ServerHandler implements Runnable{

        @Override
        public void run() {
            //Auto-generated method stub
            try{
                InputStream is = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(is, "UTF-8");
                BufferedReader br = new BufferedReader(isr);
                while(true){
                    System.out.println(br.readLine());
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public void start(){
        try{
            ServerHandler handler = new ServerHandler();
            Thread t = new Thread(handler);
            t.setDaemon(true);
            t.start();
            OutputStream out = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");
            PrintWriter pw = new PrintWriter(osw, true);
            //创建Scanner读取用户输入内容
            Scanner scanner = new Scanner(System.in);
            while(true){
                pw.println(scanner.nextLine());
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(socket != null){
                try{
                    socket.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {

        Client client = new Client();
        client.start();
    }

}
