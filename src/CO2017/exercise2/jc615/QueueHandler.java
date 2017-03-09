package CO2017.exercise2.jc615;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.ThreadPoolExecutor;

public class QueueHandler extends Object implements Runnable{

	ThreadPoolExecutor e;
	MemManager m;
	String f;
	public QueueHandler(ThreadPoolExecutor e, MemManager m, String f){
		this.e = e;
		this.m = m;
		this.f = f;
	}
	
	
	
	@Override
	public void run() {
		 String fname = f;
		    Path fpath = Paths.get(fname);
		    try (Scanner file = new Scanner(fpath)) {
		      int delay, size, rt;
		      char pid;

		      while (file.hasNextLine()) {
		        Scanner line = new Scanner(file.nextLine());
		        line.useDelimiter(":");
		        delay = line.nextInt();
		        pid   = line.next().charAt(0);
		        size  = line.nextInt();
		        rt    = line.nextInt();
		        line.close();

		        System.out.printf("delay: %s, ID: %c, size: %s, runtime: %s\n",
		                          delay, pid, size, rt );

		      }
		      file.close();
		    } catch (NoSuchFileException e) {
		      System.err.println("File not found: "+fname);
		      System.exit(1);
		    } catch (IOException e) {
		      System.err.println(e);
		      System.exit(1);
		    }
		  }

		}


