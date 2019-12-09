package characters;

import gear.Inventory;
import stats.Health;


public abstract class Enemy extends Character{

	public Enemy() {
		super();
	}
	
	public Enemy(Health hp, Inventory inv) {
		super(hp, inv);
	}

	public abstract String CombatChoice();
	
	public void damageTaken(int damage) {
		if(this.checkEffect("Reflect")) {
			status.removeEffect("Reflect");
		}else {
			damage -= this.getDefence();
			this.h.hit(damage);
		}
	}

	public int getDamage() {
		int damage = inv.getEquip().getDamage();
		if(this.checkEffect("Embolden")) {
			damage *= 2.5;
			status.removeEffect("Embolden");
		}
		return damage;
	}

	public void turnEnd() {
		status.turnTic();
	}

	public abstract boolean spell(int spellSelector, Character enemy);

	
	public String toString() {
		return "Enemy: Health: " + getHP() + " Defense: " + getDefence() + " Speed: " + getAgility();
	}
	
}
