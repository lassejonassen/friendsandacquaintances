package presentation;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logic.AddInterest;
import logic.Person;
import logic.PersonImpl;
import logic.PersonInterface;

public class CreateFriend {
	// Layout
	private static BorderPane layout;
	private static GridPane layoutCenter;
	private static HBox layoutTop;
	private static HBox layoutBottom;
	private static VBox layoutLeft;
	private static VBox layoutRight;
	
	// Headings
	private static Text scenetitle;
	
	// Firstname
	private static Label firstNameLabel;
	private static TextField firstNameInput; 
	private static Text firstNameResultLabel;
	private static Text firstNameResult;
	
	// Lastname
	private static Label lastNameLabel;
	private static TextField lastNameInput;
	private static Text lastNameResultLabel;
	private static Text lastNameResult;
	
	// Mobile
	private static Label mobileLabel;
	private static TextField mobileInput = new TextField();
	private static Text mobileResultLabel = new Text();
	private static Text mobileResult = new Text();
	
	// Email
	private static Label emailLabel;
	private static TextField emailInput = new TextField();
	private static Text emailResultLabel = new Text();
	private static Text emailResult = new Text();
	
	// Interests
	private static Label interestLabel;
	private static TextField interestInput = new TextField();
	private static Text interestsResultLabel = new Text();
	private static Text interestsResult = new Text();
	
	// Add interest btn
	private static Button addInterestBtn;
	
	// Save friend btn
	private static Button saveFriendBtn;
	
