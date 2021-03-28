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
   Scenariusz WIT_41 - API - Pobranie listy komentarzy

*/



public class API_WIT_41 {

    static JSONObject json;
    static Cookies cookie;
    static boolean AssertFlag = true;
    static boolean flag = true;

    @BeforeClass
    public static void Setup() throws InterruptedException {
        log.info("### Scenariusz Aplikacja_WIT_41 - API - Pobranie listy komentarzy");
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
            Get_List(cookie, "comments");
            log.info("Udane pobranie listy komentarzy");
        }catch (Exception e)
        {
            log.warn("Nieudane pobranie listy komentarzy");
            flag = false;
            AssertFlag =false;
        }
        assertEquals(true, flag);
    }

    @AfterClass
    public static void Close() {
        if (AssertFlag)
            log.info("### Scenariusz Aplikacja_WIT_41 ukończony pomyślnie ");
        else
            log.warn("### Scenariusz Aplikacja_WIT_41 ukończony niepomyślnie ");
    }
}
