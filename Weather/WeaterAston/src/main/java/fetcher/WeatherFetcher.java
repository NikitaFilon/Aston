package fetcher;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import parser.HtmlParser;

import java.io.IOException;
import java.net.URL;

/**
 * The WeatherFetcher class is responsible for fetching weather data from meteo.by website.
 */
public class WeatherFetcher {

    /**
     * Fetches the weather document for the specified city from meteo.by.
     *
     * @param city The name of the city for which weather data is to be fetched.
     * @return The document containing weather data.
     * @throws IOException If an I/O error occurs during the fetch operation.
     */
    private static Document fetchWeatherDocument(String city) throws IOException {
        String url = "https://meteo.by/" + city;
        return Jsoup.parse(new URL(url), 3333);
    }

    /**
     * Displays the weather information for the specified city.
     *
     * @param city The name of the city for which weather information is to be displayed.
     */
    public static void displayWeather(String city) {
        try {
            Document document = fetchWeatherDocument(city);
            String weatherTime = HtmlParser.parseWeatherHtml(document);
            System.out.println(weatherTime);
        } catch (IOException e) {
            System.err.println("Error fetching weather data: " + e.getMessage());
        }
    }
}
