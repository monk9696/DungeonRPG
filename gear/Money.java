package gear;

public class Money {

	int copper;
	int silver;
	int gold;
	int plat;
	
	public Money(){
		copper = 0;
		silver = 0;
		gold = 0;
		plat = 0;
		this.consolidate();
	}
	public Money(int c,int s,int g,int p){
		copper = c;
		silver = s;
		gold = g;
		plat = p;
		this.consolidate();
	}
	
	public void printMoney(){
		System.out.println("Copper: " + copper + "\nSilver: " + silver + "\nGold: " + gold + "\nPlatinum: " + plat);
	}
	
	public void addMoney(int c, int s, int g, long p){
		copper += c;
		silver += s;
		gold += g;
		plat += p;
		this.consolidate();
	}
	public void addMoney(Money m){
		this.addMoney(m.copper, m.silver, m.gold, m.plat);
	}

	public boolean subtractMoney(long c, long s, long g, long p) {
		long total = total();
		long subtracted = total(c,s,g,p);
		if(total >= subtracted) {
			total = total-subtracted;
			this.consolidate(total);
			return true;
		}else {
			return false;
		}
	}
	
	public long total() {
		long c = copper;
		long s = silver;
		s *= 100;
		long g = gold;
		g *= 10000;
		long p = plat;
		p *= 1000000;
		return c+s+g+p;
	}
	
	public long total(long c, long s, long g, long p) {
		s *= 100;
		g *= 10000;
		p *= 1000000;
		return c+s+g+p;
	}
	
	public void consolidate() {
		this.consolidate(total());
	}
	
	public void consolidate(long total){
		copper = (int) (total % 100);
		total = (total - copper)/100;
		silver = (int) (total % 100);
		total = (total - silver)/100;
		gold = (int) (total % 100);
		total = (total - gold)/100;
		plat = (int) total;
//		printMoney();
	}	
	
}
