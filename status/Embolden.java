package status;

import stats.Health;

public class Embolden implements StatusEffect {

	public void tic(Health health) {
	}

	public int getDuration() {
		return -1;
	}

	public String getEffectType() {
		return "Embolden";
	}

	public void update(int duration, Object otherParam) {
	}

	public void update(StatusEffect a) {
	}

}
