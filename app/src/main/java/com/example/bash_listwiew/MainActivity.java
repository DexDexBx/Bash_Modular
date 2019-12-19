package com.example.bash_listwiew;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.bash_listwiew.adapters.UsersAdapters;
import com.example.bash_listwiew.helpers.QueueUtils;
import com.example.bash_listwiew.models.Users;

public class MainActivity extends AppCompatActivity {
    ListView usersList;
    UsersAdapters usersAdapters;

    QueueUtils.QueueObject queue = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queue = QueueUtils.getInstance(this.getApplicationContext());
        usersList = findViewById(R.id.usersList);
        usersAdapters = new UsersAdapters(this, Users.getCollection(), queue.getImageLoader());
        usersList.setAdapter(usersAdapters);


    }
}
