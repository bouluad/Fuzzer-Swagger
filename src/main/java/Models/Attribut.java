package Models;

/**
 * Created by bouluad on 05/12/16.
 */
public class Attribut {

    private String Name;
    private String Type;


    public Attribut(String name, String type) {
        Name = name;
        Type = type;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
