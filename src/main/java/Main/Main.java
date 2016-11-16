package Main;

/**
 * Created by bouluad on 16/11/16.
 */

import io.swagger.models.Swagger;
import io.swagger.parser.SwaggerParser;
import io.swagger.util.Json;

public class Main {

    public static void main(String[] args) {

        Swagger swagger = new SwaggerParser().read("http://petstore.swagger.io/v2/swagger.json");

        String swaggerString = Json.pretty(swagger);

        System.out.print(swagger.getHost());


    }

}