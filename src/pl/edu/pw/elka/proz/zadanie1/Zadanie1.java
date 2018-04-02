package pl.edu.pw.elka.proz.zadanie1;

import java.util.Optional;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Pair;


public class Zadanie1 extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception{

		Optional<Pair<String, String>> result = (new LogonDialog("Login", "Login into STYLEman system")).showAndWait();
		
		result.ifPresent(usernamePassword -> {
			System.out.println("Enviroment=" + usernamePassword.getKey() + ", User=" + usernamePassword.getValue());
		});

	}
}
