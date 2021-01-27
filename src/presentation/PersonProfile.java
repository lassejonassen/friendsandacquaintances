package presentation;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import logic.Person;
import logic.PersonImpl;
import logic.PersonInterface;
import javafx.scene.control.TextField;

public class PersonProfile {
	// Layout
	private static Stage window = new Stage();
	private static Scene scene;
	private static BorderPane layout;
	private static HBox layoutTop, layoutBottom;
	private static VBox layoutLeft, layoutRight;
	private static GridPane layoutCenter, layoutCenterTop, layoutCenterBottom, layoutCenterBottomRight,
			layoutCenterBottomleft;

	// TextFields
	private static TextField firstNameIn;
	private static TextField lastNameIn;
	private static TextField mobileIn;
	private static TextField emailIn;
	private static TextField interestIn;

	// Labels
	// Loaded person information labels.
	private static Label loadedFirstNameLabel;
	private static Label loadedLastNameLabel;
	private static Label loadedMobileLabel;
	private static Label loadedEmailLabel;
	private static Label loadedInterestsLabel;

	private static Label loadedFirstName = new Label();
	private static Label loadedLastName = new Label();
	private static Label loadedMobile = new Label();
	private static Label loadedEmail = new Label();
	private static Label loadedInterests = new Label();

	// TextField Labels
	private static Label firstName;
	private static Label lastName;
	private static Label mobile;
	private static Label email;
	private static Label interests;

	// Buttons
	private static Button deleteBtn;
	private static Button updateBtn;
	private static Button deleteInterestBtn;
	private static Button addInterestBtn;

	// Person object
	private static Person person;
	private static ListView<String> interestList;

	public static void showProfile() {
		layout = new BorderPane();
		person = new Person();
		person = FindFriend.personSearched.getSelectionModel().getSelectedItem();

		layoutTopStyling();
		layoutLeftStyling();
		layoutCenterStyling(window);
		layoutRightStyling();
		layoutBottomStyling();
		scene = new Scene(layout, 800, 800);
		window.setScene(scene);
		window.show();
	}
	
	public static void showProfileMenu() {
		layout = new BorderPane();
		person = new Person();
		person = Menu.persons.getSelectionModel().getSelectedItem();

		layoutTopStyling();
		layoutLeftStyling();
		layoutCenterStyling(window);
		layoutRightStyling();
		layoutBottomStyling();
		scene = new Scene(layout, 800, 800);
		window.setScene(scene);
		window.show();
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
		layoutLeft.setStyle("-fx-background-color:#469e92; -fx-padding: 25 45 0 45;");
		layoutLeft.setPrefWidth(190);
	}

