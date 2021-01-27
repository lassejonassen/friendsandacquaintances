package presentation;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Callback;
import logic.Person;
import logic.PersonImpl;
import logic.PersonInterface;

public class FindFriend {
	// Layout
	private static BorderPane layout;
	private static HBox topLayout;
	private static HBox bottomLayout;
	private static VBox leftLayout;
	private static VBox rightLayout;
	private static GridPane centerLayout;
	private static GridPane centerLaytopTop;
	public static ListView<Person> personSearched;

	// Scene
	private static Scene scene;

	// Return btn
	private static Button backBtn;
	private static Button showProfileBtn;

	// Search options labels.
	private static Label firstName = new Label("Søg efter fornavn");
	private static Label lastName = new Label("Søg efter efternavn");
	private static Label mobile = new Label("Søg efter mobil nummer");
	private static Label email = new Label("Søg efter email");
	private static Label interest = new Label("Søg efter interesse");

	// Search options textfields.
	private static TextField firstNameIn = new TextField();
	private static TextField lastNameIn = new TextField();
	private static TextField mobileIn = new TextField();
	private static TextField emailIn = new TextField();
	private static TextField interestIn = new TextField();

	protected static void findFriendScene(Stage primaryStage) {
		search();
		layoutStyling();
		layoutTopStyling();
		layoutBottomStyling();
		layoutLeftStyling(primaryStage);
		layoutRightStyling();
		layoutCenterStyling();
		labelPlacement();
		textFieldPlacement();
		searchButton(primaryStage);
		scene = new Scene(layout, 800, 800);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void layoutStyling() {
		layout = new BorderPane();
	}

	public static void layoutTopStyling() {
		topLayout = new HBox();
		layout.setTop(topLayout);
		Label heading = new Label();
		topLayout.getChildren().add(heading);
		heading.setText("System Venner og Bekendte");
		heading.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
		heading.setPadding(new Insets(25, 10, 25, 10));
		topLayout.setAlignment(Pos.CENTER);
		topLayout.setStyle("-fx-background-color:#e3e3e3;");
	}

	public static void layoutLeftStyling(Stage primaryStage) {
		leftLayout = new VBox();
		layout.setLeft(leftLayout);
		leftLayout.setStyle("-fx-background-color:#469e92; -fx-padding: 25 45 0 45;");
		backBtn = new Button("Tilbage");
		backBtn.setPrefSize(100, 45);
		backBtn.setStyle("-fx-padding: 10;");
		leftLayout.getChildren().add(backBtn);
		backBtn.setOnAction(e -> Menu.showMenu(primaryStage));
	}

	public static void layoutCenterStyling() {
		centerLayout = new GridPane();
		centerLaytopTop = new GridPane();
		centerLayout.setHgap(10);
		centerLayout.setVgap(10);
		centerLayout.setPadding(new Insets(10, 10, 10, 10));
		centerLaytopTop.setVgap(10);
		centerLaytopTop.setHgap(10);
		centerLaytopTop.setPadding(new Insets(10, 10, 10, 10));
		ColumnConstraints centerColumn = new ColumnConstraints();
		RowConstraints centerRow1 = new RowConstraints();
		RowConstraints centerRow2 = new RowConstraints();
		centerLayout.getColumnConstraints().add(centerColumn);
		centerLayout.getRowConstraints().addAll(centerRow1, centerRow2);
		centerLayout.setGridLinesVisible(false);
		layout.setCenter(centerLayout);
		centerColumn.setPercentWidth(99);
		centerRow1.setPercentHeight(50);
		centerRow2.setPercentHeight(50);
		centerLayout.setAlignment(Pos.CENTER);
		centerLayout.add(personSearched, 0, 1);
		centerLayout.add(centerLaytopTop, 0, 0);
	}

	public static void layoutRightStyling() {
		rightLayout = new VBox();
		layout.setRight(rightLayout);
		rightLayout.setStyle("-fx-background-color:#469e92; -fx-padding: 25 45 0 45;");
		showProfileBtn = new Button("Vis profil");
		rightLayout.getChildren().add(showProfileBtn);
		showProfileBtn.setOnAction(e -> PersonProfile.showProfile());
		showProfileBtn.setPrefSize(100, 45);
		showProfileBtn.setStyle("-fx-padding: 10;");
	}

	public static void layoutBottomStyling() {
		bottomLayout = new HBox();
		layout.setBottom(bottomLayout);
		Label footer = new Label();
		bottomLayout.getChildren().add(footer);
		footer.setText("System Venner og Bekendte | EAMV Datamatiker 2020");
		footer.setFont(Font.font("Verdana", FontWeight.NORMAL, 14));
		footer.setPadding(new Insets(25, 10, 25, 10));
		bottomLayout.setAlignment(Pos.CENTER);
		bottomLayout.setStyle("-fx-background-color:#e3e3e3;");
	}

	public static void search() {
		personSearched = new ListView<>();
		for (Person person : logic.PersonImpl.tempList) {
			personSearched.getItems().addAll(person);
		}
		personSearched.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		
		personSearched.setCellFactory(new Callback<ListView<Person>, ListCell<Person>>() {
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

	public static void labelPlacement() {
		centerLaytopTop.add(firstName, 0, 2);
		centerLaytopTop.add(lastName, 0, 3);
		centerLaytopTop.add(mobile, 0, 4);
		centerLaytopTop.add(email, 0, 5);
		centerLaytopTop.add(interest, 0, 6);
		
		firstName.setFont(new Font("Arial", 18));
		lastName.setFont(new Font("Arial", 18));
		mobile.setFont(new Font("Arial", 18));
		email.setFont(new Font("Arial", 18));
		interest.setFont(new Font("Arial", 18));
		
	}

	public static void textFieldPlacement() {
		centerLaytopTop.add(firstNameIn, 1, 2);
		centerLaytopTop.add(lastNameIn, 1, 3);
		centerLaytopTop.add(mobileIn, 1, 4);
		centerLaytopTop.add(emailIn, 1, 5);
		centerLaytopTop.add(interestIn, 1, 6);
	}

	public static void searchButton(Stage primaryStage) {
		Button searchBtn = new Button("Søg");
		centerLaytopTop.add(searchBtn, 0, 7);
		searchBtn.setOnAction(e -> searchPerson(primaryStage));
		searchBtn.setPrefSize(100, 45);
		searchBtn.setStyle("-fx-padding: 10;");
	}

	public static void searchPerson(Stage primaryStage) {
		PersonInterface persons = new PersonImpl();
		
		String fNameIn = firstNameIn.getText();
		String lNameIn = lastNameIn.getText();
		String mobile = mobileIn.getText();
		String email = emailIn.getText();
		String interest = interestIn.getText().toLowerCase();
		
		if (fNameIn.length() > 0 && lNameIn.length() > 0) {
			String fname = fNameIn.substring(0, 1).toUpperCase() + fNameIn.substring(1);
			String lname = lNameIn.substring(0, 1).toUpperCase() + lNameIn.substring(1);
			persons.find(fname, lname, mobile, email, interest);
		}
		else if (fNameIn.length() > 0) {
			String fname = fNameIn.substring(0, 1).toUpperCase() + fNameIn.substring(1);
			String lname = lNameIn;
			persons.find(fname, lname, mobile, email, interest);
		}
		else if (lNameIn.length() > 0) {
			String fname = fNameIn;
			String lname = lNameIn.substring(0, 1).toUpperCase() + lNameIn.substring(1);
			persons.find(fname, lname, mobile, email, interest);
		} else {
			String fname = fNameIn;
			String lname = lNameIn;
			persons.find(fname, lname, mobile, email, interest);
		}

		search();
		findFriendScene(primaryStage);
		logic.PersonImpl.tempList.clear();
	}
}
