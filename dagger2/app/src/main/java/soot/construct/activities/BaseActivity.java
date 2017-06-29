package soot.construct.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import soot.construct.R;


public class BaseActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
