package com.example.happytraveler_realy;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;




public class sub_map extends AppCompatActivity {
    private GoogleMap mMap;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub_map);
//        MapView mapView = new MapView(this);
        textView = (TextView) findViewById(R.id.textView);
//        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);
//        mapViewContainer.addView(mapView);

        출처: https://tosuccess.tistory.com/119 [EI_HJ]
        new Thread(){
            @Override
            public void run() {
                Document doc = null;
                try {
                    doc = Jsoup.connect("https://www.google.co.kr/maps/search/%EC%82%B0%EC%B1%85%EB%A1%9C/").get();
                    Elements contents = doc.select(".mapsConsumerUiSubviewSectionGm2Placeresultcontainer__content-container mapsConsumerUiSubviewSectionGm2Placeresultcontainer__result-container-clickable mapsConsumerUiSubviewSectionGm2Placeresultcontainer__content-container-is-link");

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }.start();
    }
    Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            Bundle bundle = msg.getData();
            textView.setText(bundle.getString());                      //이런식으로 View를 메인 쓰레드에서 뿌려줘야한다.
        }
    };


    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

}