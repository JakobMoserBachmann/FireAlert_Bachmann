package at.example.firealertbachmann.ui.People;

import java.util.ArrayList;

public class PeopleListAdd {

    public ArrayList<People> addPeople(ArrayList<People> peopleList)
    {
        peopleList.add(new People("JAMO", false, 000763));
        peopleList.add(new People("MCSA", false, 000765));
        peopleList.add(new People("MCSA", false, 000420));

        return peopleList;
    }

}
