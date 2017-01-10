package Models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bouluad on 09/01/17.
 */
public class Bugs {

    // Contient code , body et donnée de test
    private Response response;
    // List des codes attendus
    Map<String, String> expectedCodes;
    private String path;
    private String method;


    public Bugs(Response response, Map<String, String> expectedCodes, String path, String method) {
        this.response = response;
        this.expectedCodes = expectedCodes;
        this.path = path;
        this.method = method;
    }

    public Bugs() {
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public Map<String, String> getExpectedCodes() {
        return expectedCodes;
    }

    public void setExpectedCodes(Map<String, String> expectedCodes) {
        this.expectedCodes = expectedCodes;
    }
}
