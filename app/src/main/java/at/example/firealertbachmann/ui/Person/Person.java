package at.example.firealertbachmann.ui.Person;

import java.util.Date;

public class Person
{
    public Person(String name, Boolean isFound, String keyNumber, String uhrzeit) {
        Name = name;
        KeyNumber = keyNumber;
        IsFound = isFound;
        Uhrzeit = uhrzeit;
    }

    String Name;
    Boolean IsFound;
    String KeyNumber;
    String Uhrzeit;
}