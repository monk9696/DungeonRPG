package status;

import stats.Health;

/**
 * Winded status effect
 */

public class Winded implements StatusEffect {

	private int duration;
	
	/**
	 * Creates the Winded Status Effect
	 * @param duration Length in turns of the effect
	 */
	public Winded(int duration) {
		this.duration = duration;
	}
	
	/**
	 * What will happen at the end of the characters turn due to the
	 * status effect
	 * @param health Unused
	 */
	public void tic(Health health) {
		duration--;
	}

	/**
	 * Simply returns the duration of the effect
	 * @return How many more turns this effect will last
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * Return a string that is the name of the class
	 * @return A string which is the name for easier class type identification
	 */
	public String getEffectType() {
		return "Winded";
	}

	/**
	 * Used to update the duration
	 * @param duration what to extend the duration to
	 * @param otherParam unused
	 */
	public void update(int duration, Object otherParam) {
		this.duration = duration;
	}
	
	/**
	 * Used to update the current effect based on another effect of the same type
	 * @param a This should be a Status effect that is the same as this
	 */
	public void update(StatusEffect a) {
		this.duration = a.getDuration();
	}


}
