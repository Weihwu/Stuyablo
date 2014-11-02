public class Rogue extends Adventurer{
    private int STA;

    public Rogue(){
	this("Roxas");
    }
    public Rogue(String name){
	super(name);
	if (getName().equals("")){
	    setName("Roxas");
	}
	setSTR(8);
	setDEX(14);
	setSTA(25);
    }
    public void setSTA(int STA){
	this.STA = STA;
    }
    public int getSTA(){
	return STA;
    }

    public void specialAttack(Adventurer other){
	if( hit(other)){
	    if (getCHA() >= 2){
		int damage = (getSTA() - other.getDEF());
		if (damage > 0){
		    System.out.println(getName() + " went in for a stealth attack!" + "\n" + getName() + " struck" + " for " + damage + "HP of damage!");
		    other.setHP(other.getHP() - (damage));
		    setCHA(getCHA() - 2);
		    if (other.getHP() > 0){
			System.out.println(other.getName() + " hangs on with " + other.getHP() + "HP left!"); 
		    } 
		}else{
		    System.out.println(getName() + " tripped!");
		}
	    }else{
		attack(other);
	    }

	}else{
	    System.out.println(other.getName() + " dodged the attack!");
	    setCHA(getCHA() + 1);
	}
    }
   public String getStats(){
	return super.getStats() + " STA:" + getSTA();
    }
    public Rogue cloneA(){
	Rogue rogueClone = new Rogue(getName());
	rogueClone.setHP(getHP());
	rogueClone.setSTR(getSTR());
	rogueClone.setDEF(getDEF());
	rogueClone.setDEX(getDEX());
	rogueClone.setINT(getINT());
	rogueClone.setCHA(getCHA());
	rogueClone.setSPD(getSPD());
	rogueClone.setSTA(getSTA());
	return rogueClone;
    }
}
	
