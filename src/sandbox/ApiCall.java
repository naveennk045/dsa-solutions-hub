package sandbox;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiCall {


    public static void main(String[] args) throws IOException {
        URL url = new URL("https://youtube.com");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        System.out.println(connection.getContent());
    }
}