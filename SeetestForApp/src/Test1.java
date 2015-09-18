
//package <set your test package>;
import com.experitest.client.*;
import org.junit.*;
/**
 *
 *
*/
public class Test1 {
    private String host = "localhost";
    private int port = 8889;
    private String projectBaseDirectory = "C:\\Users\\rashmi.c.kumari\\workspace\\project2";
    protected Client client = null;

    @Before
    public void setUp(){
        client = new Client(host, port, true);
        client.setProjectBaseDirectory(projectBaseDirectory);
        client.setReporter("xml", "reports", "MyFirstAppTest");
    }

    @Test
    public void testMyFirstAppTest(){
        client.setDevice("adb:XT1068");
        client.launch("com.accenture.myfirstapp/.MainActivity", true, false);
        client.elementSendText("NATIVE", "id=editText1", 0, "user");
        client.elementSendText("NATIVE", "id=editText2", 0, "123");
        client.click("NATIVE", "id=button1", 0, 1);
        client.click("NATIVE", "id=navigationBarBackground", 0, 1);
    }

    @After
    public void tearDown(){
        client.generateReport(true);
    }
}
