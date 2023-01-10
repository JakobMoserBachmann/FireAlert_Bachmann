package at.example.firealertbachmann.ui.Person;

import java.util.ArrayList;

public class PersonListAdd {

    public ArrayList<Person> addPeople(ArrayList<Person> peopleList)
    {
        peopleList.add(new Person("JAMO", false, "000763"));
        peopleList.add(new Person("MCSA", false, "000765"));
        peopleList.add(new Person("MASB", false, "000606"));
        peopleList.add(new Person("TEST1", false, "000101"));
        peopleList.add(new Person("TEST2", false, "000102"));
        peopleList.add(new Person("TEST3", false, "000103"));
        peopleList.add(new Person("TEST4", false, "000104"));

        return peopleList;
    }
}
