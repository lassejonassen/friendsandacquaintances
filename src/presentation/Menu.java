package presentation;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Callback;
import logic.Person;

public class Menu {
	
	private static BorderPane layout;
	protected static ListView<Person> persons;
	private static HBox layoutTop;
	private static HBox layoutBottom;
	private static VBox layoutLeft;
	private static VBox layoutRight;

	// Buttons
	private static Button findFriendBtn = new Button("Find ven");
	private static Button createFriendBtn = new Button("Opret ven");

	public static void showMenu(Stage primaryStage) {
		showPersons();
		layout = new BorderPane();
		layoutTopStyling();
		layoutLeftStyling();
		layoutCenterStyling();
		layoutRightStyling();
		layoutBottomStyling();
		buttonFunctionality(primaryStage);
		Scene scene = new Scene(layout, 800, 800);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void layoutTopStyling() {
		layoutTop = new HBox();
		layout.setTop(layoutTop);
		Label heading = new Label();
		layoutTop.getChildren().add(heading);
		heading.setText("System Venner og Bekendte");
		heading.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
		heading.setPadding(new Insets(25, 10, 25, 10));
		layoutTop.setAlignment(Pos.CENTER);
		layoutTop.setStyle("-fx-background-color:#e3e3e3;");
	}

	public static void layoutLeftStyling() {
		layoutLeft = new VBox();
		layout.setLeft(layoutLeft);
		layoutLeft.getChildren().add(findFriendBtn);
		layoutLeft.getChildren().add(createFriendBtn);
		layoutLeft.setSpacing(20);
		layoutLeft.setStyle("-fx-background-color:#469e92; -fx-padding: 25 45 0 45;");
		findFriendBtn.setStyle("-fx-padding: 10;");
		createFriendBtn.setStyle("-fx-padding: 10");
		findFriendBtn.setPrefSize(100, 45);
		createFriendBtn.setPrefSize(100, 45);	
	}

	public static void layoutCenterStyling() {
		layout.setCenter(persons);
	}

	public static void layoutRightStyling() {
		layoutRight = new VBox();
		layout.setRight(layoutRight);
		layoutRight.setStyle("-fx-background-color:#469e92; -fx-padding: 25 45 0 45;");
		layoutRight.setPrefWidth(190);

	}

	public static void layoutBottomStyling() {
		layoutBottom = new HBox();
		layout.setBottom(layoutBottom);
		Label footer = new Label();
		layoutBottom.getChildren().add(footer);
		footer.setText("System Venner og Bekendte | EAMV Datamatiker 2020");
		footer.setFont(Font.font("Verdana", FontWeight.NORMAL, 14));
		footer.setPadding(new Insets(25, 10, 25, 10));
		layoutBottom.setAlignment(Pos.CENTER);
		layoutBottom.setStyle("-fx-background-color:#e3e3e3;");
	}

	public static void showPersons() {
		persons = new ListView<>();
		for (Person person : logic.PersonImpl.personList) {
			persons.getItems().add(person);
		}
		persons.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		persons.setCellFactory(new Callback<ListView<Person>, ListCell<Person>>() {
			@Override
			public ListCell<Person> call(ListView<logic.Person> param) {
				ListCell<Person> personCell = new ListCell<Person>() {

					@Override
					protected void updateItem(Person item, boolean empty) {
						super.updateItem(item, empty);
						if (item != null) {
							setText("Navn: " + item.getFirstName() + " " + item.getLastName() + ", Mobil nr: "
									+ item.getMobile());
							setFont(new Font("Arial", 18));
						} else {
							setText("");
						}
					}
				};
				return personCell;
			}

		});
	}

	public static void buttonFunctionality(Stage primaryStage) {
		findFriendBtn.setOnAction(e -> FindFriend.findFriendScene(primaryStage));
		createFriendBtn.setOnAction(e -> CreateFriend.createFriendScene(primaryStage));
	}
}
