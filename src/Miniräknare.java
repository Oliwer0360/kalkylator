import java.util.Scanner;

public class Miniräknare {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Miniräknare");

        int svar;   //Ta emot använderns input från "avsluta" metoden
        boolean avsluta = false;

        while (!avsluta) {
            double talSvar;
            String räknesätt = räknesätt(input);   //Hämtar vilket räknesätt som är valt från "räknesätt" metoden
            double[] userInput = tal(input, räknesätt);    //Hämtar dem valda talen från "tal" metoden, och skickar räknesätt till "tal" metoden

            switch (räknesätt) {
                case "+":
                    talSvar = Addition(userInput[0], userInput[1]);
                    System.out.printf("%.2f\n", talSvar);
                    break;

                case "-":
                    talSvar = Subtraktion(userInput[0], userInput[1]);
                    System.out.printf("%.2f\n", talSvar);
                    break;

                case "*":
                    talSvar = Multiplikation(userInput[0], userInput[1]);
                    System.out.printf("%.2f\n", talSvar);
                    break;

                case "/":
                    talSvar = Division(userInput[0], userInput[1]);
                    System.out.printf("%.2f\n", talSvar);
                    break;
            }
            svar = avsluta(input);  //Tar emot använderns input från "avsluta" metoden
            if (svar == 2) {
                avsluta = true; //Avslutar loopen så programmet stängs av
            } else if (svar != 1) {
                System.out.println("Ogiltigt svar! Försök igen.");
            }
        }
        System.out.println("\nAvslutar programmet");
    }

    //Välj räknesätt
    public static String räknesätt(Scanner input) {
        String räknesätt;
        while (true) {
            System.out.println("\nVilket räknesätt vill du använda? + - * /");
            räknesätt = input.nextLine();
            if (räknesätt.equals("+") || räknesätt.equals("-") || räknesätt.equals("*") || räknesätt.equals("/")) {
                break;
            } else {
                System.out.println("Ogiltigt svar! Försök igen.");
            }
        }
        return räknesätt;
    }

    //Välj tal
    public static double[] tal(Scanner input, String räknesätt) {
        double[] userInput = new double[2]; //Array för att kunna lagra sedan skicka användarens input till main metoden

        while (true){
            System.out.println("\nSkriv in första talet: ");
            if (input.hasNextDouble()){
                userInput[0] = input.nextDouble();
                input.nextLine();
                break;
            } else {
                System.out.println("Ogiltigt svar! Försök igen.");
                input.nextLine();   //Rensa scanner vid fel input
            }
        }

        //Loop för att förhindra att användaren fösöker dela med 0
            while (true){
                System.out.println("\nSkriv in andra talet: ");
                if (input.hasNextDouble()){
                    userInput[1] = input.nextDouble();
                    input.nextLine();
                    if (räknesätt.equals("/") && userInput[1] == 0) {
                        System.out.println("Ogiltigt svar! Du kan ej dividera med 0.");
                    } else {
                        break;
                    }
                } else {
                    System.out.println("Ogiltigt svar! Försök igen.");
                    input.nextLine();   //Rensa scanner vid fel input
                }
            }
        return userInput;   //Returnerar array med användarens inputs
    }


    //Räkne operationer

    public static double Addition(double a, double b) {   //Addition
        return a + b;
    }

    public static double Subtraktion(double a, double b) {   //Subtraktion
        return a - b;
    }

    public static double Multiplikation(double a, double b) {   //Multiplikation
        return a * b;
    }

    public static double Division(double a, double b) {   //Division
        return a / b;
    }

    public static int avsluta(Scanner input) {   //Metod för att avsluta eller fortsätta programmet
        int svar = 0;

        while (true) {
            System.out.println("\nVälj 1 eller 2.");
            System.out.println("1. Nytt tal");
            System.out.println("2. Avsluta miniräknaren");

            if (input.hasNextInt()) {   //hasNextInt kollar så inputen är en int
                svar = input.nextInt();
                input.nextLine();
                if (svar == 1 || svar == 2) {   //Fortsätter koden tills användaren skrivit 1 eller 2
                    break;
                } else {
                    System.out.println("Ogiltigt svar! Försök igen.");
                }
            } else {
                System.out.println("Ogiltigt svar! Försök igen.");
                input.nextLine();   //Rensa scanner vid fel input
            }
        }
        return svar;
    }

}