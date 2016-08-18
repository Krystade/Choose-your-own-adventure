
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
        int risk = 1;
        String choice = "null";
        //Have the user open a treasure chest and recieve their class/weapon/skill
        //This determines their base stats 
        JOptionPane.showMessageDialog(null,"You stumble upon a strange looking treasure chest. \nOpen the chest to begin you journey.");
        int randomChoice = (int) (Math.random()*5);
        int giveCoins = (int) (Math.random() * 25) + 5;
        int extraCoins = 2 * giveCoins;
        //Set array for money [0] = gold, [1] = silver, [2] = bronze
        int[] wallet = {0, giveCoins, 0};
            switch (randomChoice) {
                case 1: choice = "knife";
                JOptionPane.showMessageDialog(null,"You have recieved a knife and " + giveCoins + " silver coins from the chest!");
                break;
                case 2: choice = "brass knuckles";
                JOptionPane.showMessageDialog(null,"You have recieved brass knuckles and " + giveCoins + " silver coins from the chest!");
                break;
                case 3: choice = "sling";
                JOptionPane.showMessageDialog(null,"You have recieved a sling and " + giveCoins + " silver coins from the chest.");
                break;
                case 4: choice = "stick";
                JOptionPane.showMessageDialog(null,"You have recieved a stick and " + giveCoins + " silver coins from the chest?");
                break;
                case 5: choice = "null";
                JOptionPane.showMessageDialog(null,"You have got " + extraCoins + " silver coins from the chest...");
                wallet[1] = extraCoins;
                break;
            }
            //Explain how much coins are worth
            JOptionPane.showMessageDialog(null, "Coins:\nGold = 100 silver\nSilver = " + 
                    "100 bronze\nBronze\n\nYou have " + wallet[0] + " gold coins, " + 
                    wallet[1] + " silver coins, and " + wallet[2] + " bronze coins.");

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
            default:
                break;
        }
        //Display stats
        System.out.println("class = " + skill + "\nhp = " + hp + "\nstamina = " + stamina +
                "\nattack = " + attack + "\nspeed = " + speed + "\nluck = " + luck + 
                "\nstrength = " + strength + "\nmagic = " + magic + "\nxp = " + xp[0] + "\nrequiredXp = " + xp[1] +
                "\nlevel = " + xp[2] + "\nrisk = " + risk );
        
       //Prompt user to go left or right
       int optionDialog = yesNo("choice","Will your journey begin going left, or going right?", "Left", "right");
       //Generate random number from 1 - 10 and luckDraw
       int random =(int) (Math.random() * 10);
       int luckDraw = (int) (Math.random() * luck);
       System.out.println("random = " + random);
       System.out.println("luckDraw = " + luckDraw);
       //Branch if user chooses left
       if(optionDialog == 0){
           System.out.println("Left");
           if(random <= 3){
               int miles =(int) (Math.random()*50);
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
               JOptionPane.showMessageDialog(null, "");
               System.out.println("");
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
    //subtractMoney(wallet, 5, 7, 45);
    //
    static int[] subtractMoney(int[] wallet, int gold, int silver, int bronze){
        int walletTotal = (wallet[0] * 10000) + (wallet[1] * 100) + (wallet[2]);
        int priceTotal = (gold * 10000) + (silver * 100) + (bronze);
        if (walletTotal < priceTotal){
            JOptionPane.showMessageDialog(null, "You don't have enough money.");
        }else{
                while (bronze > wallet[2]){
                    silver += 1;
                    bronze -= 100;
                }
                while (silver > wallet[1]){
                    gold += 1;
                    silver -= 100;
                }
                wallet[2] -= bronze;
        
                while (silver > wallet[1]){
                    gold += 1;
                    silver -= 100;
                }
                wallet[1] -= silver;
        
                wallet[0] -= gold;
                JOptionPane.showMessageDialog(null, "You now have " + wallet[0] +
                        " gold coins, " + wallet[1] + " silver coins, and " + 
                        wallet[2] + " bronze coins.");
            }
        return wallet;
        }
    //should be between 10 and 110
    //if(luckChance(luck, risk) == true){ System.out.println("Passed!");}
    //else {System.out.println("Failed")}
    static boolean luckChance(double luck, int risk){
        int random = (int) (Math.random() * 100);
        double luckChance = (luck *.01 * random);
        boolean trueTest;
        if (luckChance < risk){
        trueTest = true;
        }else {
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
