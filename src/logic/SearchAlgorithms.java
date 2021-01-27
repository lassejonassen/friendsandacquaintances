package logic;

/*
 * Fornavn
 * Efternavn
 * Mobil
 * Email
 * Interesser
 * 
 */

public class SearchAlgorithms {
	public static void search(String fname, String lname, String mobile, String email, String interest) {
		
		/*
		 * Search by fname, lname, mobile, email, interest
		 */
		for (Person i : logic.PersonImpl.personList) {
			if (fname.equals(i.getFirstName()) && lname.equals(i.getLastName()) && mobile.equals(i.getMobile())
					&& email.equals(i.getEmail()) && SearchInterest.searchInterest(interest)) {
				logic.PersonImpl.tempList.add(i);
			}
		}
		
		/*
		 * Search by fname, lname, mobile, email
		 */
		if (logic.PersonImpl.tempList.size() == 0) {
			for (Person i : logic.PersonImpl.personList) {
				if (fname.equals(i.getFirstName()) && lname.equals(i.getLastName()) && mobile.equals(i.getMobile())
						&& email.equals(i.getEmail())) {
					logic.PersonImpl.tempList.add(i);
				}
			}
		}
		
		/*
		 * Search by fname, lname, mobile
		 */
		if (logic.PersonImpl.tempList.size() == 0) {
			for (Person i : logic.PersonImpl.personList) {
				if (fname.equals(i.getFirstName()) && lname.equals(i.getLastName()) && mobile.equals(i.getMobile())) {
					logic.PersonImpl.tempList.add(i);
				}
			}
		}
		
		/*
		 * Search by fname, lname
		 */
		if (logic.PersonImpl.tempList.size() == 0) {
			for (Person i : logic.PersonImpl.personList) {
				if (fname.equals(i.getFirstName()) && lname.equals(i.getLastName())) {
					logic.PersonImpl.tempList.add(i);
				}
			}
		}

		/*
		 * Search by fname only
		 */
		if (logic.PersonImpl.tempList.size() == 0) {
			for (Person i : logic.PersonImpl.personList) {
				if (fname.equals(i.getFirstName())) {
					logic.PersonImpl.tempList.add(i);
				}
			}
		}
		
		/*
		 * Search by lname only
		 */
		if (logic.PersonImpl.tempList.size() == 0) {
			for (Person i : logic.PersonImpl.personList) {
				if (lname.equals(i.getLastName())) {
					logic.PersonImpl.tempList.add(i);
					}
				}
			}
		
		/*
		 * Search by mobile only
		 */
		if (logic.PersonImpl.tempList.size() == 0) {
			for (Person i : logic.PersonImpl.personList) {
				if (mobile.equals(i.getMobile())) {
					logic.PersonImpl.tempList.add(i);
					}
				}
			}
		
		/*
		 * Search by email only
		 */
		if (logic.PersonImpl.tempList.size() == 0) {
			for (Person i : logic.PersonImpl.personList) {
				if (email.equals(i.getEmail())) {
					logic.PersonImpl.tempList.add(i);
				}
			}
		}
	
		/*
		 * Search by interest only
		 */
		for (Person i : logic.PersonImpl.personList) {
			for (String personInterest : i.getInterests()) {
				if (personInterest.equals(interest)) {
					logic.PersonImpl.tempList.add(i);
				}
			}
		}
		
		// If every field is empty.
		if (fname.isEmpty() && lname.isEmpty() && mobile.isEmpty() && email.isEmpty() && interest.isEmpty()) {
			for (Person person : logic.PersonImpl.personList) {
				logic.PersonImpl.tempList.add(person);
			}
		}
	}
}
