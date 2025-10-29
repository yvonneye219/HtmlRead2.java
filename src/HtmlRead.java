import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class HtmlRead {

    public static void main(String[] args) {
        new HtmlRead();
    }

    public HtmlRead() {
        try {
            System.out.println("hello");
            URL url = new URL("https://www.milton.edu/");
            URLConnection conn = url.openConnection();
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream())
            );

            String line;
            while ((line = reader.readLine()) != null) {
                findLinks(line);
            }
            reader.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    public void findLinks(String text) {
        int index = 0;
        while (true) {
            index = text.indexOf("href=\"", index);
            if (index == -1) break;
            int start = index + 6;
            int end = text.indexOf("\"", start);
            if (end == -1) break;
            String link = text.substring(start, end);
            System.out.println(link);
            index = end + 1;
        }
    }
}