package CO2017.exercise2.jc615;

public abstract class MemManager extends Object{

	volatile boolean _changed;
	volatile int _largestSpace;
    char[] _memory;
	
	
	
	public MemManager(int s){
		
		_memory = new char[s];
		for(int i = 0; i<_memory.length;i++){
			if(_memory[i] == ' '){
				_memory[i] = '.';
			}
		}
		
		_largestSpace = s;
	/*	for(int j = 0;j<_memory.length;j++){
			if(_memory[j] == '.'){
				_largestSpace++;
			}else{
				_largestSpace--;
			}
		}*/
		_changed = true;
	}
	
	public boolean isChanged(){
	
		return _changed;
	}
	
	abstract int findSpace(int s);
	
	int countFreeSpacesAt(int pos){
		int emptySpace = 0;
		while(_memory[pos] == '.'){
			emptySpace++;
			pos++;
			
		}
		
		return emptySpace;
		
	}
	
	public void allocate(Process p) throws InterruptedException{
		int targetSlot = findSpace(p.getSize());
		while(targetSlot == -1){
			try{
				wait();
			}catch(InterruptedException e){
			}	
		}
		for(int i = 0; i < p.getSize(); i++){
			_memory[i+targetSlot] = p.getID();
		}
		p.setAddress(-1);
		_largestSpace = 0;
		for(int j = 0; j<+_memory.length;j++){
			if(_memory[j] == '.'){
				_largestSpace++;
			}
		}
		_changed = true;
		notifyAll();
	}
	
	public void free(Process p){
		for(int i = 0;i<_memory.length;i++){
			if(_memory[i]==p.getID()){
				_memory[i] = '.';
			}
		}
		p.setAddress(-1);
		_largestSpace = 0;
		for(int j = 0; j < _memory.length;j++){
			if(_memory[j] == '.'){
				_largestSpace++;
			}
		}
		_changed = false;
		notifyAll();
	}
	
	public String toString(){
		String line1 =  "0|....................|";
		String line2 = "20|....................|";
		String line3 = "40|....................|";
		String line4 = "60|....................|";
		String line5 = "80|....................|";
		
		String output = line1.concat(line2).concat(line3).concat(line4).concat(line5);
		return output;
		
		
	}
	
	
	
}












