package characters;

import gear.Inventory;
import stats.Health;


public class Enemy extends Character implements Comparable<Character>{

	public Enemy(Health hp, Inventory inv) {
		super(hp, inv);
	}

	public void damageTaken(int damage) {
		if(this.checkEffect("Reflect")) {
			status.removeEffect("Reflect");
		}else {
			damage -= this.getDefence();
			this.h.hit(damage);
		}
	}

	public int getDamage() {
		int damage = 0;
		damage += inv.getEquip().getDamage();
		if(this.checkEffect("Embolden")) {
			damage *= 2.5;
			status.removeEffect("Embolden");
		}
		return damage;
	}

	public void turnEnd() {
		status.turnTic();
	}

	public boolean spell(int spellSelector, Character enemy) {
		return false;
	}
	
	public int compareTo(Character s) {
		if(s.getAgility() == this.getAgility()) {
			return 0;
		}else if(s.getAgility() < this.getAgility()) {
			return 1;
		}else {
			return -1;
		}
	}

	public String toString() {
		return "Enemy: Health: " + getHP() + " Defense: " + getDefence() + " Speed: " + getAgility();
	}
	
}
