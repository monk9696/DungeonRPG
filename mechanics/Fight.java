package mechanics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

import characters.Character;
import characters.Enemy;
import characters.Player;

public class Fight {

	private Player player;
	private ArrayList<Character> group;
	private Scanner scan = new Scanner(System.in);
	//private String sc;

	public Fight() {	
	}
	
	public void printCombatants() {
		for(Character cha: group) {
			System.out.println(cha);
		}
	}
	
	public void printEnemies() {
		int i = 1;
		for(Character cha: group) {
			if(cha instanceof Enemy) {
				System.out.println((i++) + " " + cha.toString());				
			}
		}
	}
	
	public Character getEnemy() {
		System.out.println("Select your Target");
		printEnemies();
		String sel = scan.next();
		Character enemy = null;
		int pos;
		try{
			pos = Integer.parseInt(sel);
			enemy = getEnemy(pos);
		}catch (Exception e) {
			System.out.println(e);
		}
		if(enemy == null) {
			System.out.println("Invalid enemy");
			enemy = getEnemy();
		}
		return enemy;
	}
	
	
	public Character getEnemy(int pos){
		int i = 1;
		for(Character cha: group){
			if(cha instanceof Enemy){
				if (pos == i){
					return cha;
				}else{
					i++;
				}
			}
		}
		return null;
	}
	
	public void endTurn(Character c){
		c.turnEnd();
	}
	
	public void endCombat(){
		//Combat Rewards
		/*this.newEnemy(new Goblin(new Health(20), new Equipment(new Weapon(2),new Weapon(2),new Armor(3))));
		this.engagement();*/
	}

	public void AIChoice(Enemy enemy){
		//System.out.println("The enemy is choosing.");
		if(!enemy.checkEffect("Stunned") && !enemy.checkEffect("Confused")){
			switch (enemy.CombatChoice()){
				case "attack":
					System.out.println("The enemy chose to attack for: " + enemy.getDamage());
					player.damageTaken(enemy.getDamage());
					break;
				case "heal":
					System.out.println("The enemy chose to heal");
					enemy.heal(5);
					break;
			/*	case "spell1":
					enemy.spell(1, player);
					break;
				case "spell2":
					enemy.spell(2, player);
					break;
				case "spell3":
					enemy.spell(3, player);
					break;
				case "spell4":
					enemy.spell(4, player);
					break;
				case "spell5":
					enemy.spell(5, player);
					break;
			*/	default:
					System.out.println("AI choice error. The robots are not taking over!!, They are however going crazy by using powers they are not allowed, Luckily we put in a saftey net for this and decided to kill the program. Your welcome for saving you from their unstopable attack. ");
					//System.exit(0);
			}
		}else{
			System.out.println("The enemy did nothing");
		}
	}	
	
	public void engagement(Character[] e){
		group = new ArrayList<Character>(e.length);
		for(Character next: e) {
			if(next instanceof Player){
				System.out.println("Player Added");
				player = (Player) next;
				group.add(next);
			}else{
				group.add(next);				
			}
		}
		Collections.sort(group);
		System.out.println("This is the begining of combat");
		Iterator<Character> g = group.iterator();
		
		while(group.size() > 1 && player.getHP() > 0){
			if(g.hasNext()){
				//get the current player
				Character next = g.next();
				//check if the target is alive
				if (next.getHP() > 0){
					//printCombatants();
					if(next instanceof Player){
						printEnemies();
						System.out.println(player);
						//get the players choice
						playerChoice();
					}else if(next instanceof Enemy){
						System.out.println("Enemy");
						AIChoice((Enemy) next);
					}else {
						System.out.println("Total unknown Character0");
						System.exit(-1);
					}
					endTurn(next);
				}else{
					g.remove();
				}
			}else{
				g = group.iterator();
			}
		}
		System.out.println("Out");
		for(Character i: group){
			System.out.println(i);
		}	
	}
	
		
	public void playerChoice(){
		System.out.println("What do you want to do");
		System.out.println("Attack, Nothing, Spell, Menu");
		String choice = scan.next();
		switch (choice){
			case "attack": 
				System.out.println("Which enemy do you want to attack");
				Character c = getEnemy();
					if(c != null){
						c.damageTaken(player.getDamage());
						break;
					}
				System.out.println("Selected choice was not valid");
				playerChoice();
				break;
			case "nothing":
				System.out.println("You did nothing");
				break;
			case "spell":
				this.spell();
				break;
			case "menu":
				this.menu();
				break;
			default:
				System.out.println("Invalid input try again");
				playerChoice();
		}
	}
	
	/*
	 * set up the spells to be self,self, target, target, ult which is all enemies
	 */
				
	public void spell(){
		System.out.println("Which spell do you wish to use?" /*adda list of your spells+*/);
		player.printSpells();
		String spellNum = scan.next();
		System.out.println();
		boolean returni = false;
		switch (spellNum){
			case "1": 
				returni = player.spell(1, player);
				break;
			case "2":
				returni = player.spell(2, player);
				break;
			case "3":
				returni = player.spell(3, getEnemy());
				break;
			case "4":
				returni = player.spell(4, getEnemy());
				break;
			case "5":
				for(int i = 0; i < group.size()-1; i++) {
					if (group.get(i) != player) {
						returni = player.spell(5, group.get(i));						
					}
				}
				
				break;
			case "exit":
				playerChoice();
				break;
			default:
				System.out.println("Error that Spell does not seem to exist");
				playerChoice();
				break;	
		}
		if (returni == false){
			System.out.println("Spell Failed to cast Try something else");
			playerChoice();
		}
	}
	
	public void menu(){
		System.out.println("What would you like to look at?");
		System.out.println("Money, Level Info, Inventory, Equipment?");
		String menu = scan.next();
		switch (menu){
			case "money":
				player.getInventory().getMoney();
				break;
			case "level":
				System.out.println("Your current level is " + player.getLevel());
				break;
			case "inventory":
				System.out.println("Inventory not yet implemented");
				break;
			case "equipment":
				System.out.println("Not yet set up");
				break;
			case "exit":
				System.out.println("What do you wish to do?");
				playerChoice();
				break;
			default:
				System.out.println("Non valid input");
				this.menu();
		}
		playerChoice();
	}
	
}
