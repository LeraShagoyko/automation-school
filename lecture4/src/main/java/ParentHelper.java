import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public abstract class ParentHelper {
    protected ObjectMapper mapper = new ObjectMapper();
    protected CloseableHttpClient client = HttpClients.createDefault();
}
