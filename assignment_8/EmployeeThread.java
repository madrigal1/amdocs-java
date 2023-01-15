package assignment_8;

import java.util.concurrent.ForkJoinPool;

public class EmployeeThread implements Runnable {
    private String name;
    private double salary;

    public EmployeeThread(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public void run() {
        System.out.println("Employee " + name + " has a salary of $" + salary);
    }

    public static void main(String[] args) {
        // Create an array of EmployeeThread objects
        EmployeeThread[] employees = new EmployeeThread[5];
        employees[0] = new EmployeeThread("Alice", 45000);
        employees[1] = new EmployeeThread("Bob", 50000);
        employees[2] = new EmployeeThread("Charlie", 55000);
        employees[3] = new EmployeeThread("Dave", 60000);
        employees[4] = new EmployeeThread("Eve", 65000);

        // Create a ForkJoinPool and execute the EmployeeThreads
        ForkJoinPool pool = new ForkJoinPool();
        for (EmployeeThread employee : employees) {
            pool.execute(employee);
        }
        pool.close();
    }
}
