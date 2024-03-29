package scenarios.API;

import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import netscape.javascript.JSObject;
import org.json.simple.JSONObject;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static Methods.Methods.*;
import static org.junit.Assert.assertEquals;
/*
   Scenariusz WIT_36 - API - Pobranie listy użytkowników

*/

public class API_WIT_36 {

    static JSONObject json;
    static Cookies cookie;
    static boolean AssertFlag = true;
    static boolean flag = true;

    @BeforeClass
    public static void Setup() throws InterruptedException {
        log.info("### Scenariusz Aplikacja_WIT_36 - API - Pobranie listy użytkowników");
    }


    @Test
    public void Test1() {
        flag = true;
        try{
            json = Create_JSON();
            cookie = Login();
            log.info("Udane zalogowanie przez API");
        }catch (Exception e)
        {
            log.warn("Nieudane zalogowanie przez API");
        flag = false;
        AssertFlag =false;
        }
        assertEquals(true, flag);
    }

    @Test
    public void Test2()
    {
        flag = true;
        try{
            Get_List(cookie, "users");
            log.info("Udane pobranie listy użytkowników");
        }catch (Exception e)
        {
            log.warn("Nieudane pobranie listy użytkowników");
            flag = false;
            AssertFlag =false;
        }
        assertEquals(true, flag);
    }

    @AfterClass
    public static void Close() {
        if (AssertFlag)
            log.info("### Scenariusz Aplikacja_WIT_36 ukończony pomyślnie ");
        else
            log.warn("### Scenariusz Aplikacja_WIT_36 ukończony niepomyślnie ");
    }

}
