package presentation;

import javafx.application.Application;
import javafx.stage.Stage;
import data.ReadFromFile;

public class Start extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage window) throws Exception {
		ReadFromFile.read();
		Menu.showMenu(window);
	}
}