import java.io.*;
import java.net.*;
import java.util.*;

public class socket
{
    public static void main(String[] args) throws IOException
    {
        try(Socket s = new Socket("time-a.nist.gov", 13);
            Scanner in = new Scanner(s.getInputStream(), "UTF-8"))
        {
            while(in.hasNextLine())
            {
                String line = in.nextLine();
                System.out.println(line);
            }
        }

        if (args.length > 0)
        {
            String host = args[0];
            InetAddress[] addresses = InetAddress.getAllByName(host);
            for (InetAddress a : addresses)
            {
                System.out.println(a);
            }
        }
        else
        {
            InetAddress localHostAddress = InetAddress.getLocalHost();
            System.out.println(localHostAddress);
        }
    }
}