package gear;


public class Equipment {
	
	//Variables
	private Weapon primary = new Weapon();
	private Weapon secondary = new Weapon();
	private ArmorSet armor;
	
	//constructors
	public Equipment (){
		armor = new ArmorSet();
	}
	
	public Equipment(Weapon weapon, ArmorSet armor) {
		primary = weapon;
		this.armor = armor;
	}
	
	public Equipment(Weapon primary, Weapon secondary) {
		this.primary = primary;
		this.secondary = secondary;
		this.armor = new ArmorSet();
	}
	
	public Equipment (Weapon primary, Weapon secondary, ArmorSet armor){
		this.primary = primary;
		this.secondary = secondary;
		this.armor = armor;	
	}	
		
	public void printEquip() {
		primary.printWeapon();
		secondary.printWeapon();
		armor.printGear();
	}
	
	
	//Setting equipment
	public void setPrimary(Weapon weapon){
		primary = weapon;
	}
	public void setSecondary(Weapon weapon){
		secondary = weapon;
	}
	public void setArmor(ArmorSet armor){
		this.armor = armor;
	}
	public void setAll(Weapon weapon1, Weapon weapon2, ArmorSet armor){
		primary = weapon1;
		secondary = weapon2;
		this.armor = armor;
	}
		
	//getters
	public int getDamage(){
		if(primary.isDualWield() && secondary.isDualWield()) {
			return (primary.getDamage() + secondary.getDamage());
		}else {
			return (primary.getDamage());
		}
	}
	public int getDefence() {
		return armor.getDef();
	}
	public int getAgility() {
		return armor.getAgility();
	}
		
	//Primary
	public String getPrimaryName(){
		return primary.getName();
	}
	public int getPrimaryDamage(){
		return primary.getDamage();
	}
	public boolean getPrimaryDual(){
		return primary.isDualWield();
	}
	
	//Secondary
	public String getSecondaryName(){
		return secondary.getName();
	}
	public int getSecondaryDamage(){
		return secondary.getDamage();
	}
	public boolean getSecondaryDual(){
		return secondary.isDualWield();
	}

	//Armor
	public ArmorSet getArmor() {
		return armor;
	}
	public Armor getPeice(String type, int loc) {
		switch(type) {
			case "helmet":
			case "Helmet":
				return armor.getHelmet();
			case "chestPlate":
			case "ChestPlate":
				return armor.getChestPlate();
			case "boots":
			case "Boots":
				return armor.getBoots();
			case "gloves":
			case "Gloves":
				return armor.getGloves();
			case "greaves":
			case "Greaves":
				return armor.getGreaves();
			case "rings":
			case "Rings":
				return armor.getRings(loc);
			default:
				return null;			
		}
	}
		
}
