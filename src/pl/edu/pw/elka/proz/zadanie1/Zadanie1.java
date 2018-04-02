package pl.edu.pw.elka.proz.zadanie1;

import java.util.Optional;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Pair;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
 
public class Zadanie1 extends Application{
	
	ButtonType loginButtonType;
	Label enviromentLabel, userLabel, passLabel;
	PasswordField password;
	ChoiceBox<String> enviromentChoiceBox;
	ComboBox<ObservableList<String>> userComboBox;
	Dialog<Pair<String, String>> dialog; 
	
	UsersData usersData = new UsersData();

	
	@Override
    public void start(Stage primaryStage) {
		// Create the custom dialog.
		dialog = new Dialog<>();
		dialog.setTitle("Login Dialog");
		dialog.setHeaderText("Login into system");
		dialog.setResizable(true);

		// Set the icon (must be included in the project).
		//dialog.setGraphic(new ImageView(this.getClass().getResource("start.jpg").toString()));

		// Set the button types.
		loginButtonType = new ButtonType("Login", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

		// Create the username and password labels and fields.
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));

		 enviromentLabel = new Label("Enviroment: ");
	     grid.add(enviromentLabel, 0, 0);
	     
	     enviromentChoiceBox = new ChoiceBox<>(); 
	     enviromentChoiceBox.getItems().addAll("Developer","Testing","Production");
	     enviromentChoiceBox.setValue("Developer");
	     grid.add(enviromentChoiceBox, 1, 0);
	     
	     userLabel = new Label("User: ");
	     grid.add(userLabel, 0, 1);
	     
	     ObservableList<String> usersDeveloper = 
	        	    FXCollections.observableArrayList(
	        	        "Ania",
	        	        "Ola",
	        	        "Kamil",
	        	        "Bartek",
	        	        "John",
	        	        "Sam",
	        	        "Arlo"
	        	    );
	            
	     ComboBox userComboBox = new ComboBox(usersDeveloper);
	     userComboBox.setPromptText("New user...");
	     userComboBox.setEditable(true);  
	     grid.add(userComboBox, 1, 1);
	        
	     passLabel = new Label("Password: ");
	     grid.add(passLabel, 0, 2);
	     
	     password = new PasswordField();
	     password.setPromptText("Password");
	     grid.add(password, 1, 2);  

		// Enable/Disable login button depending on whether a username was entered.
		Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
		loginButton.setDisable(true);
	
		// Do some validation (using the Java 8 lambda syntax).
		enviromentChoiceBox.valueProperty().addListener((observable, oldValue, newValue) -> enviromentChoiceBox_Changed(newValue)); 
		userComboBox.valueProperty().addListener((observable, oldValue, newValue) -> userComboBox_Changed(newValue)); 
		password.textProperty().addListener((observable, oldValue, newValue) -> password_Changed(newValue)); 
		
		dialog.getDialogPane().setContent(grid);

		// Request focus on the username field by default.
		Platform.runLater(() -> password.requestFocus());

		// Convert the result to a enviroment-user-pair when the login button is clicked.
		dialog.setResultConverter(dialogButton -> {
		    if (dialogButton == loginButtonType) {
		    	if(usersData.isPasswordCorrect(enviromentChoiceBox.getValue().toString(), 
		    		userComboBox.getValue().toString(), password.getText())) {
		    			return new Pair<>(enviromentChoiceBox.getValue().toString(), userComboBox.getValue().toString());
		    		}
		    }
		    
		    return null;
		});

		
		Optional<Pair<String, String>> result = dialog.showAndWait();

		result.ifPresent(usernamePassword -> {
		    System.out.println("Enviroment=" + usernamePassword.getKey() + ", User=" + usernamePassword.getValue());
		});
		
    }
	
	private Object password_Changed(String newValue) {
		// TODO Auto-generated method stub
		return null;
	}

	private Object userComboBox_Changed(Object newValue) {
		// TODO Auto-generated method stub
		return null;
	}

	private Object enviromentChoiceBox_Changed(String newValue) {
		//loginButtonType.setDisable(newValue.toString().isEmpty());
		//usersData.addUsersToComboBox(enviromentChoiceBox.getValue().toString());
		return null;
	}
	/*	
		private Pair<String, String> resultConverter(ButtonType buttonType) {
			if (buttonType == loginButtonType) {
				if(usersData.isPasswordCorrect(enviromentChoiceBox.getValue().toString(), 
			    		userComboBox.getValue().toString(), password.getText())) {
						return new Pair<String, String> (password.getText(),password.getText());
						}
		}
		return null;
		}
*/	
        private void clearComboBox()
        {
        	 userComboBox.setPromptText("New user...");
        }
        private void clearPassword()
        {
        	password.setText(" ");
        }
        
        public static void main(String[] args) {
            launch(args);
        }
    
 }
