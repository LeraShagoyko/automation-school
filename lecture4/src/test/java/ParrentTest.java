import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParrentTest {

    @BeforeMethod
    public void beforeClass() {
        System.out.println("before method");

    }

    @Test(dependsOnMethods = "test2")
    public void test1() {
        System.out.println("I'm test1");
    }

    @Test
    public void test2() {
        System.out.println("I'm test2");
    }
}
