package com.sehalsein.presidencycollegeinfo.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.sehalsein.presidencycollegeinfo.Adapter.ListAdapter;
import com.sehalsein.presidencycollegeinfo.Model.ListModel;
import com.sehalsein.presidencycollegeinfo.R;

import net.bohush.geometricprogressview.GeometricProgressView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String TAG = getClass().getName();

    private RecyclerView recyclerView;
    GeometricProgressView geometricProgressView;

    private List<ListModel> listModelsList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        geometricProgressView = (GeometricProgressView) findViewById(R.id.progressView);

        setView();
        loadMemebers();


    }


    private void setView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    private void loadMemebers() {

        ListModel model = new ListModel();
        model.setQuetions("Category");
        model.setAnswers("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam et tortor imperdiet, sagittis eros sit amet, varius ex. Fusce hendrerit et enim vel rutrum. Donec auctor hendrerit nisl non auctor.");
        for (int i = 0 ; i< 10 ; i++) {
            listModelsList.add(model);
        }
        recyclerView.setAdapter(new ListAdapter(MainActivity.this, listModelsList));
        geometricProgressView.setVisibility(View.INVISIBLE);

    }
}
