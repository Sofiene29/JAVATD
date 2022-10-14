import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Server {
    ServerSocket servSocket ;
    ObjectOutputStream out;
    ObjectInputStream in;
    Socket link;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    public Server() throws IOException {
        servSocket =new ServerSocket(1233);
        link=servSocket.accept();
        out= new ObjectOutputStream(link.getOutputStream());
        in= new ObjectInputStream(link.getInputStream());
        System.out.println("awaiting data...");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line = reader.readLine();
        System.out.println("The client sent "+line);// reads a line of text
        //String input=in.readLine();
        PrintWriter writer = new PrintWriter(out, true);
        LocalDateTime now = LocalDateTime.now();
        writer.println(dtf.format(now));

        link.close();


    }
    public static void main(String[] args) throws IOException {
        Server Serveur=new Server();
    }


}
