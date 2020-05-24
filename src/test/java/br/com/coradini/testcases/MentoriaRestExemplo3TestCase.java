package br.com.coradini.testcases;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class MentoriaRestExemplo3TestCase {

    String url = "https://postman-echo.com/get";

    @Test
    public void getPageOne(){
        given().
                param("foo1", "bar1").
                param("foo4", "bar2").
        when().
                get(url).
        then().
                statusCode(200).
                contentType(ContentType.JSON).
                body("headers.host", is("postman-echo.com")).
                body("args.foo1", containsString("bar"));
    }

}
