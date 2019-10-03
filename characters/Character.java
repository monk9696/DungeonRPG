package characters;

import gear.Equipment;
import stats.Health;
import stats.StatusModifiers;
import status.NullEffect;
import status.StatusEffect;

public abstract class Character {

	protected Equipment equip;
	protected Health h;
	protected StatusModifiers status;
	protected int level = 1;
	
	public Character(Health hp1, Equipment equip1){
		h = hp1;
		equip = equip1;
		status = new StatusModifiers(h);
	}
		
	//HP
	public int getHP(){
		return h.getHP();
	}
	public double getHPPercent(){
		return h.getHPPercent();
	}
	public void heal(int hValue){
		h.heal(hValue);
	}
	public void healMax(){
		h.healMax();
	}
	public abstract void damageTaken(int damage);
	
	
	//equipment
	public int getDefence(){
		return equip.getDefence();
	}	
	public int getAgility() {
		return equip.getAgility();
	}
	public abstract int getDamage();
	
	
	//exp
	public int getLevel(){
		return level;
	}
	
	//combat
	public abstract int attack();
	public abstract void turnEnd();

	//Spell
	public abstract int spell(int spellSelector, Character subject, Character enemy);
		
	//Status
	public StatusModifiers getStatus(){
		return status;
	}
	public boolean checkEffect(String effect){
		return (status.getEffect(effect) != (new NullEffect()));
	}
	public void setStatus(StatusEffect stat) {
		status.addEffect(stat);
	}
	
	//Status ability set
	public void setReflect(){
		status.setReflect();
	}
	public void setEmbolden(){
		status.setEmbolden();
	}
	
}
