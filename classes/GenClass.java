package classes;

import spell.Spell;
import characters.Character;

public abstract class GenClass {

	protected Spell spell;
	
	public GenClass() {
		spell = new Spell();
	}
	
	public abstract String getSpellName(int spell);
	
	public abstract void printSpells();
	
	public boolean useSpell(int spellNum, Character user, Character target) {
		switch(spellNum) {
		case 1:
			return spell1(user,target);
		case 2:
			return spell2(user,target);
		case 3:
			return spell3(user,target);
		case 4:
			return spell4(user,target);
		case 5:
			return spell5(user,target);
		default:
			return false;
		}
	}
	protected abstract boolean spell1(Character user, Character target);
	protected abstract boolean spell2(Character user, Character target);
	protected abstract boolean spell3(Character user, Character target);
	protected abstract boolean spell4(Character user, Character target);
	protected abstract boolean spell5(Character user, Character target);
}
