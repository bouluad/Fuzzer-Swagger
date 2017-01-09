package Models;

/**
 * Created by bouluad on 09/01/17.
 */
public class Response {

    private String code;
    private String body;
    private String testData;

    public Response() {

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTestData() {
        return testData;
    }

    public void setTestData(String testData) {
        this.testData = testData;
    }
}
