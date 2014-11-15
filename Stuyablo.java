import java.util.Scanner;
import java.util.Random;

public class Stuyablo{
    public static void main(String[]args){
	Scanner scan = new Scanner(System.in);

	//Game starts
	out("Stuyablo");
	out("");
	out("Press ENTER To Start");
	scan.nextLine();
	out("Welcome to the Colosseum! This is the place where heroes come to test their skills. If you would like to participate, please fill out this form.");
	out("");
	
	//User chooses number of players
	int inputParty = 0;
	out("How many heroes do you want in your party? We do not accept parties of more than 4.");
	while (inputParty < 1 || inputParty > 4){
	    inputParty = scan.nextInt();
	    scan.nextLine();
	    if (inputParty < 1 || inputParty > 4){
		out("This is not a valid party size. Please reconsider.");
	    }
	}
	Adventurer[] team = new Adventurer[inputParty];
	out("");

	//Custom Party versus Random Party
	String inputCPRP = "";
	out("Are you bringing your own party? We have a hero-match system if you come alone. (y/n)");
	while (inputCPRP.equals("")){
	    inputCPRP = scan.nextLine();
	    if (inputCPRP.equals("y")){
		out("");

		//User chooses custom party
		for (int x = 0; x < team.length; x++){

		    //User chooses names for each player
		    String inputName = "";
		    out("What is Hero " + (x+1) + "'s name?");
		    while (inputName.equals("")){
			inputName = scan.nextLine();
			if (inputName.equals("")){
			    out("You must fill out your name.");
			}
			out("");
		    }
		    
		    //User chooses classes for each player
		    String inputClass = "";
		    out("What is Hero " + (x+1) + "'s profession?");
		    out("(A) warrior");
		    out("(B) wizard");
		    out("(C) rogue");
		    out("(D) martial artist");
		    out("");
		    while (inputClass.equals("")){
			inputClass = scan.nextLine();
			if (inputClass.contains("A") || inputClass.contains("warrior")){
			    team[x] = new Warrior(inputName);
			}else if (inputClass.contains("B") || inputClass.contains("wizard")){
			    team[x] = new Wizard(inputName);
			}else if (inputClass.contains("C") || inputClass.contains("rogue")){
			    team[x] = new Rogue(inputName);
			}else if (inputClass.contains("D") || inputClass.contains("martial artist")){
			    team[x] = new MartialArtist(inputName);
			}else{
			    out("This is not an accepted profession. Please try again.");
			    inputClass = "";
			}
		    }
		    out("");

		    //Pick stats?
		    String inputP = "";
		    out("Do you know the stats of your heroe (STR, DEX, INT)? If not, we can provide them for you. (y/n)");
		    while (inputP.equals("")){
			inputP = scan.nextLine();
			if (inputP.equals("y")){
			    out("");

			    //User picks stats for each player
			    int reserve = team[x].getSTR() + (int)team[x].getDEX() + team[x].getINT();

			    //Allocate points to STR
			    out("You have " + reserve + " total points of potential. How many do you have in STR?");
			    int inputSTR = 0;
			    while (inputSTR == 0){
				inputSTR = scan.nextInt();
				scan.nextLine();
				if (inputSTR >= 0 && inputSTR <= reserve){
				    team[x].setSTR(inputSTR);
				}else{
				    out("This is not a valid amount of points. Decide again.");
				    inputSTR = 0;
				}
			    }
			    reserve -= team[x].getSTR();
			    
			    //Allocate points to DEX
			    out("Your points have been set.\n\nYou have " + reserve + " total points left of potential. How many do you have in DEX?");
			    int inputDEX = 0;
			    while (inputDEX == 0){
				inputDEX = scan.nextInt();
				scan.nextLine();
				if (inputDEX >= 0 && inputDEX <= reserve){
				    team[x].setDEX(inputDEX);
				}else{
				    out("This is not a valid amount of points. Decide again.");
				    inputDEX = 0;
				}
			    }
			    reserve -= (int)team[x].getDEX();
			    
			    //Allocate points to INT
			    out("Your points have been set.\n\nYou have " + reserve + " total points left of potential. How many do you have in INT?");
			    int inputINT = 0;
			    while (inputINT == 0){
				inputINT = scan.nextInt();
				scan.nextLine();
				if (inputINT >= 0 && inputINT <= reserve){
				    team[x].setINT(inputINT);
				}else{
				    out("This is not a valid amount of points. Decide again.");
				    inputINT = 0;
				}
			    }
			    reserve -= (int)team[x].getINT();
			    out("Your points have been set.");
			    out("");
			    
			    //Finishing up
			    out(team[x].getStats());
			    out("");
			    out("Are you happy with what you have filled out? (y/n)");
			    String inputHappy = "";
			    while (inputHappy.equals("")){
				inputHappy = scan.nextLine();
				if (inputHappy.equals("y")){
				    out("Your stats are recorded.");
				    out("");
				}else if(inputHappy.equals("n")){
				    inputP = "no";
				    out("");
				}else{
				    out("This is not a valid response. Please try again.");
				    inputHappy = "";
				}		
			    }
			}else if(inputP.equals("n")){
			    out("Your stats are recorded.");
			}else{
			    out("Choose y to record your points or n if you would like us to provide it for you.");
			    inputP = "";
			}		
		    }	
		    out("");
		}
	    }else if (inputCPRP.equals("n")){

		//Randomly generates party
		for (int y = 0; y < team.length; y++){
		    Random r = new Random();
		    int choiceR = r.nextInt(4);
		    if (choiceR == 0){
			team[y] = new Warrior("");
		    }else if (choiceR == 1){
			team[y] = new Wizard("");
		    }else if (choiceR == 2){
			team[y] = new Rogue("");
		    }else{
			team[y] = new MartialArtist("");
		    }
		}
		out("");
		out("We have found some heroes for you.");
	    }else{
		out("This is not a correct response. Please answer again.");
		inputCPRP = "";
	    }
	    out("");
	}
	
	out("Your registration is complete.");
	out("");
	out("Press ENTER To Find An Opponent");
	scan.nextLine();

	//Generate enemy
	Random rO = new Random();
	int choiceO = rO.nextInt(4);
	Adventurer opponent;
	if (choiceO == 0){
	    opponent = new Warrior("Jake");
	}else if (choiceO == 1){
	    opponent = new Wizard("Jake");
	}else if (choiceO == 2){
	    opponent = new Rogue("Jake");
	}else{
	    opponent = new MartialArtist("Jake");
	}
	out("Your opponent is " + opponent.getName() + "!");
	out(opponent.getStats());
	out("");

	//Battle begins
	out("Press ENTER To Begin Battle");
	scan.nextLine();
	combat(team, opponent);
    }

