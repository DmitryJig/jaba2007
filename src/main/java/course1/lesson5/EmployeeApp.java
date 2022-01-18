package course1.lesson5;

import java.util.Arrays;

public class EmployeeApp {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Иванов Иван Иванович","Big Boss", "ivanoff@gmail.com", "322223", 3000000, 30);
        employees[1] = new Employee("Сидоров Сидор Сидорович","Программист", "sidorov@gmail.com", "223322", 300000, 35);
        employees[2] = new Employee("Петров Петр Петрович","бухгалтер", "ivanoff@gmail.com", "+75464533345", 2000000, 39);
        employees[3] = new Employee("Жан Клод Вандам","Охранник", "vamdam@gmail.com", "+732234567786", 25000, 50);
        employees[4] = new Employee("Шифер Клавдия Ивановна","Уборщица", "shiffer@gmail.com", "нет телефона", 15000, 60);

        printOldEmployees(employees, 40);

        printOldEmployees2(employees, 40);
    }

    /**
     * Метод выводит информацию о сотрудниках старше "limitAge" лет
     * @param employees массив сотрудников
     * @param limitAge возраст, старше которого надо вывести информацию
     */
    public static void printOldEmployees(Employee[] employees, int limitAge) {
        for (Employee employee: employees) {
            if (employee.getAge() >= limitAge) {
                employee.employeeInfo();
            }
        }
    }

    // решение через стрим
    public static void printOldEmployees2(Employee[] employees, int limitAge) {
        Arrays.stream(employees).filter(x -> x.getAge() >= limitAge).forEach(x -> x.employeeInfo());
    }
}
