import java.util.Scanner;


public class Main {

    static User userAdmin = new User("abcdf12345.", "AzatValiullin123@gmail.com", Role.ADMIN);
    static User userUser = new User("abcdf12345.", "UnknownUzer123@gmail.com", Role.USER);


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Введите логин или введите 'exit' для выхода: ");
            String login = scanner.nextLine();

            if (login.equalsIgnoreCase("exit")) {
                System.out.println("Программа завершена, будем ждать вас! ");
                break;
            }

            System.out.print("Введите пароль: ");
            String password = scanner.nextLine();

            try {
                Role role = Tools.userCheck(login, password);

                if (role != null) {
                    Tools.displayMenu(role);
                } else {
                    System.out.println("Неправильный логин или пароль, попробуйте еще раз!\n");
                }

            } catch (WrongLoginException e) {
                System.out.println("Ошибка: " + e.getMessage());
            } catch (WrongPasswordException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }

        }

        scanner.close();
    }
}