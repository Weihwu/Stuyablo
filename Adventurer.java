import java.util.Random;

public class Adventurer{
    private String name;
    private int HP;
    private int STR;
    private int DEF;
    private double DEX;
    private int INT;
    private int CHA;
    private int SPD;

    public Adventurer(){
	this("Sora", 20, 10, 5, 10.0, 10, 2, 10);
    }
    public Adventurer(String name){
	this(name, 20, 10, 5, 10.0, 10, 2, 10);
    }
    public Adventurer(String name, int HP, int STR, int DEF, double DEX, int INT, int CHA, int SPD){
    	 setName(name);
	 setHP(HP);
	 setSTR(STR);
	 setDEF(DEF);
	 setDEX(DEX);
	 setINT(INT);
	 setCHA(CHA);
	 setSPD(SPD);
      }
   
    public void setName(String name){
	this.name = name;
    }
    public String getName(){
	return name;
    }
    public void setHP(int HP){
	this.HP = HP;
    }
    public int getHP(){
	return HP;
    }
    public void setSTR(int STR){
	this.STR = STR;
    }
    public int getSTR(){
	return STR;
    }
    public void setDEF(int DEF){
	this.DEF = DEF;
    }
    public int getDEF(){
	return DEF;
    }
    public void setDEX(double DEX){
	this.DEX = DEX;
    }
    public double getDEX(){
	return DEX;
    }
    public void setINT(int INT){
	this.INT = INT;
    }
    public int getINT(){
	return INT;
    }
    public void setCHA(int CHA){
	this.CHA = CHA;
    }
    public int getCHA(){
	return CHA;
    }
    public void setSPD(int SPD){
	this.SPD = SPD;
    }
    public int getSPD(){
	return SPD;
    }

    public String getStats(){
	return "Name: " + getName() + "\nHP:" + getHP() + " STR:" + getSTR() + " DEF:" + getDEF() + " DEX:" + getDEX() + " INT:" + getINT() + " CHA:" + getCHA() + " SPD:" + getSPD();
    }

    public boolean hit(Adventurer other){
       Random r = new Random();
       return ((((getDEX())/(getDEX() + other.getDEX()))*((r.nextInt(10)+1)*10)) > 5);
   }
    public void attack(Adventurer other){
	if (hit(other)){
	    int damage = (getSTR() - other.getDEF());
	    if (damage > 0){
		System.out.println(getName() + " attacked " + other.getName() + " for " + damage + "HP of damage!");
		other.setHP(other.getHP() - (damage));
		if (other.getHP() > 0){
		    System.out.println(other.getName() + " has " + other.getHP() + "HP left!");
		}
	    }else{
		System.out.println("The attack had no effect!");
	    }
		setCHA(getCHA()+1);
	}else{
	    System.out.println(getName() + "'s attack missed!");
	    setCHA(getCHA()+1);
	}
    }
    public void specialAttack(Adventurer other){
	if (hit(other)){
	    if (getCHA() >= 2){
		int damage = ((getSTR()*2) - other.getDEF());
		if (damage > 0){
		    System.out.println(getName() + " performed a coup de grace"  + " for " + damage + "HP of damage!");
		    other.setHP(other.getHP() - (damage));
		    setCHA(getCHA() - 2);
		}else{
		    System.out.println("The special attack had no effect!");
		}
	    }else{
		attack(other);
	    }
	    if (other.getHP() > 0){
		System.out.println(other.getName() + " hanged on with " + other.getHP() + "HP left!");
	    }
	}else{
	    System.out.println(other.getName() + " dodged the attack!");
	    setCHA(getCHA() + 1);
	}
    }
    public static void move(Adventurer p1, Adventurer p2){
	Random r = new Random();
	while(p1.getHP() > 0 && p2.getHP() > 0){
	    if (p2.getHP() > 0){
		if ((r.nextInt(10)<3) && (p1.getCHA() > 0)){
		    p1.specialAttack(p2);
		    p1.setCHA(p1.getCHA()-1);
		}else{
		    p1.attack(p2);
		}
	    }
	    if((p1.getHP() > 0) && (p2.getHP() > 0)){
		if ((r.nextInt(10)<3) && (p2.getCHA() > 0)){
		    p2.specialAttack(p1);
		    p2.setCHA(p2.getCHA()-1);
		}else{
		    p2.attack(p1);
		}
	    }
	}
	if (p1.getHP() <= 0){
	    System.out.println(p1.getName() + " is defeated!");
	}else if(p2.getHP() <=0){
	    System.out.println(p2.getName() + " is defeated!");
	}
    }
    public static void fight(Adventurer p1, Adventurer p2){
	Random r = new Random();
	if (p1.getSPD() > p2.getSPD()){
	    System.out.println(p1.getName() + " went first!");
	    move(p1,p2);
	}else if(p2.getSPD() > p1.getSPD()){
	    System.out.println(p2.getName() + " went first!");	    
	    move(p2,p1);
	}else{
	    if (r.nextInt(2) == 0){
		System.out.println(p1.getName() + " went first!");
		move(p1,p2);
	    }else{
		System.out.println(p2.getName() + " went first!");
		move(p2,p1);
	    }
	}
    }
    public Adventurer cloneA(){
	Adventurer adventurerClone = new Adventurer();
	return adventurerClone;
    }
}
		
