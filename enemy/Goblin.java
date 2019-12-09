package enemy;

import characters.Character;
import characters.Enemy;
import gear.Inventory;
import gear.Weapon;
import stats.Health;
import stats.StatusModifiers;

public class Goblin extends Enemy{

	public Goblin() {
		h = new Health(15);
		status = new StatusModifiers(h);
		inv = new Inventory();
		inv.getEquip().setPrimary(new Weapon("Dagger",5,true));
		inv.getEquip().setSecondary(new Weapon("Claw",2,true));
	}
	
	public Goblin(Inventory inv) {
		this();	
		if(inv.getEquip().getSecondary().equals(new Weapon())) {
			inv.getEquip().setSecondary(this.inv.getEquip().getSecondary());
		}
		this.inv = inv;
	}
	
	public Goblin(Health hp, Inventory inv) {
		super(hp, inv);	
	}
	
	@Override
	public String toString() {
		return "Goblin: Health: " + getHP() + " Defense: " + getDefence() + " Speed: " + getAgility();
	}
	
	@Override
	public String CombatChoice() {
		return "attack";
	}

	@Override
	public boolean spell(int spellSelector, Character enemy) {
		return false;
	}

}
