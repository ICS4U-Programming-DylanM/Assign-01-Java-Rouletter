// import Scanner and randint
import java.util.Scanner;
import java.util.Random;

/**
 * This program calculates the volume of a sphere.
 *
 * @author Dylan Mutabazi
 * @version 1.0
 * @since 2025-September-11
 */
final class Roulette {

    /**
     * @exception IllegalStateException
     * @see IllegalStateException
     */
    private Roulette() {
        throw new IllegalStateException("Utility class");
    }

    // public variables
    public static final int MAXNUMB = 36;
    public static final int MINNUMB = 0;
    public static final int MINAMOUNT = 0;
    static int userAmount = 100000;

    /**
     * Entrypoint of the program.
     * @param args UNUSED.
     */
    public static void main(final String[] args) {

        System.out.println(
            "welcome to 🎲ROULETTE🎲."
            + "the point of this game is try and guess"
            + "either the exact amount of the number in the roulette"
            + "or try to guess if the number is even or odd"
            + " If you guess right you win, if not no money 💸. GoodLuck \n"
        );

        while (userAmount > MINAMOUNT) {

            System.out.print("Do you wanna quit (y/n)? ");
            Scanner userActionChoiceIn = new Scanner(System.in);
            String userActionChoice = userActionChoiceIn.nextLine();

            if (userActionChoice.equalsIgnoreCase("y")) {

                break;
            } else if (userActionChoice.equalsIgnoreCase("n")) {

                Random randNumb = new Random();
                int randomNumberInRange = randNumb.nextInt(MAXNUMB - MINNUMB + 1) + MINNUMB;

                System.out.println("How much do you bet 👉: ");
                Scanner userBetAmountIn = new Scanner(System.in);
                String userBetAmount = userBetAmountIn.nextLine();

                try {

                    int userBetAmountInt = Integer.parseInt(userBetAmount);

                    if (userBetAmountInt > userAmount) {
                        System.out.println("Not enough money bet again.");
                    } else {

                        System.out.println(
                                "What is your bet lad Even, Odd, or try your luck and guess the exact number: ");
                        Scanner userBetIn = new Scanner(System.in);
                        String userBet = userBetIn.nextLine();

                        if (userBet.equalsIgnoreCase("Even")) {

                            if (randomNumberInRange % 2 == 0) {
                                userAmount += userBetAmountInt;
                                System.out.println(
                                        "✔️  Good guess"
                                                + "the number was "
                                                + randomNumberInRange
                                                + " you now have $"
                                                + userAmount);
                            } else {
                                userAmount -= userBetAmountInt;
                                System.out.println(
                                        "😞 wrong guess"
                                                + "the number was "
                                                + randomNumberInRange
                                                + " you now have $"
                                                + userAmount);
                            }

                        } else if (userBet.equalsIgnoreCase("Odd")) {

                            if (randomNumberInRange % 2 != 0) {
                                userAmount += userBetAmountInt;
                                System.out.println(
                                        "✔️  Good guess"
                                                + "the number was "
                                                + randomNumberInRange
                                                + " you now have $"
                                                + userAmount);
                            } else {
                                userAmount -= userBetAmountInt;
                                System.out.println(
                                        "😞 wrong guess"
                                                + "the number was "
                                                + randomNumberInRange
                                                + " you now have $"
                                                + userAmount);
                            }
                        } else {
                            try {
                                int userBetInt = Integer.parseInt(userBet);

                                if (userBetInt == randomNumberInRange) {

                                    userAmount += userBetAmountInt * 5;
                                    System.out.println(
                                            "✔️  Good guess"
                                                    + "the number was "
                                                    + randomNumberInRange
                                                    + " you now have $"
                                                    + userAmount);
                                } else {

                                    userAmount -= userBetAmountInt;
                                    System.out.println(
                                            "😞 wrong guess"
                                                    + "the number was "
                                                    + randomNumberInRange
                                                    + " you now have $"
                                                    + userAmount);
                                }
                            } catch (Exception e) {
                                System.out.println("Invalid choice try again");
                            }
                        }
                    }

                } catch (Exception e) {
                    System.out.println("Invalid choice try again");
                }
            }
        }
        System.out.println("\nGame over! You finished with $" + userAmount);
    }
}
