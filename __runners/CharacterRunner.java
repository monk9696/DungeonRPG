package __runners;

import characters.Player;
import characters.Character;
import gear.Equipment;
import gear.Inventory;
import gear.Weapon;
import stats.Health;
import status.Stunned;
import classes.*;

public class CharacterRunner {

	public static void main(String[] args) {
		
		Character main = new Player(new Health(20), new Inventory(new Equipment(new Weapon("Sword", 10, true), new Weapon("Sword", 10, true))), new WarriorClass());
		Character enemy = new Player(new Health(20), new Inventory());
		
		enemy.getEquipment().setPrimary(new Weapon("LongSword", 15, false));
		
		enemy.damageTaken(main.getDamage());
		main.getStatus().addEffect(new Stunned(3));
		System.out.println(main.checkEffect("Stunned"));
		System.out.println(main.getStatus().getEffect("Stunned").getEffectType());
		
		
		
		
		
		System.out.println(main.getDamage());
		System.out.println(enemy.getDamage());
		
		
	}

}
