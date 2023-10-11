import java.io.*;
import java.net.*;
import java.util.*;

public class Server
{
    public static void main(String[] args) throws IOException
    {
        establish();
    }

    static void establish() throws IOException
    {
        try(ServerSocket s = new ServerSocket(5439))
        {
            try(Socket incoming = s.accept())
            {
                InputStream inStream = incoming.getInputStream();
                OutputStream outStream = incoming.getOutputStream();
                try(Scanner in = new Scanner(inStream, "UTF8"))
                {
                    PrintWriter out = new PrintWriter(
                            new OutputStreamWriter(outStream, "UTF-8"),
                                    true);
                    out.println("Hello! Enter BYE to exit...");
                    boolean done = false;
                    while(!done && in.hasNextLine())
                    {
                        String line = in.nextLine();
                        out.println("Echo: " + line);
                        if(line.trim().equals("BYE"))
                            done = true;
                    }
                }
            }
        }
    }
}