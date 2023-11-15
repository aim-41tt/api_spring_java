package artificial_intelligence;


import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Website_to_text {
	
	
    public  String getTextFromUrl(String url) {
    	
    	 CloseableHttpClient httpClient = HttpClients.createDefault();
 
         try {
             HttpGet httpGet = new HttpGet(url);
             
             // Устанавливаем заголовок "User-Agent" для эмуляции браузера
             httpGet.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");

             CloseableHttpResponse response = httpClient.execute(httpGet);

             try {
                 HttpEntity entity = response.getEntity();
                 if (entity != null) {
                     // Используем Jsoup для парсинга HTML
                	 String html = EntityUtils.toString(entity);
                     Document doc = Jsoup.parse(html);

                     // Получаем весь текст с HTML-документа
                     String textWithUrl = doc.text();

                     // Выводим текст на консоль
                    // System.out.println(text);
                     return textWithUrl;
                 }
             } finally {
                 response.close();
             }
         } catch (Exception e) {
             e.printStackTrace();
         } finally {
             try {
                 httpClient.close();
             } catch (Exception e) {
                 e.printStackTrace();
             }
         }
         return "";
     }
}
