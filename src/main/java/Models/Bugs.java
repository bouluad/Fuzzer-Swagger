package Models;

/**
 * Created by bouluad on 09/01/17.
 */
public class Bugs {

    // Contient code , body et donnée de test
    private Response response;
    private String expectedCode;

    public Bugs() {
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public String getExpectedCode() {
        return expectedCode;
    }

    public void setExpectedCode(String expectedCode) {
        this.expectedCode = expectedCode;
    }
}
