import java.util.Scanner;
import javax.swing.JOptionPane;


public class ChooseYourOwnAdventure {
    public static void main(String[]args){
        //Create Scanner object
        Scanner input = new Scanner(System.in);
        //Define variables
        String title;
        String subTitle;
        String[] choices;
        String choice = "";
        //Have the user open a treasure chest and recieve their class/weapon/skill
        //This determines their base stats 
        JOptionPane.showMessageDialog(null,"You stumble upon a strange looking treasure chest. \nOpen the chest to begin you journey.");
        int randomChoice = (int) (Math.random() * 5) + 1;
        int giveCoins = (int) (Math.random() * 30) + 5;
        //Set array for coins [0] = gold, [1] = silver, [2] = bronze
        int[] wallet = {0, 0, 0};
            switch (randomChoice) {
                case 1: choice = "knife";
                addCoins(wallet, 0, giveCoins, 0);
                if (wallet[0] == 0){ //Check if the user gets any gold or only silver
                    int coins = wallet[1];
                JOptionPane.showMessageDialog(null,"You have recieved a " + choice + " and " + coins + " silver coins from the chest!");
                showCoins(wallet);
                break;
                }else{
                    int sCoin = wallet[1];
                    JOptionPane.showMessageDialog(null,"You have recieved a gold coin and " + sCoin + " silver coins from the chest...");
                showCoins(wallet);
                break;
                }
                case 2: choice = "brass knuckles";
                addCoins(wallet, 0, giveCoins, 0);
                if (wallet[0] == 0){ //Check if the user gets any gold or only silver
                    int coins = wallet[1];
                JOptionPane.showMessageDialog(null,"You have recieved a " + choice + " and " + coins + " silver coins from the chest!");
                showCoins(wallet);
                break;
                }else{
                    int sCoin = wallet[1];
                    JOptionPane.showMessageDialog(null,"You have recieved a gold coin and " + sCoin + " silver coins from the chest...");
                showCoins(wallet);
                break;
                }
                case 3: choice = "sling";
                addCoins(wallet, 0, giveCoins, 0);
                if (wallet[0] == 0){ //Check if the user gets any gold or only silver
                    int coins = wallet[1];
                JOptionPane.showMessageDialog(null,"You have recieved a " + choice + " and " + coins + " silver coins from the chest!");
                showCoins(wallet);
                break;
                }else{
                    int sCoin = wallet[1];
                    JOptionPane.showMessageDialog(null,"You have recieved a gold coin and " + sCoin + " silver coins from the chest...");
                showCoins(wallet);
                break;
                }
                case 5: choice = "null";
                addCoins(wallet, 0, giveCoins, 0);
                if (wallet[0] == 0){ //Check if the user gets any gold or only silver
                    int coins = wallet[1];
                JOptionPane.showMessageDialog(null,"You have recieved a " + choice + " and " + coins + " silver coins from the chest!");
                showCoins(wallet);
                break;
                }else{
                    int sCoin = wallet[1];
                    JOptionPane.showMessageDialog(null,"You have recieved a gold coin and " + sCoin + " silver coins from the chest...");
                showCoins(wallet);
                break;
                }
            }
            //Define Base Stats
            int hp = 100;       // stats[0]
            int stamina = 100;  // stats[1]
            int attack = 100;   // stats[2]
            int speed = 100;    // stats[3]
            int luck = 100;     // stats[4]
            int magic = 0;      // stats[5]
            int experience = 0;
            int level = 1;
            int requiredXp = 100;
            int[] xp = {experience, requiredXp, level};
            int [] stats = {hp, stamina, attack, speed, luck, magic, xp[0], xp[1], xp[2]};
        
   
            //Define skill stats
            String skill = "";
            switch (choice) {
                case "knife":
                    skill = "warrior";
                    stats[0] += 50; // hp
                    stats[1] += 25; // stamina
                    stats[2] += 50; // attack
                    break;
                case "brass knuckles":
                    skill = "fighter";
                    stats[0] += 25; // hp
                    stats[3] += 25; // speed
                    stats[1] += 50; // stamina
                    stats[2] += 25; // attack
                    break;
                case "sling":
                    skill = "archer";
                    stats[0] -= 50; // hp
                    stats[4] += 15; // luck
                    break;
                case "stick":
                    skill = "mage";
                    stats[0] -= 50; // hp
                    stats[5] += 100; // magic
                    stats[4] += 30; // luck
                    break;
                case "null":
                    break;
            }
            //Display stats
            showStats(stats);
        addXp(stats, xp, 2000);
        
       //Prompt user to go left or right
       int optionDialog = yesNo("choice","Will your journey begin going left, or going right?", "Left", "right");
       //Generate random number from 1 - 10 and luckDraw
       int random =(int) (Math.random() * 10) + 1;
       //Branch if user chooses left
       if(optionDialog == 0){
           System.out.println("Left");
           if(random <= 3){
               int miles = 0;
               boolean luckCheck = luckTest(luck, 65); //perform a luckCheck to determine the max for miles walked
               if (luckCheck == true){
                    miles =(int) ((Math.random() * 29) + 1); //if luckCheck is passed they will walk between 1 and 30 miles
               }else if(luckCheck == false){
                   miles =(int) ((Math.random() * 50) + 1 ); //if luckCheck is failed they will walk between 1 and 50 miles
               }
               JOptionPane.showMessageDialog(null, "You walk for " + miles + " miles before you see any signs of life.");
               System.out.println("Walk");
               //miles = 45;//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
               if (miles > 20){
                   hp = subtractStat(hp, 15);
                   stamina = addStat(stamina, 15);
               }
               if (miles <= 20){
                   System.out.println("Cave");
                   yesNo("Cave", "While walking you come across a spooky looking cave, \nwill you explore it?", "uhhh, sure.", "of course not!");
                   if(optionDialog == 0){
                       
                       
                       
                       
                       
                       
                   }else if (optionDialog == 1){
                       miles = 40;
                       }
                   
               }else if (miles <= 40 && miles > 20){
                   System.out.println("Forest");
                   yesNo("Forest", "As you continue down the road you notice a \ndark forest looming in the distance, do " + ""
                           + "you explore it?", "of course!", "no thanks....");
                   if(optionDialog == 0){
                       
                       
                       
                       
                       
                   }else if (optionDialog == 1){
                       
                       
                       
                       
                       
                   }
               }else if (miles > 40){
                   int randomBronze = (int) (Math.random() * 65);
                   int randomSilver = (int) (Math.random() * 65) + 1;
                   System.out.println("Bridge");
                   if (randomBronze == 0){
                   optionDialog = yesNo("", "You come across a bridge guarded by two extremely threatening bandits" + 
                           ", \nthey demand " + randomSilver + " silver coins!", "Fight!", "pay up.");   //Pompt the user to choose to fight the bandits or pay them
                   }else if(randomBronze != 0){
                       optionDialog = yesNo("", "You come across a bridge guarded by two extremely threatening bandits" + 
                           ", \nthey demand " + randomSilver + " silver and " + randomBronze + " bronze coins!", "Fight!", "pay up.");   //Pompt the user to choose to fight the bandits or pay them
                   }
                   if(optionDialog == 1){  //user chose to pay up
                       int[] originalWallet = wallet; //used to check if subtractCoins() later on was successful
                       subtractCoins(wallet, 0, randomSilver, randomBronze );
                            if (originalWallet == wallet){
                                optionDialog = 1;
                                JOptionPane.showMessageDialog(null, "You're going to have to fight!"); //if user doesn't have enough coins they are forced to fight
                            }
                       
                       
                   }if (optionDialog == 0){ //user chose to fight
                       
                       
                       
                       
                       
                       
                       
                   }
                   
               }
               
               
               
               
           }else if (3 < random && random <= 6 ){
               JOptionPane.showMessageDialog(null, "Somehow you managed to hitch a ride on a wagon to the nearest village.");
               System.out.println("Wagon ride");
               luck = addStat(luck, 5);
               
               
               
               
               
           }else{
               JOptionPane.showMessageDialog(null, "Two hooded figures approach you without a word.");
               
               System.out.println("Hooded figures");
           }
           
       //Branch if user chooses right    
       }else if (optionDialog == 1){
           System.out.println("Right");
           
           
           
           
       }
        
    }
        // optionDialog = yesNo("title", "subTitle", "option1", "option2");
        static int yesNo(String title, String subTitle, String choice1, String choice2) {
        Object[] options = {choice1, choice2};
        int yn = JOptionPane.showOptionDialog(null, 
                subTitle, 
                title,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,     //do not use a custom Icon
                options,  //the titles of buttons
                options[0]); //default button title
        return yn;
        }
        // ADD INSTRUCTIONS HERE //////////////////////////////////////////////////////////////////////////////////////////
        //choices = {
        static String askUser(String[] choices, String subTitle, String title) {
        String s = (String) JOptionPane.showInputDialog(
                null,
                subTitle,
                title,
                JOptionPane.PLAIN_MESSAGE,
                null,
                choices,
                choices[0]);
        return s;
    }
    //showCoins (wallet);
    static void showCoins (int[] wallet){
        JOptionPane.showMessageDialog(null, "Coins:\nGold = 100 silver\nSilver = " + 
                    "100 bronze\n\nYou have " + wallet[0] + " gold coins, " + 
                    wallet[1] + " silver coins, and " + wallet[2] + " bronze coins.");
    }
    // addCoins(wallet, 0, 1, 55);
    //used to add coins to user's inventory
    static int[] addCoins(int[] wallet, int gold, int silver, int bronze){
                wallet[2] += bronze;
                while (wallet[2] > 100){ //converts extra bronze to silver
                    wallet[2] -= 100;
                    wallet[1] += 1;
                }
                wallet[1] += silver;
                while (wallet[1] > 100){ //converts extra silver to gold
                    wallet[1] -= 100;
                    wallet[0] += 1;
                }
                wallet[0] += gold;
                return wallet;
        }
        //subtractCoins(wallet, 5, 7, 45);
        //used to remove coins from user's inventory 
        static int[] subtractCoins(int[] wallet, int gold, int silver, int bronze){
        int walletTotal = (wallet[0] * 10000) + (wallet[1] * 100) + (wallet[2]);
        int priceTotal = (gold * 10000) + (silver * 100) + (bronze);
        if (walletTotal < priceTotal){
            JOptionPane.showMessageDialog(null, "You don't have enough coins.");
        }else{
                while (bronze > wallet[2]){ //when there isn't enough bronze convert 1 silver to 100 bronze
                    silver += 1;
                    bronze -= 100;
                }
                while (silver > wallet[1]){ //when there isn't enough silver convert 1 gold to 100 silver
                    gold += 1;
                    silver -= 100;
                }
                wallet[2] -= bronze; //remove bronze
                wallet[1] -= silver; //remove silver
                wallet[0] -= gold;   //remove gold
            }
        return wallet;
        }
        //used to calculate whether or not an attack is successful
        //combatTest(attack, risk)
        static boolean combatTest(int attack, double risk){
            boolean combatTest = true;              // default it to false
            double random = Math.random() * 100;    // generate a random number between 1 to 100
            risk = risk;
            if (risk < random){                     // if the random number is larger than the risk the test is passed
                combatTest = false;
            }
            return combatTest;
        }
    //chance of success between 0 and 100
    //if(luckChance(luck, 60) == true){ System.out.println("Passed!");  
    //will return true 60% of the time with 100 luck and 60 risk, 78% of the time with 130 luck
        static boolean luckTest(double luck, double risk){
        boolean trueTest = true;               // default it to false
        double luckPercent = luck * .01;        //change luck to a percent ex. 130 to 1.3 or 30%
        risk = risk * luckPercent;              //generate the highest number for a success
        double random =(Math.random() * 100);   //generate a random number between 0 and 100
        if (risk < random){                     //if the random number is larger than the risk the test is passed
            trueTest = false;
        }
        return trueTest;
    }

