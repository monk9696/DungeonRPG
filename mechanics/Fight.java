package mechanics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import characters.Character;
import characters.Player;

public class Fight {
	private boolean player;
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
				player = true;
				group.add(next);
			}else{
				group.add(next);				
			}
		}
		Collections.sort(group);
		for(Character i: group) {
			System.out.println(i.getHP() + " " + i.getAgility());
		}
		
		System.out.println("This is the begining of combat");
		Iterator<Character> g = group.iterator();
		
		while(group.size() > 1 && player) {
			if(g.hasNext()) {
				Character next = g.next();
				System.out.println(next.getHP() + " " + next.getAgility());
				if (next instanceof Player) {
					player = false;
					System.out.println("Player Removed");
				}
				g.remove();
				
			}
		}
		System.out.println("Out");
		for(Character i: group) {
			System.out.println(i.getHP() + " " + i.getAgility());
		}
		
		
		/*
		System.out.println("Combat has started");
		while (player.getHP() > 0 && enemy.getHP() > 0){
			System.out.println();
			System.out.println("Your HP is: " + player.getHP());
			System.out.println("Enemy HP is: " + enemy.getHP());
			System.out.println();
			if (!(player.checkEffect("Stunned") || player.checkEffect("Confused"))){
				System.out.println("What do you chose to do?");
				this.printChoice();
				this.combatChoice(scan.next());
			}else{
				System.out.println("You are unable to make an move due to a status effect that you are afflicted");
			}
			endTurn(player);
			System.out.println();
			if (enemy.getHP() > 0){
				if(!enemy.checkEffect("Stunned") || player.checkEffect("Confused")) {
					System.out.println("Enemy's turn");
					//this.compChoice(enemy.ai());					
				}
			}
			endTurn(enemy);
		}
		System.out.println();
		if(player.getHP() <= 0){
			System.out.println("You died");
			return 1;
		}else{
			System.out.println("You survived, you get Exp");
			endCombat();
			return 0;
		}*/
	}
	
	public void printChoice() {
		System.out.println("Attack, Nothing, Spell, Menu");
	}
	
	
	public void combatChoice(String s){
		switch (s){
			case "attack": 
				this.combatAttack("player");
				break;
			case "nothing":
				this.combatWait(true);
				break;
			case "spell":
				this.spell();
				break;
			case "menu":
				this.menu();
				break;
			default:
				System.out.println("Invalid input try again");
				this.combatChoice(scan.next());
		}
	}
	
	public void compChoice(String s){
		//System.out.println("The enemy is choosing.");
		if(!enemy.checkEffect("Stunned") && !enemy.checkEffect("Confused")){
			switch (s){
				case "attack":
					System.out.println("The enemy chose to attack");
					this.combatAttack("enemy");
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
					System.exit(0);
			}
		}else{
			this.combatWait(false);
		}
	}
	
	public void combatWait(boolean t){
		if (t == true){
			System.out.println("You did nothing");
		}else{
			System.out.println("The enemy did nothing");
		}
	}
	
	public void combatAttack(String s){
		switch (s){
			case "player":
				if(this.dieD20() == true){
					enemy.damageTaken(player.getDamage());
				}
				break;
			case "enemy":
				if(this.dieD20() == false){
					player.damageTaken(enemy.getDamage());
				}
				break;
			default:
				System.out.println("Combat base attack attacker error! Who is attacking? You may know, but I the computer have no idea, but I do know who it is, " + s + " is who but I don't know who this is");
				System.exit(0);
		}
	}
	
	public void spell(){
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
				System.out.println("What do you chose to do?");
				this.combatChoice(scan.next());
				break;
			default:
				System.out.println("Error that Spell does not seem to exist");
				System.out.println("What do you chose to do?");
				this.combatChoice(scan.next());
				break;	
		}
		if (returni == false){
			System.out.println("What do you chose to do?");
			this.combatChoice(scan.next());
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
				this.combatChoice(scan.nextLine());
				break;
			default:
				System.out.println("Non valid input");
				this.menu();
		}
		System.out.println("What do you chose to do?");
		this.combatChoice(scan.next());
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
