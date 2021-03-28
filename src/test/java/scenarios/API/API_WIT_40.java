package scenarios.API;

import io.restassured.http.Cookies;
import org.json.simple.JSONObject;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static Methods.Methods.*;
import static Methods.Methods.log;
import static org.junit.Assert.assertEquals;


/*
   Scenariusz WIT_40 - API - Pobranie listy grup

*/


public class API_WIT_40 {

    static JSONObject json;
    static Cookies cookie;
    static boolean AssertFlag = true;
    static boolean flag = true;

    @BeforeClass
    public static void Setup() throws InterruptedException {
        log.info("### Scenariusz Aplikacja_WIT_40 - API - Pobranie listy grup");
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
            Get_List(cookie, "groups");
            log.info("Udane pobranie listy grup");
        }catch (Exception e)
        {
            log.warn("Nieudane pobranie listy grup");
            flag = false;
            AssertFlag =false;
        }
        assertEquals(true, flag);
    }

    @AfterClass
    public static void Close() {
        if (AssertFlag)
            log.info("### Scenariusz Aplikacja_WIT_40 ukończony pomyślnie ");
        else
            log.warn("### Scenariusz Aplikacja_WIT_40 ukończony niepomyślnie ");
    }

}
