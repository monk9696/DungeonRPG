package spell;

import characters.Character;
import status.Bleeding;
import status.Stunned;

public class Spell {
	
	private int[] cooldown = new int[5];	
	
	
	public Spell() {	
	}
	
	public void turnEnd(){
		for(int i = 0; i < cooldown.length; i++) {
			if (cooldown[i] > 0){
				cooldown[i]--;
			}
		}
	}
	public void setCooldown(int coolDown, int duration) {
		cooldown[coolDown] = duration;
	}
	public int getCooldown(int i){
		return cooldown[i];
	}
	public boolean checkCooldown(int i){
		if (cooldown[i] > 0){
			System.out.println("That spell still has a cool down for " + getCooldown(i) + " turns");
			return false;
		}
		return true;
	}
	// Warrior spells
	//Blocks the next attack and adds the damage to tempDamage
	public void reflect(Character user, Character target){
		user.setReflect();			
	}
		//Heals the user based of level
	public void wordOfHealing(Character user, Character target){
		target.heal((user.getLevel()*3));
	}
	//garunteed hit on your enemy
	public void suddenStrike(Character user, Character target){	
		target.damageTaken(user.getDamage());
	}
	//Stunnes the target for 3 turns and Hits the enemy
	public void bash(Character user, Character target){
		target.getStatus().addEffect(new Stunned(3));
		target.damageTaken(user.getDamage());
	}
	//Afflicts
	public void whirlwind(Character user, Character target){
		target.getStatus().addEffect(new Bleeding(3,3*user.getLevel()));
	}





	//Wizard Spell
	public void mMissile(Character user, Character target){
		for(int i = 0; i < user.getLevel() + 2; i++){
			target.damageTaken(3);
		}
	}
	
	public void fireball(Character user, Character target){
		target.damageTaken((6 * user.getLevel()));
	}
	
}
