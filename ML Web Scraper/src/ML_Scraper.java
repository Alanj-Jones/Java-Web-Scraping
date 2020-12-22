import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ML_Scraper {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://listado.mercadolibre.com.ar/notebook#D[A:notebook]").timeout(6000).get();

        Elements body = doc.select("body main div.ui-search ol li");
        //System.out.println(body.select("div h2").text());
        ArrayList <Element> productos = new ArrayList<>();
        for(Element e : body.select("div")){
            if (!e.select("h2").text().isEmpty() && !e.select("span.price-tag-fraction").text().isEmpty()){

                productos.add(e);
                System.out.print("Producto: " + e.select("h2").text()
                                    +"\nPrecio: " + e.select("span.price-tag-fraction").text()+ "\n");
            }
        }

    }
}
