package com.example.android.friendcatalog;

import org.json.JSONException;
import org.json.JSONObject;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.Response.Listener;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
/**
 * Created by dylan on 11/12/16.
 */

public class FriendCatalog {

    private String token;

    public FriendCatalog(String username,String password,final FriendCatalogResponse listener){
        try {
            JSONObject value = (new JSONObject())
                    .put("username",username)
                    .put("password",password);

        new ServerCall("login",value,new Listener<String>(){
            public void onResponse(String response){
                try{
                    JSONObject json = new JSONObject(response);
                    token=json.getString("token");
                    listener.onResponse(json.getString("response"));
                }catch(org.json.JSONException err){
                    err.printStackTrace();
                }
            }
        });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public FriendCatalog (String email,String username,String password,final FriendCatalogResponse listener){
        try {
            JSONObject value = (new JSONObject())
                .put("email",email)
                .put("username",username)
                .put("password",password);

        new ServerCall("register",value,new Listener<String>(){
            public void onResponse(String response){
                try{
                    JSONObject json = new JSONObject(response);
                    token = json.getString("token");
                    listener.onResponse(json.getString("response"));
                }catch(org.json.JSONException err){
                    err.printStackTrace();
                }
            }
        });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void myprofile(final FriendCatalogResponse listener){
        try {
        JSONObject value = (new JSONObject())
                .put("token",token);

        new ServerCall("myprofile",value,new Listener<String>(){
            public void onResponse(String response){
                try{
                    JSONObject json = new JSONObject(response);
                    listener.onResponse(json);
                }catch(org.json.JSONException err){
                    err.printStackTrace();
                }
            }
        });
    } catch (JSONException e) {
        e.printStackTrace();
    }
    }

    public void editprofile(JSONObject profile,final FriendCatalogResponse listener){
        try {
            profile.put("token",token);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        new ServerCall("editprofile",profile,new Listener<String>(){
            public void onResponse(String response){
                try{
                    JSONObject json = new JSONObject(response);
                    listener.onResponse(json.getString("response"));
                }catch(org.json.JSONException err){
                    err.printStackTrace();
                }
            }
        });
    }

    public void search(JSONObject tags,int page,final FriendCatalogResponse listener){

        try {
            tags.put("page",page);
            tags.put("token",token);

        new ServerCall("search",tags,new Listener<String>(){
            public void onResponse(String response){
                try{
                    JSONObject json = new JSONObject(response);
                    listener.onResponse(json.getString("response"));
                }catch(org.json.JSONException err){
                    err.printStackTrace();
                }
            }
        });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void viewprofile(int profileId,final FriendCatalogResponse listener){
        try {
        JSONObject value = (new JSONObject())
                .put("token",token)
                .put("profileid",profileId);

        new ServerCall("viewprofile",value,new Listener<String>(){
            public void onResponse(String response){
                try{
                    JSONObject json = new JSONObject(response);
                    listener.onResponse(json);
                }catch(org.json.JSONException err){
                    err.printStackTrace();
                }
            }
        });
    } catch (JSONException e) {
        e.printStackTrace();
    }
    }

    public void getfriends(int page,final FriendCatalogResponse listener){
        try {
        JSONObject value = (new JSONObject())
                .put("token",token)
                .put("page",page);

        new ServerCall("getfriends",value,new Listener<String>(){
            public void onResponse(String response){
                try{
                    JSONObject json = new JSONObject(response);
                    listener.onResponse(json);
                }catch(org.json.JSONException err){
                    err.printStackTrace();
                }
            }
        });
    } catch (JSONException e) {
        e.printStackTrace();
    }
    }

    public void requestfriend(int profileId,final FriendCatalogResponse listener){
        try {
        JSONObject value = (new JSONObject())
                .put("token",token)
                .put("profile",profileId);

        new ServerCall("requestfriends",value,new Listener<String>(){
            public void onResponse(String response){
                try{
                    JSONObject json = new JSONObject(response);
                    listener.onResponse(json);
                }catch(org.json.JSONException err){
                    err.printStackTrace();
                }
            }
        });
    } catch (JSONException e) {
        e.printStackTrace();
    }
    }

    public class ServerCall extends StringRequest{
        private final String urldata = "https://friendcatalog.mybluemix.net/api/";
        private JSONObject params;

        public ServerCall(String function,JSONObject params,Listener<String> listener){
            super(Method.POST,"https://friendcatalog.mybluemix.net/api/".concat(function),listener,null);
            params = params;
        }

        public Map<String,String> getParams(){
            HashMap<String,String> m = new HashMap<String,String>();
            Iterator keys = params.keys();
            while(keys.hasNext()){
                String key = (String) keys.next();
                try {
                    m.put(key,params.getString(key));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return m;
        }

    }

}
