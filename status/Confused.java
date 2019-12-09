package status;

import stats.Health;

public class Confused implements StatusEffect {

	
	private int duration;

	public Confused(int duration){
		this.duration = duration;
	}
	
	public void tic(Health health){
		duration--;
	}

	public int getDuration(){
		return duration;
	}

	public String getEffectType() {
		return "Confused";
	}

	public void update(int duration, Object otherParam) {
		this.duration = duration;
	}

	public void update(StatusEffect a) {
		this.duration = a.getDuration();
	}

}
