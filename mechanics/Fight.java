package mechanics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import characters.Character;
import characters.Enemy;
import characters.Player;

public class Fight {

	private Player player;
	private ArrayList<Character> group;
	private Random gen = new Random();
	private Scanner scan = new Scanner(System.in);
	//private String sc;

	public Fight() {	
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
						printCombatants();
						//get the players choice
						playerChoice();
					}else{
						System.out.println("Enemy");
						compChoice(next, player);
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
	
	
	public void printCombatants() {
		for(Character cha: group) {
			System.out.println(cha);
		}
	}
	
	public void printCombatants(int i) {
		for(Character cha: group) {
			if(cha instanceof Enemy) {
				System.out.println((i++) + " " + cha.toString());				
			}
		}
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
	
	public void playerChoice(){
		System.out.println("What do you want to do");
		System.out.println("Attack, Nothing, Spell, Menu");
		String choice = scan.next();
		switch (choice){
			case "attack": 
				System.out.println("Which enemy do you want to attack");
				printCombatants(1);
				String sel = scan.next();
				int pos;
				try{
					pos = Integer.parseInt(sel);
					Character c = getEnemy(pos);
					if(c != null){
						c.damageTaken(player.getDamage());
						break;
					}
				}catch (Exception e) {
					System.out.println(e);
				}
				System.out.println("Selected choice was not valid");
				playerChoice();
				break;
			case "nothing":
				System.out.println("You did nothing");
				break;
			case "spell":
				this.spell(player);
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
	
	public void compChoice(Character enemy, Character player){
		//System.out.println("The enemy is choosing.");
		String s = "a";
		if(!enemy.checkEffect("Stunned") && !enemy.checkEffect("Confused")){
			switch (s){
				case "attack":
					System.out.println("The enemy chose to attack");
					player.damageTaken(enemy.getDamage());
					break;
				case "heal":
					System.out.println("The enemy chose to heal");
					enemy.heal(5);
					break;
				case "spell1":
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
				default:
					System.out.println("AI choice error. The robots are not taking over!!, They are however going crazy by using powers they are not allowed, Luckily we put in a saftey net for this and decided to kill the program. Your welcome for saving you from their unstopable attack. ");
					//System.exit(0);
			}
		}else{
			System.out.println("The enemy did nothing");
		}
	}
			
	public void spell(Character enemy){
		System.out.println("Which spell do you wish to use?" /*adda list of your spells+*/);
		String spellNum = scan.next();
		System.out.println();
		boolean returni = false;
		switch (spellNum){
			case "1": 
				returni = player.spell(1, enemy);
				break;
			case "2":
				returni = player.spell(2, enemy);
				break;
			case "3":
				returni = player.spell(3, enemy);
				break;
			case "4":
				returni = player.spell(4, enemy);
				break;
			case "5":
				returni = player.spell(5, enemy);
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
	
	public boolean dieD20(){
		int playerdie =(gen.nextInt(20)+1);
		int enemydie =(gen.nextInt(20)+1);
		System.out.println("Player roll: " + playerdie);
		System.out.println("Enemy roll: " + enemydie);
		if (playerdie > enemydie){
			System.out.println("Player Won");
			return true;
		}else if (playerdie == enemydie){
			System.out.println("Draw re-roll.");
			System.out.println();
			return dieD20();
		}else{
			System.out.println("Enemy Won");
			return false;
		}
	}

	public void endTurn(Character c){
		c.turnEnd();
	}
	public void endCombat(){
		//Combat Rewards
		/*this.newEnemy(new Goblin(new Health(20), new Equipment(new Weapon(2),new Weapon(2),new Armor(3))));
		this.engagement();*/
	}

}
