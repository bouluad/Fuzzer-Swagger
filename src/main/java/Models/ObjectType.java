package Models;

import java.util.List;

/**
 * Created by bouluad on 05/12/16.
 */
public class ObjectType {

    private String Name;
    private List<Attribut> attributList;


    public ObjectType(String name, List<Attribut> attributList) {
        Name = name;
        this.attributList = attributList;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<Attribut> getAttributList() {
        return attributList;
    }

    public void setAttributList(List<Attribut> attributList) {
        this.attributList = attributList;
    }
}
