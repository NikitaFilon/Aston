package parser;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * The HtmlParser class is responsible for extracting weather information from HTML documents.
 */
public class HtmlParser {

    /**
     * Parses the HTML document to extract weather information.
     *
     * @param doc The HTML document to parse.
     * @return A string containing the parsed weather information.
     */
    public static String parseWeatherHtml(Document doc) {

        Elements weatherTable = doc.select("div[class=weather]");
        String weather = removeDetails(weatherTable.text());

        return weather;
    }

    /**
     * Removes specific details from the input string using regular expressions.
     *
     * @param input The input string containing weather details.
     * @return The input string with specified details removed.
     */
    private static String removeDetails(String input) {

        String regex = "\\s*подробно\\s*→\\s*";

        return input.replaceAll(regex, " ");
    }
}
