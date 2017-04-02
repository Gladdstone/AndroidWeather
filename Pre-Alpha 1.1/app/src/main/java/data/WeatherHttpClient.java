package data;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import Util.Utils;

/**
 * Created by Gladdstone on 2/26/2017.
 */

public class WeatherHttpClient {

    static String stream = null;

    public String getWeatherData(String place) {

        try {

            URL url = new URL(place);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            if(httpURLConnection.getResponseCode() == 200) {
                BufferedReader r = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line;
                while((line = r.readLine()) != null) {
                    sb.append(line);
                }
                stream = sb.toString();
                httpURLConnection.disconnect();
            }

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }


        /**
        HttpURLConnection connection = null;
        InputStream inputStream = null;

        try {

            connection = (HttpURLConnection) (new URL(Utils.BASE_URL + place + Utils.APP_ID)).openConnection();
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.connect();

            StringBuffer buffer = new StringBuffer();
            inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;

            while((line = bufferedReader.readLine()) != null) {
                buffer.append(line + "\r\n");
            }

            inputStream.close();
            connection.disconnect();
            return buffer.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }**/

        return null;
    }

}
