package stats;

public class Health {
	
	
	private int currentHP;
	private int maxHP;
		
	public Health(int hp){
		maxHP = hp;
		currentHP = hp;
	}
	
	public int hit(int damage){
		currentHP = currentHP - damage;
		return currentHP;
	}
	
	public int heal(int heal){
		int h = maxHP-currentHP;
		if(heal > h){
			currentHP = maxHP;
		}else{
			currentHP += heal;
		}
		return currentHP;
	}
	
	public void healMax(){
		currentHP = maxHP;
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
