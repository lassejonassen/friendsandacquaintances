package logic;

public class PersonValidity {
	public static void validate(Person person) {
		if(person.getFirstName().isEmpty()) {
			logic.PersonImpl.personList.remove(person);
		}
		if(person.getLastName().isEmpty()) {
			person.setLastName("NA");
		}
		if(person.getMobile().isEmpty()) {
			person.setMobile("NA");
		}
		if(person.getEmail().isEmpty()) {
			person.setEmail("NA");
		}
	} 
}
