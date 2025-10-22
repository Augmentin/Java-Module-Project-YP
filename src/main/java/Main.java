import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int participantsNumber = 3;
        while (true) {
            try {
                System.out.println("Привет! Эта программа для расчета лидера в гонки 24 часа Ле-Мана.");
                System.out.println("Необходимо ввести название и скорость 3-х участников гонки.");
                Race race = new Race();
                Car leader = null;
                for (int i = 1; i <= participantsNumber; i++) {
                    leader = race.getLeader(getCarFromInput(i));
                }
                System.out.println("Самая быстрая машина: " + leader.name);
                System.out.println("Заного? да/нет");
                String continueAnswer = scanner.next();
                if (!Arrays.asList(new String[]{ "да", "lf", "y", "yes"}).contains(continueAnswer.trim().toLowerCase())) {
                    System.out.println("До свидания");
                    break;
                }
            } catch (Throwable e) {
                System.out.println("Что-то пошло не так :(");
                throw e;
            }
        }
    }


    private static Car getCarFromInput(int carNumber) {
        Car car;
        String name;
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Введите имя машины №" + carNumber);
            name = scanner.nextLine();
            if(name.trim().isEmpty()){
                System.out.println("Введите не пустое значение");
            }else {
                break;
            }
        }
        while (true) {
            System.out.println("Введите скорость машины №" + carNumber);
            if (scanner.hasNextInt()) {
                int speed = scanner.nextInt();
                if (0 < speed && speed <= 250) {
                    name = name.trim();
                    car = new Car(name, speed);
                    System.out.println("Машина с именем " + car.name + " зарегистрирована! Ее скорость: " + car.speed);
                    break;
                } else {
                    System.out.println("Скорость должна быть больше 0 и меньше или равна 250");
                }
            } else {
                System.out.println("Введите корректное значение скорости");
                scanner.next();
            }
        }

        return car;
    }
}
