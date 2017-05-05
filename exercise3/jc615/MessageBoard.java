package exercise3.jc615;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class MessageBoard {

	ConcurrentHashMap<MessageHeader, String> messages =
			new ConcurrentHashMap<MessageHeader, String>();
	MessageBoard(){
		
	}
	
	void SaveMessage(MessageHeader mh, String msg){
		MessageHeader _header = mh;
		String _message = msg;
	
		if(messages.containsKey(_header)){
			_message = null;
		}
		messages.putIfAbsent(_header, _message);
		
	}
	
	String GetMessage(MessageHeader mh){
		MessageHeader _header = mh;
		if(messages.contains( _header)){
		String _message = messages.get(_header);
		System.out.println(_message);
		}else{
			System.out.println("No such message");
		}
		return "";
		
	}
	
	Set<MessageHeader> ListHeaders(){
		Set<MessageHeader> _messageHeaders = null;
		
		for(MessageHeader mh : messages.keySet()){
			_messageHeaders.add(mh);
		}
		System.out.println(_messageHeaders);
		return _messageHeaders;
		
	}
	
	
}


