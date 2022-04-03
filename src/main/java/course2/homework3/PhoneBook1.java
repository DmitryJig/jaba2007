package course2.homework3;

import java.util.*;

/**
 * Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и
 * телефонных номеров. В этот телефонный справочник с помощью метода add() можно
 * добавлять записи, а с помощью метода get() искать номер телефона по фамилии. Следует
 * учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
 * тогда при запросе такой фамилии должны выводиться все телефоны. Желательно не добавлять
 * лишний функционал (дополнительные поля (имя, отчество, адрес), взаимодействие с пользователем
 * через консоль и т.д). Консоль использовать только для вывода результатов проверки телефонного
 * справочника
 */
public class PhoneBook1 {
    private final Set<Person> persons = new TreeSet<>();

    public void add(String lastName, String phone) {
        persons.add(new Person(lastName, phone.replaceAll("[^0-9]", "")));
    }
    // Возвращаем коллекцию потому что могут быть совпадения фамилий
    public List<String> get(String lastName) {
        List<String> phones = new ArrayList<>();
        for (Person person : persons
        ) {
            if (person.getLastName().equals(lastName)) {
                phones.add(person.getPhoneNumber());
            }
        }
        return phones;
    }
}

class Person implements Comparable<Person> {
    private final String lastName;
    private final String phoneNumber;

    public Person(String lastName, String phoneNumber) {
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(lastName, person.lastName) && Objects.equals(phoneNumber, person.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, phoneNumber);
    }

    @Override
    public int compareTo(Person o) {
        if (this.lastName.equals(o.lastName)){
            return this.phoneNumber.compareTo(o.phoneNumber);
        }
        return this.lastName.compareTo(o.getLastName());
    }
}
