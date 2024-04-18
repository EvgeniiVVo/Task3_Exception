import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import Models.Person;

public class Program {

    public static void main(String[] args) throws IOException {

        System.out.println();
        System.out.println("Пожалуйста, введите данные для нового пользователя.\n" +
                "Вводите данные через запятую: " +
                "Фамилия, Имя, Отчество, дата рождения в формате (дд.мм.гггг), номер телефона в формате (99123), пол, где f - женщина, m - мужчина\n" +
                "Например: Иванов, Иван, Иванович, 01.01.1990, 65535, m");

        try (Scanner input = new Scanner(System.in, "Cp866")) {
            String[] personData = input.nextLine().split(",");
            if (personData.length <= 0 || personData.length != 6) {
                if (personData.length <= 0) {
                    throw new ArrayIndexOutOfBoundsException(
                            "Введенно количество данных меньше, чем ожидалось. Повторите ввод. Например: Иванов, Иван, Иванович, 01.01.1990, 65535, m");
                } else if (personData.length != 6) {
                    throw new ArrayIndexOutOfBoundsException(
                            "Введенно количество данных больше, чем ожидалось. Повторите ввод. Например: Иванов, Иван, Иванович, 01.01.1990, 65535, m");
                }
            } else {
                String lastName = personData[0].trim();
                String name = personData[1].trim();
                String middleName = personData[2].trim();
                String dateOfBirth = personData[3].trim();
                String phone = personData[4].trim();
                String sex = personData[5].trim();

                try {
                    Person person = Person.Create(lastName, name, middleName, dateOfBirth, phone, sex);
                    try (FileWriter writer = new FileWriter(lastName + ".txt", true)) {
                        //writer.println(person);
                        writer.write(person.toString() + "\n");

                    } catch (Exception e) {
                        System.out.println("Во время создания файла с данными пользователя произошла ошибка. Описание ошибки: "
                                + e.getMessage());
                    }
                } catch (Exception e) {
                    System.out.println("Ошибка ввода данных. Описание ошибки: " + e.getMessage());
                }
            }
        }
    }
}