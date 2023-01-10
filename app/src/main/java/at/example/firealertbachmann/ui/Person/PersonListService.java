package at.example.firealertbachmann.ui.Person;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PersonListService {

    public static PersonListService instance = null;
    public ArrayList<Person> people = new ArrayList<Person>();

    private PersonListService()
    {
        PersonListAdd personListAdd = new PersonListAdd();
        personListAdd.addPeople(people);
    }

    public static PersonListService getInstance()
    {
        if(instance == null)
        {
            instance = new PersonListService();
        }
        return instance;
    }

    public List<Person> getFoundPeople()
    {
        return people.stream().filter(person -> person.IsFound == true).collect(Collectors.toList());
    }

    public List<Person> getMissingPeople()
    {
        return people.stream().filter(person -> person.IsFound == false).collect(Collectors.toList());
    }

    public void FoundPerson(Person person)
    {
        for (Person people:people)
        {
            Log.v("GETALL", people.Name);
        }
        for (Person people:getMissingPeople())
        {
            Log.v("GETMISSING", people.Name);
        }
        person.IsFound = true;
        for (Person people:getFoundPeople())
        {
            Log.v("GETFOUND", people.Name);
        }
    }

    public ArrayList<Person> getAllPeople()
    {
        return this.people;
    }

    public Person GetPersonByKeyNumber(String KeyNumber)
    {

        for (Person people:people)
        {
            if (people.KeyNumber.equals(KeyNumber))
            {
                return people;
            }
        }
        return null;
    }


}
