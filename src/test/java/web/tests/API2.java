package web.tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

//        GET/image/png
//        Returns a simple PNG image.

public class API2 {

  @Test
  public void test() {
    given()
            .spec(getPNGRequest())
            .when()
            .get()
            .then()
            .statusCode(200)
            .contentType("image/png");
  }

  public RequestSpecification getPNGRequest(){
    return new RequestSpecBuilder()
            .setBaseUri("https://httpbin.org/image/png")
            .setContentType(ContentType.JSON)
            .build();
  }

}
