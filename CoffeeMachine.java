package machine;

import java.util.*;



public class CoffeeMachine {
    int water, milk, coffee, disCups, money;

    public CoffeeMachine() {
        water = 400;
        milk = 540;
        coffee = 120;
        disCups = 9;
        money = 550;
    }

    public static void main(String[] args) {
  
        Scanner scanner = new Scanner(System.in);
        // System.out.println("Starting to make a coffee\nGrinding coffee beans\nBoiling
        // water\nMixing boiled water with crushed coffee beans\nPouring coffee into the
        // cup\nPouring some milk into the cup\nCoffee is ready!");
        // System.out.println("Write how many cups of coffee you will need:");
        // int nCups = scanner.nextInt();
        // int water = nCups*200;
        // int milk = nCups*50;
        // int coffee = nCups *15;
        // System.out.println("For" + nCups + "cups of coffee you will need:\n" + water
        // + "ml of water\n" + milk +"ml of milk\n"+ coffee + "g of coffee beans");
        // int water, milk, coffee, disCups, money;

        // water=400;milk=540;coffee=120;disCups=9;money=550;
        CoffeeMachine machine = new CoffeeMachine();
        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String choice = scanner.next();
            switch (choice) {
                case "buy":
                    buyCoffee(scanner, machine);
                    break;

                case "fill":
                    fillMachine(scanner, machine);
                    break;
                case "take":
                    System.out.println("I gave you $" + machine.money);
                    machine.money = 0;

                    break;
                case "remaining":
                    machine.present(machine);
                    break;
                case "exit":
                    System.exit(0);
                    break;

            }
        } while (true);

        // System.out.println("Write how many ml of water the coffee machine has:");
        // water = scanner.nextInt();
        // System.out.println("Write how many ml of milk the coffee machine has:");
        // milk = scanner.nextInt();
        // System.out.println("Write how many grams of coffee beans the coffee machine
        // has:");
        // coffee = scanner.nextInt();
        // System.out.println("Write how many cups of coffee you will need:");
        // int nCups = scanner.nextInt();
        // possCups = isPossible(water, milk, coffee, nCups);
        // if (possCups == nCups) {
        // System.out.println("Yes, I can make that amount of coffee");
        // } else if (possCups > nCups) {
        // System.out.println(
        // "Yes, I can make that amount of coffee (and even " + (possCups - nCups) + "
        // more than that)");
        // } else {
        // System.out.println("No, I can make only " + possCups + " cup(s) of coffee");
        // }

    }

    // public static int isPossible(CoffeeMachine machine) {
    // // int possCups = 0;
    // // int reqWater = 200;
    // // int reqMilk = 50;
    // // int reqCoffee = 15;

    // // while ((water >= reqWater) && (milk >= reqMilk) && (coffee >= reqCoffee))
    // {
    // // possCups++;
    // // water -= reqWater;
    // // milk -= reqMilk;
    // // coffee -= reqCoffee;
    // // }
    // if()

    // // return possCups;

    // }

    public void present(CoffeeMachine machine) {
        System.out.println("The coffee machine has:\n" + machine.water + " of water\n" + machine.milk + " of milk\n"
                + machine.coffee + " of coffee beans\n" + machine.disCups + " of disposable cups\n" + "$"
                + machine.money + " of money");
    }

    public static void fillMachine(Scanner scanner, CoffeeMachine machine) {

        System.out.println("Write how many ml of water do you want to add: ");
        machine.water += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        machine.milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        machine.coffee += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        machine.disCups += scanner.nextInt();

    }

    public static void buyCoffee(Scanner scanner, CoffeeMachine machine) {
        int input;
        try {
            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
            input = scanner.nextInt();
          
            switch (input) {
                case 1:

                    if (machine.checkWater(machine, 250) && (machine.checkCoffee(machine, 16))) {
                        System.out.println("I have enough, making you a coffee!");
                        machine.water -= 250;
                        machine.coffee -= 16;
                        machine.money += 4;
                        machine.disCups -= 1;

                    }

                    break;

                case 2:

                    if ((machine.checkWater(machine, 350)) && (machine.checkMilk(machine, 75))
                            && (machine.checkCoffee(machine, 20))) {
                        System.out.println("I have enough resources, making you a coffee!");

                        machine.water -= 350;
                        machine.milk -= 75;
                        machine.coffee -= 20;
                        machine.money += 7;
                        machine.disCups -= 1;
                    }
                    break;
                case 3:
                    if ((machine.checkWater(machine, 200)) && (machine.checkMilk(machine, 100))
                            && (machine.checkCoffee(machine, 12))) {
                        System.out.println("I have enough resources, making you a coffee!");

                        machine.water -= 200;
                        machine.milk -= 100;
                        machine.coffee -= 12;
                        machine.money += 6;
                        machine.disCups -= 1;
                    }

                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Must be a number");
        }

    }

    public boolean checkWater(CoffeeMachine machine, int reqWater) {
        if (machine.water >= reqWater)
            return true;
        else {
            System.out.println("Sorry, not enough water!");
            return false;
        }
    }

    public boolean checkMilk(CoffeeMachine machine, int reqMilk) {
        if (machine.milk >= reqMilk)
            return true;
        else {
            System.out.println("Sorry, not enough milk!");
            return false;
        }
    }

    public boolean checkCoffee(CoffeeMachine machine, int reqCoffee) {
        if (machine.coffee >= reqCoffee)
            return true;
        else {
            System.out.println("Sorry, not enough coffee!");
            return false;
        }
    }

}
