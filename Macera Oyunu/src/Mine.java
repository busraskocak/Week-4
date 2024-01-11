import java.util.Random;

        public class Mine extends Battle {
            static String award = randomAward();

            public Mine(Player player) {
                super(player, "Maden", new Snake(), randomAward(), 5);

            }

            public static String randomAward() {
                Random random = new Random();
                int randomValue = random.nextInt(100) + 1;

                if (randomValue <= 15) {
                    int weaponItem = random.nextInt(100) + 1;
                    if (weaponItem <= 20) {
                        return "Tüfek";
                    } else if (weaponItem <= 50) {
                        return "Kılıç";
                    } else {
                        return "Tabanca";
                    }
                } else if (randomValue <= 130) {
                    int armorItem = random.nextInt(100) + 1;
                    if (armorItem <= 20) {
                        return "Ağır Zırh";
                    } else if (armorItem <= 50) {
                        return "Orta Zırh";
                    } else {
                        return "Hafif Zırh";
                    }
                } else if (randomValue <= 355) {
                    int moneyItem = random.nextInt(100) + 1;
                    if (moneyItem <= 20) {
                        return "10";
                    } else if (moneyItem <= 50) {
                        return "5";
                    } else {
                        return "1";
                    }
                } else {
                    return null;
                }
            }
        }