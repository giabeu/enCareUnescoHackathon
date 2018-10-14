package com.example.trang.encare;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Newfeed extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final int NUM_COLUMNS = 2;

    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mArticle = new ArrayList<>();
    private ArrayList<String> mLink = new ArrayList<>();

    Button btn_report,btn_map;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newfeed);

        btn_report = findViewById(R.id.btn_report);
        btn_report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToReport();
            }
        });

        btn_map = findViewById(R.id.btn_map);
        btn_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToMap();
            }
        });

        initImageBitmaps();
    }

    public void moveToReport(){
        Uri uriUrl = Uri.parse("http://m.me/352669062144608");
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
   public void moveToMap(){
        Intent launchBrowser = new Intent(Newfeed.this, Map.class);
        startActivity(launchBrowser);
    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("https://climate.nasa.gov/system/news_items/list_view_images/2817_arctic20181011-320x240.jpg");
        mNames.add("The Arctic Ocean's sea ice blanket has already lost most... ");
        mArticle.add("With thick ice gone");
        mLink.add("https://climate.nasa.gov/news/2817/with-thick-ice-gone-arctic-sea-ice-changes-more-slowly/");

        mImageUrls.add("https://climate.nasa.gov/system/news_items/list_view_images/2816_PIA22748-320x240.jpg");
        mNames.add("Hurricane Michael plowed into the Florida panhandle Wednesday...");
        mArticle.add("All eyes on Hurricane");
        mLink.add("https://climate.nasa.gov/news/2816/all-eyes-on-hurricane-michael/");

        mImageUrls.add("https://climate.nasa.gov/system/news_items/main_images/2810_main_image.jpg");
        mNames.add("Five new NASA Earth science campaigns, including one from NASA...");
        mArticle.add("JPL airborne mission");
        mLink.add("https://climate.nasa.gov/news/2810/jpl-airborne-mission-is-one-of-five-new-earth-ventures/");

        mImageUrls.add("https://imagecache.jpl.nasa.gov/images/640x350/noaa20180919-16-640x350.jpg");
        mNames.add("Hurricane Harvey dumped more than 5 feet (1.5 meters) of water on...");
        mArticle.add("New study tracks Hurricane");
        mLink.add("https://climate.nasa.gov/news/2803/new-study-tracks-hurricane-harvey-stormwater-with-gps/");

        mImageUrls.add("https://climate.nasa.gov/system/news_items/main_images/2805_main_image.jpg");
        mNames.add("A typical desk globe is designed to be a geometric sphere and to...");
        mArticle.add("Scientists ID three causes of Earth");
        mLink.add("https://climate.nasa.gov/news/2805/scientists-id-three-causes-of-earths-spin-axis-drift/");

        mImageUrls.add("https://climate.nasa.gov/system/news_items/main_images/2802_main_image.jpg");
        mNames.add("NASA's ECOsystem Spaceborne Thermal Radiometer...");
        mArticle.add("ECOSTRESS maps");
        mLink.add("https://climate.nasa.gov/news/2802/ecostress-maps-las-hot-spots/");

        mImageUrls.add("https://climate.nasa.gov/system/news_items/main_images/2800_icesat2-768px.jpg");
        mNames.add("NASA’s Ice, Cloud and land Elevation Satellite-2...");
        mArticle.add("NASA, ULA launch mission");
        mLink.add("https://climate.nasa.gov/news/2800/nasa-ula-launch-mission-to-track-earths-changing-ice/");
/*
        mImageUrls.add("https://climate.nasa.gov/system/news_items/main_images/2789_D65516D9-E9ED-4109-BA79-1C3AB9D99B40.jpeg");
        mNames.add("Media accreditation is open for the launch of NASA’s Ice");
        mArticle.add("NASA invites media to view launch");
        mLink.add("https://climate.nasa.gov/news/2789/nasa-invites-media-to-view-launch-of-icesat-2-from-west-coast/");*/

        mImageUrls.add("https://climate.nasa.gov/system/news_items/main_images/2790_icesatphoto-768px.jpg");
        mNames.add("Next month, NASA will launch into space the most advanced...");
        mArticle.add("NASA launching advanced laser");
        mLink.add("https://climate.nasaF.gov/news/2790/nasa-launching-advanced-laser-to-measure-earths-changing-ice/");

/*        mImageUrls.add("https://climate.nasa.gov/system/news_items/main_images/2784_C6FC8669-1019-4D6F-BD81-656A8B873CC3.jpeg");
        mNames.add("NASA will host a media teleconference at 1 p.m...");
        mArticle.add("NASA to host media briefing");
        mLink.add("https://climate.nasa.gov/news/2784/nasa-to-host-media-briefing-on-new-ice-monitoring-mission/");*/
        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: initializing staggered recyclerview.");

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        StaggeredRecyclerViewAdapter staggeredRecyclerViewAdapter =
                new StaggeredRecyclerViewAdapter(this, mNames, mImageUrls, mArticle, mLink);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(staggeredRecyclerViewAdapter);
    }
}
