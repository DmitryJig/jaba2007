package course2.homework3;

/**
 * Тут вызываем методы Телефонной книги
 */
public class Main {
    public static void main(String[] args) {

        PhoneBook1 phoneBook1 = new PhoneBook1();
        initPhoneBook(phoneBook1);
        System.out.println(phoneBook1.get("Жигалов"));
    }

    /**
     * Метод заполняет телефонную книгу
     * @param phoneBook1 объект телефонная книга
     */
    public static void initPhoneBook(PhoneBook1 phoneBook1) {

        phoneBook1.add("Жигалов", "322223");
        phoneBook1.add("Ivanov", "223322");
        phoneBook1.add("Petrov", "6486563727487");
        phoneBook1.add("Жигалов", "8(963)-018-22-44");
        phoneBook1.add("Жигалов", "322223"); // Пробуем внести дубликат
    }
}