	// Return btn
	private static Button backBtn;
	
	
	protected static void createFriendScene(Stage primaryStage) {		
		Person person = new Person();
		layoutStyling();
		layoutTopStyling();
		layoutBottomStyling();
		layoutLeftStyling(primaryStage);
		layoutRightStyling();
		headingsStyling();
		firstNameStyling();
		lastNameStyling();
		mobileStyling();
		emailStyling();
		interestsStyling();
		addInterestBtnStyling(person);
		saveFriendBtnFunctionality(person, primaryStage);
		saveFriendBtnStyling();
		
		Scene scene = new Scene(layout, 800, 800);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void savePerson(Person personSent, Stage primaryStage) {
		PersonInterface persons = new PersonImpl();
		Person person = new Person();
		person = personSent;
		
		String fNameIn = firstNameInput.getText();
		String lNameIn = lastNameInput.getText();
		String mobile = mobileInput.getText();
		String email = emailInput.getText();
		
		firstNameResult.setText("Fornavn: " + fNameIn);
		lastNameResult.setText("Efternavn: " + lNameIn);
		mobileResult.setText("Mobil nummer: " + mobile);
		emailResult.setText("Email: " + email);
		interestsResult.setText("Interesser: " + person.toStringInterests());
		
		if (fNameIn.length() > 0 && lNameIn.length() > 0) {
			String firstName = fNameIn.substring(0, 1).toUpperCase() + fNameIn.substring(1);
			String lastName = lNameIn.substring(0, 1).toUpperCase() + lNameIn.substring(1);
			person.setFirstName(firstName);
			person.setLastName(lastName);
		}
		else if (fNameIn.length() > 0) {
			String firstName = fNameIn.substring(0, 1).toUpperCase() + fNameIn.substring(1);
			String lastName = lNameIn;
			person.setFirstName(firstName);
			person.setLastName(lastName);
		}
		else if (lNameIn.length() > 0) {
			String firstName = fNameIn;
			String lastName = lNameIn.substring(0, 1).toUpperCase() + lNameIn.substring(1);
			person.setFirstName(firstName);
			person.setLastName(lastName);
		} 
		else 
		{
			String firstName = fNameIn;
			String lastName = lNameIn;
			person.setFirstName(firstName);
			person.setLastName(lastName);
		}
		
		person.setMobile(mobile);
		person.setEmail(email);
		persons.create(person);
		Menu.showMenu(primaryStage);
	}
	
	public static void layoutStyling() {
		layout = new BorderPane();
		layoutCenter = new GridPane();
		layout.setCenter(layoutCenter);
		layoutCenter.setGridLinesVisible(false);
		layoutCenter.setAlignment(Pos.CENTER);
		layoutCenter.setHgap(10);
		layoutCenter.setVgap(10);
		layoutCenter.setPadding(new Insets(25, 25, 25, 25));
	}
	
	public static void headingsStyling() {
		scenetitle = new Text("Opret en ven");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
		layoutCenter.add(scenetitle, 0, 1, 4, 1);
		GridPane.setHalignment(scenetitle, HPos.CENTER);
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
	public static void layoutLeftStyling(Stage primaryStage) {
		layoutLeft = new VBox();
		layout.setLeft(layoutLeft);
		layoutLeft.setStyle("-fx-background-color:#469e92; -fx-padding: 25 45 0 45;");
		backBtn = new Button("Tilbage");
		backBtn.setPrefSize(100, 45);
		backBtn.setStyle("-fx-padding: 10;");
		layoutLeft.getChildren().add(backBtn);
		backBtn.setOnAction(e -> Menu.showMenu(primaryStage));
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
	public static void layoutRightStyling() {
		layoutRight = new VBox();
		layout.setRight(layoutRight);
		layoutRight.setStyle("-fx-background-color:#469e92; -fx-padding: 25 45 0 45;");
		layoutRight.setPrefWidth(190);
	}
	
	public static void firstNameStyling() {
		firstNameLabel = new Label("Fornavn: ");
		layoutCenter.add(firstNameLabel, 0, 2);
		firstNameLabel.setFont(new Font("Arial",15));
		
		firstNameInput = new TextField();
		layoutCenter.add(firstNameInput, 1, 2);
		
		firstNameResultLabel = new Text();
		firstNameResult = new Text();
		layoutCenter.add(firstNameResultLabel, 0, 7);
		layoutCenter.add(firstNameResult, 1, 7, 2, 1);
	}
	
	public static void lastNameStyling() {
		lastNameLabel = new Label("Efternavn: ");
		layoutCenter.add(lastNameLabel, 0, 3);
		lastNameLabel.setFont(new Font("Arial",15));
		lastNameInput = new TextField();
		layoutCenter.add(lastNameInput, 1, 3);
		lastNameResultLabel = new Text();
		lastNameResult = new Text();
		layoutCenter.add(lastNameResultLabel, 0, 8);
		layoutCenter.add(lastNameResult, 1, 8, 2, 1);
	}
	
	public static void mobileStyling() {
		mobileLabel = new Label("Mobil: ");
		layoutCenter.add(mobileLabel, 0, 4);
		mobileLabel.setFont(new Font("Arial",15));
		mobileInput = new TextField();
		layoutCenter.add(mobileInput, 1, 4);
		mobileResultLabel = new Text();
		mobileResult = new Text();
		layoutCenter.add(mobileResultLabel, 0, 9);
		layoutCenter.add(mobileResult, 1, 9, 2, 1);
	}
	
	public static void emailStyling() {
		emailLabel = new Label("Email: ");
		layoutCenter.add(emailLabel, 0, 5);
		emailLabel.setFont(new Font("Arial",15));
		emailInput = new TextField();
		layoutCenter.add(emailInput, 1, 5);
		emailResultLabel = new Text();
		emailResult = new Text();
		layoutCenter.add(emailResultLabel, 0, 10);
		layoutCenter.add(emailResult, 1, 10, 2, 1);
	}
	
	public static void interestsStyling() {
		interestLabel = new Label("Interesse: ");
		layoutCenter.add(interestLabel, 0, 6);
		interestLabel.setFont(new Font("Arial",15));
		interestInput = new TextField();
		layoutCenter.add(interestInput, 1, 6);
		interestsResultLabel = new Text();
		interestsResult = new Text();
		layoutCenter.add(interestsResultLabel, 0, 11);
		layoutCenter.add(interestsResult, 1, 11, 2, 1);
	}
	
	public static void addInterestBtnStyling(Person person) {
		addInterestBtn = new Button("Tilføj interesse");
		addInterestBtn.setPrefSize(100, 45);
		addInterestBtn.setStyle("-fx-padding: 10;");
		layoutCenter.add(addInterestBtn, 0, 7);
		addInterestBtn.setOnAction(e -> AddInterest.addInterest(person, interestInput));
	}
	
	public static void saveFriendBtnStyling() {
		layoutRight.getChildren().add(saveFriendBtn);
		saveFriendBtn.setPrefSize(100, 45);
		saveFriendBtn.setStyle("-fx-padding: 10;");
	}
	
	public static void saveFriendBtnFunctionality(Person person, Stage primaryStage) {
		saveFriendBtn = new Button("Opret ven");
		saveFriendBtn.setOnAction(e -> savePerson(person, primaryStage));
		
	}
}
