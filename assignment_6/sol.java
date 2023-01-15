package assignment_6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sol {
    static class FastReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            try {
                while (!st.hasMoreTokens())
                    st = new StringTokenizer(br.readLine());
            } catch (Exception err) {
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String ln = "";
            try {
                ln = br.readLine();
            } catch (Exception err) {
            }
            return ln;
        }
    }

    static FastReader fr = new FastReader();

    public static void main(String[] args) throws Exception {
        int employeeId = fr.nextInt();
        String employeeName = fr.nextLine();
        String depatment = fr.nextLine();
        Employee nemp;
        if (employeeId % 2 == 0) {
            double monthlySalary = fr.nextDouble();
            nemp = new PermanentEmployee(employeeId, employeeName, depatment, monthlySalary);
        } else {
            int contractPeriod = fr.nextInt();
            double contractAmt = fr.nextDouble();
            nemp = new ContractEmployee(employeeId, employeeName, depatment, contractPeriod, contractAmt);
        }
        System.out.println(nemp);

    }
}

class Employee implements Comparable<Employee> {
    private int employeeId;
    private String employeeName;
    private String department;

    public Employee(int employeeId, String employeeName, String department) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.department = department;
    }

    int getEmpoyeeId() {
        return this.employeeId;
    }

    String getEmployeeName() {
        return this.employeeName;
    }

    String getDepartment() {
        return this.department;
    }

    void setEmployeeId(int _emId) {
        this.employeeId = _emId;
    }

    void setEmployeeName(String _empName) {
        this.employeeName = _empName;
    }

    void setDepartment(String _department) {
        this.department = _department;
    }

    double calculateTax() {
        return 0;
    };

    @Override
    public String toString() {
        return String.format("%-10s %-20s %-15s", employeeId, employeeName, department);
    }

    @Override
    public int compareTo(Employee o) {
        if (this.employeeId == o.employeeId)
            return 0;
        return this.employeeId > o.employeeId ? 1 : -1;
    }
}

class PermanentEmployee extends Employee {
    private double monthlySalary;
    private double pf;
    private double tax;

    PermanentEmployee(int employeeId, String employeeName, String department, double monthlySalary) {
        super(employeeId, employeeName, department);
        this.monthlySalary = monthlySalary;
        this.pf = 0.15 * monthlySalary;
        this.tax = this.calculateTax();
    }

    @Override
    double calculateTax() {
        return (0.1 * monthlySalary * 12);
    }

    @Override
    public String toString() {
        return String.format("%-15s %-15s", pf, tax);
    }
}

class ContractEmployee extends Employee {
    private int contarctPeriod;
    private double contractAmt;
    private double tax;

    ContractEmployee(int employeeId, String employeeName, String department, int contractPeriod, double contractAmt) {
        super(employeeId, employeeName, department);
        this.contarctPeriod = contractPeriod;
        this.contractAmt = contractAmt;
        this.tax = this.calculateTax();
    }

    public int getContarctPeriod() {
        return contarctPeriod;
    }

    public void setContarctPeriod(int contarctPeriod) {
        this.contarctPeriod = contarctPeriod;
    }

    public double getContractAmt() {
        return contractAmt;
    }

    public void setContractAmt(double contractAmt) {
        this.contractAmt = contractAmt;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    @Override
    double calculateTax() {
        return (0.1 * contractAmt);
    }

    @Override
    public String toString() {
        return String.format("%-15s %-15s", contarctPeriod, contractAmt);
    }
}
