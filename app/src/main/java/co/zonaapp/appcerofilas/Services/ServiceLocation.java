package co.zonaapp.appcerofilas.Services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.location.LocationListener;

public class ServiceLocation extends Service implements LocationListener {

    private Context context;
    protected LocationManager locationManager;
    private Location location;
    boolean gpsActivo;

    public ServiceLocation() {
        super();
        this.context = getApplicationContext();
    }

    public ServiceLocation(Context c) {
        super();
        this.context = c;
    }

    public Location getLocation(){
        try {
            locationManager = (LocationManager)this.context.getSystemService(LOCATION_SERVICE);
            gpsActivo = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        }catch (Exception e){}
        if(gpsActivo){
            locationManager.requestLocationUpdates(locationManager.GPS_PROVIDER,1000*60,10,this);
            location = locationManager.getLastKnownLocation(locationManager.NETWORK_PROVIDER);
        }
        return location;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
