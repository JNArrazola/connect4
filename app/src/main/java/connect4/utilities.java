package connect4;

import java.util.Scanner;

public class utilities {
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

}
