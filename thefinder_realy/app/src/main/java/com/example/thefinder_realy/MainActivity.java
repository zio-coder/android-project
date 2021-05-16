package com.example.thefinder_realy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 1001;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton b = (ImageButton) findViewById(R.id.imageButton11);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(), // 현재 화면의 제어권자
                        sub_map_finder.class); // 다음 넘어갈 클래스 지정
                startActivity(intent); // 다음 화면으로 넘어간다
            }
        });
    }
}


//    final LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);


//    final LocationListener gpsLocationListener = new LocationListener() {
//        public void onLocationChanged(Location location) {
//
//            String provider = location.getProvider();
//            longitude = location.getLongitude();
//            latitude = location.getLatitude();
//
//        }
//
//        public void onStatusChanged(String provider, int status, Bundle extras) {
//        }
//
//        public void onProviderEnabled(String provider) {
//        }
//
//        public void onProviderDisabled(String provider) {
//        }
//
//    };
//
//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        mMap = googleMap;
//
//        LatLng location = new LatLng(latitude, longitude);
//
//        MarkerOptions markerOptions = new MarkerOptions();
//        markerOptions.position(location);
//        markerOptions.title("물건의 위치");
//        markerOptions.snippet("어서 가져가세요!");
//        mMap.addMarker(markerOptions);
//
//        public void onClick(){
//
//        }

        // 기존에 사용하던 다음 2줄은 문제가 있습니다.

        // CameraUpdateFactory.zoomTo가 오동작하네요.
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));
        //mMap.animateCamera(CameraUpdateFactory.zoomTo(10));
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 10));
//    }

//    @Override
//    public void onLocationChanged(Location location) {
//
//    }
