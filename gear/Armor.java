package gear;

public class Armor {

	private String name;
	private int def;
	private int agi;
	private String type;
	
	public Armor() {
		
	}

	public Armor(String name, int def, int agi, String type) {
		this.name = name;
		this.def = def;
		this.agi = agi;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getAgi() {
		return agi;
	}

	public void setAgi(int agi) {
		this.agi = agi;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	
}
