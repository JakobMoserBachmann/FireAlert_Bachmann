package QRCodeScan;

import com.google.gson.Gson;
import java.io.InputStreamReader;
import java.net.URL;
import at.example.firealertbachmann.ui.Person.Person;

public class GsonFetchNetworkJson {

    public static void main(String[] ignored) throws Exception {

        URL url = new URL("http://localhost:3000/people");
        InputStreamReader reader = new InputStreamReader(url.openStream());
        Person[] people = new Gson().fromJson(reader, Person[].class);
    }
}
