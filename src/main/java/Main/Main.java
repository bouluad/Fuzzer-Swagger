package Main;

/**
 * Created by bouluad on 16/11/16.
 */

import Business.Fuzzer;
import Business.ParserSwagger;
import Models.Bugs;
import io.swagger.models.Swagger;
import io.swagger.parser.SwaggerParser;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) throws MalformedURLException {

        Swagger swagger = new SwaggerParser().read("http://petstore.swagger.io/v2/swagger.json");

        ParserSwagger parserSwagger = new ParserSwagger(swagger);

        Fuzzer fuzzer = new Fuzzer(parserSwagger.parser());

        List<Bugs> bugsList = new ArrayList<Bugs>();

        bugsList = fuzzer.fuzzing();

        System.out.println("List bugs :" + bugsList.size());

        for (Bugs b :bugsList){


                System.out.println("Path : " + b.getPath() + ", Method :" + b.getMethod() + ", Code :" + b.getResponse().getCode() + " , DT: " + b.getResponse().getTestData() + " | " + b.getExpectedCodes().get(0));

        }


//        Faker faker = new Faker(new Locale("en"));
//
//        Integer response = HttpRequest.get("http://" + swagger.getHost() + swagger.getBasePath() + "/pet/" + "36").code(); //#5896 => 405 , <> => 400
//        System.out.println(response);
//        System.out.println("Faker :"+faker.idNumber().valid());
//        System.out.println("Faker :"+new Random().nextInt(5));
//
//
//        for (Models.Path p : parserSwagger.parser()) {
//            System.out.println("***************************");
//            System.out.println("Path : " + p.getPath());
//
//            for (MethodHttp m : p.getMethodHttps()) {
//
//                System.out.println("------------ Type " + m.getType());
//                System.out.println("------------ Tag " + m.getTag());
//
//                for (ResponseHttp r : m.getResponseHttps()) {
//
//                    System.out.println("----------------- Res [" + r.getId() + "," + r.getDescription() + "]");
//                }
//
//                for (Parameter par : m.getParams()) {
//
//                    System.out.println("----------------- Param [" + par.getIn() + "," + par.getDescription() + "]");
//                }
//
//
//            }
//
//            System.out.println("***************************");
//        }

//
//                Set set = new HashSet();
//                set = swagger.getPaths().keySet();
//
//        for (Map.Entry<String, Path> entry : swagger.getPaths().entrySet()) {
//            String cle = entry.getKey();
//            Path p = entry.getValue();
//
//
//            for (Entry<HttpMethod, Operation> list : p.getOperationMap().entrySet()) {
//                HttpMethod method = list.getKey();
//                Operation operation = list.getValue();
//
//                System.out.println("+++++++++++++++++++++");
//                for (Map.Entry<String, Response> res : list.getValue().getResponses().entrySet())  {
//
//
//
//                    System.out.println("Code :"+res.getKey());
//                    System.out.println("Description : "+res.getValue().getDescription());
//
//
//                }
//                System.out.println("+++++++++++++++++++++");
//            }
//        }
//
//        for (Path p : swagger.getPaths().values()) {
//
//            System.out.println("******************");
//
//
//            for (Operation o : p.getOperationMap().values()
//                    ) {
//
//                System.out.println(o.getSummary());
//                for (Parameter par : o.getParameters()
//                        ) {
//
//                    System.out.println(par.getDescription());
//                    System.out.println(par.getIn());
//                    System.out.println(par.getName());
//                }
//
//                System.out.println("-------------------------------");
//
//                for (Response res : o.getResponses().values()
//                        ) {
//
//                    System.out.println("[" + o.getResponses().keySet().iterator().next().toString() + "," + res.getDescription());
//
//
//                }
//                System.out.println("-------------------------------");
//
//            }
//
//
//            System.out.println("******************");
//        }
//
//        System.out.println(swagger.getPaths().keySet());
//
//
//        Path path = new Path();
//
//        System.out.print("Host : " + swagger.getHost());
//        System.out.println("Base Path :" + swagger.getBasePath());
//
//
//        for (int i = 0; i < 100; i++) {
//
//
//            Faker faker = new Faker(new Locale("en"));
//
//            Long test = faker.number().randomNumber();
//
//            String tt2 = faker.name().firstName();
//
        //  Integer response1 = HttpRequest.get("http://" + swagger.getHost() + swagger.getBasePath() + "/pet/" + "36").code(); //#5896 => 405 , <> => 400; 31 =>500; 32 =>500
        // System.out.println(response1);

//
//        }

        // String tt = HttpRequest.get("http://" + swagger.getHost() + swagger.getBasePath() + "/pet/findByStatus").body();

        //  System.out.println(tt);

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