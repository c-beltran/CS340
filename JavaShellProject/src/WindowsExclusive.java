import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class WindowsExclusive {
	
	static HistoryFeature hf = new HistoryFeature();
	static StartProcess initiate = new StartProcess();
	
	public void startWindowsCMD() throws IOException{
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		String homeDir = System.getProperty("user.dir");
		String cdCommand = null;
		String commandLine;
				
		List<String> commands = new ArrayList<String>();
		List<String> historyList = new ArrayList<String>();
		
		while(true){
			
			// read what the user entered
			System.out.print("jsh>");
			commandLine = console.readLine();
			commandLine.toLowerCase();

			// if the user entered a return, just loop again
			if (commandLine.equals("")) continue;
			else{
				
				//clear the command list
				commands = new ArrayList<String>();
				commands.add("cmd.exe");
				commands.add("/c");
				//store the history commands onto the list
				historyList.add(commandLine);
				
				//start of history conditions
				if(commandLine.equals("history")){		
					hf.history(historyList);
					continue;
				}
				else if(commandLine.equals("!!")){
					commandLine = hf.prevCommand(historyList);
				}
				else if(commandLine.matches("[!][0-9]")){
					commandLine = hf.runIthCommand(commandLine, historyList);			
				}//end of history conditions
				
				//parse the input to obtain the command and any parameters
				StringTokenizer getInput = new StringTokenizer(commandLine);
				while(getInput.hasMoreTokens()){
					//add to list
					commands.add(getInput.nextToken());
				}

				//need to check for other commands
				if(commandLine.equals("cd")){
					homeDir = System.getProperty("user.dir");
					System.out.println("Your Current Dir. is: " + homeDir);
				}
				else if(commands.get(2).equals("cd") && commands.size() > 1 ){
					cdCommand = commands.get(3);
					homeDir = cdCommand;
				}
				else{
				//start the process 
					try{
						initiate.initiateProcess(homeDir, commands);
					}
					catch (Exception e){
						System.out.println("Please Enter a Valid Input");
					}
				}//end of else
			}//end of else
		}//end of while loop
	}//end of startWindowsCMD 
}//end of class
