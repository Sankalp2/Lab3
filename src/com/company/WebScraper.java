import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


public class WebScraper {
    public static void main(String[] args) {
        System.out.println(countWords("http://erdani.com/tdpl/hamlet.txt"));
        System.out.println(countWords("https://www.bls.gov/tus/charts/chart9.txt"));
        System.out.println(countWords("http://tgftp.nws.noaa.gov/data/raw/fz/fzus53.klot.srf.lot.txt"));
    }

    public static int countWords(String url) {
        String text = urlToString(url);
        int wordCount = 0;
        for(int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == ' ') {
                wordCount++;
            }
        }
        return wordCount;
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }


}