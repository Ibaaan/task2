import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("№1 Введите n [0, ∞)");
        int n = sc.nextInt();
        RandomArray.avgElement(n);
        System.out.println();


    }
}
