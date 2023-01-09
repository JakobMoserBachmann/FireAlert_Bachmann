package at.example.firealertbachmann.ui.People;

import java.util.ArrayList;

public class PeopleListService {

    public static PeopleListService instance = null;
    public ArrayList<People> missingPeople = new ArrayList<People>();
    public ArrayList<People> foundPeople = new ArrayList<People>();


    private PeopleListService()
    {
        PeopleListAdd peopleListAdd = new PeopleListAdd();
        peopleListAdd.addPeople(missingPeople);
    }

    public static PeopleListService getInstance()
    {
        if(instance == null)
        {
            instance = new PeopleListService();
        }
        return instance;
    }

    public ArrayList<People> getFoundPeople()
    {
        return  this.foundPeople;
    }

    public ArrayList<People> getMissingPeople()
    {
        return this.missingPeople;
    }

    public void addFoundPeople(People people)
    {
        //foundPeople.add()
    }

}
