package classes;

import spell.Spell;
import characters.Character;

public abstract class GenClass {

	protected Spell spell;
	
	public GenClass() {
		spell = new Spell();
	}
	
	public abstract String getSpellName(int spell);
	
	public void useSpell(int spellNum, Character user, Character target) {
		switch(spellNum) {
		case 1:
			spell1(user,target);
			break;
		case 2:
			spell2(user,target);
			break;
		case 3:
			spell3(user,target);
			break;
		case 4:
			spell4(user,target);
			break;
		case 5:
			spell5(user,target);
			break;
		default:
			break;
		}
	}
	protected abstract boolean spell1(Character user, Character target);
	protected abstract boolean spell2(Character user, Character target);
	protected abstract boolean spell3(Character user, Character target);
	protected abstract boolean spell4(Character user, Character target);
	protected abstract boolean spell5(Character user, Character target);
}
