
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstExam {

    @Test(dataProvider = "one", dataProviderClass = DataProvidderOne.class, priority = 1)

    public void testone(String username, String password) {

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        JSONObject json = new JSONObject();
        json.put("userName", username);
        json.put("password", password);

        request.body(json.toJSONString());
        Response resp = request.post("https://bookstore.toolsqa.com/Account/v1/User");
        ResponseBody responseBody = resp.getBody();
        int code = resp.getStatusCode();
        System.out.println(responseBody.asString());
        Assert.assertEquals(responseBody.asString(), "{\"code\":\"1204\",\"message\":\"User exists!\"}");
//        Assert.assertEquals(code,200);


    }

//
    @Test(dataProvider = "three", dataProviderClass = DataProviderThree.class, priority = 3)

    public void testthree(String username, String password) {

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        JSONObject json = new JSONObject();
        json.put("userName", username);
        json.put("password", password);

        request.body(json.toJSONString());
        Response resp = request.post("https://bookstore.toolsqa.com/Account/v1/User");
        ResponseBody responseBody = resp.getBody();
        int code = resp.getStatusCode();
        System.out.println(responseBody.asString());
        Assert.assertEquals(responseBody.asString(), "{\"code\":\"1200\",\"message\":\"UserName and Password required.\"}");
//       Assert.assertEquals(code,200);

    }

    @Test(dataProvider = "two", dataProviderClass = DataProviderTwo.class, priority = 2)

    public void testtwo(String username, String password) {

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        JSONObject json = new JSONObject();
        json.put("userName", username);
        json.put("password", password);

        request.body(json.toJSONString());
        Response resp = request.post("https://bookstore.toolsqa.com/Account/v1/User");
        ResponseBody responseBody = resp.getBody();
        int code = resp.getStatusCode();
        System.out.println(responseBody.asString());
        Assert.assertEquals(responseBody.asString(), "{\"code\":\"1300\",\"message\":\"Passwords must have at least one non alphanumeric character, one digit ('0'-'9'), one uppercase ('A'-'Z'), one lowercase ('a'-'z'), one special character and Password must be eight characters or longer.\"}");
//       Assert.assertEquals(code,200);

    }
}
