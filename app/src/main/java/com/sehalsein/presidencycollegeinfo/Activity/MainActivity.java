package com.sehalsein.presidencycollegeinfo.Activity;

import android.content.Intent;
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

import me.alexrs.prefs.lib.Prefs;

public class MainActivity extends AppCompatActivity {

    private String TAG = getClass().getName();

    private RecyclerView recyclerView;
    GeometricProgressView geometricProgressView;

    String key = "logged_in";

    private List<ListModel> listModelsList = new ArrayList<>();

    String categories[] = {
            "ROUTE",
            "SECURITY CHECK",
            "Reception / Help desk",
            "Orientation programme",
            "Administration Department",
            "Accounts Department",
            "Library",
            "Lecture halls",
            "Canteen Facility",
            "Sports",
            "Club",
            "Parking",
            "CLINIC and Counsellor",
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
            "Landmark 1: Esteem Mall\n" +
                    "Landmark 2: Towards Kempapura road\n" +
                    "5 mins walk on this road towards Kempapura\n" +
                    "College building to your left",

            /*SECURITY CHECK*/
            "Security check at gate a must\n" +
                    "ID cards to be displayed prominently\n" +
                    "Registration at counter a must for visitors and parents\n" +
                    "Uniform check a must at gate\n" +
                    "CCTV monitored gates",

            /*Reception*/
            "Digital display  boards at lobby\n" +
                    "Ms Radhika at the reception\n" +
                    "Lift access is only on permission\n" +
                    "Soft tone of language and voice is respected",

            /*Orientation*/
            "A must for all students\n" +
                    "Session for overview of College and courses of the Department\n" +
                    "Conducted by the Head of the Department\n" +
                    "Venue: Seminar hall",

            /*Administration*/
            "Located in the basement\n" +
                    "Contact point for all queries related to admission formalities and University norms\n" +
                    "Contact point: Ms Bhan",

            /*Accounts*/
            "Located in the ground floor next to Admission office near the Atrium \n" +
                    "All course fee, exam fee, other fee done here",

            /*Library*/
            "Located at the 2nd & 3rd floors\n" +
                    "Temporary ID CARDs will be provided for all freshers\n" +
                    "A must use space for all students",

            /*Class*/
            "UG courses:\n" +
                    "BCA/BA: Basement classrooms and Psychology Lab\n" +
                    "BCom/BBA:  Ground floor, above the Atrium classrooms and II floor\n" +
                    "Computer labs: Ground floor",

            /*Canteen*/
            "Located at the rear side of the building\n" +
                    "Menu at display for each day -Break fast, Lunch and snack available apart from ice cream and chaat\n" +
                    "Veg and Non veg food available",

            /*Sports*/
            "Indoor and Outdoor games\n" +
                    "Basket ball court: near parking area\n" +
                    "Badminton court: near parking area\n" +
                    "Indoor Games\n" +
                    "Table tennis & carrom : 4th floor.",

            /*Club*/
            "Technozia – IT Club\n" +
                    "Disha – Cultural  Club\n" +
                    "ECO Club\n" +
                    "Udaan – Human  Rights Club\n" +
                    "Rotaract Club \n" +
                    "Khoj  – Hindi Club\n" +
                    "Odyssey – English Club \n" +
                    "Prathibhana – Kannada Club ",

            /*Parking*/
            "For 2 wheelers only\n" +
                    "Rs 500 parking fee paid in advance \n" +
                    "Parking sticker a must \n" +
                    "Flash parking card at security for smooth entry at gate\n" +
                    "Speed limit controlled\n" +
                    "No honking or revving engine inside campus",

            /*Clinic*/
            "Located inside Marketing office\n" +
                    "Doctor on call \n" +
                    "First aid and basic medical aid ready at campus\n" +
                    "Counsellor: Ms Bhama Suresh",

            /*Hostel*/
            "Separate hostels for boys and girls\n" +
                    "1 minute walk from college\n" +
                    "Lunch served at college premise: 4th floor\n" +
                    "Wardens to be contacted for all requirement",

            /*STUDENT*/
            "Who to contact for what?\n" +
                    "Anti-ragging - HOD\n" +
                    "Anti-Sexual Harassment Cell – Ms. Roseline\n" +
                    "Counselor – Ms. Bhama Suresh\n" +
                    "Physical Instructor: Mr Arun Prem\n" +
                    "Grievance Cell – Class Teacher\n" +
                    "Facilities head: Mr Raman"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(!Prefs.with(getApplicationContext()).getBoolean(key, false)) {
            Intent i = new Intent(MainActivity.this, Login.class);
            startActivity(i);
            finish();
        }

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
