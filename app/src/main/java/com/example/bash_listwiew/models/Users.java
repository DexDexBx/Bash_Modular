package com.example.bash_listwiew.models;

import java.util.ArrayList;

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
}
