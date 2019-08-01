package br.com.comprecerto.api.push;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
 
import org.springframework.http.HttpEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
 
@Service
public class AndroidPushNotificationsService {
 
  private static final String FIREBASE_SERVER_KEY = "AAAAkyDZg90:APA91bEbNHnJ9LysDosmz3rPheltnf3j4HK2YkzpOf0bmHc8X5e5wODVDnjvqvfy_LKGSCDRmIfUdJ7jqjp1ahpMsof4ji9MB1affNIm6pQAcZliXT2tHbzDcBVPwwQfFpsuf_HlCII0";
  private static final String FIREBASE_API_URL = "https://fcm.googleapis.com/fcm/send";
  
  @Async
  public CompletableFuture<String> send(HttpEntity<String> entity) {
 
    RestTemplate restTemplate = new RestTemplate();
    
    restTemplate.getMessageConverters()
    .add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
 
    /**
    https://fcm.googleapis.com/fcm/send
    Content-Type:application/json
    Authorization:key=FIREBASE_SERVER_KEY*/
 
    ArrayList<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
    interceptors.add(new HeaderRequestInterceptor("Authorization", "key=" + FIREBASE_SERVER_KEY));
    interceptors.add(new HeaderRequestInterceptor("Content-Type", "application/json;charset=UTF-8"));
    restTemplate.setInterceptors(interceptors);
        
    String firebaseResponse = restTemplate.postForObject(FIREBASE_API_URL,entity , String.class);
    
    return CompletableFuture.completedFuture(firebaseResponse);
  }
}