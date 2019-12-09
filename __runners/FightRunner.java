package __runners;

import characters.Character;
import characters.Player;
import classes.WarriorClass;
import enemy.Goblin;
import gear.Armor;
import gear.Equipment;
import gear.Inventory;
import gear.Weapon;
import mechanics.Fight;
import stats.Health;

public class FightRunner {

	public static void main(String[] args) {
		
		Player main = new Player(new Health(20), new Inventory(new Equipment(new Weapon("Sword", 10, true), new Weapon("Sword", 10, true))), new WarriorClass());
		Character enemy0 = new Goblin();
		Character enemy1 = new Goblin();
		Character enemy2 = new Goblin(new Inventory(new Equipment(new Weapon("Sword", 10, true),new Weapon("Fist", 5, true))));
		Character enemy3 = new Goblin();
		
		Armor a = new Armor("Main", 8, 2, "Helmet");
		Armor b = new Armor("Main", 5, 3, "Helmet");
		Armor c = new Armor("Main", 10, 8, "Helmet");
		
		enemy0.getEquipment().getArmor().setArmor(a);
		enemy1.getEquipment().getArmor().setArmor(b);
		enemy2.getEquipment().getArmor().setArmor(c);
		
		Armor player = new Armor("Helmet", 4, 2, "Helmet");
		main.getEquipment().getArmor().setArmor(player);
		
		player = new Armor("ChestPlate", 10, 0, "chestPlate");
		main.getEquipment().getArmor().setArmor(player);
		
		Fight f = new Fight();
		Character[] list = {main, enemy0, enemy1, enemy2, enemy3};
		f.engagement(list);
		
	}
}