import java.util.Scanner;


public class Main {

    static User userAdmin = new User("abcdf12345.", "AzatValiullin123@gmail.com", Role.ADMIN);
    static User userUser = new User("abcdf12345.", "UnknownUzer123@gmail.com", Role.USER);


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter login or type 'exit' to exit: ");
            String login = scanner.nextLine();

            if (login.equalsIgnoreCase("exit")) {
                System.out.println("The program is over, buy");
                break;
            }

            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            try {
                Role role = Tools.userCheck(login, password);

                if (role != null) {
                    Tools.displayMenu(role);
                } else {
                    System.out.println("Incorrect login or password, try again!\n");
                }

            } catch (WrongLoginException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (WrongPasswordException e) {
                System.out.println("Error: " + e.getMessage());
            }

        }

        scanner.close();
    }
}