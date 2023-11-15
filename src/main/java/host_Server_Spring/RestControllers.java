package host_Server_Spring;



import java.util.concurrent.ExecutionException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import artificial_intelligence.multithreaded_processing;




@RestController
//@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class RestControllers {

    public static class RestResponse { 

        private String url;
        private String tema;
        
        public void setTema(String tema) {
            this.tema = tema;
        }
        public String getTema() {
            return tema;
        }
        public void setUrl(String url) {
            this.url = url;
        }
        public String getUrl() {
            return url;
        }
    }
   
    
    

    @RequestMapping(value = "/check_url", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RestResponse> check_url(String url1
    		
    		) {
        try {
            String[] mas = multithreaded_processing.getTEXT(url1).split(";");
            RestResponse RR = new RestResponse();
            RR.setUrl(url1);

            StringBuilder otvet = new StringBuilder();
            int count = 0;

            for (String text : mas) {
                if (count < 3) {
                    otvet.append(text).append(" ");
                    count++;
                } else {
                    break;
                }
            }

            RR.setTema(otvet.toString());

            return new ResponseEntity<>(RR, HttpStatus.OK);
        } catch (Exception e) {
            // Обработка ошибок, например, логирование
            e.printStackTrace();

            // Вернуть корректный HTTP-ответ в случае ошибки
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }






    
    
    @GetMapping("/check_url_test")
    public String check_url_test(String url1) {
    	String mas[];
		try {
			mas = multithreaded_processing.getTEXT(url1).split(";");
			String otvet="";
	    	for(String text:mas) {
	    		otvet+=text+" ";
	    	}
	    		
	        return otvet;
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
        return "500";
    }
     

}
