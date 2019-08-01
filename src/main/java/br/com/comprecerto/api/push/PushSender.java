package br.com.comprecerto.api.push;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.comprecerto.api.entities.Pedido;
 
 

public class PushSender {
 
  private final String TOPIC = "JavaSampleApproach";
  
  @Autowired
  AndroidPushNotificationsService androidPushNotificationsService;
 
  
  public ResponseEntity<String> sendAtualizaçãoPedido( Pedido pedido) throws JSONException {
 
    JSONObject body = new JSONObject();
    body.put("to",  pedido.getUsuario().getFirebaseToken());    
 
    JSONObject notification = new JSONObject();
    notification.put("title", "O pedido "+ pedido.getIdPedido()+"tem um novo status!");
    notification.put("body", br.com.comprecerto.api.entities.enums.Status.valueOf(pedido.getStatus().toString()));
    notification.put("priority", "high");
    notification.put("icon", "notification_icon");
    
    JSONObject data = new JSONObject();
    data.put("body", "O pedido "+ pedido.getIdPedido()+" mudou para "+br.com.comprecerto.api.entities.enums.Status.valueOf(pedido.getStatus().toString()));
    data.put("priority", "high");
 
    body.put("notification", notification);
    body.put("data", data);
 
/**
    {
 "to" : "dClQP1Dml58:APA91bEPjueAX0xdxSDLwR3nKOphneVH0ZWfzSPjFOQw3KHfBClMR2uIcMsvgQP5c3EAhZVeAoZUPlpnM69eRL2nypLWw9r6zum_A9mNEz1kI_FH22tM8vy20V7gwkDu6U1b8z8WfMbx",
 "notification" : {
	 "body" : "cuidado com seu sócio!",
	 "title" : "IMPORTANTE",
	 "priority" : "high",
	 "icon" : "notification_icon"
 },
 "data" : {
	 "body" : "great match!",
	 "priority" : "high"
 } 
}
*/
 
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
