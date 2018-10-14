package com.example.trang.encare;

import android.Manifest;
        import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
        import com.google.android.gms.maps.CameraUpdateFactory;
        import com.google.android.gms.maps.GoogleMap;
        import com.google.android.gms.maps.MapFragment;
        import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class Map extends AppCompatActivity implements
        GoogleMap.OnMarkerClickListener,
        OnMapReadyCallback {

    Button btn_news, btn_rp, button;
    TextView title, snippet, info;
    private Marker markNum1, markNum2, markNum3, markNum4, markNum5, markNum6, markNum7, markNum8, markNum9, markNum10;
    public static TextView tv_seachkey;
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mLinks = new ArrayList<>();
    LinearLayout ll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        btn_news = findViewById(R.id.btn_news);
        button = findViewById(R.id.button);
        btn_rp = findViewById(R.id.btn_rp);
        ll = findViewById(R.id.ll);
        tv_seachkey = findViewById(R.id.tv_seachkey);
        title = findViewById(R.id.title);
        snippet = findViewById(R.id.snippet);
        info = findViewById(R.id.info);
        btn_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToNews();
            }
        });
        snippet.setText("Please feel free to expand knowledge by searching on the map.");
        ll.setBackgroundResource(R.drawable.ima3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Map.this, Main2Activity.class);
                startActivity(intent);
            }
        });

        btn_rp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToReport();
            }
        });

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.myMap);
        mapFragment.getMapAsync(this);
        getImages();
    }

    public void moveToReport(){
        Uri uriUrl = Uri.parse("http://m.me/352669062144608");
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
    public void moveToNews(){
        Intent intent = new Intent(Map.this, Newfeed.class);
        startActivity(intent);

    }

    private void addLinks(){
        mLinks.add("https://i0.wp.com/pattayaone.news/wp-content/uploads/2018/02/1-35.jpg");
        mLinks.add("http://www.thaige.co.th/addons/default/modules/service/uploads/news_1351564321.JPG");
        mLinks.add("https://www.myclimate.org/fileadmin/myc/klimaschutzprojekte/thailand-7140-7170/klimaschutzprojekt-thailand-7140-7170-3.jpg");
        mLinks.add("https://www.digitalnewsasia.com/sites/default/files/images/digital%20economy/Padi%20Farmer%20Thailand%20cropped.jpg");
        mLinks.add("http://kitmiyamoto.com/wp-content/uploads/2014/08/chaing-rai-street.jpg");
    }
    private void getImages(){
//import image source and its nametag
        mNames.add("Government");
        mNames.add("Drought");
        mNames.add("Flood");
        mNames.add("El Nina");
        mNames.add("Tornado");
        mNames.add("Ice-Melting");
        mNames.add("Earthquake");
        mNames.add("El Nino");
        mNames.add("Affected areas");
        mNames.add("Lives");
        mNames.add("Stories");
        mNames.add("Statistic");
        // mImageUrls.add("https://i.imgur.com/ZcLLrkY.jpg");
        // mNames.add("Washington");

        initRecyclerView();
    }

    private void initRecyclerView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames);
        recyclerView.setAdapter(adapter);
    }
    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng sydney = new LatLng(13.5435426, 100.6573302); // 13.5435426,100.6573302

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        googleMap.setMyLocationEnabled(true);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,5));
        markNum1 = googleMap.addMarker(new MarkerOptions()
                .title("Thailand")
                .snippet("Bangkok - Top 20 emitting countries by total fossil-fuel CO2 emissions")
                .position(sydney)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.facemask))
        );

        sydney = new LatLng(15.2014402,100.6412823);

        markNum2 = googleMap.addMarker(new MarkerOptions()
                .title("Thailand")
                .snippet("Lopburi Solar Farm - A 55-megawatt photovoltaic power station")
                .position(sydney)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.m))
        );

        sydney = new LatLng(16.4386536,99.7133155);

        markNum3 = googleMap.addMarker(new MarkerOptions()
                .title("Thailand")
                .snippet("Nakhon Sawan - Generating sustainable electricity from wastewater biogas")
                .position(sydney)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.m))
        );

        sydney = new LatLng(18.0678092,98.4355751);

        markNum4 = googleMap.addMarker(new MarkerOptions()
                .title("Thailand")
                .snippet("Lamphun - An example for where farmers are provided insurances")
                .position(sydney)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.insurance))
        );

        sydney = new LatLng(16.2474496,100.6537069);

        markNum5 = googleMap.addMarker(new MarkerOptions()
                .title("Thailand")
                .snippet("Phetchabun - An example for where farmers are provided insurances")
                .position(sydney)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.insurance))
        );

        sydney = new LatLng(19.9216035,99.7386383);

        markNum6 = googleMap.addMarker(new MarkerOptions()
                .title("Thailand")
                .snippet("Chiang Rai - Affected by a magnitude-6.1 earthquake")
                .position(sydney)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.earthquake))
        );

        sydney = new LatLng(17.4456164,102.2799298);

        markNum7 = googleMap.addMarker(new MarkerOptions()
                .title("Thailand")
                .snippet("Udon Thani - Water Pollution")
                .position(sydney)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.potion))
        );

        sydney = new LatLng(15.8195782,103.8493684);

        markNum8 = googleMap.addMarker(new MarkerOptions()
                .title("Thailand")
                .snippet("Yasothon - New Solar Power Farm")
                .position(sydney)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.m))
        );

        sydney = new LatLng(14.9065431,103.0287347);

        markNum9 = googleMap.addMarker(new MarkerOptions()
                .title("Thailand")
                .snippet("Surin - Farmers get insuranced")
                .position(sydney)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.insurance))
        );

        sydney = new LatLng(17.4310941,103.2799809);

        markNum10 = googleMap.addMarker(new MarkerOptions()
                .title("Thailand")
                .snippet("Sakon Nakhon - Earthquake")
                .position(sydney)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.earthquake))
        );

        googleMap.setOnMarkerClickListener((GoogleMap.OnMarkerClickListener) this);
    }

    @Override
    public boolean onMarkerClick(final Marker marker) {
        title.setText(marker.getTitle().toString());
        snippet.setText(marker.getSnippet());
        info.setText("Emissions in the region are high in both absolute and per capita terms...");
        button.setVisibility(View.VISIBLE);
        ll.setBackgroundResource(R.drawable.ima2); // need changes
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Map.this, Main2Activity.class);
                startActivity(intent);
            }
        });
        return false;
    }
}