package stats;

/**
 * Health Class which holds the basic information on health
 * This maintains the ability to modify the characters health
 * 
 * @author nkrems
 *
 */


public class Health {
	
	
	private int currentHP;
	private int maxHP;
	
	/**
	 * Basic Constructor for Health which is generated based on max Health
	 * 
	 * @param hp Current Max health for the character
	 */
	public Health(int hp){
		maxHP = hp;
		currentHP = hp;
	}
	
	/**
	 * Hit Command modifies health based of the damage taken
	 * @param damage Damage taken to be subtracted from your Current Health
	 * @return Remaining Current Health
	 */
	public int hit(int damage){
		currentHP = currentHP - damage;
		return currentHP;
	}
	
	/**
	 * Basic Heal Command that will restore health to your current HP
	 * @param heal The amount being healed
	 * @return Current Health of the caracter
	 */
	public int heal(int heal){
		int h = maxHP-currentHP;
		if(heal > h){
			currentHP = maxHP;
		}else{
			currentHP += heal;
		}
		return currentHP;
	}
	
	/**
	 * Basic Function that heals the character back to their max health
	 * @return Current HP
	 * 
	 */
	public int healMax(){
		currentHP = maxHP;
		return currentHP;
	}
	
	/**
	 * @return Returns the current HP
	 */
	public int getHP(){
		return currentHP;
	}
	
	/**
	 * @return Returns the current MaxHP
	 */
	public int getMaxHP(){
		return maxHP;
	}
	
	/**
	 * Calculate the characters health in a percentage of total health remaining
	 * @return returns the percentage as a decimal rounded to two places
	 */
	public double getHPPercent(){
		return Math.floor(((double) currentHP/maxHP) * 100) / 100;
	}

}
