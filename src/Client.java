import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        int serverPort = 6678;
        String address = "127.0.0.1";

        try {
            InetAddress ipAddress = InetAddress.getByName(address);
            Socket socket = new Socket(ipAddress, serverPort);


            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            System.out.println("So, you need to type simething and press enter, we will send in to the server:");


            while (true){
                line = kb.readLine();
                System.out.println("Sending this line to the server");
                out.writeUTF(line);
                out.flush();
                line = in.readUTF();
                System.out.println("Server send this to you: " +line);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
