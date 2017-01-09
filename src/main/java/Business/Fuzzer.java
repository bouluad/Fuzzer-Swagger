package Business;

import Models.MethodHttp;
import Models.Path;
import Models.ResponseHttp;

import java.util.List;

/**
 * Created by bouluad on 09/01/17.
 */
public class Fuzzer {

    private static int NB=100;

    private List<Path> pathList;

    public Fuzzer(List<Path> p){

        pathList = p;

    }

    public void fuzzing(){

        ResponseHttp res = new ResponseHttp();

        for (Path p : pathList){

                for (MethodHttp m :p.getMethodHttps()){


                        for (int i=0;i<NB;i++){

                            res = execute(p,m);

                        }

                }
        }
    }

    public ResponseHttp execute(Path path, MethodHttp m) {

        switch (m.getType()) {

            case "GET":

                break;
            case "PUT":

                break;
            case "DELETE":

                break;

            case "post":
                break;

            default:
                break;
        }


        return null;
    }

}
