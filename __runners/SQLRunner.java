package __runners;

import util.SQLLookup;

public class SQLRunner {

	public static void main(String[] args) {
		
		SQLLookup sql = new SQLLookup("jdbc:mysql://localhost:3306/Test","root", "monk9696");

		
		sql.removeWeapon("temp");
		sql.addWeapon("Temp", 4, 0, false);
		sql.getWeapon("temp");
		
		sql.addArmor("Iron Helm", 5, 0, "Helmet");
		sql.getArmor("Iron Helm");
		sql.removeArmor("Iron Helm");
	}
}
