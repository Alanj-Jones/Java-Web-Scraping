import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Scraper {
    public static void main(String[] args) throws Exception{
        //Conectamos a la pagina que queremos recorrer
        Document doc = Jsoup.connect("https://www.imdb.com/chart/top").timeout(6000).get();
        
        //Podemos encontrar la totalidad de elementos dentro de una etiqueta del dom
        Elements body = doc.select("tbody.lister-list");
        //System.out.println(body.select("tr").size());

        //Usamos un 'for' para recorrer todos los elementos de un determinado lado
        for(Element e : body.select("tr")){

            String img = e.select("td.posterColumn img").attr("src");
            String title = e.select("td.titleColumn a").text();
            String year = e.select("td.titleColumn span.secondaryInfo").text();
            //System.out.println(img); 
            System.out.println(title + " "+year);
        }
    }
}
