import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.lang.*;
import java.util.*;

public class JavaShell {
//	public static String separator = "\\";
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String commandLine;
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		ProcessBuilder pb = new ProcessBuilder();
		
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
			StringTokenizer getInput = new StringTokenizer(commandLine);
			//store commands in the List
			while(getInput.hasMoreTokens()){
				commands.add(getInput.nextToken());
			}
			
			//need to check for other commands
			
			//(2) create a ProcessBuilder object
			pb = new ProcessBuilder(commands);
			
			//(3) starting the process 
	        try{
				Process process = pb.start();  //NEED TO FIX TRY CATCH
		        
		        //(4) for reading the output from stream 
		        BufferedReader stdInput = new BufferedReader(new
		         InputStreamReader(process.getInputStream())); 
		        String s = null; 
		        while ((s = stdInput.readLine()) != null) 
		        { 
		        //(5) output the contents returned by the command
		            System.out.println(s); 
		        }
	        }
	        catch (Exception e){
	        	System.out.println("Please Enter a Valid Input");
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
