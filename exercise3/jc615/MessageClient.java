package exercise3.jc615;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.net.Socket;
import java.net.UnknownHostException;

public class MessageClient {

	
	public MessageClient(){
	}
	
	public static void main(String[] args) throws IOException{
		
		if(args.length != 2){
			System.out.println("Incorrect amount of parameters");
		}
		//String message;
		String recieved;
		
		String _hostname = args[0].trim();
		int _port = Integer.parseInt(args[1].trim());
		
		try {
			while(true){
			Socket server = new Socket(_hostname, _port);
		
		System.out.println("Connection to " + _hostname + " Successful");
	/*	
		BufferedReader in =
				new BufferedReader (
						new InputStreamReader(server.getInputStream(),
								"UTF-8"));
		
		Writer out =
				new OutputStreamWriter(server.getOutputStream());
		BufferedWriter bw = new BufferedWriter(out);
		PrintStream PS = new PrintStream(server.getOutputStream());
		BufferedReader stdin =
				new BufferedReader(new InputStreamReader(System.in));
		do{
			System.out.println("Enter your message here: ");
		
		message = stdin.readLine();
		System.out.println(message);
		bw.write(message);
		bw.flush();
		
		if(message != "BYE"){
			recieved = in.readLine();
			System.out.println(recieved);
		}
		}while(message != "BYE");
		System.out.print("Client Shutdown");
		server.close();*/
		
		OutputStream os = server.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(osw);
		
		BufferedReader stdin =
				new BufferedReader(new InputStreamReader(System.in));
		
		InputStream is = server.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		String number;
		do{
		System.out.println("Enter Message");
		number = stdin.readLine();
		
		String sendMessage = number +"\n";
		bw.write(sendMessage);
		bw.flush();
		System.out.println("Message sent to server");
		
		if(sendMessage != "BYE"){
		String message = br.readLine();
		System.out.println("Message recieved from server " + message);
		}
		
		}while(number != "BYE");
		System.out.println("Closing connection");
		server.close();
		}
		}
		 catch (Exception exception) {
            exception.printStackTrace();
        }
    finally
        {
            //Closing the socket
            try
            {
           //     server.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
       }
  }
	
	}
}

