import org.testng.annotations.DataProvider;

public class CreateMyUser {

    @DataProvider(name = "myuser")
    public Object[][] getData(){
        Object[][] data ={{"testuser","Automation@!@1234"}};
        return data;

    }
}
