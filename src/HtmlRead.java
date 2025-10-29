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

                if(line.contains("href")) {
                    int index = 0;
                    int start = 0;
                    int end = 0;
                        start = line.indexOf("href=") + 6;
                        System.out.println(line);
                        String line2 = line.substring(start);
                        System.out.println(line2);
                        end = line2.indexOf("\"");
                        System.out.println(line2.substring(0, end));
                }
            }
            reader.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }


}
