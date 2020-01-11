package com.example.bash_listwiew;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

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
        final boolean btn1,btn2;
        btn1 = true;
        btn2 = true;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button btnTipo = findViewById(R.id.btnTipo);
        btnTipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Platos de Lima", Toast.LENGTH_SHORT).show();
                items.clear();
                Users.injectContactsFromCloud(queue, items, MainActivity.this, "lima");
                if (btn1 == true) {
                    btnTipo.setBackgroundColor(0x05a27a);
                }
            }
        });

        final Button btnTipo2 = findViewById(R.id.btnTipo2);
        btnTipo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Platos de Huancayo", Toast.LENGTH_SHORT).show();
                items.clear();
                Users.injectContactsFromCloud(queue, items, MainActivity.this, "huancaino");
                if (btn2  == true) {
                    btnTipo2.setBackgroundColor(0x05a27a);
                }
            }
        });
        
        usersList = findViewById(R.id.usersList);
        queue = QueueUtils.getInstance(this.getApplicationContext());
        items = new ArrayList<>();
        Users.injectContactsFromCloud(queue, items, this, "huancaino");
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
