package data;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import logic.Person;
import presentation.Menu;

public class ReadFromFile {
	public static void read() {
		try {
			Gson gson = new Gson();
			JsonReader reader = new JsonReader(Files.newBufferedReader(Paths.get("friends.json")));
			List<Person> persons = gson.fromJson(reader, new TypeToken<List<Person>>() {
			}.getType());
			for (Person person : persons) {
				logic.PersonImpl.personList.add(person);
			}
			Menu.showPersons();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
