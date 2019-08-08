package br.com.comprecerto.api.push;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.comprecerto.api.entities.Pedido;
 
 
@Service
public class PushSender {
 
  
  @Autowired
  AndroidPushNotificationsService androidPushNotificationsService;
 
  
  public ResponseEntity<String> sendAtualizacaoPedido(Pedido pedido) throws JSONException {
 
    JSONObject body = new JSONObject();
    body.put("to",  pedido.getUsuario().getFirebaseToken());    
 
    JSONObject notification = new JSONObject();
    notification.put("title", "O pedido #"+ pedido.getIdPedido()+" tem um novo status!");
    notification.put("body", pedido.getStatus().getDescricao());
    notification.put("priority", "high");
    notification.put("icon", "notification_icon");
    notification.put("color", "#009b89");
    
    JSONObject data = new JSONObject();
    data.put("body", "O pedido "+ pedido.getIdPedido()+" mudou para "+pedido.getStatus().getDescricao());
    data.put("priority", "high");
 
    body.put("notification", notification);
    body.put("data", data);

    
    HttpEntity<String> request = new HttpEntity<>(body.toString());    		
 
    CompletableFuture<String> pushNotification = androidPushNotificationsService.send(request);
    CompletableFuture.allOf(pushNotification).join();
     
    try {
      String firebaseResponse = pushNotification.get();
      
      return new ResponseEntity<>(firebaseResponse, HttpStatus.OK);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    }
 
    return new ResponseEntity<>("Push Notification ERROR!", HttpStatus.BAD_REQUEST);
  }
  
  public ResponseEntity<String> sendAtualizacaoPedido2() throws JSONException {
	  
	    JSONObject body = new JSONObject();
	    body.put("to",  "cxiMW3UmNKg:APA91bHTKbBCJDuhTwY2qbDdtXMZEta-vcYjpsvSxv7K_Y_DriZ2CuUSUKyj-w_h0Hdmoa7oKGt62Ja2DY-vYcyP1Y-tgc3Bjm53wY-IIvrWPnj0Pz4LL0UKvWMPy_Wh8NHwEbG-Ul3j");    
	 
	    JSONObject notification = new JSONObject();
	    notification.put("title", "O pedido #");
	    notification.put("body", "teste");
	    notification.put("priority", "high");
	    notification.put("icon", "notification_icon");
	    notification.put("color", "#009b89");
	    
	    JSONObject data = new JSONObject();
	    data.put("body", "O pedido ");
	    data.put("priority", "high");
	 
	    body.put("notification", notification);
	    body.put("data", data);

	    
	    HttpEntity<String> request = new HttpEntity<>(body.toString());    		
	 
	    CompletableFuture<String> pushNotification = androidPushNotificationsService.send(request);
	    CompletableFuture.allOf(pushNotification).join();
	     
	    try {
	      String firebaseResponse = pushNotification.get();
	      
	      return new ResponseEntity<>(firebaseResponse, HttpStatus.OK);
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	    } catch (ExecutionException e) {
	      e.printStackTrace();
	    }
	 
	    return new ResponseEntity<>("Push Notification ERROR!", HttpStatus.BAD_REQUEST);
	  }
}
