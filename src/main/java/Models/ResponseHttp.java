package Models;

/**
 * Created by bouluad on 23/11/16.
 */
public class ResponseHttp {

    private String id;
    private String description;

    public ResponseHttp(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public ResponseHttp() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
