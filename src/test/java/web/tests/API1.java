package web.tests;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

//Develop automation tests to check status and response using Java and any library of your choice.
//
//        There is a simple HTTP Request & Response Service https://httpbin.org
//        GET/delay/{delay}
//        Returns a delayed response (max of 10 seconds).


import static io.restassured.RestAssured.given;

public class API1 {
  int i = (int)Math.random()*10;

  @Test
  public void test() {
    for(int i=0; i<10; i++){
      String url = given()
              .spec(getDelayRequest(i))
              .when()
              .get()
              .then()
              .statusCode(200)
              .extract().path("url");
      Assert.assertEquals(url, "https://httpbin.org/delay/" + i);
    }
  }

public RequestSpecification getDelayRequest(int i){
      return new RequestSpecBuilder()
              .setBaseUri("https://httpbin.org/delay/" + i)
              .setContentType(ContentType.JSON)
              .build();
    }
}
