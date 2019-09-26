package status;

import java.util.ArrayList;

import stats.Health;
import util.Pair;

/**
 * Bleeding Status Effect
 */

public class Bleeding implements StatusEffect {

	private ArrayList<Pair<Integer,Integer>> bleed;
	
	
	/**
	 * Creates the Bleeding status effect
	 */
	public Bleeding(int duration, int damage) {
		bleed = new ArrayList<Pair<Integer,Integer>>();
		bleed.add(new Pair<Integer, Integer>(duration,damage));
	}
	
	
	public void tic(Health health) {
		int damage = 0;
		for(Pair<Integer, Integer> proc: bleed) {
			damage += proc.getSecond();
			if(proc.getFirst() == 1) {
				bleed.remove(proc);
			}else{
				proc.setFirst(proc.getFirst()-1);
			}
		}
		health.hit(damage);

	}

	public int getDuration() {
		int max = 0;
		for(Pair<Integer,Integer> proc: bleed) {
			max = (proc.getFirst() > max) ? proc.getFirst() : max;
		}
		return max;
	}

	public String getEffectType() {
		return "Bleeding";
	}

	public void update(int duration, Object otherParam) {
		Integer damage = (Integer) otherParam;
		bleed.add(new Pair<Integer,Integer>(duration,damage));
	}
	

	@Override
	public void update(StatusEffect a) {
		// TODO Auto-generated method stub
		Bleeding b = (Bleeding) a;
		bleed.add(b.getProc());
	}
	
	public Pair<Integer,Integer> getProc(){
		return bleed.get(0);
	}

}
