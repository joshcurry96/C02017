package CO2017.exercise2.jc615;

public class Process extends Object implements Runnable{

	
	private char i;
	private MemManager m;
	private int s;
	private int r;
	private int a;
	
	public Process(MemManager m, char i, int s, int r){
		this.i = i;
		this.m = m;
		this.s = s;
		this.r = r;
	}
	
	public int getSize(){
		return s;
		
	}
	
	public char getID(){
		return i;
		
	}
	
	public void setAddress(int a){
		this.a = a;
		
	} 
	
	public int getAddress(){
		return a;
	}
	
	@Override
	public void run() {
		
		System.out.println(toString() + " waiting to run.");
		//m.allocate(p);
		System.out.println(toString() + " running.");
		//Thread.sleep(100);
		//m.free(p);
		System.out.println(toString() + " has finished.");
		
	}

	public String toString(){
	
		String message = getID() + ": " +getAddress() + " + " + getSize();
		return message;
	}
}
