package models;


import java.util.List;

/**
 * Created by bouluad on 23/11/16.
 */
public class MethodHttp {

    private String type;
    private String tag;
    private List<ResponseHttp> responseHttps;
    private String parametrs;

    public MethodHttp(String type, String tag, List<ResponseHttp> responseHttps, String parametrs) {
        this.type = type;
        this.tag = tag;
        this.responseHttps = responseHttps;
        this.parametrs = parametrs;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public List<ResponseHttp> getResponseHttps() {
        return responseHttps;
    }

    public void setResponseHttps(List<ResponseHttp> responseHttps) {
        this.responseHttps = responseHttps;
    }

    public String getParametrs() {
        return parametrs;
    }

    public void setParametrs(String parametrs) {
        this.parametrs = parametrs;
    }
}
