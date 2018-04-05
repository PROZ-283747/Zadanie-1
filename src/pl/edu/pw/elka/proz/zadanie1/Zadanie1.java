package pl.edu.pw.elka.proz.zadanie1;

import java.util.Optional;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Pair;

/*
 *	Class Zadanie1- Class with main method which start the programm.
 *
 *	@autor Adela Jaworowska / adela.jaworowska@gmail.com
 */
public class Zadanie1 extends Application {
	/*
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Optional<Pair<String, String>> result = (new LogonDialog("Login", "Login into STYLEman system")).showAndWait();

		if (result.isPresent()) {
			System.out.println("Enviroment = " + result.get().getKey() + " User = " + result.get().getValue());
		} else {
			System.out.println("Login unsuccessful! ");
		}
	}
}
