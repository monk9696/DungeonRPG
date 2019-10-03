package stats;

import java.util.ArrayList;
import status.*;

public class StatusModifiers {
	
	
	private ArrayList<StatusEffect> statArr = new ArrayList<StatusEffect>(0);
	private Health health;
		
	public StatusModifiers(Health h){
		health = h;
	}

	public void turnTic(){
		for(StatusEffect effect: statArr) {
			effect.tic(health);
		}
	}
	
	public void addEffect(StatusEffect stat) {
		StatusEffect find = getEffect(stat.getEffectType());
		if(find.getEffectType() != "Null") {
			find.update(stat);
		}else {
			statArr.add(stat);
		}
	}
	
	public StatusEffect getEffect(String stat){
		for(StatusEffect effect: statArr) {
			if(effect.getEffectType().equals(stat)) {
				return effect;
			}
		}
		return new NullEffect();
	}
	
	public int getEffectDuration(String stat) {
		for(StatusEffect effect: statArr) {
			if(effect.getEffectType().equals(stat)) {
				return effect.getDuration();
			}
		}
		return 0;
	}
	
	public boolean removeEffect(String stat) {
		if(getEffect(stat).getEffectType() != "Null") {
			statArr.remove(getEffect(stat));
			return true;
		}
		return false;
	}
	
	public void listEffects() {
		for(StatusEffect effect: statArr) {
			System.out.println(effect.getEffectType());
		}
		System.out.println("-----------------------------");
	}
	
	//Spell status
	//Ability spec status
	public boolean reflect = false;
	public boolean embolden = false;	
	//reflect
	public void setReflect(){
		reflect = true;
		System.out.println("Reflect has been activated");
	}
	public boolean isReflect(){
		if (reflect == true){
			reflect = false;
			return true;
		}
		return reflect;
	}
	//embolden
	public void setEmbolden(){
		embolden = true;
	}
	public boolean isEmbolded(){
		if (embolden == true){
			embolden = false;
			return true;
		}
		return embolden;
	}
}
