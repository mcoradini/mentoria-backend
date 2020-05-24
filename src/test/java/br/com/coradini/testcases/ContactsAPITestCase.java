package br.com.coradini.testcases;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static io.restassured.RestAssured.*;

public class ContactsAPITestCase {

    private static final String JSON_CREATE = "src\\test\\resources\\create.json";
    private static final String JSON_EDIT = "src\\test\\resources\\edit.json";
    private static final String JSON_PATCH = "src\\test\\resources\\patch.json";

    @BeforeEach
    public void setUp() {
        baseURI = "https://private-anon-c12307323c-apidetarefas.apiary-mock.com";
        basePath = "/contacts";
    }

    @Test
    public void listContactsTest(){
        when().
                get().
        then().
                statusCode(200).
                header("Content-Type", "application/json");
    }

    @Test
    public void createContactTest() {
        try {
            FileReader file = new FileReader(new File(JSON_CREATE));

            given().
                    body(file).
                    header("Content-Type", "application/json").
                    header("Accept", "application/vnd.tasksmanager.v2").
            when().
                    post().
            then().
                    statusCode(201);
        } catch (FileNotFoundException f) {
            System.out.println("Não foi possível encontrar arquivo json...");
            f.getMessage();
        } catch (Exception e) {
            e.getMessage();
        }

    }

    @Test
    public void editContactTest() {
        try {
            FileReader file = new FileReader(new File(JSON_EDIT));

            given().
                    body(file).
                    header("Content-Type","application/json").
                    header("Accept","application/vnd.tasksmanager.v2").
                    header("Location","/contacts/1").
            when().
                    post().
            then().
                    statusCode(201);
        } catch (FileNotFoundException f) {
            System.out.println("Não foi possível encontrar arquivo json...");
        } catch (Exception e) {
            e.getMessage();
        }

    }

    @Test
    public void patchContactTest() {
        try {
            FileReader file = new FileReader(new File(JSON_PATCH));

            given().
                    body(file).
                    header("Content-Type","application/json").
                    header("Accept","application/vnd.tasksmanager.v2").
                    header("Location","/contacts/1").
            when().
                    patch().
            then().
                    statusCode(201);
        } catch (FileNotFoundException f) {
            System.out.println("Não foi possível encontrar arquivo json...");
        } catch (Exception e) {
            e.getMessage();
        }

    }

    @Test
    public void deleteContactTest() {
        when().
                delete().
        then().
                statusCode(204);
    }

}
