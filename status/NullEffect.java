package status;

import stats.Health;

public class NullEffect implements StatusEffect {

	
	public NullEffect(){
		
	}
	/**
	 * Does nothing as a Null
	 * @param health unused
	 */
	public void tic(Health health) {
	}
	/**
	 * As a null effect has no duration
	 */
	public int getDuration() {
		return 0;
	}
	/**
	 * Return a string that is the name of the class
	 * @return A string which is the name for easier class type identification
	 */
	public String getEffectType() {
		return "Null";
	}
	/**
	 * Updates nothing for Null
	 * @param duration unused
	 * @param otherParam unused
	 */
	public void update(int duration, Object otherParam) {
		
	}
	
	/**
	 * Used to update the current effect based on another effect of the same type
	 * @param a This should be a Status effect that is the same as this
	 */
	public void update(StatusEffect a) {
	}


}
