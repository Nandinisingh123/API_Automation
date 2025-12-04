package httpmethods;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class GetAPI{

    @Test
    public static void GetApiTest() {

        // Performing GET request and validating its response.
        given()
                // Specifying the Base URI.
                .baseUri("http://localhost:3000")
                .contentType(ContentType.JSON)
                .when()
                //HTTP Request Method.
                .get("/users/1")
                .then()
                // Ensuring that status code is 200 OK.
                .statusCode(200)
                // Validating Id value.
                .body("id", equalTo("1"))
                // Validating Email value.
                .body("role", equalTo("QA Engineer"))
                // Validating First Name value.
                .body("name", equalTo("Nandini"))
                // Validating Last Name value.
                .body("last_name", equalTo("Singh"))
                // Ensuring that Avatar value is not null.
                .body("id", notNullValue())
                // Log response details
                .log().all();
    }
}