package com.vrajaninfotech.vampy.googlelogin;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;

public class profile_activity extends AppCompatActivity {

    ImageView profile_photo;
    TextView surname,name,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Bundle inBundle = getIntent().getExtras();
        String fname = inBundle.get("name").toString();
        String fsurname = inBundle.get("surname").toString();
        String fimageUrl = inBundle.get("imageUrl").toString();

        surname = (TextView)findViewById(R.id.surname);
        name = (TextView)findViewById(R.id.name);
        email = (TextView)findViewById(R.id.email);

        surname.setText(fsurname);
        name.setText(fname);
        new DownloadImage((ImageView)findViewById(R.id.profile_photo)).execute(fimageUrl);
    }
}

