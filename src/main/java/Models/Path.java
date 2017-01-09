package Models;

import java.util.List;

public class Path {

    private String basePath;
    private  String host;

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

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
