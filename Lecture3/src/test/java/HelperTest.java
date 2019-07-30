import org.junit.Assert;
import org.junit.Test;
import task1.Helper;

import java.util.List;

public class HelperTest {

    @Test
    public void readFromFileTest() {
        List<String> result = Helper.readFromFile("C:\\JAVA\\automation-school\\lecture3\\src\\test\\java\\TestFile");
        Assert.assertEquals(2, result.size());
    }

    @Test
    public void writeToFileTest() {
        String myMessage = "My input message";
        String myFile = "C:\\JAVA\\automation-school\\lecture3\\src\\test\\java\\TestFileForMessage";
        Helper.clearFile(myFile);
        Helper.writeToFile(myMessage, myFile);
        List<String> result = Helper.readFromFile(myFile);
        Assert.assertEquals(myMessage, result.get(0));
    }
}
