package connect4;

import java.util.Scanner;

public class Utilities {
    private static final Scanner in = new Scanner(System.in);

    public static int validateNumberBoard(){
        int number;
        do {
            try {
                number = Integer.parseInt(in.nextLine());
                if(number<4||number>9)
                    System.out.println("Número no válido");
                else break;
            } catch (Exception e) {
                System.out.println("Ingresa un número valido\n");
            }
        } while (true);
        return number;
    }

    public static int validateNumber(){
        int number;
        do {
            try {
                number = Integer.parseInt(in.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Ingresa un número valido\n");
            }
        } while (true);
        return number;
    }

    public static String validateString(){
        String string;
        do {
            try {
                string = in.nextLine();

                if(string.isEmpty())
                    System.out.println("No puedes dejar un string vacío");
                else break;
            } catch (Exception e) {
                System.out.println("Ingresa un String válido");
            }
        } while (true);
        return string;
    }

    public static void sleep(int miliseconds){
        try {
            Thread.sleep(miliseconds); 
        } catch (Exception e) {}
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  
}
