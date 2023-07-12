package com.example.listfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LeaderDescription extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        render();
        setContentView(R.layout.activity_leader_description);
    }

    public void render(){
        ImageView leaderimg = findViewById(R.id.leaderImage);
        TextView leaderName = findViewById(R.id.leaderName);
        TextView leaderDob = findViewById(R.id.leaderDob);
        TextView description = findViewById(R.id.leaderDescription);

//        leaderName.setText(primeMinisters[i]);
//        leaderDob.setText(primeministerDob[i]);
    }
}