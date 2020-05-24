package br.com.coradini.testcases;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class MentoriaRestExemplo1TestCase {

    @BeforeEach
    public void setUp() {
        baseURI = "https://private-anon-13ec314ff7-apidetarefas.apiary-mock.com";
        basePath = "/contacts";
    }

    @Test
    public void verifyPostRequestTest() {
        given().
                body("{\n" +
                        "  \"name\": \"bruno\",\n" +
                        "  \"last_name\": \"batista\",\n" +
                        "  \"email\": \"bruno@gmail.com\",\n" +
                        "  \"age\": \"28\",\n" +
                        "  \"phone\": \"21984759575\",\n" +
                        "  \"address\": \"Rua dois\",\n" +
                        "  \"state\": \"Minas Gerais\",\n" +
                        "  \"city\": \"Belo Horizonte\"\n" +
                        "}").
                header("Content-Type", "application/json").
                header("Accept","application/vnd.tasksmanager.v2").
        when().
                post().
        then().
                statusCode(201);
    }

}
