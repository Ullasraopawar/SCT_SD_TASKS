import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;

public class SCT_SD_04 {

    public static void main(String[] args) {

        String baseUrl = "https://books.toscrape.com/catalogue/page-";
        String fileName = "products.csv";

        try (CSVWriter writer = new CSVWriter(new FileWriter(fileName))) {
            // CSV Header
            writer.writeNext(new String[]{"Product Name", "Price", "Rating"});

            for (int i = 1; i <= 5; i++) { // Scrape first 5 pages
                String url = baseUrl + i + ".html";
                Document doc = Jsoup.connect(url).get();
                Elements products = doc.select("article.product_pod");

                for (Element product : products) {
                    String title = product.select("h3 a").attr("title");
                    String price = product.select(".price_color").text();
                    String ratingClass = product.select(".star-rating").first().className();
                    String rating = ratingClass.replace("star-rating", "").trim();

                    writer.writeNext(new String[]{title, price, rating});
                }
            }

            System.out.println("Data successfully written to " + fileName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

