package com.sehalsein.presidencycollegeinfo.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

    String categories[] = {
            "ROUTE",
            "SECURITY CHECK",
            "Reception / Help desk",
            "Orientation programme",
            "Administration Department",
            "Accounts Department",
            "Library",
            "Class Room",
            "Canteen Facility",
            "Sports",
            "Club",
            "Parking",
            "Clinic",
            "Hostel",
            "Student Support"};

    int images[] = {
            R.drawable.route1,
            R.drawable.security1,
            R.drawable.reception1,
            R.drawable.classroom1,
            R.drawable.admin1,
            R.drawable.accounts1,
            R.drawable.library1,
            R.drawable.classroom2,
            R.drawable.canteen1,
            R.drawable.sports1,
            R.drawable.club1,
            R.drawable.parking1,
            R.drawable.clinic1,
            R.drawable.hostel1,
            R.drawable.teacher1
    };

    String solutions[] = {
            /*ROUTE*/
            "From Hebbal or Yelhanka reach Esteem mall bus stop.\n" +
                    "5 min walk through the adjacent road of Esteem Mall.\n" +
                    "0.5 km distance to reach college.",

            /*SECURITY CHECK*/
            "Securities at the  gate check ID card(except freshers).\n" +
                    "Parents must register and acquire visitors pass from security chamber.",

            /*Reception*/
            "Any queries related to college regarding admission, class rooms and staff will be attended.",

            /*Orientation*/
            "Brief and basic introduction of college and course will be given for the freshers.\n" +
                    "It would be conducted by the respective head of the department",

            /*Administration*/
            "Location-Basement\n" +
                    "Queries related to admission formalities pertaining to university norms can be clarified.",

            /*Accounts*/
            "Location- Right side of Atrium \n" +
                    "Any queries/payments regarding course fee structure.",

            /*Library*/
            "Location-2nd and 3rd floor.\n" +
                    "Temporary ID CARD will be provided for the fresher.",

            /*Class*/
            "UG: B1,B2,G1,G2.\n" +
                    "LAB-ROOMS: LAB1,LAB2,LAB3. ",

            /*Canteen*/
            "Menu for each day -Break fast, Lunch and snacks, will be different.",

            /*Sports*/
            "Outdoor Games\n" +
                    "Basket ball court: near parking area\n" +
                    "Badminton court: near parking area\n" +
                    "Indoor Games\n" +
                    "Table tennis & carom : 4th floor.",

            /*Club*/
            "GYM:4th floor",

            /*Parking*/
            "2 wheelers only\n" +
                    "500 rupees will be collected \n" +
                    "Parking card provided to student after paying amount.\n" +
                    "Flash parking card to security for entry in college.",

            /*Clinic*/
            "Location-Admission Department\n" +
                    "Doctor available for consultation.",

            /*Hostel*/
            "BOYS & GIRLS Hostel are separate\n" +
                    "1 minute walk from college.\n" +
                    "Lunch will be provided for hostellers on 4th floor.",

            /*STUDENT*/
            "Anti-ragging - HOD\n" +
                    "Anti-Sexual Harassment Cell – Ms. Roseline\n" +
                    "Counselor – Ms. Bhama Suresh\n" +
                    "Grievances Cell – Class Teacher"
    };


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


        List<ListModel> result = null;
        try {

            result = new ArrayList<ListModel>();
            for (int i = 0; i <= categories.length; i++) {
                ListModel model = new ListModel();
                model.setQuetions(categories[i]);
                model.setAnswers(solutions[i]);
                model.setImages(images[i]);
                result.add(model);
            }
        } catch (Exception e) {
            System.out.print(e);
        }

        recyclerView.setAdapter(new ListAdapter(MainActivity.this, result));
        geometricProgressView.setVisibility(View.INVISIBLE);

    }
}
