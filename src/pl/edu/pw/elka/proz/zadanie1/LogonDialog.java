package pl.edu.pw.elka.proz.zadanie1;

import java.util.Optional;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class LogonDialog {

	private Dialog<Pair<String, String>> dialog = new Dialog<>();
	
	private ButtonType loginButtonType = new ButtonType("Login");
	private Node loginButton;
	
	private Label enviromentLabel= new Label("Enviroment: ");
	private Label userLabel = new Label("User: ");
	private Label passLabel = new Label("Password: ");
			
	private PasswordField password= new PasswordField();
	
	private ChoiceBox<String> enviromentChoiceBox = new ChoiceBox<>();
	
	private ComboBox<String> userComboBox;
	
	private GridPane grid = new GridPane();
	
	UsersData usersData = new UsersData();
	
	// class constructor
	public LogonDialog(String title, String header) {

		// Create the custom dialog.
		dialog.setTitle(title);
		dialog.setHeaderText(header);
		dialog.setResizable(true);
		dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));

		grid.add(enviromentLabel, 0, 0);

		enviromentChoiceBox.getItems().addAll("Developer", "Testing", "Production");
		enviromentChoiceBox.setValue("Developer");
		grid.add(enviromentChoiceBox, 1, 0);

		grid.add(userLabel, 0, 1);

		userComboBox = new ComboBox(usersData.createDevUsersList(usersData.getDeveloperTable()));
		userComboBox.setPromptText("New user...");
		userComboBox.setEditable(true);
		grid.add(userComboBox, 1, 1);

		grid.add(passLabel, 0, 2);

		password.setPromptText("Password");
		grid.add(password, 1, 2);

		// Enable/Disable login button depending on whether a username was entered.
		loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
		loginButton.setDisable(true);
		
		enviromentChoiceBox.valueProperty().addListener((observable, oldValue, newValue) -> 
		{
			afterChange();
			enviromentChange();
		});
		userComboBox.valueProperty().addListener((observable, oldValue, newValue) -> afterChange());
		password.textProperty().addListener((observable, oldValue, newValue) -> afterChange());
		
		
		dialog.getDialogPane().setContent(grid);

		// Convert the result to enviroment-user-pair when the login button is clicked.
		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == loginButtonType) {
				if (usersData.isPasswordCorrect(enviromentChoiceBox.getValue().toString(),
						userComboBox.getValue().toString(), password.getText())) {
					return new Pair<>(enviromentChoiceBox.getValue().toString(), userComboBox.getValue().toString());
				}
			}
			return null;
		});
		
	}

	private void enviromentChange() 
	{
		if(enviromentChoiceBox.getValue()== "Developer")
			userComboBox.setItems(usersData.createDevUsersList(usersData.getDeveloperTable()));
		if(enviromentChoiceBox.getValue()== "Testing")
			userComboBox.setItems(usersData.createDevUsersList(usersData.getTestingTable()));
		if(enviromentChoiceBox.getValue()== "Production")
			userComboBox.setItems(usersData.createDevUsersList(usersData.getProductionTable()));
	}

	public Optional<Pair<String, String>> showAndWait() {
		return dialog.showAndWait();
	}
	
	private void afterChange()
	{ 
		loginButton.setDisable(enviromentChoiceBox.getValue() == null || 
		userComboBox.getEditor().getText().trim().isEmpty() || 
		password.getText().isEmpty() ); 
	}

	private void clearComboBox() {
		userComboBox.setPromptText("New user...");
	}

	private void clearPassword() {
		password.setText(" ");
	}

}
