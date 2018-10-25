import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class StartProcess {

	
	public void initiateProcess(File directory, List<String> commands, ProcessBuilder pb) throws IOException{
		Process process;
    	pb.directory(directory);	
		pb.command(commands);
		process = pb.start();
   
        // reading the output from stream 
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream())); 
        String output = null; 
        while ((output = stdInput.readLine()) != null) 
        { 
        // output the contents returned by the command
            System.out.println(output); 
        }
	}
}
