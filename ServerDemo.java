import java.net.Socket;
import java.net.ServerSocket;
import java.io.DataInputStream;
import java.io.PrintStream;
import java.io.IOException;

public class ServerDemo {
    public static void main(String[] args) {
        String rxMsg="", txMsg="";
        final int serverListenPort = 33000;
        try(ServerSocket serverSock = new ServerSocket(serverListenPort)) {
            
            try(Socket conn = serverSock.accept();) {
                DataInputStream in = new DataInputStream(conn.getInputStream());
                PrintStream out = new PrintStream(conn.getOutputStream());

                while(true) {
                    if((rxMsg=in.readLine())!=null) {
                        System.out.println("Client says: " + rxMsg);
                        txMsg="Hi";
                        out.println(txMsg);
                    }
                }
            } catch(IOException e) {
                System.err.println("Error occurred when listening from client" + e);
            }

        } catch(IOException e) {
            System.err.println("Unable to start server" + e);
        }


    }
}
