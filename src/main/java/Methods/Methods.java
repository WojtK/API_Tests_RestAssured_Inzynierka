package Methods;

import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import org.json.simple.JSONObject;
import org.apache.log4j.Logger;
import static Methods.Data.*;
import static io.restassured.RestAssured.given;

public class Methods {

    public static Logger log = Logger.getRootLogger();

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

    public static void Get_List(Cookies cookie, String section)
    {
        section = section.toLowerCase();
        given().cookies(cookie).
                when().
                get("http://127.0.0.1:8000/"+section+"/").
                then().
                log().all().
                statusCode(200);
    }

    public static Cookie Cookie_Separator(Cookies cookie)
    {
        return null;
    }
}
