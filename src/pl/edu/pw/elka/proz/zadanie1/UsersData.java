package pl.edu.pw.elka.proz.zadanie1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UsersData {

		private String developerTable[][]= new String[][] 
			{{"Ola","098765"},
			{"Ania", "jestemania"},
			{"Tomek", "jestemsuper"},
			{"Basia", "devlife"},
			{"Kate","22.03.95"}}; 
		private String testingTable[][] = new String[][] 
			{{"Arlo","iksde"},
			{"Kris", "zzzzz"},
			{"Jola", "lala"},
			{"Ewa", "zielony"},
			{"Justyna","karate"}};
		private String productionTable[][] = new String[][]
			{{"Jan","1234567"},
			{"Bogdan", "qazwsx"},
			{"Gra¿yna", "supersilnehas³o"},
			{"Tytus", "romek*atomek"},
			{"Inga","peru.2018"}};
			
		public boolean isPasswordCorrect(String  env, String user, String pass)
		{
			String table[][] = new String[][] {};
			if(env == "Developer")
				table = getDeveloperTable();
			if(env == "Testing")
				table = getTestingTable();
			if(env == "Production")
				table = getProductionTable();
			
			for(int i = 0; i< table.length; ++i)
			{
				if(table[i][0].equals(user))
					if(table[i][1].equals(pass))
						return true;
			}
			return false;
		}
		
		public ObservableList<String> createDevUsersList(String table[][])
		{
			ObservableList<String> list = FXCollections.observableArrayList();
			for( int i = 0; i< table.length; ++i)
			{
				list.add(table[i][0]);
			}
			return list;
		}
		
		public void printTable(String usersTable[][])
		{
			for(int i = 0; i<5 ; ++i)
			{
				System.out.println(usersTable[i][0]+ " " + usersTable[i][1]);
			}
		}

		public String[][] getDeveloperTable() {
			return developerTable;
		}

		public void setDeveloperTable(String developerTable[][]) {
			this.developerTable = developerTable;
		}

		public String[][] getTestingTable() {
			return testingTable;
		}

		public void setTestingTable(String testingTable[][]) {
			this.testingTable = testingTable;
		}

		public String[][] getProductionTable() {
			return productionTable;
		}

		public void setProductionTable(String productionTable[][]) {
			this.productionTable = productionTable;
		}

}