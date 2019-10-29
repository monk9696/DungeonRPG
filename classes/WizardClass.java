package classes;

import characters.Character;

public class WizardClass extends GenClass {

	public String getSpellName(int spell) {
		switch (spell){
			case 1:
				return "Magic Missile";
			case 2:
				return "Fireball";
			case 3:
				return "Reflect";
			case 4:
				return "Word of Healing ";
			case 5: 
				//return "Whirlwind ";
			default:
				return "Not a valid spell";
		}
	}

	public void printSpells() {
		System.out.println("1: Reflect");
		System.out.println("2: Word of Healing");
		System.out.println("3: Sudden Strike");
		System.out.println("4: Bash");
		System.out.println("5: Whirlwind");
	}
	
	protected boolean spell1(Character user, Character target) {
		if(spell.checkCooldown(0)) {
			spell.setCooldown(0, 3);
			spell.mMissile(user, target);
			return true;
		}
		return false;
	}

	protected boolean spell2(Character user, Character target) {
		if(spell.checkCooldown(1)) {
			spell.setCooldown(1, 3);
			spell.fireball(user, target);
			return true;
		}
		return false;
	}

	protected boolean spell3(Character user, Character target) {
		if(spell.checkCooldown(2)) {
			spell.setCooldown(2, 5);
			spell.reflect(user, target);
			return true;
		}
		return false;
	}

	protected boolean spell4(Character user, Character target) {
		if(spell.checkCooldown(3)) {
			spell.setCooldown(3, 5);
			spell.wordOfHealing(user, target);
			return true;
		}
		return false;
	}

	protected boolean spell5(Character user, Character target) {
		if(spell.checkCooldown(4)) {
			spell.setCooldown(4, 5);
			spell.reflect(user, target);
			return true;
		}
		return false;
	}

}
