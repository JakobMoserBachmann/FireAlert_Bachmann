package at.example.firealertbachmann.ui.Person;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class PersonListAdd {
    LocalTime time = LocalTime.of(0, 0, 0);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public ArrayList<Person> addPeople(ArrayList<Person> peopleList)
    {
        peopleList.add(new Person("JAMO", false, "000763", time.format(formatter), false));
        peopleList.add(new Person("MCSA", false, "000765", time.format(formatter), false));
        peopleList.add(new Person("MASB", false, "000606", time.format(formatter), false));
        peopleList.add(new Person("TEST1", false, "000101", time.format(formatter), false));
        peopleList.add(new Person("TEST2", false, "000102", time.format(formatter), false));
        peopleList.add(new Person("TEST3", false, "000103", time.format(formatter), false));
        peopleList.add(new Person("TEST4", false, "000104", time.format(formatter), false));

        return peopleList;
    }
}
