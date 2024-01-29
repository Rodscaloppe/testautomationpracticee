package com.automationpractice.api;
import io.restassured.response.Response;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;


@Tag("api")
class ApiTest {
@Test
    public void testGetTrelloApi() {
        Response response = given()
                .when()
                .get("https://api.trello.com/1/actions/592f11060f95a3d3d46a987a")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .response();

        String name = response.path("data.list.name");
        System.out.println("Name: " + name);

        // Validar o status code da resposta do serviço
        assertEquals(200, response.statusCode());
    }
}
