import java.util.Scanner;

import static java.lang.Thread.sleep;

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

        System.out.println("№5");
        FileDownload fd = new FileDownload();
        fd.start();
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        fd.stop();
    }
}
