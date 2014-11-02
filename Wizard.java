import java.util.Random;

public class Wizard extends Adventurer{
    private int mana;

    public Wizard(){
	this("Yen Sid");
    }
    public Wizard(String name){
	super(name);
	if (getName().equals("")){
	    setName("Yen Sid");
	}
	setSTR(6);
	setDEX(8);
	setINT(18);
	setMana(25);
    }

    public void setMana(int mana){
	this.mana = mana;
    }
    public int getMana(){
	return mana;
    }

    public void attack(Adventurer other){
	    hitMagic(other);
    }
    public void hitMagic(Adventurer other){
	    if (hit(other)){
		int damage = ((getINT()) - other.getINT());
		if (damage > 0){
		    System.out.println(getName() + " cast a spell on " + other.getName() + " for " + damage + "HP of damage!");
		    other.setHP(other.getHP() - (damage));
		    setCHA(getCHA() + 1);
		    if (other.getHP() > 0){
			System.out.println(other.getName() + " endured with " + other.getHP() + "HP left!");
		    }
		}else{
		    System.out.println("The spell was harmless!");
		}
	    }else{
		System.out.println(other.getName() + " avoided the attack!");
		setCHA(getCHA() + 1);
	    }
	} 
    public void specialAttack(Adventurer other){
	if (hit(other)){
	    if (getCHA() >= 2){
		int damage = (getMana() - other.getINT());
		if (damage > 0){
		    System.out.println(getName() + " cast magic burst" + " for " + damage + "HP of damage!");
		    other.setHP(other.getHP() - (damage));
		    setCHA(getCHA() - 2);
		    if (other.getHP() > 0){
			System.out.println(other.getName() + " struggled with " + other.getHP() + "HP left!");
		    }
		}else{
		    System.out.println("The spell was too weak!");
		}
	    }else{
		hitMagic(other);
	    }
	}else{
	    System.out.println(other.getName() + " avoided the attack!");
	    setCHA(getCHA() + 1);
	}
    }
    public String getStats(){
	return super.getStats() + " mana:" + getMana();
    }
    public Wizard cloneA(){
	Wizard wizardClone = new Wizard(getName());
	wizardClone.setHP(getHP());
	wizardClone.setSTR(getSTR());
	wizardClone.setDEF(getDEF());
	wizardClone.setDEX(getDEX());
	wizardClone.setINT(getINT());
	wizardClone.setCHA(getCHA());
	wizardClone.setSPD(getSPD());
	wizardClone.setMana(getMana());
	return wizardClone;
    }
}
