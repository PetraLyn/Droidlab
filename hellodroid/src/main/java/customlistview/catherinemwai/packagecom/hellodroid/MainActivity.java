package customlistview.catherinemwai.packagecom.hellodroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends Activity {

    private GoogleMap googlemap;
    private GoogleMap googleMap;
    private MarkerOptions markerOptions;
    double latitude;
    double longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        googlemap = ((MapFragment) getFragmentManager().findFragmentById(R.id.mapFragment)).getMap();

        markerOptions = new MarkerOptions().position(new LatLng(latitude, longitude)).title("Nairobi");

        //set icon to the marker     //cast_ic_notification_0 put an icon of my choice
        markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_cast_dark));

        CameraPosition cameraPosition = new CameraPosition.Builder().target(
                new LatLng(latitude, longitude)).zoom(12).build();

        //animating the camera
        googlemap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        //show the current location
        googleMap.setMyLocationEnabled(true);

        //for zooming ctrl buttons
        googleMap.getUiSettings().setZoomControlsEnabled(false);

        //Disable zooming
        googleMap.getUiSettings().setZoomGesturesEnabled(false);

        //functionality of the compass
        googleMap.getUiSettings().setCompassEnabled(true);

        //show location
        googleMap.getUiSettings().setMyLocationButtonEnabled(true);

        //rotation
        googleMap.getUiSettings().setRotateGesturesEnabled(true);

        //add marker to the map
        googlemap.addMarker(markerOptions);


    }




    public void onclick(View view) {
        //break: the first process is done and goes to the next

        switch (view.getId()) {
            case R.id.hybrid:
                googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                break;
                case R.id.terrain:
                    googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                    break;
                    case R.id.normal:
                        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                        break;
                        case R.id.satellite:
                            googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                            break;
                    }

            }
        }










