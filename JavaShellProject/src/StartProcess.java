import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
/**
 * StartProcess class
 * this class contains the process
 * of starting the ProcessBuilder
 * it also prints out the result
 * of the commands enter by user.
 * @author Carlos Alberto
 *
 */
public class StartProcess {

	/**
	 * InitiateProcess method handles the process initiation.
	 * It takes in a File, List, and  ProcessBuilder arguments.
	 * Also, it throws an IOException if found.
	 * @param directory
	 * @param commands
	 * @param pb
	 * @throws IOException
	 */
	public void initiateProcess(File directory, List<String> commands, ProcessBuilder pb) throws IOException{
		Process process;
    	pb.directory(directory);	
		pb.command(commands);
		process = pb.start();
   
        // reading the output from stream 
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream())); 
        String result = null; 
        while ((result = stdInput.readLine()) != null) 
        { 
        // output the contents returned by the command
            System.out.println(result); 
        }
	}
}
