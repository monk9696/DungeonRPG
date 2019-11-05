package __runners;

import characters.Character;
import characters.Enemy;
import characters.Player;
import classes.*;
import gear.*;
import stats.Health;
import mechanics.Fight;

public class FightRunner {

	public static void main(String[] args) {
		
		Player main = new Player(new Health(20), new Inventory(new Equipment(new Weapon("Sword", 10, true), new Weapon("Sword", 10, true))), new WarriorClass());
		Character enemy0 = new Enemy(new Health(18), new Inventory());
		Character enemy1 = new Enemy(new Health(19), new Inventory());
		Character enemy2 = new Enemy(new Health(19), new Inventory());
		Character enemy3 = new Enemy(new Health(19), new Inventory());

		Weapon temp = new Weapon("Jake",5,true);
		
		Armor a = new Armor("Main", 8, 2, "Helmet");
		Armor b = new Armor("Main", 5, 3, "Helmet");
		Armor c = new Armor("Main", 10, 8, "Helmet");
		Armor d = new Armor("Main", 15, 20, "Helmet");
		
		main.getEquipment().getArmor().setHelmet(b);
		enemy0.getEquipment().getArmor().setHelmet(a);
		enemy1.getEquipment().getArmor().setHelmet(c);
		enemy3.getEquipment().getArmor().setHelmet(d);
		enemy0.getEquipment().setPrimary(temp);
		enemy1.getEquipment().setPrimary(temp);
		enemy2.getEquipment().setPrimary(temp);
		enemy3.getEquipment().setPrimary(temp);
		
		Fight f = new Fight();
		Character[] list = {main, enemy0, enemy1,enemy2,enemy3};
		f.engagement(list);
		
	}
}