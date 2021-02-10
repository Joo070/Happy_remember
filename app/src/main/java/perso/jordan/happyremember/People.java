package perso.jordan.happyremember;

import org.joda.time.*;


public class People {

    public String name;
    public DateTime birthday;


    public People(String pName, DateTime pBirthday) {
        name = pName;
        birthday = pBirthday;
    }

    public String getName() { return
            name;
    }

    public DateTime getBirthday() {
        return birthday;
    }
}
