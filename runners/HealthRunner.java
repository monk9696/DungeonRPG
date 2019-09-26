package runners;

import stats.Health;

public class HealthRunner {

	public static void main(String[] args) {
		
		Health h = new Health(45);
		
		System.out.println(h.getHP());
		System.out.println(h.getMaxHP());
		System.out.println(h.getHPPercent());
		System.out.println(h.hit(15));
		System.out.println(h.getHP());
		System.out.println(h.getMaxHP());
		System.out.println(h.getHPPercent());
		System.out.println(h.heal(40));
		System.out.println(h.heal(11));
		
		
	}

}
