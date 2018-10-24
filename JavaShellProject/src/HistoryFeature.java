import java.util.List;
/**
 * HistoryFeature class
 * contains the functions needed to properly
 * execute the history feature of JavaShell.
 * @author Carlos Alberto
 *
 */
public class HistoryFeature {
	/**
	 * This function accepts a list and prints 
	 * the list of history commands
	 * @param historyList
	 */
	public void history(List<String> historyList){
		for(int i=0; i<historyList.size(); i++){
			System.out.println(i + " " + historyList.get(i));
		}
	}
	/**
	 * This function accepts a list and returns 
	 * back the previous command entered by a user
	 * @param historyList
	 * @return
	 */
	public String prevCommand(List<String> historyList){
		if(historyList.size() == 1 ){
			System.out.println("There are no previous commands. Please continue...");
		}

		return historyList.get(historyList.size() - 2);
	}
	
	/**
	 * This function accepts a string input and a list 
	 * it returns back the ith command entered by a user
	 * Example - !4 and so on
	 * @param input
	 * @param historyList
	 * @return
	 */
	public String runIthCommand(String input, List<String> historyList){
		String newString = input.replaceAll("\\D+","");
		int num = Integer.parseInt(newString);
		
		return historyList.get(num);		
	}
}
