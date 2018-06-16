package weather;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

//08b3e5e9a44509e2446f4f64eccbcf21
public class Weather {

    public static String getWeather(String message, Model model) throws IOException {
        URL query = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + message
                + "&units=metric&appid=08b3e5e9a44509e2446f4f64eccbcf21");

        Scanner scanner = new Scanner((InputStream) query.getContent());
        String result = "";
        while (scanner.hasNext()) result += scanner.nextLine();

        JSONObject object = new JSONObject(result);
        model.setNameCity(object.getString("name"));
        JSONObject main = object.getJSONObject("main");
        model.setTemp(main.getDouble("temp"));
        model.setHumidity(main.getDouble("humidity"));
        model.setPressure(main.getInt("pressure"));

        return "Город: " + model.getNameCity() + "\n" +
                "температура: " + model.getTemp() + " C \n" +
                "давление: " + model.getPressure() + " hpa \n" +
                "влажность: " + model.getHumidity() + " % \n";
    }

}
