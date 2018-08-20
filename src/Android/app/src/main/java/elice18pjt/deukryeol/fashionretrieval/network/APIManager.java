package elice18pjt.deukryeol.fashionretrieval.network;

import android.content.Context;
import android.graphics.Bitmap;

import org.json.JSONException;
import org.json.JSONObject;

public class APIManager {
    public SocketManager sm;

    public APIManager(){
        sm = new SocketManager();
    }

    public Bitmap sendImage(Bitmap bitmap){
        int request = 1;
        JSONObject obj = new JSONObject();
        try {
            obj.put("request", request);
            obj.put("bitmap", bitmap);
        } catch(JSONException e){
            e.printStackTrace();
        }
        sm.sendJSON(obj);
        JSONObject resultJ = sm.getJSON();
        System.out.print("NotImplemented");
        sm.closeSocket();
        return null;
    }

}
