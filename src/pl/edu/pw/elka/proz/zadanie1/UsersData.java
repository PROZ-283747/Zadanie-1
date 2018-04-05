package pl.edu.pw.elka.proz.zadanie1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Class UsersData- holds data and check if entered data is correct
 *
 * @autor Adela Jaworowska / adela.jaworowska@gmail.com
 */
public class UsersData {
	// Table with users from developer environment
	private String developerTable[][] = new String[][] { { "Ola", "098765" }, { "Ania", "jestemania" },
			{ "Tomek", "jestemsuper" }, { "Basia", "devlife" }, { "Kate", "22.03.95" } };

	// Table with users from developer environment
	private String testingTable[][] = new String[][] { { "Arlo", "iksde" }, { "Kris", "zzzzz" }, { "Jola", "lala" },
			{ "Ewa", "zielony" }, { "Justyna", "karate" } };
	// Table with users from developer environment
	private String productionTable[][] = new String[][] { { "Jan", "1234567" }, { "Bogdan", "qazwsx" },
			{ "Gra¿yna", "supersilnehas³o" }, { "Tytus", "romek*atomek" }, { "Inga", "peru.2018" } };

	/**
	 * Checks if password is correct
	 * 
	 * @param env
	 * @param user
	 * @param pass
	 * @return true when password correct or false when password incorrect
	 */
	public boolean isPasswordCorrect(String env, String user, String pass) {
		String table[][] = new String[][] {};
		if (env == "Developer")
			table = getDeveloperTable();
		if (env == "Testing")
			table = getTestingTable();
		if (env == "Production")
			table = getProductionTable();

		for (int i = 0; i < table.length; ++i) {
			if (table[i][0].equals(user)) {
				if (table[i][1].equals(pass))
					return true;
				else
					return false;
			}
		}
		return true;
	}

	/**
	 * Creates Observable list with users to add to comboBox
	 * 
	 * @param table
	 *            with users' data
	 * @return ObservableList<String> with users from given environment
	 */
	public ObservableList<String> createDevUsersList(String table[][]) {
		ObservableList<String> list = FXCollections.observableArrayList();
		for (int i = 0; i < table.length; ++i) {
			list.add(table[i][0]);
		}
		return list;
	}

	/**
	 * @return developerTable
	 */
	public String[][] getDeveloperTable() {
		return developerTable;
	}

	/**
	 * @return testingTable
	 */
	public String[][] getTestingTable() {
		return testingTable;
	}

	/**
	 * @return productionTable
	 */
	public String[][] getProductionTable() {
		return productionTable;
	}
}