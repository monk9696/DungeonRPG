package gear;


public class Weapon {

	private String name;
	private int damage;
	private boolean dualWield;
	
	public Weapon(){
		name = "Fist";
		damage = 1;
		dualWield = true;
	}

	public Weapon(String name, int damage, boolean dualWield){
		this.name = name;
		this.damage = damage;
		this.dualWield = dualWield;
	}
	
	public void printWeapon() {
		System.out.println(name + " " + damage + " " + dualWield);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public boolean isDualWield() {
		return dualWield;
	}

	public void setDualWield(boolean dualWield) {
		this.dualWield = dualWield;
	}
	
	
	
	
	
}
