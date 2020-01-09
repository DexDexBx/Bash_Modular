package com.example.bash_listwiew;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.bash_listwiew.adapters.UsersAdapters;
import com.example.bash_listwiew.helpers.QueueUtils;
import com.example.bash_listwiew.models.Users;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView usersList;
    UsersAdapters usersAdapters;
    QueueUtils.QueueObject queue = null;
    ArrayList<Users> items;
/*    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queue = QueueUtils.getInstance(this.getApplicationContext());
        usersList = findViewById(R.id.usersList);
        usersAdapters = new UsersAdapters(this, Users.getCollection(), queue.getImageLoader());
        usersList.setAdapter(usersAdapters);
    }*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usersList = findViewById(R.id.usersList);
        queue = QueueUtils.getInstance(this.getApplicationContext());
        items = new ArrayList<>();
        Users.injectContactsFromCloud(queue, items, this);
        Users.sendRequestPOST(queue,this);
        usersAdapters = new UsersAdapters(this, items,queue.getImageLoader());
        usersList.setAdapter(usersAdapters);
    }
    public void refreshList(){
        if ( usersAdapters!= null ) {
            usersAdapters.notifyDataSetChanged();
        }
    }
}
