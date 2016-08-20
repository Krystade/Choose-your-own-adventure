import java.util.Scanner;
import javax.swing.JOptionPane;


public class ChooseYourOwnAdventure {
    public static void main(String[]args){
        /*//Begin while loop to allow for playing again
        boolean playAgain = true;
        while (playAgain == true){
            //begin while loop to determine when user dies/loses
            boolean dead = false;
            while (dead == false){*/
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
                JOptionPane.showMessageDialog(null,"You have recieved " + choice + " and " + coins + " silver coins from the chest!");
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
                case 5: choice = "none";
                addCoins(wallet, 0, giveCoins, 0);
                if (wallet[0] == 0){ //Check if the user gets any gold or only silver
                    int coins = wallet[1];
                JOptionPane.showMessageDialog(null,"You have recieved " + coins + " silver coins from the chest!");
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
            int hp = 100;           // stats[0]
            int stamina = 100;      // stats[1]
            int attack = 100;       // stats[2]
            int speed = 100;        // stats[3]
            int luck = 100;         // stats[4]
            int magic = 0;          // stats[5]
            int experience = 0;     // stats[6]
            int requiredXp = 100;   // stats[7]
            int level = 1;          // stats[8]
            String skill = "";      // stats[9]
            int[] xp = {experience, requiredXp, level};
            int [] stats = {hp, stamina, attack, speed, luck, magic, xp[0], xp[1], xp[2], 0};
            
            //Define skill stats
            switch (choice) {
                case "knife":
                    skill = "warrior";
                    stats[0] += 50; // hp
                    stats[1] += 25; // stamina
                    stats[2] += 50; // attack
                    stats[9] += 1;
                    break;
                case "brass knuckles":
                    skill = "fighter";
                    stats[0] += 25; // hp
                    stats[3] += 25; // speed
                    stats[1] += 50; // stamina
                    stats[2] += 25; // attack
                    stats[9] += 2;
                    break;
                case "sling":
                    skill = "archer";
                    stats[0] -= 50; // hp
                    stats[3] += 50; // speed
                    stats[4] += 25; // luck
                    stats[9] += 3;
                    break;
                case "stick":
                    skill = "mage";
                    stats[0] -= 50; // hp
                    stats[5] += 100; // magic
                    stats[4] += 50; // luck
                    stats[9] += 4;
                    break;
                case "none":
                    stats[9] += 5;
                    break;
            }
            //Display stats
            showStatsOriginal(stats);
        addXp(stats, 220);
        
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
                                optionDialog = 0;
                                JOptionPane.showMessageDialog(null, "You're going to have to fight!"); //if user doesn't have enough coins they are forced to fight
                            }
                       
                       
                   }if (optionDialog == 0){ //user chose to fight
                       boolean combatTest = combatTest(stats, 40);
                       
                       System.out.println(combatTest);
                       
                       
                       
                       
                       
                       
                   }
               }
               // have all the walking paths meet up here possibly
               
               
               
           }else if (3 < random && random <= 6 ){
               JOptionPane.showMessageDialog(null, "Somehow you managed to hitch a ride on a wagon to a nearby village.");
               System.out.println("Wagon ride");
               luck = addStat(luck, 5);
               random = (int) (Math.random() * 3) + 1;
               String sizeOne = "";
               String sizeTwo = "";
               String sizeThree = "";
               switch (random){
                   case 1:
                       sizeOne = "small";
                       sizeTwo = "medium";
                       sizeThree = "large";
                       break;
                    case 2:
                       sizeOne = "large";
                       sizeTwo = "small";
                       sizeThree = "medium";
                       break;
                    case 3:
                       sizeOne = "medium";
                       sizeTwo = "large";
                       sizeThree = "small";
                       break;
               }
               optionDialog = yesNo("Wagon Ride", "You arrive at a " + sizeOne + 
                       " village surrounded by a scorching desert. Do you stop to investigate or continue?", "stop", "continue");
                   if(optionDialog == 0){
                       System.out.println("Stop 1");
                       
                       
                       
                       
                   }else if (optionDialog == 1){
                       System.out.println("Continue 1");
                       optionDialog = yesNo("Wagon Ride", "You arrive at a " + sizeTwo + 
                       " village enveloped by a dense forest. Do you stop to investigate or continue?", "stop", "continue");
                       if(optionDialog == 0){
                       System.out.println("Stop 2");
                       
                       
                       
                       
                   }else if (optionDialog == 1){
                       System.out.println("Continue 2");
                       JOptionPane.showMessageDialog(null,"You arrive at a " + sizeThree + 
                       " village with un-ending plains on evey side. The wagon will take you no further.");
                       if(optionDialog == 0){
                       System.out.println("Final Stop");   
                   }    
                   }    
                   }
               
               
               
               // have all the wagon paths meet up here possibly
           }else if(random > 6){
               JOptionPane.showMessageDialog(null, "Two hooded figures approach you without a word.");
               
               System.out.println("Hooded figures");
           }
           // have all the Hooded paths meet up here possibly
           
           
       //Branch if user chooses right    
       }else if (optionDialog == 1){
           System.out.println("Right");
           
           
           
           
       }
        
    }/*
            System.out.println("Dead");
            dead = true;
            //you have died
            //show stats, coins, level?
            //give score?
        }
        playAgain = false;
        //Would you like to play again?
        //yes = do nothing
        //no = set playAgain = false
}*/
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
        //combatTest(stats, 70) risk level of 70 is successful sometimes risk level of 40 is successful often
        static boolean combatTest(int[] stats, double risk){
            boolean combatTest = true;              // default it to false
            double random = Math.random() * 100;    // generate a random number between 1 to 100
            double luck = stats[5] * .01;
            double attack = .05 * stats[1] * luck;
            double hp = .025 * stats[0] * luck;
            double magic = .025 * stats[4] * luck;
            double stamina = .0125 * stats[2] * luck;
            double speed = .0125 * stats[3] * luck;
            risk -= attack - hp - magic - stamina - speed;
            if (risk > random){                     // if the random number is larger than the risk the test is passed
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
        //addXp(stats, 50) //addXp(int[] stats, int plusXp) will add 50 xp and level up if possible
        static int[] addXp (int[] stats, int plusXP){
        int experience = stats[6];
        int requiredXp = stats[7];
        int level = stats[8];
        double plusRequiredXp = 0;
        stats[6] += plusXP;
        while (stats[6] > stats[7]){
            stats[6] -= stats[7];
            plusRequiredXp = (level * .1);
            plusRequiredXp = (plusRequiredXp * stats[7]);
            stats[7] = (int)(stats[7] + plusRequiredXp);
            stats[8] += 1;
            JOptionPane.showMessageDialog(null,"You leveled up!");
            int [] statsOld = {0,0,0,0,0,0};
                statsOld[0] = stats[0];
                statsOld[1] = stats[1];
                statsOld[2] = stats[2];
                statsOld[3] = stats[3];
                statsOld[4] = stats[4];
                statsOld[5] = stats[5];
            switch (stats[9]){
                case 1:
                    stats[0] += 5;
                    stats[1] += 4;
                    stats[2] += 5;
                    
                    break;
                case 2:
                    stats[0] += 4;
                    stats[1] += 5;
                    stats[2] += 4;
                    stats[3] += 4;
                    
                    break;
                case 3:
                    stats[0] += 1;
                    stats[4] += 6;
                    break;
                case 4:
                    stats[0] += 1;
                    stats[4] += 5;
                    stats[5] += 7;
                    break;
                case 5:
                    stats[0] += 3;
                    stats[1] += 3;
                    stats[2] += 3;
                    stats[3] += 3;
                    stats[4] += 3;
                    stats[5] += 3;
                    break;
            }
            showStats(stats, statsOld);
        }
        return stats;
    }
    //showStats(stats);
    static void showStats(int[] stats, int[] statsOld){
        JOptionPane.showMessageDialog(null, "Your Current Stats: \nHp: " +
                statsOld[0] + "  >>>  " + stats[0] + "\nStamina: " + statsOld[1] + "  >>>  " +  stats[1] + "\nAttack: " + statsOld[2] + "  >>>  " + 
                stats[2] + "\nSpeed: " + statsOld[3] + "  >>>  " + stats[3] + "\nLuck: " + statsOld[4] + "  >>>  " + stats[4] + "\nMagic: " + 
                statsOld[5] + "  >>>  " + stats[5] + "\n\n\nXP: " + stats[6] +  "/" + stats[7] +  "\nLevel: " + stats[8]);
    }
    
    //hp = addStat(stats[0], 50); // add 50 hp
    static int addStat(int original, int plus) {
        original += plus;
        return original;
    }
    //hp = subtractStat(stats[0],50); // subtract 50 stats
    static int subtractStat(int original, int minus) {
        original -= minus;
        return original;
    }
    //used at the beginning of the code once.
    static void showStatsOriginal(int[] stats){
        JOptionPane.showMessageDialog(null, "Your Current Stats: \nHp: " +
                stats[0] + "\nStamina: " + stats[1] + "\nAttack: " + stats[2] +
                "\nSpeed: " + stats[3] + "\nLuck: " + stats[4] + "\nMagic: " + 
                stats[5] + "\n\n\nXP: " + stats[6] + "/" + stats[7] + "\nLevel: " + stats[8] );
    }
}
