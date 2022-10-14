import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {
    Socket link;
    ObjectOutputStream out;
    ObjectInputStream in;
    public Client() throws IOException {

        link=new Socket("10.32.43.235",1234);
        out= new ObjectOutputStream(link.getOutputStream());
        in= new ObjectInputStream(link.getInputStream());
        PrintWriter writer = new PrintWriter(out, true);
        writer.println("Message sent to the client");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line = reader.readLine();
        System.out.println("The server sent   "+line);// reads a line of text



    }
    public static void main(String[] args) throws IOException {
        Client cli=new Client();
    }


}
