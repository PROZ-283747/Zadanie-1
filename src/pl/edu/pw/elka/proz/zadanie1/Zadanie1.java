package pl.edu.pw.elka.proz.zadanie1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
 
public class Zadanie1 extends Application {
	
	private GridPane grid, grid2;
	private Text formTitle, notification;
	private Label userLoginLabel, userPass, enviromentLabel;
	private TextField userLoginField, enviromentField;
	private PasswordField userPassField;
	private Button signInButton, cancelButton;
	private Scene scene;
	private String cssPath;
	

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
        //grid.getColumnConstraints().add(new ColumnConstraints(100)); // column 0 is 100 wide
        
        grid2 = new GridPane();
        
        formTitle = new Text("Login into STYLEman system");
        grid.add(formTitle, 0,0,2,1);
        
        userLoginLabel = new Label("Enviroment: ");
        grid.add(userLoginLabel, 0, 1);
        
        enviromentField = new TextField();
        grid.add(enviromentField, 1, 1);
        
        userLoginLabel = new Label("User login: ");
        grid.add(userLoginLabel, 0, 2);
        
        userLoginField = new TextField();
        grid.add(userLoginField, 1, 2);
        
        userPass = new Label("Password: ");
        grid.add(userPass, 0, 3);
        
        userPassField = new PasswordField();
        grid.add(userPassField, 1, 3);

        signInButton = new Button("SIgn In");
        grid.add(signInButton, 1, 4);
        
        notification = new Text();
        grid.add(notification, 1, 6);
        
        
        signInButton.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("You've just logged in :)");
            }
        });
        
        scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
        
    
 }
