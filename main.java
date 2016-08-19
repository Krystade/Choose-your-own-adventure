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
        String choice = "null";
        //Have the user open a treasure chest and recieve their class/weapon/skill
        //This determines their base stats 
        JOptionPane.showMessageDialog(null,"You stumble upon a strange looking treasure chest. \nOpen the chest to begin you journey.");
        int randomChoice = (int) (Math.random() * 5) + 1;
        int giveCoins = (int) (Math.random() * 70) + 5;
        int extraCoins = 2 * giveCoins;
        //Set array for coins [0] = gold, [1] = silver, [2] = bronze
        int[] wallet = {0, giveCoins, 0};
            switch (randomChoice) {
                case 1: choice = "knife";
                JOptionPane.showMessageDialog(null,"You have recieved a knife and " + giveCoins + " silver coins from the chest!");
                break;
                case 2: choice = "brass knuckles";
                JOptionPane.showMessageDialog(null,"You have recieved brass knuckles and " + giveCoins + " silver coins from the chest!");
                break;
                case 3: choice = "sling";
                JOptionPane.showMessageDialog(null,"You have recieved a sling and " + giveCoins + " silver coins from the chest!");
                break;
                case 4: choice = "stick";
                JOptionPane.showMessageDialog(null,"You have recieved a stick and " + giveCoins + " silver coins from the chest.");
                break;
                case 5: choice = "null";
                JOptionPane.showMessageDialog(null,"You have got " + extraCoins + " silver coins from the chest...");
                wallet[1] = extraCoins;
                break;
            }
            //Explain how much coins are worth and display how much they have
            showCoins(wallet);
        //Define Base Stats
        int hp = 100;
        int stamina = 100;
        int attack = 100;
        int speed = 100;
        int luck = 100;
        int strength = 100;
        int magic = 0;
        int experience = 0;
        int level = 1;
        int requiredXp = 100;
        int[] xp = {experience, requiredXp, level};
        
   
        //Define skill stats
        String skill = "";
        switch (choice) {
            case "knife":
                skill = "warrior";
                hp += 50;
                stamina += 25;
                attack += 50;
                break;
            case "brass knuckles":
                skill = "fighter";
                hp += 25;
                speed += 25;
                stamina += 50;
                attack += 25;
                break;
            case "sling":
                skill = "archer";
                hp -= 50;
                luck += 15;
                break;
            case "stick":
                skill = "mage";
                hp -= 50;
                magic += 100;
                luck += 30;
                break;
            case "null":
                break;
        }
        //Display stats
        System.out.println("class = " + skill + "\nhp = " + hp + "\nstamina = " + stamina +
                "\nattack = " + attack + "\nspeed = " + speed + "\nluck = " + luck + 
                "\nstrength = " + strength + "\nmagic = " + magic + "\nxp = " + xp[0] + "\nrequiredXp = " + xp[1] +
                "\nlevel = " + xp[2]);
        
       //Prompt user to go left or right
       int optionDialog = yesNo("choice","Will your journey begin going left, or going right?", "Left", "right");
       //Generate random number from 1 - 10 and luckDraw
       int random =(int) (Math.random() * 10);
       //Branch if user chooses left
       int count = 1;
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
               
               
               
               
               
           }else if (3 < random && random <= 6 ){
               JOptionPane.showMessageDialog(null, "Somehow you managed to hitch a ride on a wagon to the closest town.");
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
        static int yesNo(String title, String subTitle, String choice1, String choice2) {
        Object[] options = {choice1, choice2};
        int m = JOptionPane.showOptionDialog(null, 
                subTitle, 
                title,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,     //do not use a custom Icon
                options,  //the titles of buttons
                options[0]); //default button title
        return m;
        }

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
                JOptionPane.showMessageDialog(null, "You now have " + wallet[0] +
                        " gold coins, " + wallet[1] + " silver coins, and " + 
                        wallet[2] + " bronze coins.");
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
                showCoins (wallet);
            }
        return wallet;
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
    //addXp(xp, 160);     will add 160 xp leveling from level 1 to level two
    static int[] addXp (int[]xp, int plusXP){
        int experience = xp[0];
        int requiredXp = xp[1];
        int level = xp[2];
        experience += plusXP;
        while (experience > requiredXp){
            requiredXp = level * 100;
            experience -= requiredXp;
            level += 1;
        }
        xp[0] = experience;
        xp[1] = requiredXp;
        xp[2] = level;
        return xp;
    }
    //hp = addStat(hp,50);
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
