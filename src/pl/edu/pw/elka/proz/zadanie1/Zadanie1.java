package pl.edu.pw.elka.proz.zadanie1;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
 
public class Zadanie1 extends Application {
	
	private GridPane grid;
	private Text formTitle, notification;
	private Label userLoginLabel, userPass;
	private PasswordField userPassField;
	private Button signInButton, cancelButton;
	private Scene scene;
	private String cssPath;
	private ChoiceBox<String> choiceBox;
	

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login");
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);      
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setGridLinesVisible(false);
        
        formTitle = new Text("Login into STYLEman system");
        grid.add(formTitle, 0,0,2,1);
        
        ChoiceBox<String> choiceBox = new ChoiceBox<>(); 
        
        userLoginLabel = new Label("Enviroment: ");
        grid.add(userLoginLabel, 0, 2);
        
        choiceBox.getItems().add("Developer");
        choiceBox.getItems().add("Testing");
        choiceBox.getItems().add("Production");
        choiceBox.setValue("Developer");
        grid.add(choiceBox, 1, 2);
        
        userLoginLabel = new Label("User login: ");
        grid.add(userLoginLabel, 0, 3);
        
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
        ObservableList<String> usersTesting = 
        	    FXCollections.observableArrayList(
        	        "Anita",
        	        "Inga",
        	        "Mi³osz",
        	        "Miron",
        	        "Kaja",
        	        "Tom",
        	        "Jery"
        	    );
        ObservableList<String> usersProduction = 
        	    FXCollections.observableArrayList(
        	        "Agata",
        	        "Adela",
        	        "Kinga",
        	        "Bob",
        	        "Maria",
        	        "Alfred",
        	        "Kate"
        	    );
        final ComboBox comboBox = new ComboBox(usersDeveloper);
        comboBox.setPromptText("New user...");
        comboBox.setEditable(true);  
        grid.add(comboBox, 1, 3);
              
        userPass = new Label("Password: ");
        grid.add(userPass, 0, 4);
        
        userPassField = new PasswordField();
        grid.add(userPassField, 1, 4);

        signInButton = new Button("Sign In");
        grid.add(signInButton, 1, 5);
          
        signInButton.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("You've just logged in :)");
            }
        });
        
        cancelButton = new Button("Cancel");
        grid.add(cancelButton, 1, 5);
        grid.setHalignment(cancelButton, HPos.RIGHT);
        
        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
       	 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Operation canceled :(");
                Platform.exit();
            }
        });
       
        scene = new Scene(grid, 350, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
        
    
 }
