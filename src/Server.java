import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 6678;


        try {
           ServerSocket ss = new ServerSocket(port);
            System.out.println("Server started!");
            Socket socket = ss.accept();
            System.out.println("Server got a clinet");
            System.out.println();

            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            String line = null;
            while (true){
                line = in.readUTF();
                System.out.println("Client sent that: " + line);
                System.out.println("Let's send it back");
                out.writeUTF(line);
                out.flush();
                System.out.println("Waiting for the next line");
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
