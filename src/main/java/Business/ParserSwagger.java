package Business;

import Models.MethodHttp;
import Models.Path;
import Models.ResponseHttp;
import io.swagger.models.HttpMethod;
import io.swagger.models.Operation;
import io.swagger.models.Response;
import io.swagger.models.Swagger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by bouluad on 05/12/16.
 */
public class ParserSwagger {

    private Swagger swagger;

    private List<Path> paths;
    private String host;
    private String basePath;
    private String description;
    private String title;
    private String mail;

    public ParserSwagger(Swagger s) {

        this.swagger = s;
        paths = new ArrayList<Path>();
    }

    public List<Path> parser() {

        List<Path> paths = new ArrayList<Path>();

        // Parser les données de base
        host = swagger.getHost();

        if (swagger.getBasePath() != null) {

            basePath = swagger.getBasePath();
        } else {
            basePath = "";
        }
        description = swagger.getInfo().getDescription();
        title = swagger.getInfo().getTitle();
        mail = swagger.getInfo().getContact().getEmail();

        // Parser tout les paths
        for (Map.Entry<String, io.swagger.models.Path> listPath : swagger.getPaths().entrySet()) {

            Path mPath = new Path();
            mPath.setBasePath(basePath);
            mPath.setHost(host);
            mPath.setPath(listPath.getKey());

            // Récupérer tout les méthodes HTTP
            List<MethodHttp> methodHttps = new ArrayList<MethodHttp>();
            for (Map.Entry<HttpMethod, Operation> list : listPath.getValue().getOperationMap().entrySet()) {

                MethodHttp mMethodHttp = new MethodHttp();

                mMethodHttp.setType(list.getKey().name());

                mMethodHttp.setParams(list.getValue().getParameters());
                mMethodHttp.setTag(list.getValue().getTags().get(0));

                List<ResponseHttp> responseHttps = new ArrayList<ResponseHttp>();

                for (Map.Entry<String, Response> res : list.getValue().getResponses().entrySet()) {

                    ResponseHttp responseHttp = new ResponseHttp(res.getKey(), res.getValue().getDescription());
                    responseHttps.add(responseHttp);

                }

                mMethodHttp.setResponseHttps(responseHttps);
                methodHttps.add(mMethodHttp);

            }

            mPath.setMethodHttps(methodHttps);
            paths.add(mPath);
        }

        this.paths = paths;
        return paths;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Swagger getSwagger() {
        return swagger;
    }

    public void setSwagger(Swagger swagger) {
        this.swagger = swagger;
    }

    public List<Path> getPaths() {
        return paths;
    }

    public void setPaths(List<Path> paths) {
        this.paths = paths;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
