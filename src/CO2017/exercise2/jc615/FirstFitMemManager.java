package CO2017.exercise2.jc615;

public class FirstFitMemManager extends MemManager {

	
	
	FirstFitMemManager(int s){
		super(s);
	}
	
	protected int findSpace(int s){
     int blocksize = 0;
		
		int i;
		for(i = 0; i < _memory.length - s; i++)
		{
			if(_memory[i] == '.' && blocksize < s)
				blocksize++;
			else
			{
				if(blocksize >= s)
					return i - blocksize;
				blocksize = 0;
			}
		}
		
		return -1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