	public static void layoutRightStyling() {
		layoutRight = new VBox();
		layout.setRight(layoutRight);
		layoutRight.setStyle("-fx-background-color:#469e92; -fx-padding: 25 45 0 45;");

		deleteBtn = new Button("Slet ven");
		updateBtn = new Button("Opdater ven");
		deleteBtn.setPrefSize(100, 45);
		updateBtn.setPrefSize(100, 45);
		layoutRight.setSpacing(20);
		layoutRight.getChildren().addAll(deleteBtn, updateBtn);

		updateBtn.setOnAction(e -> updatePerson(person));
		deleteBtn.setOnAction(e -> deletePerson(person));

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

	public static void layoutCenterStyling(Stage window) {
		layoutCenter = new GridPane();
		layoutCenterTop = new GridPane();
		layoutCenterBottom = new GridPane();
		layoutCenterBottomleft = new GridPane();
		layoutCenterBottomRight = new GridPane();

		ColumnConstraints centerColumn = new ColumnConstraints();
		RowConstraints centerRow1 = new RowConstraints();
		RowConstraints centerRow2 = new RowConstraints();
		layoutCenter.getColumnConstraints().add(centerColumn);
		layoutCenter.getRowConstraints().addAll(centerRow1, centerRow2);
		layoutCenter.setGridLinesVisible(false);
		layout.setCenter(layoutCenter);
		centerColumn.setPercentWidth(99);
		centerRow1.setPercentHeight(20);
		centerRow2.setPercentHeight(80);
		layoutCenter.setAlignment(Pos.CENTER);
		layoutCenter.setHgap(1);
		layoutCenter.setVgap(1);
		layoutCenter.setPadding(new Insets(1,1,1,1));

		// Top | Information about the selected person.
		layoutCenter.add(layoutCenterTop, 0, 0);
		layoutCenterTop.setGridLinesVisible(false);
		layoutCenterTop.setAlignment(Pos.TOP_CENTER);
		layoutCenterTop.setHgap(9);
		layoutCenterTop.setVgap(9);
		layoutCenterTop.setPadding(new Insets(9,9,9,9));

		ColumnConstraints centerTopColumn1 = new ColumnConstraints();
		ColumnConstraints centerTopColumn2 = new ColumnConstraints();
		RowConstraints centerTopRow1 = new RowConstraints();
		RowConstraints centerTopRow2 = new RowConstraints();
		RowConstraints centerTopRow3 = new RowConstraints();
		RowConstraints centerTopRow4 = new RowConstraints();
		RowConstraints centerTopRow5 = new RowConstraints();

		centerTopColumn1.setPercentWidth(25);
		centerTopColumn2.setPercentWidth(75);
		centerTopRow1.setPercentHeight(10);
		centerTopRow2.setPercentHeight(10);
		centerTopRow3.setPercentHeight(10);
		centerTopRow4.setPercentHeight(10);
		centerTopRow5.setPercentHeight(10);

		layoutCenterTop.getColumnConstraints().addAll(centerTopColumn1, centerTopColumn2);
		layoutCenterTop.getRowConstraints().addAll(centerTopRow1, centerTopRow2, centerTopRow3, centerTopRow4,
				centerTopRow5);

		loadedFirstNameLabel = new Label("Fornavn:");
		loadedLastNameLabel = new Label("Efternavn:");
		loadedMobileLabel = new Label("Mobil nr.:");
		loadedEmailLabel = new Label("Email:");
		loadedInterestsLabel = new Label("Interesser:");
		
		loadedFirstNameLabel.setFont(new Font("Arial", 15));
		loadedLastNameLabel.setFont(new Font("Arial", 15));
		loadedMobileLabel.setFont(new Font("Arial", 15));
		loadedEmailLabel.setFont(new Font("Arial", 15));
		loadedInterestsLabel.setFont(new Font("Arial", 15));

		layoutCenterTop.add(loadedFirstNameLabel, 0, 0);
		layoutCenterTop.add(loadedLastNameLabel, 0, 1);
		layoutCenterTop.add(loadedMobileLabel, 0, 2);
		layoutCenterTop.add(loadedEmailLabel, 0, 3);
		layoutCenterTop.add(loadedInterestsLabel, 0, 4);
		
		loadedFirstName.setFont(new Font("Arial", 15));
		loadedLastName.setFont(new Font("Arial", 15));
		loadedMobile.setFont(new Font("Arial", 15));
		loadedEmail.setFont(new Font("Arial", 15));
		loadedInterests.setFont(new Font("Arial", 15));

		loadedFirstName.setText(person.getFirstName());
		loadedLastName.setText(person.getLastName());
		loadedMobile.setText(person.getMobile());
		loadedEmail.setText(person.getEmail());
		loadedInterests.setText(person.toStringInterests());

		layoutCenterTop.add(loadedFirstName, 1, 0);
		layoutCenterTop.add(loadedLastName, 1, 1);
		layoutCenterTop.add(loadedMobile, 1, 2);
		layoutCenterTop.add(loadedEmail, 1, 3);
		layoutCenterTop.add(loadedInterests, 1, 4);

		// Bottom | Oppunity to edit the selected person's information.
		layoutCenter.add(layoutCenterBottom, 0, 1);
		layoutCenterBottom.setGridLinesVisible(false);
		layoutCenterBottom.setAlignment(Pos.CENTER);
		ColumnConstraints centerBottomColumnLeft = new ColumnConstraints();
		ColumnConstraints centerBottomColumnRight = new ColumnConstraints();
		RowConstraints centerBottomRow = new RowConstraints();
		centerBottomColumnLeft.setPercentWidth(50);
		centerBottomColumnRight.setPercentWidth(50);
		centerBottomRow.setPercentHeight(100);
		layoutCenterBottom.getColumnConstraints().addAll(centerBottomColumnLeft, centerBottomColumnRight);
		layoutCenterBottom.getRowConstraints().add(centerBottomRow);
		layoutCenterBottom.add(layoutCenterBottomleft, 0, 0);
		layoutCenterBottom.add(layoutCenterBottomRight, 1, 0);
		layoutCenterBottom.setHgap(5);
		layoutCenterBottom.setVgap(5);
		layoutCenterBottom.setPadding(new Insets(5,5,5,5));

		// Left
		ColumnConstraints centerBottomColumnLeftColumn = new ColumnConstraints();
		RowConstraints centerBottomRowLeft1 = new RowConstraints();
		RowConstraints centerBottomRowLeft2 = new RowConstraints();
		RowConstraints centerBottomRowLeft3 = new RowConstraints();
		RowConstraints centerBottomRowLeft4 = new RowConstraints();
		RowConstraints centerBottomRowLeft5 = new RowConstraints();
		RowConstraints centerBottomRowLeft6 = new RowConstraints();
		RowConstraints centerBottomRowLeft7 = new RowConstraints();
		RowConstraints centerBottomRowLeft8 = new RowConstraints();
		RowConstraints centerBottomRowLeft9 = new RowConstraints();
		RowConstraints centerBottomRowLeft10 = new RowConstraints();
		RowConstraints centerBottomRowLeft11 = new RowConstraints();
		layoutCenterBottomleft.getColumnConstraints().add(centerBottomColumnLeftColumn);
		layoutCenterBottomleft.getRowConstraints().addAll(centerBottomRowLeft1, centerBottomRowLeft2,
				centerBottomRowLeft3, centerBottomRowLeft4, centerBottomRowLeft5, centerBottomRowLeft6,
				centerBottomRowLeft7, centerBottomRowLeft8, centerBottomRowLeft9, centerBottomRowLeft10,
				centerBottomRowLeft11);
		layoutCenterBottomleft.setGridLinesVisible(false);
		centerBottomColumnLeftColumn.setPercentWidth(100);
		centerBottomRowLeft1.setPercentHeight(5);
		centerBottomRowLeft2.setPercentHeight(5);
		centerBottomRowLeft3.setPercentHeight(5);
		centerBottomRowLeft4.setPercentHeight(5);
		centerBottomRowLeft5.setPercentHeight(5);
		centerBottomRowLeft6.setPercentHeight(5);
		centerBottomRowLeft7.setPercentHeight(5);
		centerBottomRowLeft8.setPercentHeight(5);
		centerBottomRowLeft9.setPercentHeight(5);
		centerBottomRowLeft10.setPercentHeight(5);
		centerBottomRowLeft11.setPercentHeight(5);

		firstName = new Label("Fornavn");
		lastName = new Label("Efternavn");
		mobile = new Label("Mobil nummer:");
		email = new Label("Email adresse:");
		interests = new Label("Tilføj interesse:");
		
		firstName.setFont(new Font("Arial", 15));
		lastName.setFont(new Font("Arial", 15));
		mobile.setFont(new Font("Arial", 15));
		email.setFont(new Font("Arial", 15));
		interests.setFont(new Font("Arial", 15));

		firstNameIn = new TextField();
		lastNameIn = new TextField();
		mobileIn = new TextField();
		emailIn = new TextField();
		interestIn = new TextField();

		addInterestBtn = new Button("+");

		layoutCenterBottomleft.add(firstName, 0, 0);
		layoutCenterBottomleft.add(firstNameIn, 0, 1);
		layoutCenterBottomleft.add(lastName, 0, 2);
		layoutCenterBottomleft.add(lastNameIn, 0, 3);
		layoutCenterBottomleft.add(mobile, 0, 4);
		layoutCenterBottomleft.add(mobileIn, 0, 5);
		layoutCenterBottomleft.add(email, 0, 6);
		layoutCenterBottomleft.add(emailIn, 0, 7);
		layoutCenterBottomleft.add(interests, 0, 8);
		layoutCenterBottomleft.add(interestIn, 0, 9);
		layoutCenterBottomleft.add(addInterestBtn, 0, 10);
		
		addInterestBtn.setOnAction(e -> addInterest(window));
		
		

		// Right
		ColumnConstraints centerBottomColumnRightColumn = new ColumnConstraints();
		RowConstraints centerBottomRowRight1 = new RowConstraints();
		RowConstraints centerBottomRowRight2 = new RowConstraints();
		RowConstraints centerBottomRowRight3 = new RowConstraints();
		layoutCenterBottomRight.getColumnConstraints().add(centerBottomColumnRightColumn);
		layoutCenterBottomRight.getRowConstraints().addAll(centerBottomRowRight1, centerBottomRowRight2,
				centerBottomRowRight3);
		layoutCenterBottomRight.setGridLinesVisible(false);
		centerBottomColumnRightColumn.setPercentWidth(100);
		centerBottomRowRight1.setPercentHeight(5);
		centerBottomRowRight2.setPercentHeight(50);
		centerBottomRowRight3.setPercentHeight(5);

		Label interestsRightLabel = new Label("Interesser");
		layoutCenterBottomRight.add(interestsRightLabel, 0, 0);
		interestsRightLabel.setFont(new Font("Arial", 15));

		interestList = new ListView<>();
		for (String interest : person.getInterests()) {
			interestList.getItems().add(interest);
		}
		interestList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

		layoutCenterBottomRight.add(interestList, 0, 1);

		deleteInterestBtn = new Button("Slet markerede");
		layoutCenterBottomRight.add(deleteInterestBtn, 0, 2);
		
		deleteInterestBtn.setOnAction(e -> deleteInterest(person, window));
	}

	public static void updatePerson(Person person) {
		PersonInterface persons = new PersonImpl();
		String fname, lname, mobile, email;
		
		if(firstNameIn.getText().isEmpty()) {
			fname = person.getFirstName();
		} else {
			String fnameIn = firstNameIn.getText();
			fname = fnameIn.substring(0, 1).toUpperCase() + fnameIn.substring(1);
		}
		if(lastNameIn.getText().isEmpty()) {
			lname = person.getLastName();
			
		} else {
			String lnameIn = lastNameIn.getText();
			lname = lnameIn.substring(0, 1).toUpperCase() + lnameIn.substring(1);
		}
		if(mobileIn.getText().isEmpty()) {
			mobile = person.getMobile();
		} else {
			mobile = mobileIn.getText();
		}
		if(emailIn.getText().isEmpty()) {
			email = person.getEmail();
		} else {
			email = emailIn.getText();
		}
		
		
		
		
		
		person.setFirstName(fname);
		person.setLastName(lname);
		person.setMobile(mobile);
		person.setEmail(email);
		persons.update(person);
		showProfile();
	}
	
	public static void deletePerson(Person person) {
		PersonInterface persons = new PersonImpl();
		persons.delete(person);
		window.close();
	}
	
	public static void addInterest(Stage window) {
		PersonInterface persons = new PersonImpl();
		logic.AddInterest.addInterest(person, interestIn);
		persons.update(person);
		showProfile();
		
	}
	
	public static void deleteInterest(Person person, Stage window) {
		PersonInterface persons = new PersonImpl();
		String interest = interestList.getSelectionModel().getSelectedItem();
		person.delInterest(interest);
		persons.update(person);
		showProfile();
	}

}
