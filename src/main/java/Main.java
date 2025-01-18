import java.util.Scanner;

public class Main {
    private static final String ADMIN_LOGIN = "Admin@kpfu.com";
    private static final String ADMIN_PASSWORD = "abcd1234";
    private static final String USER_LOGIN1 = "AzatValiullin123@gmail.com";
    private static final String USER_PASSWORD1 = "abcdf12345.уч";


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
                Role role = userCheck(login, password);

                if (role != null) {
                    displayMenu(role);
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

    public static Role userCheck(String login, String password) throws WrongLoginException, WrongPasswordException {
        if (!isValidLogin(login)) {
            throw new WrongLoginException("Login должен содержать не менее 20 символов: латинскиx букв прописных и строчных, цифр и символов @ . _ -\n\n");
        }

        if (!isValidPassword(password)) {
            throw new WrongPasswordException("Password должен содержать не менее 8 символов: латинские буквы, цифры и {}[](),.;&?!_-+\n");
        }

        if (login.equals(ADMIN_LOGIN) && password.equals(ADMIN_PASSWORD)) {
            return Role.ADMIN;
        } else if (login.equals(USER_LOGIN1) && password.equals(USER_PASSWORD1)) {
            return Role.USER;
        }
        return null;
    }

    private static boolean isValidLogin(String login) {
        return login.length() >= 20 && login.matches("[a-zA-Z0-9@._-]+");
    }

    private static boolean isValidPassword(String password) {
        return password.length() >= 8 && password.matches("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[{}\\[\\](),.;&?!_\\-+]).{8,}$");
    }

    private static void displayMenu(Role role) {
        switch (role) {
            case ADMIN:
                System.out.println("\n--- ADMIN MENU ---");
                System.out.println("1. File");
                System.out.println("2. Create new user");
                System.out.println("3. Exit");
                break;

            case USER:
                System.out.println("\n--- USER MENU ---");
                System.out.println("1. File");
                System.out.println("2. Get play list");
                System.out.println("3. Exit");
                break;
        }
    }
}