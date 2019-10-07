package gear;

import java.util.ArrayList;

public class Inventory {
	
	private Money money;
	private ArrayList<Armor> armorList;
	private ArrayList<Weapon> weaponList;
	private Equipment equip;
	
	
	public Inventory() {
		money = new Money();
		armorList = new ArrayList<Armor>();
		weaponList = new ArrayList<Weapon>();
		equip = new Equipment();
	}

	public Inventory(Equipment equip) {
		money = new Money();
		armorList = new ArrayList<Armor>();
		weaponList = new ArrayList<Weapon>();
		this.equip = equip;
	}

	public Equipment getEquip() {
		return equip;
	}
	public void setEquip(Equipment equip) {
		this.equip = equip;
	}


	public Money getMoney() {
		return money;
	}
	public void setMoney(Money money) {
		this.money = money;
	}


	public ArrayList<Armor> getArmorList() {
		return armorList;
	}
	public void setArmorList(ArrayList<Armor> armorList) {
		this.armorList = armorList;
	}


	public ArrayList<Weapon> getWeaponList() {
		return weaponList;
	}
	public void setWeaponList(ArrayList<Weapon> weaponList) {
		this.weaponList = weaponList;
	}

	
	
}
