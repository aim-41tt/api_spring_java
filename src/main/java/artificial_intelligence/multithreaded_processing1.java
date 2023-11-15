package artificial_intelligence;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class multithreaded_processing1 implements  Callable<String> {

	private String textWithUrl;
	
	public multithreaded_processing1(String textWithUrl) {this.textWithUrl = textWithUrl;}

	public String get_url() {return textWithUrl;}
	

	private String  mult_precess (String url) throws FileNotFoundException {
		// техт полученный из ссылки
		Website_to_text TextUrl = new  Website_to_text(); 
		
		Scanner sc = new Scanner(new File("DataSet/DataSet.txt"));
		
		
		
		/*
		создаю пул патоков под количество ядер
		*/
		 ExecutorService executorService = Executors.newFixedThreadPool(4); 
		 
		 Future<String> result1 = executorService.submit(new multithreaded_processing1(url));
		 Future<String> result2 = executorService.submit(new multithreaded_processing1(url));
		 Future<String> result3 = executorService.submit(new multithreaded_processing1(url));
		 Future<String> result4 = executorService.submit(new multithreaded_processing1(url));
	        
		 
		
		return "";
	}
   
	
	@Override
	public String call() throws Exception {
		
	return "";
	}
	
	
	
}
	
	/*
	 public static String getTEXT(String url1) throws InterruptedException, ExecutionException {
		
	        ExecutorService executorService = Executors.newFixedThreadPool(1); // Создаем пул из 4 потоков

	        Future<String> result1 = executorService.submit(new multithreaded_processing(url1));
	            
		return result1.get();
	}
	 
	
	

	public multithreaded_processing(String textToProcess) {this.url = textToProcess;}
	    
	

	@Override
	public String call() throws Exception {
		
		Scanner sc = new Scanner(new File("DataSet/DataSet.txt"), StandardCharsets.UTF_8.name()); // загружаем и сканируем датасет
	
		Map<String, Integer> Result = new HashMap<>();

				 
		website_to_text WEB_text = new  website_to_text(); // создаём объект website_to_text
		String textTo_Process = WEB_text.get_website_to_text(url); // берём текст из url
	 
		while(sc.hasNext()) {					// проходка по датасету до его конца
			String textDataset = sc.nextLine();
			if(!textDataset.equals("")) {
		String []mas = textDataset.split(":");	// создаём массив [0] тема [1] ключ слова
		 List<String> list_keytext = new ArrayList<>(Arrays.asList(mas[1].split(","))); // создаём лист и записываем в него ключ слова
		 int counter=0;
		 for (String word : list_keytext) 
			 if (textTo_Process.contains(word)) 
				 Result.put(mas[0], counter+=1);
	            

		}
		}

		List<Map.Entry<String, Integer>> list = new ArrayList<>(Result.entrySet());

       // Сортировка списка по значениям в обратном порядке
       Collections.sort(list, Collections.reverseOrder(Map.Entry.comparingByValue()));

       // Создание новой упорядоченной Map
       Map<String, Integer> sortedMap = new LinkedHashMap<>();
       for (Map.Entry<String, Integer> entry : list) {
           sortedMap.put(entry.getKey(), entry.getValue());
       }
       
		String result_get = "";
		 for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
	            String key = entry.getKey();
	            Integer value = entry.getValue();
	            result_get+=(key+":"+value+";");
	        }
		 
		 if (result_get.isEmpty()) {
		        return "ошибка программа не может определить тему данного сайта";
		    } else {
		        return result_get;
		    }
		
	}
	   
	}
*/