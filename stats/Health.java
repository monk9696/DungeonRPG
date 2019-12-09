package stats;


public class Health {
	
	//possible Additions
	//Bonus HP from equipment
	//max health increasing
		
	private int currentHP;
	private int maxHP;
	
	public Health() {
		maxHP = 10;
		currentHP = 10;
	}

	public Health(int hp){
		maxHP = hp;
		currentHP = hp;
	}
	
	public void raiseMax(int added) {
		maxHP += added;
	}
	
	public int hit(int damage){
		if(damage > 0) {
			currentHP = currentHP - damage;
		}
		return currentHP;
	}
	
	//heal based of what is left in the current hp pool
	public int heal(int heal){
		int h = maxHP-currentHP;
		if(heal > h){
			currentHP = maxHP;
		}else{
			currentHP += heal;
		}
		return currentHP;
	}
	
	public int healMax(){
		currentHP = maxHP;
		return currentHP;
	}
	
	public int getHP(){
		return currentHP;
	}
	
	public int getMaxHP(){
		return maxHP;
	}
	
	public double getHPPercent(){
		return Math.floor(((double) currentHP/maxHP) * 100) / 100;
	}

}