    //Who goes first
    public static boolean whoFirst(Adventurer[] p1, Adventurer p2){
	Random r = new Random();
	double avgSPD = 0.0;
	for (int x = 0; x < p1.length; x++){
	    avgSPD +=  p1[x].getSPD();
	}
	avgSPD = avgSPD/p1.length;
	if (avgSPD > p2.getSPD()){
	    out("Your team is faster! " + p1[0].getName() + " goes first.");
	    return true;
	}else if(p2.getSPD() > avgSPD){
	    out("Your opponent is faster! " + p2.getName() + " goes first.");
	    return false;
	}else{
	    if (r.nextInt(2) == 0){
		out("Your team is faster! " + p1[0].getName() + " goes first.");
		return true;
	    }else{
		out("Your opponent is faster! " + p2.getName() + " goes first.");
		return false;
	    }
	}
    }

    //Player options menu
    public static void options(Adventurer p1, Adventurer p2){
	Scanner scan = new Scanner(System.in);
	out("Choose an action:");
	out("(A) attack");
	out("(B) special attack");
	out("(C) give up");
	String inputOption = scan.nextLine();
	if (inputOption.contains("A") || inputOption.equals("(A) attack")){
	    out("");
	    p1.attack(p2);
	    out("");
	    out(p1.getStats());
	    out(p2.getStats());
	}else if (inputOption.contains("B") || inputOption.contains("special attack")){
	    out("");
	    p1.specialAttack(p2);
	    out("");
	    out(p1.getStats());
	    out(p2.getStats());						
	}else if (inputOption.contains("C") || inputOption.contains("give up")){
	    out("");
	    p1.setHP(0);
	    out(p1.getName() + " is defeated!");
	}else{
	    System.out.println("This is not a valid input.\nPlease try again.");
	    out("");
	    options(p1, p2);
	}
    }
    
