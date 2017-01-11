package Main;

/**
 * Created by bouluad on 16/11/16.
 */

import Business.Fuzzer;
import Business.ParserSwagger;
import Models.Bugs;
import io.swagger.models.Swagger;
import io.swagger.parser.SwaggerParser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws MalformedURLException {

        /**
         *  API Petstore
         **/
        Swagger swagger = new SwaggerParser().read("http://petstore.swagger.io/v2/swagger.json");

        /**
         *  Mon propre API généré avec JHipster
         **/
        //Swagger swagger = new SwaggerParser().read("http://localhost:8080/v2/api-docs.json");

        ParserSwagger parserSwagger = new ParserSwagger(swagger);

        Fuzzer fuzzer = new Fuzzer(parserSwagger.parser());

        List<Bugs> bugsList = new ArrayList<Bugs>();

        bugsList = fuzzer.fuzzing();

        System.out.println("List bugs :" + bugsList.size());


        // Log file

        File file = new File("/var/www/html/testvv/index.html");
        
        // creates the file
        try {
            file.createNewFile();
            // creates a FileWriter Object
            FileWriter writer = new FileWriter(file);

            // Writes the content to the file
            writer.write("******************** Bugs : " + parserSwagger.getTitle() + " ********************\n");
            writer.write("<br/>");
            writer.write("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
            writer.write("<br/>");
            writer.write("+   You must contact : '" + parserSwagger.getMail() + "' To fix the bugs +\n");
            writer.write("<br/>");
            writer.write("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
            writer.write("<br/>");
            for (Bugs b : bugsList) {
                 writer.write("<br/>");
                writer.write("-----------------------------------------------------------\n");
                writer.write("<br/>");
                writer.write(" + Path             : " + b.getPath() + "\n");
                writer.write("<br/>");
                writer.write(" + HTTP method      : " + b.getMethod() + "\n");
                writer.write("<br/>");
                writer.write(" + Code returned    : " + b.getResponse().getCode() + "\n");
                writer.write("<br/>");
                writer.write(" + Expected results : [ ");
                writer.write("<br/>");
                for (Map.Entry<String, String> entry : b.getExpectedCodes().entrySet()) {
                    writer.write(entry.getKey() + " : " + entry.getValue() + " | ");
                    writer.write("<br/>");

                }
                writer.write("<br/>");
                writer.write("]\n ");
                writer.write("<br/>");
                writer.write(" + Test data          : " + b.getResponse().getTestData() + "\n");
                writer.write("<br/>");
                writer.write("-----------------------------------------------------------\n");
             writer.write("<br/>");
            }


            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


/**
 *  Ce morceau de code montre le parsing :
 *
 */

/*
        for (Models.Path p : parserSwagger.parser()) {
            System.out.println("***************************");
            System.out.println("Path : " + p.getPath());

            for (MethodHttp m : p.getMethodHttps()) {

                System.out.println("------------ Type " + m.getType());
                System.out.println("------------ Tag " + m.getTag());

                for (ResponseHttp r : m.getResponseHttps()) {

                    System.out.println("----------------- Res [" + r.getId() + "," + r.getDescription() + "]");
                }

                for (Parameter par : m.getParams()) {

                    System.out.println("----------------- Param [" + par.getIn() + "," + par.getDescription() + "]");
                }


            }

            System.out.println("***************************");
        }
*/
    }

}