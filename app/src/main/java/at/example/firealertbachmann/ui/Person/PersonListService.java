package at.example.firealertbachmann.ui.Person;

import android.os.Build;
import android.util.Log;
import androidx.annotation.RequiresApi;
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


    //Gets all Found People

    public List<Person> getFoundPeople()
    {
        return people.stream().filter(person -> person.IsFound == true).collect(Collectors.toList());
    }


    //Gets all Missing People


    public List<Person> getMissingPeople()
    {
        return people.stream().filter(person -> person.IsFound == false).collect(Collectors.toList());
    }


    //Resets all People to Missing Only to Test
    public void SetBackPeople()

    public void FoundPerson(Person person)

    {
        for (Person person:getFoundPeople())
        {
            person.IsFound = false;
        }
    }

    //Sets the Person to found
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
        }    }

    //Gets all People
    public ArrayList<Person> getAllPeople()
    {
        return this.people;
    }

    //Gets one specific Person filtered by the Key number
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
