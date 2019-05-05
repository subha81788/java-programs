import java.net.Socket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.io.DataInputStream;
import java.io.PrintStream;
import java.io.IOException;

public class ClientSocketDemo {
    public static void main(String[] args) {
        InetAddress serverAddr=null;
        try { 
            serverAddr = InetAddress.getByName("127.0.0.1"); 
        } catch(UnknownHostException e) {
            System.err.println(e);
        }
        int serverPortNum = 33000;
        try(Socket clientSock = new Socket(serverAddr,serverPortNum)) {
            if(clientSock == null) {
                System.out.println("Unable to connect to server");
            }

            DataInputStream in=new DataInputStream(clientSock.getInputStream());

            PrintStream out=new PrintStream(clientSock.getOutputStream());
            String txMsg="", rxMsg="";
            txMsg = "Hello";
            out.println(txMsg);
            rxMsg=in.readLine();
            System.out.println("Server says: " + rxMsg);
        } catch(UnknownHostException e) {
            System.err.println("Unable to create client socket" + e);
        } catch(IOException e) {
            System.err.println("Unable to create client socket" + e);
        }
    }
}
