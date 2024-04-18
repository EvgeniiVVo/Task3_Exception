package Models;

import java.io.IOException;
import java.text.SimpleDateFormat;

public class Person {

    /** Фамилия */
    private String lastName;
    /** Имя */
    private String name;
    /** Отчество */
    private String middleName;
    /** Дата рождения */
    private String dateOfBirth;
    /** Номер телефона */
    private String phone;
    /** Пол */
    private String sex;


    /**
     * Метод возвращает фамилию человека
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Метод изменения фамилии человека
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Метод возвращает имя человека
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Метод изменения имени человека
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Метод возвращает отчество человека
     * @return
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Метод изменения отчества человека
     * @param middleName
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * Метод возвращает дату рождения человека (в формате  dd.mm.yyyy)
     * @return
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Метод изменения даты рождения человека (в формате  dd.mm.yyyy)
     * @param dateOfBirth
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Метод возвращает номер телефона человека
     * @return
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Метод изменения номера телефона человека
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Метод возвращает пол человека
     * @return
     */
    public String getSex() {
        return sex;
    }

    /**
     * Метод изменения пола человека
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    public static Person Create(String lastName, String name, String middleName, String dateOfBirth, String phone, String sex) throws IOException {
        validateDateOfBirth(dateOfBirth);
        validatePhone(phone);
        validateSex(sex);
        return new Person(lastName, name, middleName, dateOfBirth, phone, sex);
    }

    private Person(String lastName, String name, String middleName, String dateOfBirth, String phone, String sex) {
        this.lastName = lastName;
        this.name = name;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "ИНформация о пользователе: [Фамилия = " + lastName + ", Имя = " + name + ", Отчество = " + middleName + ", Дата рождения = "
                + dateOfBirth + ", Номер телефона = " + phone + ", Пол = " + sex + "]";
    }


    private static void validateDateOfBirth(String dateOfBirth) throws IOException {
        try {
            new SimpleDateFormat("dd.MM.yyyyy").parse(dateOfBirth);
        } catch (Exception e) {
            throw new IOException("Неверный формат даты рождения. Повторите ввод. Введите данные в формате День.Месяц.Год");
        }
    }

    private static void validatePhone(String phone) throws IOException {
        try {
            Integer.parseUnsignedInt(phone);
        } catch (NumberFormatException e) {

            throw new IOException("Неверный формат номера телефона. Повторите ввод. Номер телефона не может быть меньше нуля и больше 65535");
        }
    }

    private static void validateSex(String sex) throws IOException {
        if (sex.equals("f")) return;
        else if (sex.equals("m")) return;
        else throw new IOException("Неверно указан пол. Повторите ввод. Укажите пол, где f - женщина, m - мужчина");
    }
}