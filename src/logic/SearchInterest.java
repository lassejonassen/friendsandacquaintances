package logic;

public class SearchInterest {	
	
	public static boolean searchInterest(String interest) {
		for(Person person : logic.PersonImpl.personList) {
			for(String personInterest : person.getInterests()) {
				if(personInterest.equals(interest)) {
					return true;
				}
			}
		}
	return false;
	}
}
