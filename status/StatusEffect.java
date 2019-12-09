package status;

import stats.Health;

public interface StatusEffect {

	public void tic(Health health);

	public int getDuration();

	public String getEffectType();
	
	public void update(int duration, Object otherParam);
	
	
	
	public void update(StatusEffect a);
	
	
}
