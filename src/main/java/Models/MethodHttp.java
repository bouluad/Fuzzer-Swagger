package Models;


import io.swagger.models.parameters.Parameter;

import java.util.List;

/**
 * Created by bouluad on 23/11/16.
 */
public class MethodHttp {

    private String type;
    private String tag;
    private List<ResponseHttp> responseHttps;
    private List<Parameter> params ;

    public MethodHttp(String type, String tag, List<ResponseHttp> responseHttps, List p) {
        this.type = type;
        this.tag = tag;
        this.responseHttps = responseHttps;
        this.params = p;
    }

    public MethodHttp() {

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

    public List<Parameter> getParams() {
        return params;
    }

    public void setParams(List<Parameter> params) {
        this.params = params;
    }
}
