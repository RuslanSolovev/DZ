package DZgonka.MainAndRace;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();
        List<Integer> speeds = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            System.out.println("Введите название автомобиля " + i + ":");
            String name = scanner.nextLine();

            int speed;
            while (true) {
                System.out.println("Введите скорость автомобиля " + i + " (от 1 до 250):");
                speed = scanner.nextInt();
                scanner.nextLine();

                if (speeds.contains(speed)) {
                    System.out.println("Такая скорость уже была введена! Введите другую скорость.");
                    continue;
                }

                if (speed > 0 && speed <= 250) {
                    speeds.add(speed);
                    break;
                }

                System.out.println("Неверная скорость! Попробуйте снова.");
            }
            Car car = new Car(name, speed);
            race.checkLeader(car);
        }

        System.out.println("Самая быстрая машина: " + race.getLeaderName());
        scanner.close();
    }

    public static class Race {
        private Car leader;

        public void checkLeader(Car car) {
            if (leader == null || car.calculateDistance() > leader.calculateDistance()) {
                leader = car;
            }
        }

        public String getLeaderName() {
            return leader != null ? leader.getName() : "Нет лидера";
        }
    }
}
