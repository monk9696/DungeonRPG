package __runners;

import gear.*;

public class EquipmentRunner {

	public static void main(String[] args) {
		
		Equipment e = new Equipment();
		System.out.println(e.getDamage());
		System.out.println(e.getDefence());
		System.out.println(e.getAgility());

		e = new Equipment(new Weapon("Sword",15,true), new Weapon("Sword", 10, false),new ArmorSet());
		System.out.println(e.getDamage());
		System.out.println(e.getDefence());
		System.out.println(e.getAgility());		
		
		ArmorSet a = new ArmorSet(new Armor[] {new Armor("Helm",3,2,"helmet"),
												new Armor("Chest", 5,2,"chestPlate"),
												new Armor("Gloves", 2,4,"gloves"),
												new Armor("Pants", 5,2,"greaves"),
												new Armor("Boots", 2, 3,"boots")},
												new Armor[0]);

		e.setArmor(a);
		
		e.getArmor().swapRings(new Armor("Admin Ring", 1000000, 10000000, "ring"), 6);
		
		
		e.printEquip();
		
	}

}
