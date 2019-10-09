package __runners;

import characters.Character;
import characters.Player;
import classes.*;
import gear.*;
import stats.Health;
import mechanics.Fight;

public class FightRunner {

	public static void main(String[] args) {
		
		Character main = new Player(new Health(20), new Inventory(new Equipment(new Weapon("Sword", 10, true), new Weapon("Sword", 10, true))), new WarriorClass());
		Character enemy = new Player(new Health(18), new Inventory(), new WizardClass());
		Character enemy1 = new Player(new Health(19), new Inventory(), new WizardClass());
		Character enemy2 = new Player(new Health(19), new Inventory(), new WizardClass());
		Character enemy3 = new Player(new Health(19), new Inventory(), new WizardClass());

		Armor a = new Armor("Main", 1, 2, "Helmet");
		Armor b = new Armor("Main", 1, 3, "Helmet");
		Armor c = new Armor("Main", 1, 8, "Helmet");
		Armor d = new Armor("Main", 1, 20, "Helmet");
		
		enemy.getEquipment().getArmor().setHelmet(a);
		enemy1.getEquipment().getArmor().setHelmet(c);
		enemy3.getEquipment().getArmor().setHelmet(d);
		main.getEquipment().getArmor().setHelmet(b);
		Fight f = new Fight();
		Character[] list = {main, enemy, enemy1,enemy2,enemy3};
		f.engagement(list);
		
	}

}
