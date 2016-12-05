package Main;

/**
 * Created by bouluad on 16/11/16.
 */

import com.github.javafaker.Faker;
import com.github.kevinsawicki.http.HttpRequest;
import io.swagger.models.Operation;
import io.swagger.models.Path;
import io.swagger.models.Response;
import io.swagger.models.Swagger;
import io.swagger.models.parameters.Parameter;
import io.swagger.parser.SwaggerParser;

import java.net.MalformedURLException;
import java.util.Locale;


public class Main {

    public static void main(String[] args) throws MalformedURLException {

        Swagger swagger = new SwaggerParser().read("http://generator.swagger.io/api/swagger.json");


        for (Path p : swagger.getPaths().values()
                ) {

            System.out.println("******************");

            for (Operation o : p.getOperationMap().values()
                    ) {

                System.out.println(o.getSummary());
                for (Parameter par : o.getParameters()
                        ) {

                    System.out.println(par.getDescription());
                    System.out.println(par.getIn());
                    System.out.println(par.getName());
                }

                System.out.println("-------------------------------");

                for (Response res : o.getResponses().values()
                        ) {

                    System.out.println("[" + o.getResponses().keySet().iterator().next().toString() + "," + res.getDescription());


                }

            }


            System.out.println("******************");
        }

        System.out.println(swagger.getPaths().keySet());


        Path path = new Path();

        System.out.print(swagger.getHost());
        System.out.println(swagger.getBasePath());


        for (int i = 0; i < 100; i++) {


            Faker faker = new Faker(new Locale("en"));

            int test = faker.number().randomDigit();

            String tt2 = faker.name().firstName();

            Integer response = HttpRequest.get("http://" + swagger.getHost() + swagger.getBasePath() + "/pet/" + tt2).code();


        }

        String tt = HttpRequest.get("http://" + swagger.getHost() + swagger.getBasePath() + "/pet/mmmm").message();


     //   System.out.println(tt);
//
//        Path path1 = new Path();
//
//
//        Faker faker = new Faker(new Locale("en"));
//
//        String name = faker.name().fullName(); // Miss Samanta Schmidt
//        String firstName = faker.name().firstName(); // Emory
//        String lastName = faker.name().lastName(); // Barton
//
//        String streetAddress = faker.address().streetAddress(); // 60018 Sawayn Brooks Suite 449
//
//        int test = faker.number().numberBetween(10, 200);
//
//        System.out.println(test);
//

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