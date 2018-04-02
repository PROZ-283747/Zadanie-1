package pl.edu.pw.elka.proz.zadanie1;

public class UsersData {

		private String developerUsers[][]= new String[][] 
			{{"Ola","ola"},
			{"Ania", "ania"},
			{"Tomek", "tomek"},
			{"Basia", "basia"},
			{"Kate","kate"}}; 
		private String testingUsers[][] = new String[][] 
			{{"Ola","ola"},
			{"Ania", "ania"},
			{"Tomek", "tomek"},
			{"Basia", "basia"},
			{"Kate","kate"}};
		private String productionUsers[][] = new String[][]
			{{"Ola","ola"},
			{"Ania", "ania"},
			{"Tomek", "tomek"},
			{"Basia", "basia"},
			{"Kate","kate"}};
			
		public boolean isPasswordCorrect(String  env, String user, String pass)
		{
			return true;
		}
		
		public void addUsersToComboBox(String env)
		{
			
		}
		
		public void printTable(String usersTable[][])
		{
			for(int i = 0; i<5 ; ++i)
			{
				System.out.println(usersTable[i][0]+ " " + usersTable[i][1]);
			}
		}

		public String[][] getDeveloperUsers() {
			return developerUsers;
		}

		public void setDeveloperUsers(String developerUsers[][]) {
			this.developerUsers = developerUsers;
		}

		public String[][] getTestingUsers() {
			return testingUsers;
		}

		public void setTestingUsers(String testingUsers[][]) {
			this.testingUsers = testingUsers;
		}

		public String[][] getProductionUsers() {
			return productionUsers;
		}

		public void setProductionUsers(String productionUsers[][]) {
			this.productionUsers = productionUsers;
		}
}
