import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChoiceLogic {

    private final Scanner tinydaddy;
    private final StatsClass gameStats;
    String[] currentChoices;
    Boolean[] currentChoicesB;

    public ChoiceLogic(Scanner tinydaddy, StatsClass gameStats) {
        this.tinydaddy = tinydaddy;
        this.gameStats = gameStats;
    }

    //choice() returns the array index of a choice from currentChoices as a string
    public String choice() {
        //this if-else just checks if DTM can be displayed
        if (gameStats.allowDTMdisplay) {
            FancyPrinter.println("\n" + gameStats.showDTM() + "You can: ");
        } else {
            FancyPrinter.println("\nYou can: ");
        }
        List<String> selectnums = new ArrayList<>();
        List<String> choiceindex = new ArrayList<>();
        currentChoices = gameStats.GetChoices();
        currentChoicesB = gameStats.GetChoicesB();
        int selectnum = 1;
        for (int c = 0; c < currentChoices.length; c++) {
            if (currentChoicesB[c] == true) {
                FancyPrinter.println(selectnum + ") " + currentChoices[c]);
                String num = ("" + selectnum);
                selectnums.add(num);
                choiceindex.add("" + c);
                selectnum += 1;
            }
        }
        FancyPrinter.print("What do you do? : ");
        String input = tinydaddy.nextLine().trim();
        while (!selectnums.contains(input)) {
            FancyPrinter.print("You didn't choose a valid option. Select again: ");
            input = tinydaddy.nextLine().trim();
        }
        //I had to look this up cause I forgot, but .get(int index#) for lists
        //will return whatever type the type of the list is;
        //choiceindex is a string list
        return (choiceindex.get((Integer.parseInt(input) - 1)));
    }

    private static boolean stringTointCheck(String input) {
        if (input.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean responses1(String choiceindex) {
        int input = Integer.parseInt(choiceindex);
        System.out.println("");
        switch (input) {
            case 0: {
                FancyPrinter.printWrapln("You walk over to the computer desk and peel the yellow sticky note off the screen. The note reads: ");
                System.out.println("");
                FancyPrinter.printCenteredln(CenterString.space("------------------------------"));
                FancyPrinter.printWrapln("Hello future self, this is you from three days ago. If your confused and don't remember anything, then you probably got beaten up by the mafia for not paying them and got concussed or something. All that matters now is getting the hell out of NYC as soon as possible, so here's what you need to know to do that. ");
                System.out.println("");
                FancyPrinter.printWrapln("#1: A new mafia crime syndicate has taken complete control of NYC. The mafia come by the apartment every day at 8:00 pm (20:00 in military time btw) to collect a \"protection fee\" of 25$. If you don't pay them every day, you'll probably get slimed. ");
                FancyPrinter.printWrapln("#2: You are hella broke. You only have " + gameStats.currentMoney + "$ right now. If you haven't done so yet, put on the wristwatch and check the wallet in your pocket to get constant date and time updates. ");
                FancyPrinter.printWrapln("#3: Your \"job\" right now is AI dropshipping. Everybody in the family thinks we're bums, but I promise we're gonna pop off soon! Use the computer and do some dropshipping to make money. ");
                FancyPrinter.printWrapln("#4: If you can save up 400$, use the computer to buy a plane ticket to Romania and go live with your uncle, Tom Pearl. It's not great, but it's the only way we can escape the mafia that are running NYC! ");
                FancyPrinter.printWrapln("That pretty much summarizes everything for now. If you've really lost your memory, you should probably look around the apartment a bit, then start dropshipping to get us out of here. ");
                FancyPrinter.printCenteredln(CenterString.space("------------------------------"));
                System.out.println("");
                FancyPrinter.printWrapln("You get back up and think to yourself \"Wow, what an interesting, brilliant and thought provoking note I left myself there, providing all the exposition this game needs. I should probably heed my own word and check my pockets, to use the time and money display feature so graciously created for me by the developer.\" ");
                gameStats.choices1b[0] = false;
                gameStats.choices1b[1] = true;
                break;
            }
            case 1: {
                FancyPrinter.println("You sit down at the desk and boot up the computer. ");
                gameStats.gameState = 2;
                return false;
            }
            case 2: {
                FancyPrinter.println("Nothing happens because this is placeholder code.");
                gameStats.gameState = 3;
                return false;
            }
            case 3: {
                FancyPrinter.println("Nothing happens because this is placeholder code.");
                gameStats.gameState = 4;
                return false;
            }
            case 4: {
                FancyPrinter.println("The poster: ");
                FancyPrinter.printCenteredln(CenterString.space("------------------------------"));
                FancyPrinter.printCenteredln(CenterString.space("CASINO FORTUNA"));
                System.out.println("");
                FancyPrinter.printCenteredln(CenterString.space("Where fortune meets elegance;"));
                FancyPrinter.printCenteredln(CenterString.space("Tonight, anything is possible."));
                System.out.println("");
                FancyPrinter.printCenteredln(CenterString.space("COME TO PLAY"));
                FancyPrinter.printCenteredln(CenterString.space("BLACKJACK & WIN BIG!"));
                System.out.println("");
                FancyPrinter.printCenteredln(CenterString.space("148 Mulberry Street, New York"));
                FancyPrinter.printCenteredln(CenterString.space("------------------------------"));
                System.out.println("");
                FancyPrinter.printWrapln("A yellow sticky note on the poster reads: [reminder to self: it takes about one hour to get here, then another hour to get back.] ");
                FancyPrinter.println("*casino unlocked* ");
                gameStats.choices1b[4] = false;
                gameStats.choices1b[3] = true;
                break;
            }
            case 5: {
                FancyPrinter.printWrapln("You open up the cabinet, finding a fishing rod and tackle box, along with a map. A yellow sticky note on the map says: [reminder to self: the lake is a thirty minute walk from here.] ");
                FancyPrinter.println("*fishing unlocked* ");
                gameStats.choices1b[5] = false;
                gameStats.choices1b[2] = true;
                break;
            }
            case 6: {
                FancyPrinter.printWrapln("You thumb around your pockets, finding your wallet and a wristwatch. Because the developer is lazy, the wristwatch only reads in military time. ");
                FancyPrinter.println("*date, time and cash display unlocked* ");
                gameStats.choices1b[6] = false;
                gameStats.allowDTMdisplay = true;
                break;
            }
            case 7: {
                int randomfood = (int) ((Math.random() * 5) + 1);
                while (randomfood == gameStats.lastFridgemeal) {
                    randomfood = (int) ((Math.random() * 5) + 1);
                }
                switch (randomfood) {
                    case 1: {
                        FancyPrinter.printWrapln("You grab some pizza bagels out of the freezer and microwave them. They're alright. ");
                        FancyPrinter.println("You ate for 15 minutes");
                        gameStats.lastFridgemeal = 1;
                        break;
                    }
                    case 2: {
                        FancyPrinter.printWrapln("You see some hotdogs in the fridge, but remember that you don't own a stove and get a little sadder.");
                        FancyPrinter.println("You \"ate\" for 15 minutes");
                        gameStats.lastFridgemeal = 2;
                        break;
                    }
                    case 3: {
                        FancyPrinter.printWrapln("You grab some slices of bread from a loaf sitting on the counter next to the fridge. You wish you had a toaster and something to put on the bread, but then remember that your too broke for allat. ");
                        FancyPrinter.println("You ate for 15 minutes");
                        gameStats.lastFridgemeal = 3;
                        break;
                    }
                    case 4: {
                        FancyPrinter.printWrapln("You look in the fridge ang get a little depressed at what you see, so you use some DoorDash points to get some Chili's instead. Why are you doordashing Chili's you freak??");
                        FancyPrinter.println("You ate for 15 minutes. ");
                        gameStats.lastFridgemeal = 4;
                        gameStats.chiliGodcount += 1;
                        if (gameStats.chiliGodcount == 5) {
                            System.out.println("");
                            FancyPrinter.println("*You unlocked the achievement: God of Chili's!* ");
                        }
                        break;
                    }
                    case 5: {
                        FancyPrinter.printWrapln("You look in the fridge, and decide to save some money you'll just have some water-ice soup instead. ");
                        FancyPrinter.println("You \"ate\" for 15 minutes");
                        gameStats.lastFridgemeal = 5;
                        break;
                    }
                }
                gameStats.currentTime += .25;
                break;
            }
            case 8: {
                FancyPrinter.print("How many hours would you like to doomscroll for (integers only)? ");
                String DSinput = tinydaddy.nextLine().trim();
                while (!ChoiceLogic.stringTointCheck(DSinput)) {
                    FancyPrinter.print("You didn't input an integer. Try again: ");
                    DSinput = tinydaddy.nextLine().trim();
                }
                FancyPrinter.println("You doomscroll for " + DSinput + " hours.");
                double hours = (double) Integer.parseInt(DSinput);
                if (gameStats.currentTime + hours >= 20) {
                    gameStats.currentTime = 20.0;
                    FancyPrinter.println("You open up reels and start scrolling, but you get cut short by a sound. ");
                    return mafiachecks1(0);
                } else {
                    FancyPrinter.println("You doomscroll for " + DSinput + " hours.");
                    gameStats.currentTime += hours;
                }
                break;
            }
            case 9: {
                int sleepytime;
                if (gameStats.currentTime >= 16.00) {
                    sleepytime = 5;
                } else {
                    sleepytime = (int) ((Math.random() * 4) + 1);
                }
                FancyPrinter.println("You get back into bed to take a nap during daytime, because you are a bum. You slept for: " + sleepytime + " hours. ");
                gameStats.currentTime += sleepytime;
                return mafiachecks1(1);
            }
            default:
                FancyPrinter.println(" !!the default case of respond() was triggered!! ");
                break;
        }
        return mafiachecks1(0);
    }

    private boolean mafiachecks1(int deathNum) {
        if (deathNum == 1 && gameStats.currentTime >= 20.0) {
            System.out.println("");
            FancyPrinter.printWrapln("Suddently, you are waken up from your deep sleep to a tommy-gun pressed against your temple. \"Geegee buddy.\" says the mobster. What kind of mobster talks like that? ");
            FancyPrinter.linebreak();
            FancyPrinter.printCenteredln(CenterString.space("GAME OVER "));
            FancyPrinter.printCenteredln(CenterString.space("*You completed Ending 2: Sleeping With the Fishes* "));
            return true;
        }
        if (deathNum == 0 && gameStats.currentTime == 20.0) {
            System.out.println("");
            FancyPrinter.printWrapln("It's 20:00, and you hear a loud banging on your door. \"Open up buddy! Daily 25$ protection fee, it's time to pay up!\" ");
            if (gameStats.currentMoney >= 25) {
                gameStats.currentMoney -= 25;
                FancyPrinter.printWrapln("\"Alright, I'm coming!\" You check your pocket, whip your wallet out and strut to the door. \"Here you go dude.\" \"The man takes the money. \"Good, we'll be back tomorrow. Remember, 25 bucks at eight pm sharp, every day!\" ");
                if (!gameStats.allowDTMdisplay) {
                    System.out.println("");
                    FancyPrinter.printWrapln("This whipping out of the wallet, however, does not unlock the time and money display, as you would've had to interact with the check pockets option in your apartment (generously coded and provided to you by the developer btw), which you haven't done for some inexplicable reason. ");
                }
                System.out.println("");
                if (gameStats.currentMoney >= 400) {
                    FancyPrinter.println("You've accrued enough money to escape to Romania.\n ");
                    FancyPrinter.println("You can: ");
                    FancyPrinter.println("1) Buy your Ticket and Escape. ");
                    FancyPrinter.println("2) Go to bed.\n ");
                    FancyPrinter.print("What do you do?: ");
                    String input = tinydaddy.nextLine().trim();
                    while (!(input.equals("1") || input.equals("2"))) {
                        FancyPrinter.print("You didn't choose a valid option. Select again: ");
                        input = tinydaddy.nextLine().trim();
                    }
                    if (input.equals("1")) {
                        System.out.println("");
                        FancyPrinter.printWrapln("You open up the computer one last time, buy your ticket, and uber to LaGuardia. The flight is peaceful, and after landing in Romania, Tom Pearl greets you with open arms. Now, you spend your days relaxing at the beach, listening to the rhythmic crash of the waves, and watching the sun melt into the Romanian horizon. ");
                        FancyPrinter.linebreak();
                        FancyPrinter.printCenteredln("GAME OVER - YOU WIN!");
                        FancyPrinter.printCenteredln("*You completed Ending 4: Romaniac* ");
                        return true;
                    } else {
                        FancyPrinter.printWrapln("After considering the ticket purchase, you decide to hit the hay to get ready for tomorrow " + (gameStats.currentDay + 1) + ". ");
                        gameStats.currentDay += 1;
                        gameStats.currentTime = 8.00;
                    }
                } else {
                    System.out.println("");
                    FancyPrinter.printWrapln("After handing over the money, you hit the hay to get ready for tomorrow " + (gameStats.currentDay + 1) + ". ");
                    gameStats.currentDay += 1;
                    gameStats.currentTime = 8.00;
                }
            } else {
                FancyPrinter.printWrapln("\"I don't have it.\" You check your pockets, but you don't have enough money. \"What do you mean you don't have it? You know the rules!\" A flurry of bullets shreds your wooden door to pieces. You fall to the ground, and the mobster kicks you in the stomach. \"That's why you don't disrespect the mafia buddy.\" You feel your vision fading as the bullets punch into you, and realize that this is the end. ");
                FancyPrinter.linebreak();
                FancyPrinter.printCenteredln(CenterString.space("GAME OVER "));
                FancyPrinter.printCenteredln(CenterString.space("*You completed Ending 1: Swimming With the Fishes* "));
                return true;
            }
        }
        return false;
    }

    public boolean responses2(String choiceindex) {
        int input = Integer.parseInt(choiceindex);
        System.out.println("");
        switch (input) {
            case 0: {
                FancyPrinter.println("You Chose test choice 1!");
                gameStats.choices2b[0] = false;
                return false;
            }
            case 1: {
                FancyPrinter.println("You Chose test choice 2!");
                gameStats.choices2b[1] = false;
                return false;
            }
        }
        FancyPrinter.println("Something went wrong in responses2()");
        return true;
    }
}