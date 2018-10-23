import java.util.List;

public class HistoryFeature {
	/**
	 * this function prints the list
	 * of history commands
	 * @param historyList
	 */
	public void history(List<String> historyList){
		for(int i=0; i<historyList.size(); i++){
			System.out.println(i + " " + historyList.get(i));
		}
	}
	
	public String prevCommand(List<String> historyList){
		if(historyList.size() == 1 ){
			System.out.println("There are no previous commands. Please continue...");
		}

		return historyList.get(historyList.size() - 2);
	}
	
	public String runIthCommand(String input, List<String> historyList){
		String newString = input.replaceAll("\\D+","");
		int num = Integer.parseInt(newString);
		
		return historyList.get(num);		
	}
}
