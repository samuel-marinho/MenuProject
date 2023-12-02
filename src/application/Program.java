package application;
import entities.Foods;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        System.out.println("Enter how many itens do you want to add? ");
        int n = sc.nextInt();
        List <Foods> list = new ArrayList<>();

        // Para percorrer o número de itens que o usuário digitar, usamos a estrutura for
        // logo após, instacia o objeto para receber as informações dadas pelo usuário.

        for (int i=0; i<n; i++){
            System.out.println("Insert ID: ");
            Integer id = sc.nextInt();
            System.out.println("Insert the name of the food: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.println("Insert the price: ");
            Double price = sc.nextDouble();
            Foods menu = new Foods(id, name, price);
            list.add(menu);
        }
        System.out.println();
        String answer;
        do {
            System.out.println("Enter the plate will have a promotion: ");
            Integer idFood = sc.nextInt();
            Integer pos = position(list, idFood);
            if (pos == null) {
                System.out.println("This ID doesn't exist");
            } else {
                System.out.println("Enter the percentage: ");
                double percent = sc.nextDouble();
                list.get(pos).promotion(percent);
            }
            System.out.println();
            System.out.println("Do you want to change another plate? [Y/N] ");
            sc.nextLine();
            answer = sc.nextLine();
        }
        while (answer!="N");
        sc.close();

    }
    public static Integer position (List<Foods> list, int id){
        for (int i=0; i< list.size(); i++){
            if (list.get(i).getId() == id){
                return i;
            }
        }
        return null;
    }
}
