public class MartialArtist extends Adventurer{
    private int qi;

    public MartialArtist(){
	this("Jackie");
    }
    public MartialArtist(String name){
	super(name);
	if (getName().equals("")){
	    setName("Jackie");
	}
	setHP(25);
	setSTR(18);
	setDEX(5);
	setQi(25);
    }

    public void setQi(int qi){
	this.qi = qi;
    }
    public int getQi(){
	return qi;
    }

    public void specialAttack(Adventurer other){
	if( hit(other)){
	    if (getCHA() >= 2){
		int damage = (getQi() - other.getDEF());
		if (damage > 0){
		    System.out.println(getName() + " stored up power!" + "\n" + getName() + " unleashed a powerful qi blast" + " for " + damage + "HP of damage!");
		    other.setHP(other.getHP() - (damage));
		    setCHA(getCHA() - 2);
		    if (other.getHP() > 0){
			System.out.println(other.getName() + " survived the attack with " + other.getHP() + "HP left!"); 
		    } 
		}else{
		    System.out.println("The qi fizzled out!");
		}
	    }else{
		attack(other);
	    }

	}else{ 
	    System.out.println(other.getName() + " jumped out of the way!"); 
	    setCHA(getCHA() + 1);
	}
    }
    public MartialArtist cloneA(){
	MartialArtist martialArtistClone = new MartialArtist(getName());
	martialArtistClone.setHP(getHP());
	martialArtistClone.setSTR(getSTR());
	martialArtistClone.setDEF(getDEF());
	martialArtistClone.setDEX(getDEX());
	martialArtistClone.setINT(getINT());
	martialArtistClone.setCHA(getCHA());
	martialArtistClone.setSPD(getSPD());
	martialArtistClone.setQi(getQi());
	return martialArtistClone;
    }
}