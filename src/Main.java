import java.util.Random;

public class Main {


    private final static Random RANDOM = new Random();
    private final static String[] NAMES = {"Алексей", "Сергей", "Павел", "Василий", "Константин", "Петр", "Михаил", "Ипполит", "Андрей", "Борис"};
    private final static String[] SURNAMES = {"Алексеев", "Сергеев", "Павлов", "Васильев", "Константинов", "Петров", "Михаилов", "Ипполитов", "Андреев", "Борисов"};
    private final static String[] PATRONIMIC_NAMES = {"Алексеевич", "Сергеевич", "Павлович", "Васильевич", "Константинович", "Петрович", "Михаилович", "Ипполитович", "Андреевич", "Борисович"};

    public final static Employee[] EMPLOYEES = new Employee[10];

    public static void initEmployees() {
        for (int i = 0; i < EMPLOYEES.length; i++) {
            String fullName = SURNAMES[RANDOM.nextInt(0, SURNAMES.length)] + " " +
                    NAMES[RANDOM.nextInt(0, NAMES.length)] + " " +
                    PATRONIMIC_NAMES[RANDOM.nextInt(0, PATRONIMIC_NAMES.length)];
            EMPLOYEES[i] = new Employee(fullName, RANDOM.nextInt(1, 10), RANDOM.nextInt(30000, 100000));
        }

    }


    public static void main(String[] args) {
        initEmployees();
        print();
        System.out.println("Сумма ЗП сотрудников " + calculateSumOfSalaries());
        System.out.println("Сотрудник с минимальной зарплатой " + findEmployeeWithMinSalary());
        System.out.println("Сотрудник с максимальной зарплатой " + findEmployeeWithMaxSalary());
        System.out.println("Средняя ЗП " + calculateAverageOfSalaries());
        printFullName();
    }

    private static void print() {
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee);
        }
    }

    public static int calculateSumOfSalaries() {
        int sum = 0;
        for (Employee employee : EMPLOYEES) {
            sum += employee.getSalary();
        }
        return sum;
    }

    private static Employee findEmployeeWithMinSalary() {
        Employee employeeWithMinSalary = null;
        for (Employee employee : EMPLOYEES) {
            if (employeeWithMinSalary == null || employee.getSalary() < employeeWithMinSalary.getSalary()) {
                employeeWithMinSalary = employee;
            }
        }
        return employeeWithMinSalary;
    }
    private static Employee findEmployeeWithMaxSalary() {
        Employee employeeWithMaxSalary = null;
        for (Employee employee : EMPLOYEES) {
            if (employeeWithMaxSalary == null || employee.getSalary() > employeeWithMaxSalary.getSalary()) {
                employeeWithMaxSalary = employee;
            }
        }
        return employeeWithMaxSalary;
    }
    public static double calculateAverageOfSalaries() {
        return (double) calculateSumOfSalaries() / EMPLOYEES.length;
    }
    private static void printFullName() {
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee.getfullName());
        }
    }
}
