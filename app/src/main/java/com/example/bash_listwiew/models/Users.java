package com.example.bash_listwiew.models;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.bash_listwiew.MainActivity;
import com.example.bash_listwiew.helpers.QueueUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Users {
    public String nickname;
    public String name;
    public String apellidos;
    public String phone;
    public String image;

    public Users(String _nickname, String _name,String _apellidos,String _phone,String _image) {
        this.nickname = _nickname;
        this.name = _name;
        this.apellidos = _apellidos;
        this.phone = _phone;
        this.image = _image;
    }

    public static ArrayList getCollection() {
        ArrayList<Users> collection = new ArrayList<>();
        collection.add(new Users("user01","Bash","Wolf",
                "963696889",
                "https://mymodernmet.com/wp/wp-content/uploads/2019/09/100k-ai-faces-3.jpg"));
        collection.add(new Users("user02","Endevor","Bata",
                "963123963","https://mymodernmet.com/wp/wp-content/uploads/2019/09/100k-ai-faces-3.jpg"));
        collection.add(new Users("user03","Doraemon","Tilin","965213741",
                "https://mymodernmet.com/wp/wp-content/uploads/2019/09/100k-ai-faces-3.jpg"));
        collection.add(new Users("user04","Basura","Inmunda","987456582","https://mymodernmet.com/wp/wp-content/uploads/2019/09/100k-ai-faces-3.jpg"));
        collection.add(new Users("user05","Harry","Potter","951357852","https://mymodernmet.com/wp/wp-content/uploads/2019/09/100k-ai-faces-3.jpg"));
        collection.add(new Users("user06","Bil","Gates","984268751","https://mymodernmet.com/wp/wp-content/uploads/2019/09/100k-ai-faces-3.jpg"));
        return collection;
    }
    public String getSmallImage() {
        return this.image;
    }

    public static void injectContactsFromCloud(final QueueUtils.QueueObject o,
                                               final ArrayList<Users> users,
                                               final MainActivity _interface,
                                               final String tipo) {
        String url = "http://earthy-auroraceratops-pky31oxz6q.glitch.me/products.json?tipo="+tipo;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        if (response.has("objects")) {

                            try {
                                JSONArray list = response.getJSONArray("objects");
                                for (int i=0; i < list.length(); i++) {
                                    JSONObject o = list.getJSONObject(i);
                                    users.add(new Users(o.getString("name"),
                                            o.getString("description"),"_apellido","123","_image"));
                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            _interface.refreshList(); // Esta función debemos implementarla
                            // en nuestro activity
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        o.addToRequestQueue(jsonObjectRequest);
    }
    public static void sendRequestPOST(QueueUtils.QueueObject o, final MainActivity _interface) {
        String url = "http://rrojasen.alwaysdata.net/purchaseorders.json";
/*        url = "http://fipo.equisd.com/api/users/new.json";*/
        url = "https://earthy-auroraceratops-pky31oxz6q.glitch.me/products/new.json";
        /*url = "http://192.168.58.3:8056/api/users/new.json";*/
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            //Do it with this it will work
                            JSONObject _response = new JSONObject(response);
                            if (_response.has("object")) {
                                JSONObject object_response = null;
                                try {
                                    object_response = _response.getJSONObject("object");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                                if ( object_response != null ) {
                                    try {
                                        System.out.println(object_response.getInt("id"));
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("first_name","Jhonatan  ");
                params.put("last_name","Yalico");
                params.put("avatar","^-^");

                return params;
            }
        };
        o.addToRequestQueue(stringRequest);
    }
}
