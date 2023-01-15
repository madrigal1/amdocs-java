package assignment_7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
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
        int n = fr.nextInt();
        ArrayList<Product> arr = new ArrayList<>();
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String[] input = fr.nextLine().split(",");
            if (input.length != 5)
                throw new Exception("5 comma seprated fields required");
            Integer id = Integer.parseInt(input[0]);
            String name = input[1];
            Double purchasePrice = Double.parseDouble(input[2]);
            Double salesPrice = Double.parseDouble(input[3]);
            String grade = input[4];
            if (!grade.equals("N") && !grade.equals("E"))
                throw new GradeMismatchException();
            if (salesPrice <= purchasePrice)
                throw new PriceException();
            if (grade == "E" && salesPrice > purchasePrice * 1.25)
                throw new EssentialCommodityException();
            if (s.contains(id))
                continue;
            s.add(id);
            arr.add(new Product(id, name, purchasePrice, salesPrice, grade));
        }
        for (Product p : arr)
            System.out.println(p);
    }
}

class Product {
    private int id;
    private String name;
    private Double purchasePrice;
    private Double salesPrice;
    private String grade;

    public Product(int id, String name, Double purchasePrice, Double salesPrice, String grade) {
        this.id = id;
        this.name = name;
        this.purchasePrice = purchasePrice;
        this.salesPrice = salesPrice;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(Double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return String.format("%-5s %-20s %-10s %-10s %-5s", id, name, purchasePrice, salesPrice, grade);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((purchasePrice == null) ? 0 : purchasePrice.hashCode());
        result = prime * result + ((salesPrice == null) ? 0 : salesPrice.hashCode());
        result = prime * result + ((grade == null) ? 0 : grade.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (purchasePrice == null) {
            if (other.purchasePrice != null)
                return false;
        } else if (!purchasePrice.equals(other.purchasePrice))
            return false;
        if (salesPrice == null) {
            if (other.salesPrice != null)
                return false;
        } else if (!salesPrice.equals(other.salesPrice))
            return false;
        if (grade == null) {
            if (other.grade != null)
                return false;
        } else if (!grade.equals(other.grade))
            return false;
        return true;
    }
}

class PriceException extends Exception {
    public PriceException() {
        super("Sales Price Lower than Purchase Price");
    }
}

class EssentialCommodityException extends Exception {
    public EssentialCommodityException() {
        super("Essential Commodity cannot be 25% more than purchase price");
    }
}

class GradeMismatchException extends Exception {
    public GradeMismatchException() {
        super("grade is not N or E");
    }
}