    import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DoctorManagementService service = new DoctorManagementService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Doctor Management System");
            System.out.println("1. Add Doctor");
            System.out.println("2. Find Doctor by ID");
            System.out.println("3. Remove Doctor by ID");
            System.out.println("4. List All Doctors");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Doctor ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // consume the newline
                    System.out.print("Enter Doctor Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Doctor Specialization: ");
                    String specialization = scanner.nextLine();
                    System.out.println(service.addDoctor(id, name, specialization));
                    break;

                case 2:
                    System.out.print("Enter Doctor ID to find: ");
                    int findId = scanner.nextInt();
                    System.out.println(service.findDoctorById(findId));
                    break;

                case 3:
                    System.out.print("Enter Doctor ID to remove: ");
                    int removeId = scanner.nextInt();
                    System.out.println(service.removeDoctorById(removeId));
                    break;

                case 4:
                    System.out.println("List of Doctors:");
                    for (Doctor d : service.listDoctors()) {
                        System.out.println(d);
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid option. Please choose again.");
                    break;
            }
        }
    }
}
