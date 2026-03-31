import java.util.ArrayList;
import java.util.List;

//Задание №3. Stream API.

//2. Найти среднюю зарплату всех сотрудников отдела в указанном
//департаменте.

//Выходные данные: в консоль напечатан результат выполнения задания.
//Объекты должны быть напечатаны в читаемом виде.
public class EmployeeSort {
    public static void sort() {
        List<Employee> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Employee e = new Employee();
            e.setAge(i + 20);
            e.setFullName(i + "ovich");
            e.setDepartment(i + "ment of buisness");
            e.setSalary(i * 10000);
            list.add(e);
        }

        double avgSalary = list.stream()
                .mapToInt(Employee::getSalary)  // or .mapToInt(p -> p.getAge())
                .average()
                .orElse(0.0);

        list.forEach(System.out::println);
        System.out.println("Средняя зарплата: " + avgSalary);
    }
}
