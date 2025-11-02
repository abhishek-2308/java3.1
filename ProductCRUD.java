import java.util.*;

class Product {
    int id;
    String name;
    double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + price;
    }
}

public class ProductCRUD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n=== Product Management System ===");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    products.add(new Product(id, name, price));
                    System.out.println("✅ Product added!");
                    break;

                case 2:
                    System.out.println("\nAll Products:");
                    for (Product p : products) System.out.println(p);
                    break;

                case 3:
                    System.out.print("Enter ID to Update: ");
                    int uid = sc.nextInt();
                    boolean found = false;
                    for (Product p : products) {
                        if (p.id == uid) {
                            System.out.print("Enter new price: ");
                            p.price = sc.nextDouble();
                            System.out.println("✅ Product updated!");
                            found = true;
                            break;
                        }
                    }
                    if (!found) System.out.println("❌ Product not found!");
                    break;

                case 4:
                    System.out.print("Enter ID to Delete: ");
                    int did = sc.nextInt();
                    products.removeIf(p -> p.id == did);
                    System.out.println("✅ Product deleted!");
                    break;

                case 5:
                    System.out.println("Exiting... 👋");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }
}
