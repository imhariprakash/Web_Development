/*
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class myClass
{

    public static void main(String[] args){
      try{
        System.out.println(isInternetAvailable());
      }catch(Exception e){
        System.out.println("No internet connection");
      }
    }
    public static boolean isInternetAvailable() throws IOException
    {
        return isHostAvailable("http://WWW.google.com");
    }

    private static boolean isHostAvailable(String hostName) throws IOException
    {
        try(Socket socket = new Socket())
        {
            int port = 80;
            InetSocketAddress socketAddress = new InetSocketAddress(hostName, port);
            socket.connect(socketAddress, 3000);

            return true;
        }
        catch(UnknownHostException unknownHost)
        {
            return false;
        }
    }
}

*/



import java.io.*;
import java.net.*;
public class myClass {

  public static void main(final String[] args) throws Exception {
    try {
      URL url = new URL("https://dumacollective.com/404/");
      URLConnection conn = url.openConnection();
      conn.connect();
      System.out.println("connection established");
  } catch (MalformedURLException e) {
      System.out.println("Malformed URL");
  } catch (IOException e) {
      System.out.println("IO Exception");
  }
    
  }

public static String getUrlDomainName(String url) {
    String domainName = new String(url);
  
    int index = domainName.indexOf("://");
  
    if (index != -1) {
      // keep everything after the "://"
      domainName = domainName.substring(index + 3);
    }
  
    index = domainName.indexOf('/');
  
    if (index != -1) {
      // keep everything before the '/'
      domainName = domainName.substring(0, index);
    }
  
    // check for and remove a preceding 'www'
    // followed by any sequence of characters (non-greedy)
    // followed by a '.'
    // from the beginning of the string
    domainName = domainName.replaceFirst("^www.*?\\.", "");
  
    return domainName;
  }

}


