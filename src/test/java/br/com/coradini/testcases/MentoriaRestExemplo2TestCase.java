package br.com.coradini.testcases;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class MentoriaRestExemplo2TestCase {

    @BeforeEach
    public void setUp() {
        baseURI = "https://postman-echo.com";
        basePath = "/get";
    }

    @Test
    @Ignore
    public void verifyGetRequestTest(){
        given().
                param("foo1", "bar1").
                param("foo4", "bar2").
        when().
                get().
        then().
                statusCode(200).
                contentType(ContentType.JSON).
                body("headers.host", is("postman-echo.com")).
                body("args.foo1", containsString("bar"));
    }

    @Test
    public void returnBodyTest() {
        Response response =
                given().
                    param("foo1", "bar1").
                    param("foo4", "bar2").
                when().
                    get();
        response.body().prettyPrint();
    }

}
