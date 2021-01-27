package logic;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.scene.control.TextField;

public class AddInterest {
	public static void addInterest(Person person, TextField interestInput) {
		String interest = interestInput.getText().toLowerCase();		
		person.putInterest(interest);
		checkListForEmptySpaces(person.getInterests());
		checkListForDuplicates(person.getInterests(), interest);
		interestInput.clear();
	}
	
	public static void checkListForEmptySpaces(ArrayList<String> interests) {
		interests.removeAll(Arrays.asList("", null, " ", "exit"));
	}
	
	public static void checkListForDuplicates(ArrayList<String> interests, String interest) {		
		for (int i = 0; i < interests.size(); i++) {
			for (int j = i + 1; j < interests.size(); j++) {
				if(!interests.get(j).equals(interests.get(i))) {
					continue;
					}
				interests.remove(j);
				j--;
				}
			}
		}
}