    //Add xp for completing a task, check if xp > 100, if so subtract 100 xp and add a level
    //addXp(stats, xp, 160);     will add 160 xp leveling from level 1 to level 2
    static int[] addXp (int[] stats, int[]xp, int plusXP){
        int experience = xp[0];
        int requiredXp = xp[1];
        int level = xp[2];
        double plusRequiredXp = 0;
        experience += plusXP;
        while (experience > requiredXp){
            experience -= requiredXp;
            plusRequiredXp = (level * .1);
            plusRequiredXp = (plusRequiredXp * requiredXp);
            requiredXp = (int)(requiredXp + plusRequiredXp);
            level += 1;
            JOptionPane.showMessageDialog(null,"You leveled up!");
            showStats(stats);
        }
        xp[0] = experience;
        xp[1] = requiredXp;
        xp[2] = level;
        return xp;
    }
    //showStats(stats);
    static void showStats(int[] stats){
        JOptionPane.showMessageDialog(null, "Your Current Stats: \nHp: " +
                stats[0] + "\nStamina: " + stats[1] + "\nAttack: " + stats[2] +
                "\nSpeed: " + stats[3] + "\nLuck: " + stats[4] + "\nMagic: " + 
                stats[5] + "\n\n\nXP: " + stats[6] + "/" + stats[7] + "\nLevel: " + stats[8] );
    }
    //hp = addStat(stats[0], 50); // add 50 hp
    static int addStat(int original, int plus) {
        original += plus;
        return original;
    }
    //hp = subtractStat(hp,50);
    static int subtractStat(int original, int minus) {
        original -= minus;
        return original;
    }
}
