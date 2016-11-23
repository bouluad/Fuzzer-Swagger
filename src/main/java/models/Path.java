package models;

import java.util.List;

/**
 * Created by bouluad on 23/11/16.
 */
public class Path {

    private String path;
    private List<MethodHttp> methodHttps;

    public Path() {

    }

    public Path(String path, List<MethodHttp> methodses) {
        this.path = path;
        this.methodHttps = methodses;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<MethodHttp> getMethodHttps() {
        return methodHttps;
    }

    public void setMethodHttps(List<MethodHttp> methodses) {
        this.methodHttps = methodses;
    }
}
