package gear;

public class ArmorSet {
	
	private Armor helmet = new Armor("None",0,5,"Helmet");
	private Armor chestPlate = new Armor("None",0,5,"ChestPlate");
	private Armor gloves = new Armor("None",0,5,"Gloves");
	private Armor greaves = new Armor("None",0,5,"Greaves");
	private Armor boots = new Armor("None",0,5,"Boots");
	private Armor[] rings = new Armor[10];
	
	public ArmorSet() {
		setRings(new Armor[0]);
	}

	public ArmorSet(Armor helmet, Armor chestPlate, Armor gloves, Armor greaves, Armor boots, Armor[] rings) {
		this.helmet = helmet;
		this.chestPlate = chestPlate;
		this.gloves = gloves;
		this.greaves = greaves;
		this.boots = boots;
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
	
	public Armor getHelmet() {
		return helmet;
	}
	public void setHelmet(Armor helmet) {
		if(helmet.getType().equals("helmet") || helmet.getType().equals("Helmet")) {
			this.helmet = helmet;
		}else {
			System.out.println("Not equiped");
		}
	}

	public Armor getChestPlate() {
		return chestPlate;
	}
	public void setChestPlate(Armor chestPlate) {
		if(chestPlate.getType().equals("chest plate") || chestPlate.getType().equals("Chest Plate")) {
			this.chestPlate = chestPlate;
		}else {
			System.out.println("Not equiped");
		}
	}

	public Armor getGloves() {
		return gloves;
	}
	public void setGloves(Armor gloves) {
		if(gloves.getType().equals("gloves") || gloves.getType().equals("Gloves")) {
			this.gloves = gloves;
		}else {
			System.out.println("Not equiped");
		}
	}

	public Armor getGreaves() {
		return greaves;
	}
	public void setGreaves(Armor greaves){
		if(greaves.getType().equals("greaves") || greaves.getType().equals("Greaves")) {
			this.greaves = greaves;
		}else {
			System.out.println("Not equiped");
		}
	}

	public Armor getBoots() {
		return boots;
	}
	public void setBoots(Armor boots) {
		if(boots.getType().equals("boots") || boots.getType().equals("Boots")) {
			this.boots = boots;
		}else {
			System.out.println("Not equiped");
		}
	}

	public Armor getRings(int loc) {
		return rings[loc];
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
