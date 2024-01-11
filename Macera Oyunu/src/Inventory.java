public class Inventory {
   private Weapon weapon;
   private Armor armor;
   String award;

   private boolean caveAward;
   private boolean forestAward;
   private boolean riverAward;
   private boolean mineAward;

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public boolean isCaveAward() {
        return caveAward;
    }

    public void setCaveAward(boolean caveAward) {
        this.caveAward = caveAward;
    }

    public boolean isForestAward() {
        return forestAward;
    }

    public void setForestAward(boolean forestAward) {
        this.forestAward = forestAward;
    }

    public boolean isRiverAward() {
        return riverAward;
    }

    public void setRiverAward(boolean riverAward) {
        this.riverAward = riverAward;
    }

    public boolean isMineAward() {
        return mineAward;
    }

    public void setMineAward(boolean mineAward) {
        this.mineAward = mineAward;
    }

    public Inventory() {
        this.weapon = new Weapon("Yumruk " ,-1,0 ,0);
        this.armor = new Armor(-1,"Paçavra",0,0);


    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }


}
