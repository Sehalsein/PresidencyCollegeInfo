package com.sehalsein.presidencycollegeinfo.Activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.sehalsein.presidencycollegeinfo.Model.ListModel;
import com.sehalsein.presidencycollegeinfo.R;
import com.sehalsein.presidencycollegeinfo.UserData;

public class Solutions extends AppCompatActivity {

    private TextView solutions;
    private TextView title;
    private Button additional;
    private ImageView detailImage;

    public ListModel listModel;

    private String answers,quetions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solutions);

        solutions = (TextView) findViewById(R.id.answers);
        title = (TextView) findViewById(R.id.title);
        additional = (Button) findViewById(R.id.additionalInfo);
        detailImage = (ImageView) findViewById(R.id.detailImage);


        answers = UserData.listModel.getAnswers();
        quetions = UserData.listModel.getQuetions().toUpperCase();
        detailImage.setBackgroundResource(UserData.listModel.getDetailImage());

        if(quetions.equals("ROUTE")) {
            additional.setVisibility(View.VISIBLE);
        }else{
            additional.setVisibility(View.GONE);
        }
        solutions.setText(answers);
        title.setText(quetions);

    }


    public void getDirection(View view){
        String map = "https://www.google.com/maps/search/?api=1&query=3.0505124,77.597941&query_place_id=ChIJP13gvoUXrjsRUvhNt4amGug";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(map));
        this.startActivity(intent);
    }

}
