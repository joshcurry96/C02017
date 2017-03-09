package CO2017.exercise2.jc615;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;



public class SimController implements Runnable{

	MemManager _memoryManager;
	
	public SimController(){
		
	}
	
	@Override
	public void run() {
		while(_memoryManager.isChanged()==true){
			_memoryManager.toString();
		}
	}
	
	public static void main(String[] args){
		MemManager _memoryManager;
		String fname;
		String outputPolicy;
		int s = Integer.parseInt(args[1].trim());
		
		
		
		
		if(args.length != 3){
			System.out.println("incorrect ammount of parameters");
			
			String policy = args[0].trim();
			
		if(policy.equals("f")){
			 outputPolicy = "Policy: FIRST fit";
			 System.out.println(outputPolicy);
			 _memoryManager = new FirstFitMemManager(s);
		
		}
		
		if(policy.equals("b")){
			outputPolicy = "Policy: BEST fit";
			System.out.println(outputPolicy);
			_memoryManager = new BestFitMemManager(s);
			
		}
		
		if(policy.equals("w")){
			outputPolicy = "Policy: WORST fit";
			System.out.println(outputPolicy);
			_memoryManager = new WorstFitMemManager(s);
		}
		}
		fname = args[2];
		ThreadPoolExecutor threadPoolEx = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		
		
		
	    
	}

}
