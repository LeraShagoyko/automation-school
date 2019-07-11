import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ChildTest extends ParrentTest {
    @DataProvider(name = "data")
    public Object[][] dataProvider() {
        return new Object[][] { { 1,1,2 }, { 1,2,3 }};
    }

    @Test(dataProvider = "data")
    public void test1(int a, int b, int expected) throws InterruptedException {
        int result = a+b;
        new ArrayList<String>().remove("asd");
        Thread.sleep(2000);
        System.out.println(Thread.currentThread());
        Assert.assertEquals(result, expected);
    }

//    @Test(invocationCount = 3)
//    public void test2() {
//        System.out.println("I'm test2");
//    }
}
