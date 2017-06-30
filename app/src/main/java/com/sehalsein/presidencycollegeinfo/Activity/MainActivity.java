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

    int detailedImage[] = {

            R.drawable.college,
            R.drawable.securitycheck1,
            R.drawable.reception3,
            R.drawable.orientation,
            R.drawable.admin,
            R.drawable.accounts,
            R.drawable.library5,
            R.drawable.lecturehall,
            R.drawable.canteen,
            R.drawable.sports,
            R.drawable.club,
            R.drawable.parking,
            R.drawable.clinic,
            R.drawable.hostel4,
            R.drawable.support
    };


    String solutions[] = {
            /*ROUTE*/
            "\u2022 Landmark 1: Esteem Mall\n" +
                    "\u2022 Landmark 2: Towards Kempapura road\n" +
                    "\u2022 5 mins walk on this road towards Kempapura\n" +
                    "\u2022 College building to your left",

            /*SECURITY CHECK*/
            "\u2022 Security check at gate a must\n" +
                    "\u2022 ID cards to be displayed prominently\n" +
                    "\u2022 Registration at counter a must for visitors and parents\n" +
                    "\u2022 Uniform check a must at gate\n" +
                    "\u2022 CCTV monitored gates",

            /*Reception*/
            "\u2022 Digital display  boards at lobby\n" +
                    "\u2022 Ms Radhika at the reception\n" +
                    "\u2022 Lift access is only on permission\n" +
                    "\u2022 Soft tone of language and voice is respected",

            /*Orientation*/
            "\u2022 A must for all students\n" +
                    "\u2022 Session for overview of College and courses of the Department\n" +
                    "\u2022 Conducted by the Head of the Department\n" +
                    "\u2022 Venue: Seminar hall",

            /*Administration*/
            "\u2022 Located in the basement\n" +
                    "\u2022 Contact point for all queries related to admission formalities and University norms\n" +
                    "\u2022 Contact point: Ms Bhan",

            /*Accounts*/
            "\u2022 Located in the ground floor next to Admission office near the Atrium \n" +
                    "\u2022 All course fee, exam fee, other fee done here",

            /*Library*/
            "\u2022 Located at the 2nd & 3rd floors\n" +
                    "\u2022 Temporary ID CARDs will be provided for all freshers\n" +
                    "\u2022 A must use space for all students",

            /*Class*/
            "\u2022 UG courses:\n" +
                    "\u2022 BCA/BA: Basement classrooms and Psychology Lab\n" +
                    "\u2022 BCom/BBA:  Ground floor, above the Atrium classrooms and II floor\n" +
                    "\u2022 Computer labs: Ground floor",

            /*Canteen*/
            "\u2022 Located at the rear side of the building\n" +
                    "\u2022 Menu at display for each day -Break fast, Lunch and snack available apart from ice cream and chaat\n" +
                    "\u2022 Veg and Non veg food available",

            /*Sports*/
            "\u2022 Indoor and Outdoor games\n" +
                    "\u2022 Basket ball court: near parking area\n" +
                    "\u2022 Badminton court: near parking area\n" +
                    "\u2022 Indoor Games\n" +
                    "\u2022 Table tennis & carrom : 4th floor.",

            /*Club*/
            "\u2022 Technozia – IT Club\n" +
                    "\u2022 Disha – Cultural  Club\n" +
                    "\u2022 ECO Club\n" +
                    "\u2022 Udaan – Human  Rights Club\n" +
                    "\u2022 Rotaract Club \n" +
                    "\u2022 Khoj  – Hindi Club\n" +
                    "\u2022 Odyssey – English Club \n" +
                    "\u2022 Prathibhana – Kannada Club ",

            /*Parking*/
            "\u2022 For 2 wheelers only\n" +
                    "\u2022 Rs 500 parking fee paid in advance \n" +
                    "\u2022 Parking sticker a must \n" +
                    "\u2022 Flash parking card at security for smooth entry at gate\n" +
                    "\u2022 Speed limit controlled\n" +
                    "\u2022 No honking or revving engine inside campus",

            /*Clinic*/
            "\u2022 Located inside Marketing office\n" +
                    "\u2022 Doctor on call \n" +
                    "\u2022 First aid and basic medical aid ready at campus\n" +
                    "\u2022 Counsellor: Ms Bhama Suresh",

            /*Hostel*/
            "\u2022 Separate hostels for boys and girls\n" +
                    "\u2022 1 minute walk from college\n" +
                    "\u2022 Lunch served at college premise: 4th floor\n" +
                    "\u2022 Wardens to be contacted for all requirement",

            /*STUDENT*/
            "\u2022 Who to contact for what?\n" +
                    "\u2022 Anti-ragging - HOD\n" +
                    "\u2022 Anti-Sexual Harassment Cell – Ms. Roseline\n" +
                    "\u2022 Counselor – Ms. Bhama Suresh\n" +
                    "\u2022 Physical Instructor: Mr Arun Prem\n" +
                    "\u2022 Grievance Cell – Class Teacher\n" +
                    "\u2022 Facilities head: Mr Raman"
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
                model.setDetailImage(detailedImage[i]);
                result.add(model);
            }
        } catch (Exception e) {
            System.out.print(e);
        }

        recyclerView.setAdapter(new ListAdapter(MainActivity.this, result));
        geometricProgressView.setVisibility(View.INVISIBLE);

    }
}
