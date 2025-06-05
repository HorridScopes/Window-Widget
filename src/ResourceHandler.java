import java.awt.Font;
import java.util.HashMap;

public class ResourceHandler {
    public static HashMap<String, Font> fontCache = new HashMap<>();

    public static void handleAllResources() {
        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.loadFontResources();
    }

    public void loadFontResources() {
        String[] locations = {"resources/AlumniSansSC-Regular.ttf"};

        for (String location : locations) {
            try (java.io.InputStream is = getClass().getResourceAsStream(location)) {
                if (is != null) {
                    Font font = Font.createFont(Font.TRUETYPE_FONT, is);
                    String fileName = location.substring(location.lastIndexOf('/') + 1);
                    String key = fileName.contains("-") ? fileName.substring(0, fileName.indexOf('-')) : fileName;
                    fontCache.put(key, font);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
