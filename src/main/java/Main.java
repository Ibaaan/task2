import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        System.out.println("№1 Введите n [0, ∞)");
        n = sc.nextInt();
        RandomArray.avgElement(n);
        System.out.println();

        System.out.println("№2 Введите n [0, ∞)");
        n = sc.nextInt();
        ListWork.bubbleSort(n);
        System.out.println();

        System.out.println("№3 ");
        EmployeeSort.sort();
        System.out.println();

        System.out.println("№4 ");
        HTTPRequest.headerRequest();
        System.out.println();


    }
}
