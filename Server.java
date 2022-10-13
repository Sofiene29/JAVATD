import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    ServerSocket servSocket ;
    ObjectOutputStream out;
    ObjectInputStream in;
    Socket link;

    public Server() throws IOException {
        servSocket =new ServerSocket(1234);
        link=servSocket.accept();
        out= new ObjectOutputStream(link.getOutputStream());
        in= new ObjectInputStream(link.getInputStream());
        System.out.println("awaiting data...");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line = reader.readLine();
        System.out.println("The client sent "+line);// reads a line of text
        //String input=in.readLine();
        PrintWriter writer = new PrintWriter(out, true);
        writer.println("Message sent to the client");

        link.close();


    }
    public static void main(String[] args) throws IOException {
        Server Serveur=new Server();
    }


}
