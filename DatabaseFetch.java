import java.util.*;

class DatabaseFetch {
    public static void main(String[] args) {
        // Simulated database (ArrayList instead of MySQL table)
        List<String> students = Arrays.asList("Abhishek", "Ankitha", "Ravi", "Sneha");

        System.out.println("Connected to Database Successfully ✅");
        System.out.println("Fetching data from Student table...\n");

        for (String s : students) {
            System.out.println("Student Name: " + s);
        }
    }
}
