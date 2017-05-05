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
import java.io.PrintWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

public class MessageServer {
	
	private static Socket client;
	private static MessageBoard mb = new MessageBoard();
	

	public MessageServer(){
	}
	
	public static void main(String[] args) throws IOException{
		if(args.length != 1){
			System.out.println("Please enter a port number.");
		}
		
		
		String received="";
		//String returnMessage="";
		int _port = Integer.parseInt(args[0].trim());
		try{
			ServerSocket server = new ServerSocket(_port);
			while(true){
			System.out.println("Waiting for client...");
			Socket client = server.accept();
			System.out.println("successfully connected to client.");
		/*	Writer out = 
					new OutputStreamWriter(client.getOutputStream());
			BufferedReader in = new BufferedReader(
					new InputStreamReader(client.getInputStream()));
			
			message = in.readLine();
			System.out.println("Client sent: " + message);
			do{
				
			
		 
			System.out.println("Client sent: " + message);
			
			if(message.contains("LIST")){
				mb.ListHeaders();
			}
			if(message.contains("SEND")){
				
			}
			if(message.contains("GET:")){
				String number = Character.toString(message.charAt(6));
				int h = Integer.parseInt(number);
				char t = message.charAt(4);
				MessageHeader mh = new MessageHeader(t,h);
				mb.GetMessage(mh);
			if(message.equals("BYE")){
					System.out.println("Server Shutdown");
					server.close();
				}
			}
			}while (message != "BYE");
			System.out.println("Enter your message here: ");
			out.write(returnMessage);
			out.flush();
		*/
			
			String returnMessage;
			InputStream is = client.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String message = br.readLine();
			
			System.out.println("Message recieved from client is " + message);
			
			OutputStream os = client.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
				
				 
				System.out.println("Client sent: " + message);
				
				if(message.contains("LIST")){
					 mb.ListHeaders();
				}
				if(message.contains("SEND:")){
					String[] _split = message.split(":");
					String _header = _split[1];
					String _body = _split[2];
					int id = Integer.parseInt(_header);
					
					MessageHeader mh = new MessageHeader('t',id);
					System.out.println(_body);
					mb.SaveMessage(mh, _body);
					returnMessage = "Message Recieved";
					bw.write(returnMessage);
					System.out.println("Message sent to client: " + returnMessage);
					bw.flush();
				}
				if(message.contains("GET:")){
					String[] result = message.split(":");
					String msgId = result[1];
					String[] result2 = msgId.split("\\+");
					String tId = result2[0];
					char t = tId.charAt(0);
					String id = result[1];
					int mId = Integer.parseInt(id);
					MessageHeader mh = new MessageHeader(t,mId);
					mb.GetMessage(mh);
				if(message.equals("BYE")){
					System.out.println("Server Shutdown");
					server.close();
					}
				}
		}
			
	}
	catch(Exception e){
		e.printStackTrace();
	}
		finally{
			try{
				client.close();
			}catch(Exception e){}
		}
	}
		//}catch(IOException e){
		//	System.err.println(e);
	//	}
	}
/*try{
	int numberInIntFormat = Integer.parseInt(number);
	int returnValue = numberInIntFormat * 2;
	returnMessage = String.valueOf(returnValue) + "\n";
}
catch(NumberFormatException e){
	returnMessage = "Please send a proper number\n";
}*/


