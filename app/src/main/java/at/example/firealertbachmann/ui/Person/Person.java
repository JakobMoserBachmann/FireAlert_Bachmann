package at.example.firealertbachmann.ui.Person;



public class Person
{
    public Person(String name, Boolean isFound, String keyNumber, String uhrzeit, Boolean checkBox) {
        Name = name;
        KeyNumber = keyNumber;
        IsFound = isFound;
        Uhrzeit = uhrzeit;
        CheckBox = checkBox;
    }

    String Name;
    Boolean CheckBox;
    Boolean IsFound;
    String KeyNumber;
    String Uhrzeit;
}