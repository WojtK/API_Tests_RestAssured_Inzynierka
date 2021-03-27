package Methods;

import io.restassured.http.Cookies;
import org.json.simple.JSONObject;

import static Methods.Data.*;
import static io.restassured.RestAssured.given;

public class Methods {

    public static JSONObject Create_JSON() {
        JSONObject request = new JSONObject();
        request.put("username", username);
        request.put("password",  password);
        request.put("email",  email);

        return request;
    }

    public static Cookies Login()
    {
        JSONObject request = Create_JSON();
        Cookies cookie =  given().contentType("application/json").
                body(request.toJSONString()).
                when().
                post("http://127.0.0.1:8000/api/login/").
                then().
                log().all().
                statusCode(200).
                extract().response().getDetailedCookies();

        return cookie;
    }
}
