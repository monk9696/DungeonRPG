package gear;

public class ArmorSet {
	
	private Armor helmet;
	private Armor chestPlate;
	private Armor gloves;
	private Armor greaves;
	private Armor boots;
	private Armor[] rings;
	
	public ArmorSet() {
		this.helmet = new Armor("None",0,0,"Helmet");
		this.chestPlate = new Armor("None",0,0,"ChestPlate");
		this.gloves = new Armor("None",0,0,"Gloves");
		this.greaves = new Armor("None",0,0,"Greaves");
		this.boots = new Armor("None",0,0,"Boots");
		this.rings = new Armor[10];
		setRings(new Armor[] {});
	}
	
	public ArmorSet(Armor[] armor, Armor[] rings) {
		this();
		for(Armor arm: armor) {
			this.setArmor(arm);
		}
		setRings(rings);
	}
	
	public void setRings(Armor[] rings) {
		if(rings.length <= 10) {
			for(int i = 0; i < rings.length; i++) {
				this.rings[i] = rings[i];
			}
		}
		for(int i = rings.length; i < 10; i++) {
			if(this.rings[i] == null) {
				this.rings[i] = new Armor("None", 0, 0, "Ring");
			}
		}
	}
		
	public void setArmor(Armor armor){
		switch(armor.getType().toLowerCase()){
			case "helmet":
				helmet = armor;
				break;
			case "chestplate":
				chestPlate = armor;
				break;
			case "gloves":
				gloves = armor;
				break;
			case "greaves":
				greaves = armor;
				break;
			case "boots":
				boots = armor;
				break;
			case "ring":
				System.out.println("Rings should be equiped by using swapRing, If you are the player this is an issue.");
				break;
			default:
				System.out.println(armor.getType() + ": Not equiped");
		}
	}
	
	public Armor swapRings(Armor ring, int loc) {
		if(ring.getType().equals("ring") || ring.getType().equals("Ring")) {
			if(rings[loc] == null) {
				rings[loc] = ring;
				return null;
			}else{
				Armor temp = rings[loc];
				rings[loc] = ring;
				return temp;
			}			
		}else {
			System.out.println("Not a ring");
			return ring;
		}	
	}

	public Armor removeRing(int loc) {
		Armor out = rings[loc];
		rings[loc] = new Armor("None", 0, 0, "Ring");
		return out;
	}
	
	public Armor getHelmet(){
		return helmet;
	}

	public Armor getChestPlate() {
		return chestPlate;
	}
	
	public Armor getGloves() {
		return gloves;
	}

	public Armor getGreaves() {
		return greaves;
	}
	
	public Armor getBoots() {
		return boots;
	}
	
	public Armor getRings(int loc) {
		return rings[loc];
	}

	
	public int getDef() {
		int def = 0;
		def += helmet.getDef();
		def += chestPlate.getDef();
		def += gloves.getDef();
		def += greaves.getDef();
		def += boots.getDef();
		for(Armor ring: rings) {
			def += ring.getDef();
		}
		return def;
	}
	
	public int getAgility() {
		int agi = 0;
		agi += helmet.getAgi();
		agi += chestPlate.getAgi();
		agi += gloves.getAgi();
		agi += greaves.getAgi();
		agi += boots.getAgi();
		for(Armor ring: rings) {
			agi += ring.getAgi();
		}
		return agi;
	}

	public void printGear() {
		System.out.println(helmet.getType()+ "  " + helmet.getName());
		System.out.println(chestPlate.getType()+ "  " +chestPlate.getName());
		System.out.println(gloves.getType()+ "  " + gloves.getName());
		System.out.println(greaves.getType()+ "  " + greaves.getName());
		System.out.println(boots.getType() + "  " + boots.getName());
		int i = 1;
		for(Armor ring: rings) {
			System.out.println(i + " " + ring.getType() + " " + ring.getName());
			i++;
		}
		
		
	}
	
	

}
