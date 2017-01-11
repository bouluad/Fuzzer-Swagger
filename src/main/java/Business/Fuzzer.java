package Business;

import Models.*;
import com.github.javafaker.Faker;
import com.github.kevinsawicki.http.HttpRequest;
import io.swagger.models.parameters.Parameter;

import java.util.*;

/**
 * Created by bouluad on 09/01/17.
 */
public class Fuzzer {

    private static int NB = 4;

    private List<Path> pathList;

    public Fuzzer(List<Path> p) {

        pathList = p;

    }

    public List<Bugs> fuzzing() {

        String oldPath = "";
        String oldMethod = "";
        String oldCode = "";
        List<Bugs> bugsList = new ArrayList<Bugs>();
        Response res = new Response();

        for (Path p : pathList) {

            for (MethodHttp m : p.getMethodHttps()) {


                for (int i = 0; i < NB; i++) {

                    res = execute(p, m);

                    if (res.getCode() != null && res.getTestData() != null && assertResponse(m.getResponseHttps(), res) == false) {

                        // Pour stocker les résultats attendus
                        Map<String, String> l = new HashMap();

                        for (ResponseHttp rh : m.getResponseHttps()) {

                            l.put(rh.getId(), rh.getDescription());
                        }

                        if (p.getPath() != oldPath && m.getType() != oldMethod && res.getCode() != oldCode) {

                            bugsList.add(new Bugs(res, l, p.getPath(), m.getType()));
                            oldPath = p.getPath();
                            oldCode = res.getCode();
                            oldMethod = m.getType();
                        }
                    }

                }

            }
        }

        return bugsList;
    }

    public Response execute(Path path, MethodHttp m) {

        Response response = new Response();
        String dataTest = dataTest();

        if ("GET".equals(m.getType())) {

            for (Parameter p : m.getParams()) {

                if (p.getRequired()) {
                    if ("path".equals(p.getIn())) {


                        Integer code = HttpRequest.get("http://" + path.getHost() + path.getBasePath() + path.getPath().replaceAll("\\{.*?\\}", dataTest)).code();
                        String body = HttpRequest.get("http://" + path.getHost() + path.getBasePath() + path.getPath().replaceAll("\\{.*?\\}", dataTest)).body();

                        response.setCode(String.valueOf(code));
                        response.setBody(body);
                        response.setTestData(dataTest);

                    }
                }

            }
        } else if ("POST".equals(m.getType())) {

            for (Parameter p : m.getParams()) {

                if (p.getRequired()) {
                    if ("path".equals(p.getIn())) {

                        Integer code = HttpRequest.post("http://" + path.getHost() + path.getBasePath() + path.getPath().replaceAll("\\{.*?\\}", dataTest)).code();
                        String body = HttpRequest.post("http://" + path.getHost() + path.getBasePath() + path.getPath().replaceAll("\\{.*?\\}", dataTest)).body();

                        response.setCode(String.valueOf(code));
                        response.setBody(body);
                        response.setTestData(dataTest);

                    }
                }

            }

        } else if ("PUT".equals(m.getType())) {

            for (Parameter p : m.getParams()) {

                if (p.getRequired()) {
                    if ("path".equals(p.getIn())) {

                        Integer code = HttpRequest.put("http://" + path.getHost() + path.getBasePath() + path.getPath().replaceAll("\\{.*?\\}", dataTest)).code();
                        String body = HttpRequest.put("http://" + path.getHost() + path.getBasePath() + path.getPath().replaceAll("\\{.*?\\}", dataTest)).body();

                        response.setCode(String.valueOf(code));
                        response.setBody(body);
                        response.setTestData(dataTest);

                    }
                }

            }

        } else {

            for (Parameter p : m.getParams()) {

                if (p.getRequired()) {
                    if ("path".equals(p.getIn())) {

                        Integer code = HttpRequest.delete("http://" + path.getHost() + path.getBasePath() + path.getPath().replaceAll("\\{.*?\\}", dataTest)).code();
                        String body = HttpRequest.delete("http://" + path.getHost() + path.getBasePath() + path.getPath().replaceAll("\\{.*?\\}", dataTest)).body();

                        response.setCode(String.valueOf(code));
                        response.setBody(body);
                        response.setTestData(dataTest);

                    }
                }

            }
        }

        return response;
    }

    public String dataTest() {

        Faker faker = new Faker(new Locale("en"));
        int randomNum = new Random().nextInt((3 - 1) + 1) + 1;
        String carSpe[] = {"#5896", "<>", "?hello", "!non", "%53698", "256+10.3"};
        String data = "";

        switch (randomNum) {

            case 1:

                data = faker.name().firstName();

                break;
            case 2:

                data = String.valueOf(faker.number().numberBetween(0, 100));

                break;
            case 3:

                data = carSpe[new Random().nextInt(5)];

                break;
            default:

                data = faker.idNumber().valid();

                break;

        }

        return data;
    }

    public boolean assertResponse(List<ResponseHttp> responseHttps, Response res) {


        for (ResponseHttp r : responseHttps) {

            if (r.getId().equals(res.getCode())) {

                return true;

            }
        }

        return false;
    }

}
