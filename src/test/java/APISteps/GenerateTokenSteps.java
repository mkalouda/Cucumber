package APISteps;

import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import utils.apiConstants;
import utils.apiPayloadConstants;

public class GenerateTokenSteps {

    static String token;

    @Given("a JWT is generated")
    public void a_jwt_is_generated() {
        RequestSpecification generateTokenRequest = given().header(apiConstants.Header_Content_type, apiConstants.Content_type)
                .body(apiPayloadConstants.createUserPayload());
        Response generateTokenResponse = generateTokenRequest.when().post(apiConstants.GENERATE_TOKEN_URI);

        //generateTokenResponse.prettyPrint();

        token = "Bearer " +generateTokenResponse.jsonPath().getString("token");
    }
}
