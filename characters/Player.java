package characters;

import classes.GenClass;
import gear.Inventory;
import stats.Health;

public class Player extends Character implements Comparable<Character>{

	private GenClass charClass;
	
	public Player(Health hp, Inventory inv) {
		super(hp, inv);
		charClass = null;
	}
	
	public Player(Health hp, Inventory inv, GenClass clas) {
		super(hp,inv);
		charClass = clas;
	}
	
	public GenClass getCharClass() {
		return charClass;
	}
	public void setCharClass(GenClass charClass) {
		this.charClass = charClass;
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
		int dam = 0;
		dam = inv.getEquip().getDamage();
		if(this.checkEffect("Embolden")) {
			dam *= 2.5;
			status.removeEffect("Embolden");
		}
		return dam;
	}

	public void turnEnd() {
		status.turnTic();
	}

	public boolean spell(int spellSelector, Character enemy) {
		if(charClass.useSpell(spellSelector, this, enemy)) {
			return true;
		}
		return false;
	}

	@Override
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
		return "Player: " + getHP() ;
	}
}
