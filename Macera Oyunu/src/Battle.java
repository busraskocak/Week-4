import java.util.Random;

public class Battle extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;
    private boolean regionCleared;


    public Battle(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
        this.regionCleared = false;

    }

    @Override
    public boolean onLocation() {
        int obsNumber = this.randomObstacleNumber();

        System.out.println("Şu an buradasınız: " + this.getName());
        System.out.println("Dikkatli Ol! Burada " + obsNumber + " tane " + this.getObstacle().getName() + " yaşıyor.");
        System.out.print("<S>avaş veya <K>aç :");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();
        if (selectCase.equals("S")) {
            if (combat(obsNumber)) {
                System.out.println(this.getName() + " tüm düşmanları yendiniz !");
                System.out.println(this.getAward() + "ödülünü kazandınız !");
                giveReward();

            }
        }
        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("Öldünüz.");
            return false;
        }
        return true;
    }

    private void giveReward() {
        if (isCleared()) {
            System.out.println("Bölgeyi zaten temizlediniz. Tekrar ödül alamazsınız.");
        } else {
            System.out.println("Bölgeyi temizlediniz! Ödül kazandınız.");
            switch (this.getName()) {
                case "Mağara":
                    this.getPlayer().getInventory().setCaveAward(true);
                    System.out.println("Ödül: Yemek (Food)");
                    break;
                case "Orman":
                    this.getPlayer().getInventory().setForestAward(true);
                    System.out.println("Ödül: Odun (Firewood)");
                    break;
                case "Nehir":
                    this.getPlayer().getInventory().setRiverAward(true);
                    System.out.println("Ödül: Su (Water)");
                    break;
                case "Maden":
                    this.getPlayer().getInventory().setMineAward(true);
                    break;
                default:
                    System.out.println("Ödül aldığınız yere giremezsiniz");
                    break;
            }
            setRegionCleared(true);
        }
    }

    private boolean isCleared() {
        return regionCleared;
    }

    private void setRegionCleared(boolean cleared) {
        this.regionCleared = cleared;
    }



public boolean combat(int obsNumber) {
    for (int i = 1; i < obsNumber; i++) {
        this.getObstacle().setHealth(this.getObstacle().getOrjHealth());
        playerStats();
        obstacleStats(i);

        boolean firstAttack = new Random().nextBoolean();

        while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
            if (firstAttack) {
                System.out.println();
                System.out.println(" Oyuncunun Sırası  ");
                System.out.print("<V>ur veya <K>aç: ");
                String selectCombat = input.nextLine().toUpperCase();
                if (selectCombat.equals("V")) {
                    System.out.println("Siz vurdunuz! ");
                    getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                    afterHit();
                } else if (selectCombat.equals("K")) {
                    System.out.println("Savaştan kaçıldı.");
                    return false;
                } else {
                    System.out.println("Geçersiz bir seçenek girdiniz.");
                }
            } else {
                System.out.println();
                System.out.println(i + ".Canavarın Sırası ");
                int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                if (obstacleDamage < 0) {
                    obstacleDamage = 0;
                }
                this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                afterHit();
            }
            firstAttack = !firstAttack;
        }
        if (this.getObstacle().getHealth() < this.getPlayer().getHealth()) {
            System.out.println("Düşmanı Yendiniz !");
            System.out.println(this.getObstacle().getAward() + " para kazandınız !");
            this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
            System.out.println("Güncel Paranız :" + this.getPlayer().getMoney());
        } else {
            return false;
        }
    }
    return true;
}

public void afterHit() {
    System.out.println("Canınız : " + this.getPlayer().getHealth());
    System.out.println(this.getObstacle().getName() + "Canı : " + this.getObstacle().getHealth());
    System.out.println("-------------------");
}

public void playerStats() {
    System.out.println();
    System.out.println("Oyuncu Değerleri");
    System.out.println("-----------------------------------");
    System.out.println("Sağlık :" + this.getPlayer().getHealth());
    System.out.println("Silah : " + this.getPlayer().getInventory().getWeapon().getName());
    System.out.println("Hasar :" + this.getPlayer().getTotalDamage());
    System.out.println("Zırh : " + this.getPlayer().getInventory().getArmor().getName());
    System.out.println("Bloklama : " + this.getPlayer().getInventory().getArmor().getBlock());
    System.out.println("Para :" + this.getPlayer().getMoney());
    System.out.println();
}

public void obstacleStats(int i) {
    System.out.println(i + "." + this.getObstacle().getName() + " Değerleri");
    System.out.println("-----------------------------------");
    System.out.println("Sağlık : " + this.getObstacle().getHealth());
    System.out.println("Hasar : " + this.getObstacle().getDamage());
    System.out.println("Ödül : " + this.award);
}

public int randomObstacleNumber() {
    Random r = new Random();
    return r.nextInt(this.getMaxObstacle()) + 1;
}


public Obstacle getObstacle() {
    return obstacle;
}

public void setObstacle(Obstacle obstacle) {
    this.obstacle = obstacle;
}

public String getAward() {
    return award;
}

public void setAward(String award) {
    this.award = award;
}

public int getMaxObstacle() {
    return maxObstacle;
}

public void setMaxObstacle(int maxObstacle) {
    this.maxObstacle = maxObstacle;
}
}
