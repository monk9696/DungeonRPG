package status;

import stats.Health;

/**
 * Interface that sets up base lines for all status effects
 * All variables and functions within a status effect will either be
 * used mentioned methods, or should be looked into being adding to
 * this interface
 * Constructors should have their first parameter be the duration
 */

public interface StatusEffect {

	/**
	 * Triggers at the end of the characters turn
	 * bare minimum reduces the duration of the effect by one
	 * @param health Health of the character so status effects can
	 *	modify it
	 */
	public void tic(Health health);
	/**
	 * Simply returns the duration of the effect
	 * @return How many more turns this effect will last
	 */
	public int getDuration();
	/**
	 * Return a string that is the name of the class
	 * @return A string which is the name for easier class type identification
	 */
	public String getEffectType();
	
	
	/**
	 * A method that can modify attributes for the status effect
	 * @param duration Duration to set the effect length
	 * @param otherParam object for other things that are effect specific.
	 */
	public void update(int duration, Object otherParam);
	
	
	
	public void update(StatusEffect a);
	
	
}
