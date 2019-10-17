package characters;

import gear.Equipment;
import gear.Inventory;
import stats.Health;
import stats.StatusModifiers;
import status.StatusEffect;

public abstract class Character implements Comparable<Character> {

	protected Inventory inv;
	protected Health h;
	protected StatusModifiers status;
	protected int level = 1;
	
	public Character(Health hp, Inventory inv){
		h = hp;
		this.inv = inv;
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
	public void setEquipment(Equipment e) {
		inv.setEquip(e);
	}
	public Equipment getEquipment() {
		return inv.getEquip();
	}
	
	public int getDefence(){
		return inv.getEquip().getDefence();
	}	
	public int getAgility() {
		return inv.getEquip().getAgility();
	}
	public void setInventory(Inventory inv) {
		this.inv = inv;
		this.setEquipment(inv.getEquip());
	}
	public Inventory getInventory() {
		return inv;
	}
	public abstract int getDamage();
	
	//exp
	public int getLevel(){
		return level;
	}
	
	//combat
	public abstract void turnEnd();

	//Spell
	public abstract boolean spell(int spellSelector, Character enemy);
		
	//Status
	public StatusModifiers getStatus(){
		return status;
	}
	public boolean checkEffect(String effect){
		if(status.getEffect(effect).getEffectType() != "Null") {
			return true;
		}
		return false;
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
	
	public int compareTo(Character s) {
		if(s.getAgility() == this.getAgility()){
			return 0;
		}else if(s.getAgility() < this.getAgility()) {
			return 1;
		}else {
			return -1;
		}
	}
	
	public abstract String toString();
	
}
