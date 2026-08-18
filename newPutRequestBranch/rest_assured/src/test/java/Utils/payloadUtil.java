package Utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Files;
import java.nio.file.Paths;

public class payloadUtil {

    // Load full JSON file as String
    public static String getFileAsString(String fileName) throws Exception {
        return new String(Files.readAllBytes(Paths.get("src/test/resources/" + fileName)));
    }

    // Load specific payload by key (preauth, cancel, etc.)
    public static String getPayload(String fileName, String key) throws Exception {
        String json = getFileAsString(fileName);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(json);
        return root.get(key).toString();
    }
}
