import io.cucumber.java.After;
import io.cucumber.java.Before;
import utility.CommonLibrary;

public class Hooks extends CommonLibrary {
    @Before
    public void beforeMethod() {
        openBrowser();
    }

    @After
    public void afterMethod() {
        closeBrowser();

    }
}
