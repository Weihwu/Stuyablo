public class Warrior extends Adventurer{
    private int rage;

    public Warrior(){
	this("Ventus");
    }
    public Warrior(String name){
	super(name);
	if (getName().equals("")){
	    setName("Ventus");
	}
	setHP(30);
	setSTR(14);
	setDEX(6);
	setRage(20);
    }
    
    public void setRage(int rage){
	this.rage = rage;
    }
    public int getRage(){
	return rage;
    }

    public void specialAttack(Adventurer other){
	if( hit(other)){
	    if (getCHA() >= 2){
		int damage = (getRage() - other.getDEF());
		if (damage > 0){
		    System.out.println(getName() + " is filled with rage!" + "\n" + getName() + " struck with all his might" + " for " + damage + "HP of damage!");
		    other.setHP(other.getHP() - (damage));
		    setCHA(getCHA() - 2);
		    if (other.getHP() > 0){
			System.out.println(other.getName() + " hangs on with " + other.getHP() + "HP left!"); 
		    }
		}else{
		    System.out.println("The attack was too weak!");
		}
	    }else{
		attack(other);
	    }

	}else{ 
	    System.out.println(other.getName() + " dodged the attack!");
	    setCHA(getCHA() + 1);	    
	}
    }
    public Warrior cloneA(){
	Warrior warriorClone = new Warrior(getName());
	warriorClone.setHP(getHP());
	warriorClone.setSTR(getSTR());
	warriorClone.setDEF(getDEF());
	warriorClone.setDEX(getDEX());
	warriorClone.setINT(getINT());
	warriorClone.setCHA(getCHA());
	warriorClone.setSPD(getSPD());
	warriorClone.setRage(getRage());
	return warriorClone;
    }
}
	
