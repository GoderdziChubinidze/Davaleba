
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SecondExam {

    @Test(dataProvider = "myuser", dataProviderClass = CreateMyUser.class,priority = 1)

    public void testone(String username, String password) {

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        JSONObject json = new JSONObject();
        json.put("userName", username);
        json.put("password", password);

        request.body(json.toJSONString());
        Response resp = request.post("https://bookstore.toolsqa.com/Account/v1/User");
        ResponseBody responseBody = resp.getBody();
//      int code = resp.getStatusCode();
        System.out.println("userparameters " + responseBody.asString());
        //უნიკალური პარამეტრები მოდის და Assert ვერ გამოვიყენე, partial text Assert.assertequals მსგავსი რამე ვერ ვნახე დროის სიმცირის გამო, სორი :(

        Response responseunauorized = request.post("https://bookstore.toolsqa.com/Account/v1/Authorized");
        System.out.println("isautorized = " + responseunauorized.asString());
        Assert.assertEquals("isautorized = " + responseunauorized.asString(), "isautorized = false");

        Response responseToken = request.post("https://bookstore.toolsqa.com/Account/v1/GenerateToken");
        System.out.println("token is = " + responseToken.asString());
        //აქაც იგივე, რაც ზემოთ

        Response responseAutorized = request.post("https://bookstore.toolsqa.com/Account/v1/Authorized");
        System.out.println("isautorized = " + responseAutorized.asString());
        Assert.assertEquals("isautorized = " + responseAutorized.asString(), "isautorized = true");

    }
//
//    @Test(dataProvider = "myuser", dataProviderClass = MyUser.class, priority = 2)
//    public void testtwo(String username, String password) {
//
//        RequestSpecification request = RestAssured.given();
//        request.header("Content-Type", "application/json");
//        JSONObject json = new JSONObject();
//        json.put("userName", username);
//        json.put("password", password);
//
//        request.body(json.toJSONString());
//        Response resp = request.post("https://bookstore.toolsqa.com/Account/v1/Authorized");
//        ResponseBody responseBody = resp.getBody();
//        int code = resp.getStatusCode();
//        System.out.println(responseBody.asString());
//     Assert.assertEquals(responseBody.asString(), "false");
////        Assert.assertEquals(code,200);
//
//
//    }
//
//    @Test(dataProvider = "myuser", dataProviderClass = MyUser.class, priority = 3)
//    public void testhree(String username, String password) {
//
//        RequestSpecification request = RestAssured.given();
//        request.header("Content-Type", "application/json");
//        JSONObject json = new JSONObject();
//        json.put("userName", username);
//        json.put("password", password);
//
//        request.body(json.toJSONString());
//        Response resp = request.post("https://bookstore.toolsqa.com/Account/v1/GenerateToken");
//        ResponseBody responseBody = resp.getBody();
//        int code = resp.getStatusCode();
//        System.out.println(responseBody.asString());
////        Assert.assertEquals(responseBody.asString(), "{\"code\":\"1204\",\"message\":\"User exists!\"}");
////        Assert.assertEquals(code,200);
//
//
//    }
//
//    @Test(dataProvider = "myuser", dataProviderClass = MyUser.class, priority = 4)
//    public void testfour(String username, String password) {
//
//        RequestSpecification request = RestAssured.given();
//        request.header("Content-Type", "application/json");
//        JSONObject json = new JSONObject();
//        json.put("userName", username);
//        json.put("password", password);
//
//        request.body(json.toJSONString());
//        Response resp = request.post("https://bookstore.toolsqa.com/Account/v1/Authorized");
//        ResponseBody responseBody = resp.getBody();
//        int code = resp.getStatusCode();
//        System.out.println(responseBody.asString());
//        Assert.assertEquals(responseBody.asString(), "true");
////        Assert.assertEquals(code,200);
//
//
//    }
}
