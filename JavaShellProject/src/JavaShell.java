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
		Process process;
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		ProcessBuilder pb = new ProcessBuilder();
		String homeDir = System.getProperty("user.dir");
		String cdCommand = null;
		
		
		List<String> commands = new ArrayList<String>();
		List<String> historyList = new ArrayList<String>();
		
		// we break out with <control><C>
		while (true)
		{
		// read what the user entered
		System.out.print("jsh>");
		commandLine = console.readLine();
		// if the user entered a return, just loop again
		if (commandLine.equals("")) continue;
		else{
			
			//clear the command list
			commands = new ArrayList<String>();
			
			//store the history commands onto the list
			historyList.add(commandLine);
			
			//history
			if(commandLine.equals("history")){
				for(int i=0; i<historyList.size(); i++){
					System.out.println(i + " " + historyList.get(i));
				}
			}
			else if(commandLine.equals("!!")){
				if(historyList.size() == 1 ){
					System.out.println("There are no previous commands. Please continue...");
					continue;
				}
				else{
					commandLine = historyList.get(historyList.size() - 2);
//					System.out.println("THIS ARE HISCOMANDS " + commandLine);
				}
			}
			else if(commandLine.matches("[!][0-9]")){
				String newString = commandLine.replaceAll("\\D+","");
				int num = Integer.parseInt(newString);
				commandLine = historyList.get(num);
				System.out.println(historyList.get(num));
				
			}
			
			//(1) parse the input to obtain the command and any parameters
			StringTokenizer getInput = new StringTokenizer(commandLine);
			//store commands in the List
			while(getInput.hasMoreTokens()){
				//add to list
				commands.add(getInput.nextToken());
			}
			
			
			//need to check for other commands
			if(commandLine.equals("cd")){
				homeDir = System.getProperty("user.dir");
				System.out.println("Your Current Dir. is: " + homeDir);
			}
			else if(commands.get(0).equals("cd") && commands.size() >= 1 ){
				cdCommand = commands.get(1);
				homeDir = cdCommand;
				
				
//				System.out.println(homeDir);
				
				
//				System.out.println("DIRRR " + pb.directory(workingDir));
				
//				System.out.print("ARE YOU HERE?");
				
			}
			else{
			
//			System.out.println("HELLOOOOO "+commands.get(1));
			
			//(3) starting the process 
	        try{
				//(2) create a ProcessBuilder object
				pb = new ProcessBuilder(commands);
	        	//need this here bc we need to know where to cd
	        	File workingDir = new File(homeDir);
	        	pb.directory(workingDir);
	        	
				process = pb.start();  
		   
		        //(4) for reading the output from stream 
		        BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream())); 
		        String s = null; 
		        while ((s = stdInput.readLine()) != null) 
		        { 
		        //(5) output the contents returned by the command
		            System.out.println(s); 
		        }
	        }
	        catch (Exception e){
//	        	e.printStackTrace();
	        	System.out.println("Please Enter a Valid Input");
	        }
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
