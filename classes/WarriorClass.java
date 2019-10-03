package classes;

import characters.Character;

public class WarriorClass extends GenClass {

	public WarriorClass() {
		super();
	}
	
	public String getSpellName(int spell){
		switch (spell){
			case 1:
				return "Reflect";
			case 2:
				return "Embolden";
			case 3:
				return "Sudden Strike";
			case 4:
				return "Word of Healing ";
			case 5: 
				return "Whirlwind ";
			default:
				return "Not a valid spell";
		}
	}
	
	protected boolean spell1(Character user, Character target) {
		if(spell.checkCooldown(0)) {
			spell.setCooldown(0, 5);
			spell.reflect(user, target);
			return true;
		}
		return false;
	}

	protected boolean spell2(Character user, Character target) {
		if(spell.checkCooldown(0)) {
			spell.setCooldown(1, 8);
			spell.embolden(user, target);
			return true;
		}
		return false;
	}

	protected boolean spell3(Character user, Character target) {
		if(spell.checkCooldown(0)) {
			spell.setCooldown(2, 5);
			spell.suddenStrike(user, target);
			return true;
		}
		return false;
	}

	protected boolean spell4(Character user, Character target) {
		if(spell.checkCooldown(0)) {
			spell.setCooldown(3, 5);
			spell.wordOfHealing(user, target);
			return true;
		}
		return false;
	}

	protected boolean spell5(Character user, Character target) {
		if(spell.checkCooldown(0)) {
			spell.setCooldown(4, 5);
			spell.whirlwind(user, target);
			return true;
		}
		return false;
	}
}
