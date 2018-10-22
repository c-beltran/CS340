import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.lang.*;
import java.util.*;

public class JavaShell {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String commandLine;
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		
		List<String> commands = new ArrayList<String>();
		
		// we break out with <control><C>
		while (true)
		{
		// read what the user entered
		System.out.print("jsh>");
		commandLine = console.readLine();
		// if the user entered a return, just loop again
		if (commandLine.equals("")) continue;
		else{
			//(1) parse the input to obtain the command and any parameters
			String[] getInput = commandLine.split("\\s+");
			for(int i=0; i<getInput.length; i++){
				commands.add(getInput[i]);
//				System.out.println(commands.get(i));
			}

			for(int i=0; i<commands.size(); i++){
				System.out.println(commands.get(i));
			}
			
			//create a ProcessBuilder object
			ProcessBuilder pb = new ProcessBuilder(commands);
			
			// starting the process 
	        Process process = pb.start();
	        
	        // for reading the output from stream 
	        BufferedReader stdInput = new BufferedReader(new
	         InputStreamReader(process.getInputStream())); 
	        String s = null; 
	        while ((s = stdInput.readLine()) != null) 
	        { 
	            System.out.println(s); 
	        }
		}
		
		/** The steps are:
		(1) parse the input to obtain the command and any parameters		
		(2) create a ProcessBuilder object
		(3) start the process
		(4) obtain the output stream
		(5) output the contents returned by the command */
		}
	}

}
