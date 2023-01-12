package at.example.firealertbachmann.ui.Person;

import android.util.Log;

import com.google.gson.Gson;

import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class PersonListAdd {
    LocalTime time = LocalTime.of(00, 00, 00);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public ArrayList<Person> addPeople(ArrayList<Person> peopleList) {
/*        peopleList.add(new Person("JAMO", false, "000763", time.format(formatter), false));
        peopleList.add(new Person("MCSA", false, "000765", time.format(formatter), false));
        peopleList.add(new Person("MASB", false, "000606", time.format(formatter), false));
        peopleList.add(new Person("TEST1", false, "000101", time.format(formatter), false));
        peopleList.add(new Person("TEST2", false, "000102", time.format(formatter), false));
        peopleList.add(new Person("TEST3", false, "000103", time.format(formatter), false));*/

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("http://10.160.0.234:3000/people");
                    Log.v("test", "Loading...");

                    InputStreamReader reader = new InputStreamReader(url.openStream());
                    Log.v("test", "Loading...");

                    Person[] people = new Gson().fromJson(reader, Person[].class);
                    Log.v("test", "Loading People.....");
                    Arrays.asList(people).stream().forEach(it -> Log.v("test", it.Name));
                } catch (Exception e) {
                    Log.e("test", e.getMessage(), e);
                }
            }
        }).start();
        return peopleList;
    }
}
