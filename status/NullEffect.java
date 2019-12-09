package status;

import stats.Health;

public class NullEffect implements StatusEffect {

	
	public NullEffect(){
		
	}

	public void tic(Health health) {
	}

	public int getDuration() {
		return 0;
	}

	public String getEffectType() {
		return "Null";
	}

	public void update(int duration, Object otherParam) {
		
	}
	
	public void update(StatusEffect a) {
	}


}
