package Business;

import Models.MethodHttp;
import Models.Path;
import Models.ResponseHttp;
import com.github.javafaker.Faker;
import com.github.kevinsawicki.http.HttpRequest;

import java.util.List;
import java.util.Locale;
import java.util.Random;

/**
 * Created by bouluad on 09/01/17.
 */
public class Fuzzer {

    private static int NB = 100;

    private List<Path> pathList;

    public Fuzzer(List<Path> p) {

        pathList = p;

    }

    public void fuzzing() {

        ResponseHttp res = new ResponseHttp();

        for (Path p : pathList) {

            for (MethodHttp m : p.getMethodHttps()) {


                for (int i = 0; i < NB; i++) {

                    res = execute(p, m);

                }

            }
        }
    }

    public ResponseHttp execute(Path path, MethodHttp m) {

        ResponseHttp responseHttp = new ResponseHttp();

        if ("GET".equals(m.getType())) {
            Integer code = HttpRequest.get("http://" + path.getHost() + path.getBasePath() + "/" + path.getPath() + "/" + dataTest()).code();
            String body = HttpRequest.get("http://" + path.getHost() + path.getBasePath() + "/" + path.getPath() + "/" + dataTest()).body();

            responseHttp.setId(String.valueOf(code));
            responseHttp.setDescription(body);

        } else if ("POST".equals(m.getType())) {

            Integer code = HttpRequest.post("http://" + path.getHost() + path.getBasePath() + "/" + path.getPath() + "/" + dataTest()).code();
            String body = HttpRequest.post("http://" + path.getHost() + path.getBasePath() + "/" + path.getPath() + "/" + dataTest()).body();

            responseHttp.setId(String.valueOf(code));
            responseHttp.setDescription(body);


        } else if ("PUT".equals(m.getType())) {

            Integer code = HttpRequest.put("http://" + path.getHost() + path.getBasePath() + "/" + path.getPath() + "/" + dataTest()).code();
            String body = HttpRequest.put("http://" + path.getHost() + path.getBasePath() + "/" + path.getPath() + "/" + dataTest()).body();

            responseHttp.setId(String.valueOf(code));
            responseHttp.setDescription(body);


        } else {

            Integer code = HttpRequest.delete("http://" + path.getHost() + path.getBasePath() + "/" + path.getPath() + "/" + dataTest()).code();
            String body = HttpRequest.delete("http://" + path.getHost() + path.getBasePath() + "/" + path.getPath() + "/" + dataTest()).body();

            responseHttp.setId(String.valueOf(code));
            responseHttp.setDescription(body);


        }

        return responseHttp;
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

}
