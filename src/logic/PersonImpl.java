package logic;

import java.util.*;
import data.WriteToFile;

public class PersonImpl implements PersonInterface {
	public static List<Person> personList = new ArrayList<Person>();
	public static List<Person> tempList = new ArrayList<Person>();

	public void create(Person person) {
		personList.add(person);
		PersonValidity.validate(person);
		WriteToFile.write(personList);
	}

	public void update(Person person) {
		create(person);
		delete(person);
	}

	public void delete(Person person) {
		personList.remove(person);
		WriteToFile.write(personList);
	}

	public void find(String fname, String lname, String mobile, String email, String interest) {
		SearchAlgorithms.search(fname, lname, mobile, email, interest);
	}

}
