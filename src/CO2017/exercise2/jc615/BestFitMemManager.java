package CO2017.exercise2.jc615;

public class BestFitMemManager extends MemManager {

	
	BestFitMemManager(int s){
		super(s);
	}
	
	int findSpace(int s){
		int best_start = -1;
		int best_size = Integer.MAX_VALUE;
		int current_start = -1;
		int current_size = 0;
		
		for (int i = 0; i < _memory.length; i++) {
			if (_memory[i] == '.') {
				if (current_size == 0) {
					current_start = i;
				}
				current_size++;
			} else {
				//We just hit in-use memory
				
				//Only change placement info if we're coming off of an empty block
				if (current_size > 0) {
					if (current_size < best_size && current_size >= s) {
						best_start = current_start;
						best_size = current_size;
					}
					current_size = 0;
				}
			}
		}
		
		//If the last spot is free, take that block into account
		if (current_size < best_size && current_size >= s) {
			best_start = current_start;
			best_size = current_size;
			current_size = 0;
		}
		
		return best_start;
	}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
