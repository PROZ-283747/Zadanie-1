package pl.edu.pw.elka.proz.zadanie1;

import java.util.Optional;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
/**
 *	Class LogonDialog
 *
 *	@autor Adela Jaworowska / adela.jaworowska@gmail.com
 */
public class LogonDialog {
	
	//	Window
	private Dialog dialog;
	
	//	Button
	private ButtonType loginButtonType;
	private Node loginButton;
	
	private GridPane grid;
	
	//	Labels
	private Label enviromentLabel;
	private Label userLabel;
	private Label passLabel;
	
	//	Choice fields
	private PasswordField password;
	private ChoiceBox<String> enviromentChoiceBox;
	private ComboBox<String> userComboBox;
	
	// Class UsersData's object 
	UsersData usersData;
	
	/**
	 *	Called when environment in choiceBox is changed
	 */
	private void enviromentChange() 
	{
		if(enviromentChoiceBox.getValue()== "Developer")
			userComboBox.setItems(usersData.createDevUsersList(usersData.getDeveloperTable()));
		if(enviromentChoiceBox.getValue()== "Testing")
			userComboBox.setItems(usersData.createDevUsersList(usersData.getTestingTable()));
		if(enviromentChoiceBox.getValue()== "Production")
			userComboBox.setItems(usersData.createDevUsersList(usersData.getProductionTable()));
	}
	
	/**
	 *	Called after any change in any choice field
	 */
	private void afterChange()
	{ 
		loginButton.setDisable(enviromentChoiceBox.getValue() == null || 
		userComboBox.getEditor().getText().trim().isEmpty() || 
		password.getText().isEmpty() ); 
	}
	/**
	 * Converts buttonType to pair of two strings: environment and user's name who logged in.
	 * 
	 * @param buttonType result of the Dialog.showAndWait()
	 * @return Pair of two strings: environment and user's name who logged in
	 */
	private Pair<String, String> resultConverter(Optional<ButtonType> buttonType){
		if (buttonType.isPresent() && buttonType.get() == loginButtonType) {
			if (usersData.isPasswordCorrect(enviromentChoiceBox.getValue().toString(),
					userComboBox.getValue().toString(), password.getText())) {
				return new Pair<>(enviromentChoiceBox.getValue().toString(), userComboBox.getValue().toString());
			}
		}
		return null;
	}
	/**
	 * Redefinition of Dialog.showAndWait() method.
	 * 
	 * @return Pair of environment and user's name who logged in. Null if login failed.
	 */
	public Optional<Pair<String, String>> showAndWait() {
		return Optional.ofNullable(resultConverter(dialog.showAndWait()));
	}
	
	/**
	 *	LogonDiaog class constructor without parameters
	 */
	public LogonDialog()
	{
		this(" "," ");
	}
	
	/**
	 *	LogonDiaog class constructor with parameters
	 *
	 *	@param title Tile of the dialog
	 *	@param header Header of the dialog
	 */
	public LogonDialog(String title, String header) {

		// constructors
		dialog = new Dialog();
		loginButtonType = new ButtonType("Login");
		grid = new GridPane();
		enviromentLabel= new Label("Enviroment: ");
		userLabel = new Label("User: ");
		passLabel = new Label("Password: ");
		password= new PasswordField();
		enviromentChoiceBox = new ChoiceBox<>();
		usersData = new UsersData();
		
		//	Setting dialog parameters
		dialog.setTitle(title);
		dialog.setHeaderText(header);
		dialog.setResizable(true);
		
		//	Adding buttons to dialog
		dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);
		
		//	Setting grid parameters
		grid.setHgap(0);
		grid.setVgap(15);
		grid.setPadding(new Insets(20, 20, 10, 10));
		
		//	Setting choiceBox
		enviromentChoiceBox.getItems().addAll("Developer", "Testing", "Production");
		enviromentChoiceBox.setValue("Developer");
		
		// Setting comboBox
		userComboBox = new ComboBox(usersData.createDevUsersList(usersData.getDeveloperTable()));
		userComboBox.setPromptText("New user...");
		userComboBox.setEditable(true);
			
		//	Adding fields to the window
		grid.add(enviromentLabel, 0, 0);
		grid.add(userLabel, 0, 1);
		grid.add(passLabel, 0, 2);
		grid.add(enviromentChoiceBox, 1, 0);
		grid.add(userComboBox, 1, 1);
		grid.add(password, 1, 2);

		// Enable/Disable login button depending on whether a username was entered.
		loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
		loginButton.setDisable(true);
		
		//	Setting listeners and handling events
		enviromentChoiceBox.valueProperty().addListener((observable, oldValue, newValue) -> 
		{
			afterChange();
			enviromentChange();
		});
		userComboBox.valueProperty().addListener((observable, oldValue, newValue) -> afterChange());
		password.textProperty().addListener((observable, oldValue, newValue) -> afterChange());
		
		//	Adding grid to the dialog window
		dialog.getDialogPane().setContent(grid);

		
	}
}
