package data;

import java.io.FileWriter;
import java.io.Writer;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import logic.Person;

public class WriteToFile {
	public static void write(List<Person> personList) {
		try {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			Writer writer = new FileWriter("friends.json");
			gson.toJson(personList, writer);
			writer.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
