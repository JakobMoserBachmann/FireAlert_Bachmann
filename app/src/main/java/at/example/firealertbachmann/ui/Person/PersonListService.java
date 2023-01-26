package at.example.firealertbachmann.ui.Person;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PersonListService {

    public static PersonListService instance = null;
    private ArrayList<Person> people = new ArrayList<>();

    private PersonListService() {}

    public void addPerson(String name,String keyNumber){
        Person person = new Person();

        person.setName(name);
        person.setKeyNumber(keyNumber); ;

        people.add(person);
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
        return people.stream().filter(person -> person.isFound()).collect(Collectors.toList());
    }

    //Gets all Missing People
    public List<Person> getMissingPeople()
    {
        return people.stream().filter(person -> !person.isFound()).collect(Collectors.toList());
    }

    public void clearList(){
        people.clear();
    }

    //Resets all People to Missing Only to Test
    public void SetBackPeople()
    {
        for (Person person:getFoundPeople())
        {
            person.setFound(false);
        }
    }

    //Sets the Person to found
    public void foundPerson(Person person)
    {
        LocalTime time = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        person.setUhrzeit(time.format(formatter));
        person.setFound(true);
    }

    //Gets one specific Person filtered by the Key number
    public Person getPersonByKeyNumber(String KeyNumber)
    {
        for (Person people:people)
        {
            if (people.getKeyNumber().equals(KeyNumber))
            {
                return people;
            }
        }
        return null;
    }
}
