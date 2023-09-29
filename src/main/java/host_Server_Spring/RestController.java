package host_Server_Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	public static class RestResponse{
		private String param1;
		private String param2;
		private ResponseEntity<String> param3;
		
		public void setParam1(String param1) {
			this.param1 = param1;
		}
		public void setParam2(String param2) {
			this.param2 = param2;
		}
		public void setParam3(ResponseEntity<String> param3) {
			this.param3 = param3;
		}
		
		public String getParam1() {
			return param1;
		}
		public String getParam2() {
			return param2;
		}
		public ResponseEntity<String> getParam3() {
			return param3;
		}
	}
	
	@RequestMapping (value = "/api", method = RequestMethod.GET,
			produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	
			public RestResponse testmethod(String name,String age) {
			RestResponse result = new RestResponse();
			result.setParam1(age);
			result.setParam2(name);
			
			String chatResponse = chatService.chatWithGPT(name);
		
			result.setParam3(ResponseEntity.ok(chatResponse));
			return result;
			
	}
	
	 @Autowired
	    private ChatService chatService;

	    @PostMapping("/chat")
	    public ResponseEntity<String> chatWithGPT(@RequestBody String userMessage) {
	    	System.out.println(userMessage);
	        try {
	            String chatResponse = chatService.chatWithGPT(userMessage);
	            return ResponseEntity.ok(chatResponse);
	        } catch (Exception e) {
	            return ResponseEntity.status(500).body("Произошла ошибка: " + e.getMessage());
	        }
	    }
}