    //Enemy movement
    public static void opponentMove(Adventurer p1, Adventurer p2){
	Random r = new Random();
	if (r.nextInt(10) < 3){
	    p2.specialAttack(p1);
       	}else{
	    p2.attack(p1);
       	}
    }
    public static void opponentOptions(Adventurer [] p1, Adventurer p2){
	Random r = new Random();
	int optionO = r.nextInt(p1.length);
	if (p1[optionO].getHP() > 0){
	    opponentMove(p1[optionO], p2);
	    out("");
	    if (p1[optionO].getHP() <= 0){
		out(p1[optionO].getName() + " is defeated!");
		p1[optionO].setHP(0);
		out("");
	    }
	    out(p1[optionO].getStats());
	    out(p2.getStats());	
	}else{
	    opponentOptions(p1,p2);
	}
    }

    //Battle mechanics
    public static void combat(Adventurer[] p1, Adventurer p2){
	Adventurer[] cloneTeam = new Adventurer[p1.length];
	for (int w = 0; w < p1.length; w++){
	    cloneTeam[w] = p1[w].cloneA();
	}
	Adventurer cloneO = p2.cloneA();
	boolean userTurn = true;
	boolean isPlayerAlive = true;
	int turn = 1;
	String turnNumber = "Turn # 0==[]:::::::::::::::::::::::>";
	if (!(whoFirst(p1, p2))){
	    userTurn = false;
	}
	while (isPlayerAlive && p2.getHP() > 0){
	    out("");
	    out(turnNumber.replace("#", turn + ""));
	    out("");
	    for (int x = 0; x < p1.length; x++){
		out(p1[x].getStats());
	    }
	    out(p2.getStats());
	    out("");
	    if (userTurn){
		for (int y = 0; y < p1.length; y++){
		    if (p1[y].getHP() > 0){			
			out(p1[y].getName());
			options(p1[y], p2);
		    }
		    isPlayerAlive = false;
		    for (int z = 0; z < p1.length; z++){
			if (p1[z].getHP() > 0){
			    isPlayerAlive = true;
			}
		    }
		    if (p2.getHP() <= 0) {			
			break;
		    }
		}
		userTurn = false;
	    }
	    if ((!(userTurn)) && p2.getHP() > 0 && isPlayerAlive){
		opponentOptions(p1,p2);
		userTurn = true;
	    }
	    isPlayerAlive = false;
	    for (int z = 0; z < p1.length; z++){
		if (p1[z].getHP() > 0){
		    isPlayerAlive = true;
		}
	    }
	    turn++;
	}
	if (isPlayerAlive && p2.getHP() <= 0){
	    p2.setHP(0);
	    out("");
	    out("Your team won!\n" + p2.getName() + " is defeated!");
	}else{
	    out("");
	    out("Your team is defeated!\n" + p2.getName() + " won!");
	}

	//Restart
	Scanner scan = new Scanner(System.in);
	String inputRestart = "";
	out("Would you like to participate again? (y/n)");
	while (inputRestart.equals("")){
	    inputRestart = scan.nextLine();
	    if (inputRestart.equals("y")){
		out("");
		out("Your team has been healed.");
		out("");
		combat(cloneTeam, cloneO);
	    }else if (inputRestart.equals("n")){
		out("");
		out("We hope to see you again!");
	    }else{
		out("That is an invalid input. Please answer again.");
		inputRestart = "";
	    }
	}
    }
			   			 
    public static void out(String phrase){
	System.out.println(phrase);
    }

}
