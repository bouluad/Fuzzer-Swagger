package Main;

/**
 * Created by bouluad on 16/11/16.
 */

import com.github.kevinsawicki.http.HttpRequest;
import io.swagger.models.Path;
import io.swagger.models.Swagger;
import io.swagger.parser.SwaggerParser;
import io.swagger.util.Json;


public class Main {

    public static void main(String[] args) {


        Swagger swagger = new SwaggerParser().read("http://petstore.swagger.io/v2/swagger.json");

        String swaggerString = Json.pretty(swagger);


        Path path = new Path();

        System.out.print(swagger.getHost());
        System.out.println(swagger.getBasePath());

        String response = HttpRequest.get("http://" + swagger.getHost() + swagger.getBasePath() + "/pet/10").body();

        Path path1 = new Path();


        // System.out.println(response);


        //  System.out.println(swagger.getDefinitions());
        // System.out.println(swagger.getPath("/pet/{petId}").getGet());
//        Set set = new HashSet();
//        // set = swagger.getPaths().keySet();
//       // set = swagger.getPath("/pet/{petId}").getOperationMap().keySet();
//
//        set = swagger.getDefinitions().keySet();
//
//        Iterator i = set.iterator(); // on crée un Iterator pour parcourir notre HashSet
//        while (i.hasNext()) // tant qu'on a un suivant
//        {
//            System.out.println(i.next()); // on affiche le suivant
//            System.out.println("*************************");
//        }


    }

}