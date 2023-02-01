package at.example.firealertbachmann.ui.Person;

public class Person {

    private String Name;
    private boolean CheckBox;
    private boolean IsFound;
    private String KeyNumber;
    private String Uhrzeit;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public boolean isCheckBox() {
        return CheckBox;
    }

    public void setCheckBox(boolean checkBox) {
        CheckBox = checkBox;
    }

    public boolean isFound() {
        return IsFound;
    }

    public void setFound(boolean found) {
        IsFound = found;
    }

    public String getKeyNumber() {
        return KeyNumber;
    }

    public void setKeyNumber(String keyNumber) {
        KeyNumber = keyNumber;
    }

    public String getUhrzeit() {
        return Uhrzeit;
    }

    public void setUhrzeit(String uhrzeit) {
        Uhrzeit = uhrzeit;
    }
}