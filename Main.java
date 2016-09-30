import javax.swing.JOptionPane;


public class ChooseYourOwnAdventure {
    public static void main(String[]args){
        //Define variables
        String title;
        String subTitle;
        String[] choices;
        String choice = "";
        //Begin while loop to allow for playing again
        boolean play = true;
        while (play == true){
            boolean dead = false;
            while (dead == false){
            //Have the user open a treasure chest and recieve their class/weapon/skill
            //This determines their base stats 
                JOptionPane.showMessageDialog(null,"You stumble upon a strange looking treasure chest. \nOpen the chest to begin you journey.");
                int randomChoice = (int) (Math.random() * 4) + 1;
                int giveCoins = (int) (Math.random() * 30) + 12;
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
                        
                        case 4: choice = "stick";
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
                        addCoins(wallet, 0, (int)(giveCoins * 1.25), 0);
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
                    System.out.println("Gold: " + wallet[0] + "\nSilver: " + wallet[1] + "\nBronze: " + wallet[2]);
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
                    System.out.println(skill);
                    showStatsOriginal(stats);       //Display stats
                    
                
               int beginLeftRight = yesNo("choice","Will your journey begin going left, or going right?", "Left", "right");    //Prompt user to go left or right
               int random =(int) (Math.random() * 10) + 1; 
               random = 1;////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
               //Generate random number from 1 - 10 for random path
               //Branch if user chooses left
               if(beginLeftRight == 0){
                   System.out.println("\nLeft");
                   if(random <= 3){
                       int miles = 0;
                       boolean luckCheck = luckTest(stats, 65); //perform a luckCheck to determine the max for miles walked
                       if (luckCheck == true){
                            miles =(int) ((Math.random() * 29) + 1); //if luckCheck is passed they will walk between 1 and 30 miles
                       }else if(luckCheck == false){
                           miles =(int) ((Math.random() * 50) + 1 ); //if luckCheck is failed they will walk between 1 and 50 miles
                       }
                       JOptionPane.showMessageDialog(null, "You walk for " + miles + " miles before you see any signs of life.");
                       System.out.println("Walk");
                       if (miles > 20){
                           stats[0] = subtractStat(stats[0], 15);
                           stats[1] = addStat(stats[1], 15);
                       }
                       if (miles <= 20){
                           System.out.println("Cave");
                           int caveYN = yesNo("Cave", "While walking you come across a spooky looking cave, \nwill you explore it?", "uhhh, sure.", "of course not!");
                           if(caveYN == 0){
                               int caveLeftRight = yesNo("choice","Will you begin exploring to the left of the cave, or the right?", "Left", "right");
                               if(caveLeftRight == 0){
                                   JOptionPane.showMessageDialog(null, "You are attacked by a vicious swarm blood-thirsty bats!");
                                   boolean check = combatTest(stats, "low");
                                   if (check == true){
                                       addXp(stats,120);
                                       System.out.println("Killed bats");
                                   }else{
                                       JOptionPane.showMessageDialog(null, "You Died!");
                                       dead = true;
                                       int yn = yesNo("End", "Would you like to play again?", "Yes", "No");
                                        if (yn == 1){
                                            play = false;
                                            break;
                                        }else{
                                            continue;
                                        }
                                   }
                                   boolean batCheck = luckTest(stats,50);
                                   if(batCheck == true){
                                       int coinType = (int) (1 + (Math.random() * 2));
                                       int randomNum = (int) (1 + (Math.random() * 20));
                                       if (coinType == 0){
                                       JOptionPane.showMessageDialog(null,"You found the nesting place of the bats, \nYou got " + randomNum + " bronze coins  in the nest!");
                                       addCoins(wallet, 0, 0, randomNum);
                                       showCoins(wallet);
                                    }else if (coinType == 1){
                                        JOptionPane.showMessageDialog(null,"You found the nesting place of the bats, \nYou got " + randomNum + " silver coins  in the nest!");
                                        addCoins(wallet, 0, randomNum, 0);
                                        showCoins(wallet);
                                    }
                                }else{
                                    JOptionPane.showMessageDialog(null,"You found the nesting place of the bats, \nbut there was nothing there.");
                                }
                                int mineshaft = yesNo("Mineshaft","You arrive at a vertical mineshaft. \nWill you climb down it or exit the cave?","Climb Down","Leave");
                                if(mineshaft == 0){
                                    
                                    
                                }else if (mineshaft == 1){
                                    caveYN = 1;
                                }
                               }else if(caveLeftRight == 1){
                                   JOptionPane.showMessageDialog(null, "You enter an enormous, dimly lit cavern.");
                                   int cavern = yesNo("Cavern", "The floor is covered in  fluorescent flowers, lighting the \nentire space, " + 
                                            "including the bright shimmering pool of water. ", "Pick the flowers.", "go for a swim.");
                                   //Player chose to pick flowers
                                   if(cavern == 0){
                                       System.out.println("pick the flowers");
                                       JOptionPane.showMessageDialog(null,"You are attacked by a swarm of radiated butterflies!");
                                       boolean butterflyCombat = combatTest(stats, "veryLow");
                                       if (butterflyCombat == true){
                                           JOptionPane.showMessageDialog(null,"Taking care of the butterflies was a piece of cake!");
                                           addXp(stats,60);
                                           System.out.println("Killed butterflies");
                                        }else{
                                            JOptionPane.showMessageDialog(null, "You died to a bunch of butterflies...");
                                           dead = true;
                                           int yn = yesNo("End", "Would you like to play again?", "Yes", "No");
                                            if (yn == 1){
                                                play = false;
                                                break;
                                            }else{
                                                continue;
                                            }
                                        }
                                   //Player chose to go for a swim
                                   }else if (cavern == 1){
                                       System.out.println("go for a swim");
                                       JOptionPane.showMessageDialog(null,"A feeling of power overwhelms you once\nyou enter the water.");
                                       int pool = (int)(Math.random() * 5);
                                       int[] statsOld = {stats[0],stats[1],stats[2],stats[3],stats[4],stats[5]};
                                       statsOld(stats);
                                       stats[pool] += 10;
                                       switch (pool){
                                           case 0:
                                                 System.out.println("+10 health");
                                                 JOptionPane.showMessageDialog(null, "You have raised your health by 10 points.");
                                                break;
                                           case 1:
                                                System.out.println("+10 stamina");
                                                JOptionPane.showMessageDialog(null, "You have raised your stamina by 10 points.");
                                                break;
                                           case 2:
                                                System.out.println("+10 attack");
                                                JOptionPane.showMessageDialog(null, "You have raised your attack by 10 points.");
                                                break;
                                           case 3:
                                                System.out.println("+10 speed");
                                                JOptionPane.showMessageDialog(null, "You have raised your speed by 10 points.");
                                                break;
                                           case 4:
                                                System.out.println("+10 luck");
                                                JOptionPane.showMessageDialog(null, "You have raised your luck by 10 points.");
                                                break;
                                           case 5:
                                                System.out.println("+10 magic");
                                                JOptionPane.showMessageDialog(null, "You have raised your magic by 10 points.");
                                                break;
                                            }
                                            showStats(stats, statsOld);
                                   }

                                   

                               }
                               }if (caveYN == 1){ //If the user doesn't want to enter the cave change the number of miles walked
                               miles = 40;
                               }

                       }if (miles <= 40 && miles > 20){
                           System.out.println("Forest");
                           int forestYN = yesNo("Forest", "As you continue down the road you notice a \ndark forest looming in the distance, do " + ""
                                   + "you explore it?", "of course!", "no thanks....");
                           if(forestYN == 0){





                           }else if (forestYN == 1){
                               miles = 41;
                           }
                       }if (miles > 40){
                           int bridgeDialog = 0;
                           int randomBronze = (int) (Math.random() * 65);
                           int randomSilver = (int) (Math.random() * 35) + 1;
                           System.out.println("Bridge");
                           if (randomBronze == 0){
                                bridgeDialog = yesNo("", "You come across a bridge guarded by two extremely threatening bandits" + 
                                   ", \nthey demand " + randomSilver + " silver coins!", "Fight!", "pay up.");   //Pompt the user to choose to fight the bandits or pay them
                           }else if(randomBronze != 0){
                                bridgeDialog = yesNo("", "You come across a bridge guarded by two extremely threatening bandits" + 
                                   ", \nthey demand " + randomSilver + " silver and " + randomBronze + " bronze coins!", "Fight!", "pay up.");   //Pompt the user to choose to fight the bandits or pay them
                           }
                           if(bridgeDialog == 1){  //user chose to pay up
                                int[] originalWallet = wallet; //used to check if subtractCoins() later on was successful
                                subtractCoins(wallet, 0, randomSilver, randomBronze );
                                    if (originalWallet == wallet){
                                        bridgeDialog = 0;
                                        JOptionPane.showMessageDialog(null, "You're going to have to fight!"); //if user doesn't have enough coins they are forced to fight
                                    }


                           }if (bridgeDialog == 0){ //user chose to fight
                                boolean bridgeTest = combatTest(stats, "medium");
                                if (bridgeTest == true){
                                    System.out.println("bandits killed");
                                   addXp(stats, 150);
                                }else if (bridgeTest == false){
                                    System.out.println("Dead");
                                   JOptionPane.showMessageDialog(null, "You Died!");
                                   dead = true;
                                   int yn = yesNo("End", "Would you like to play again?", "Yes", "No");
                                    if (yn == 1){
                                        System.out.println("Play again = false");
                                        play = false;
                                        break;
                                    }else{
                                        continue;
                                    }
                                }
                                System.out.println("bridgeTest = " + bridgeTest);
                           }
                       }
                       // have all the walking paths meet up here possibly



                   }else if (3 < random && random <= 6 ){
                       JOptionPane.showMessageDialog(null, "Somehow you managed to hitch a ride on a wagon to a nearby village.");
                       System.out.println("Wagon ride");
                       stats[4] = addStat(stats[4], 5);
                       random = (int) (Math.random() * 3);
                       String sizeOne = "";
                       String sizeTwo = "";
                       String sizeThree = "";
                       switch (random){
                           case 0:
                               sizeOne = "small";
                               sizeTwo = "medium";
                               sizeThree = "large";
                               break;
                            case 1:
                               sizeOne = "large";
                               sizeTwo = "small";
                               sizeThree = "medium";
                               break;
                            case 2:
                               sizeOne = "medium";
                               sizeTwo = "large";
                               sizeThree = "small";
                               break;
                       }
                       int wagonOneDialog = yesNo("Wagon Ride", "You arrive at a " + sizeOne + 
                               " village surrounded by a scorching desert. Do you stop to investigate or continue?", "stop", "continue");
                           if(wagonOneDialog == 0){
                               System.out.println("Wagon Stop 1");
                               int villageOneDialog = yesNo(sizeOne + " village", "You observe a wake of vultures circling in the distance, \ndo you investigate?", "Enter the village", "Go towards vultures");
                               
                               
                               
                           }else if (wagonOneDialog == 1){
                                System.out.println("Wagon Continue 1");
                                int wagonTwoDialog = yesNo("Wagon Ride", "You arrive at a " + sizeTwo + 
                                " village enveloped by a dense forest. Do you stop to investigate or continue?", "stop", "continue");
                                if(wagonTwoDialog == 0){
                                    System.out.println("Wagon Stop 2");
                                    int villageTwoDialog = yesNo(sizeTwo + " village", "Before entering the village you hear a strange noise coming from the forest, \ndo you investigate?", "Enter the village", "Investigate noise");
                                    
                                    
                                    
                           }else if (wagonTwoDialog == 1){
                                System.out.println("Wagon Continue 2");
                                JOptionPane.showMessageDialog(null,"You arrive at a " + sizeThree + 
                                " village with un-ending plains on evey side. \nThe wagon will take you no further.");
                                if(wagonTwoDialog == 0){
                                    System.out.println("Wagon Final Stop");
                                    int villageThreeDialog = yesNo(sizeThree + " village", "You notice an enormous castle looming in the distance, \ndo you investigate?", "Enter the village", "Walk to castle");
                                    
                                    
                                    }    
                                }    
                            }



                       // have all the wagon paths meet up here possibly
                            }else if(random > 6){
                                random = (int) (2 + (Math.random() * 5));
                                JOptionPane.showMessageDialog(null, random + " hooded figures approach you without a word.\nYou are killed on the spot....");
                                System.out.println("Hooded figures");
                                dead = true;
                                int yn = yesNo("End", "Would you like to play again?", "Yes", "No");
                                if (yn == 1){
                                    System.out.println("Play again = false");
                                    play = false;
                                    break;
                                }else{
                                }
                            }
                            // have all the Hooded paths meet up here possibly

                            
                                    }else if (beginLeftRight == 1){             //Branch if user chooses right
                                        System.out.println("\nRight");




                                    }

                                }
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
            ///////////////////////////////////////////////////////////////////////////make a speed test to allow the player to escape the enemy ///////////////////////////////////////////////////////////////////
            //used to calculate whether or not an attack is successful
            //combatTest(stats, "low") risk level of Verylow = 5% failure / low = 20% failure / medium = 40% failure / hard = 70% failure / extreme = 90% failure 
            //^^ for default stats ^^ 
                        static boolean combatTest(int[] stats, String risk){
                boolean combatTest = true;              // default it to true / pass
                double random = Math.random() * 100;    // generate a random number between 1 to 100
                int danger = 0;                         // create variable danger, default it to 0
                boolean dead;
                switch (risk) {
                    case "veryLow":
                        danger = 5;
                        break;
                    case "low":
                        danger = 20;
                        break;
                    case "medium":
                        danger = 40;
                        break;
                    case "high":
                        danger = 70;
                        break;
                    case "veryHigh":
                        danger = 90;
                        break;
                }
                danger += (.250 * (stats[0] - 100));
                danger += (.500 * (stats[1] - 100));
                danger += (.125 * (stats[2] - 100));
                danger += (.125 * (stats[3] - 100));
                danger += (.500 * (stats[4] - 100));
                danger += (.250 * (stats[5]));
                if ( random <= danger){                     // if the random number is less than or equal to the danger the test is failed
                    combatTest = false;
                    System.out.println("Dead");
                    dead = true;
                }
                return combatTest;
            }
            
            
        //chance of success between 0 and 100
        //if(luckChance(stats, 60) == true){ System.out.println("Passed!");  
        //will return true 60% of the time with 100 luck and 60 risk, 78% of the time with 130 luck
            static boolean luckTest(int[] stats, double risk){
            boolean trueTest = true;               // default trueTest to false
            double luckPercent = stats[4] * .01;        //change luck to a percent ex. 130 to 1.3 or 30%
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
            stats[6] += plusXP;
            while (stats[6] > stats[7]){
                stats[6] -= stats[7];
                double plusRequiredXp = (level * .1);
                plusRequiredXp = (plusRequiredXp * stats[7]);
                stats[7] = (int)(stats[7] + plusRequiredXp);
                stats[8] += 1;
                JOptionPane.showMessageDialog(null,"You leveled up!");
                int [] statsOld = {stats[0],stats[1],stats[2],stats[3],stats[4],stats[5]};
                
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
                        stats[0] += 2;
                        stats[4] += 6;
                        break;
                    case 4:
                        stats[0] += 2;
                        stats[4] += 5;
                        stats[5] += 7;
                        break;
                    case 5:
                        stats[0] += 3;
                        stats[1] += 3;
                        stats[2] += 3;
                        stats[3] += 3;
                        stats[4] += 3;
                        break;
                }
                showStats(stats, statsOld);
            }
            return stats;
        }
        
        //statsOld(stats) -- used to save old stats before giving a new skill
        static void statsOld (int[] stats){
            int[] statsOld = {stats[0],stats[1],stats[2],stats[3],stats[4],stats[5]};
        }
        //showStats(stats, stats);
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
