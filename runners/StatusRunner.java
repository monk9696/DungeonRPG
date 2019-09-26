package runners;

import stats.*;
import status.*;

public class StatusRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Health h = new Health(100);
		StatusModifiers stat = new StatusModifiers(h);
		
		stat.listEffects();
		stat.addEffect(new Winded(5));
		stat.listEffects();
		System.out.println(stat.getEffectDuration("Winded"));
		stat.turnTic();
		System.out.println(stat.getEffectDuration("Winded"));
		stat.addEffect(new Winded(5));
		System.out.println(stat.getEffectDuration("Winded"));
		stat.listEffects();
		
		stat.addEffect(new Bleeding(5,5));
		stat.addEffect(new Bleeding(5,6));		
		stat.turnTic();
		
		System.out.println(h.getHP());
		
		stat.listEffects();
		
		//stat.addEffect(stat.getEffect(new Stunned(3)));
		
		
		stat.listEffects();
		
		if(stat.removeEffect("Null")) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
		stat.listEffects();
		
	}

}
