import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class StartProcess {

	
	public void initiateProcess(String input, List<String> commands) throws IOException{
		Process process;
		ProcessBuilder pb = new ProcessBuilder();
		
		//create a ProcessBuilder object
		pb = new ProcessBuilder(commands);
    	//create a file to properly use 'cd'
    	File workingDir = new File(input);
    	pb.directory(workingDir);
    	

		process = pb.start();
   
        //reading the output from stream 
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream())); 
        String output = null; 
        while ((output = stdInput.readLine()) != null) 
        { 
        //output the contents returned by the command
            System.out.println(output); 
        }
	}
}
