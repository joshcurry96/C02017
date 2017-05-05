package exercise3.jc615;

public class Test {

	public static void main(String[] args){
	String message = "GET:B+4:Penis";
	String result[] = message.split(":");
	String header = result[1];
	String[] result2 = header.split("\\+");
	String header2 = result2[1];
	System.out.println(header2);
}
}
