package webscrape;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
/**
 *
 * @author Shane - shanelee.co.uk
 */
public class WebScrape {
    public static void main(String[] args) {
    int counter = 1;
        final String url =

                "https://www.nfl.com/stats/player-stats/category/receiving/2021/post/all/receivingreceptions/desc";
        try {
            final Document document = Jsoup.connect(url).get();
            for (Element row : document.select(
                    "table.d3-o-table.d3-o-table--detailed.d3-o-player-stats--detailed.d3-o-table--sortable tr")) {
                if (row.select("td:nth-of-type(1)").text().equals("")) {
                    continue;
                }
                else {
                    final String name =
                            row.select("td:nth-of-type(1)").text();
                    final String rec =
                            row.select("td:nth-of-type(2)").text();
                    final String yds =
                            row.select("td:nth-of-type(3)").text();
                    final String tds =
                            row.select("td:nth-of-type(4)").text();



                    System.out.println(counter +".) Name: " + name+ " rec: " + rec + " yds: " + yds + " TDs: " + tds);
                    counter++;
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
