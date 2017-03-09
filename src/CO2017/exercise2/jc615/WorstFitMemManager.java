package CO2017.exercise2.jc615;

public class WorstFitMemManager extends MemManager{

	public WorstFitMemManager(int s) {
		super(s);
	}

	
	protected int findSpace(int s) {
		//Go through and find the index of the biggest gap
				int best_start = -1;
				int current_start = -1;
				int biggest_size = 0;
				int found_size = 0;
				
				for (int i = 0; i < _memory.length; i++) {
					if (_memory[i] == '.') {
						if (found_size == 0) {
							current_start = i;
						}
						found_size++;
					} else {
						//Just hit non-free memory
						if (found_size > biggest_size) {
							biggest_size = found_size;
							best_start = current_start;
						}
						found_size = 0;				
					}
				}
				
				//If the last slot is free, we take care of that here
				if (found_size > biggest_size) {
					biggest_size = found_size;
					best_start = current_start;
				}
				
				if (s > biggest_size) { //No slot available
					return -1;
				} else {
					return best_start;
				}
			}
	}


