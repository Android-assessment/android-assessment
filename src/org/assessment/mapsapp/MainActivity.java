package org.assessment.mapsapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.osmdroid.api.IMapController;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedIconOverlay.OnItemGestureListener;
import org.osmdroid.views.overlay.OverlayItem;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static final double SEARCH_RADIUS_KM = 2;
	private static final GeoPoint BERLIN = new GeoPoint(52.51, 13.40);
	
	private IMapController controller;
	private MapView map;
	
	private static class Car {
		
		public GeoPoint position;
		public String name;
		public String address;

		public Car(GeoPoint position, String name, String address) {
			this.position = position;
			this.name = name;
			this.address = address;
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initLocation();
	}
	
	private void initLocation() {
		this.map = (MapView) this.findViewById(R.id.mapview);
		this.map.setBuiltInZoomControls(true);
		this.controller = map.getController();

		updateLocation(BERLIN);
	}
	
	private void updateLocation(GeoPoint location){
		this.controller.setZoom(12);
		this.controller.setCenter(location);
		
		List<Car> carsInCloseRadius = filterCarsByDistance(getCars(), location, SEARCH_RADIUS_KM);
		
		//  ###################################### TO IMPLEMENT  ###########################################
		
		// Show cars on map
	}

	private List<Car> getCars() {
		
		//  ###################################### TO IMPLEMENT  ###########################################
		
		// Read the JSON data from https://www.drive-now.com/php/metropolis/json.vehicle_filter?cit=6099
		// Parse the data and fill a list of Car objects
		
		return Collections.emptyList();
	}
	
	private List<Car> filterCarsByDistance(List<Car> cars, GeoPoint location, double searchRadiusKm) {
		
		//  ###################################### TO IMPLEMENT  ###########################################
		
		// Filter the list of cars by a location within the specified radius
		
		return Collections.emptyList();
	}

	private void showCarsOnMap(List<Car> cars) {
		List<OverlayItem> items = new ArrayList<OverlayItem>();

		for (Car car : cars){
			items.add(new OverlayItem(car.name, car.address, car.position));
		}
	   
		OnItemGestureListener<OverlayItem> listener = new OnItemGestureListener<OverlayItem>() {
			@Override
			public boolean onItemLongPress(int arg0, OverlayItem item) {
			     Toast toast = Toast.makeText(getApplicationContext(), item.getTitle() + ", " + item.getSnippet(), Toast.LENGTH_LONG);
                 toast.show();
                 return false;
			}
			@Override
			public boolean onItemSingleTapUp(int arg0, OverlayItem item) {
			     Toast toast = Toast.makeText(getApplicationContext(), item.getTitle() + ", " + item.getSnippet(), Toast.LENGTH_LONG);
                 toast.show();
                 return false;
			}};
		ItemizedIconOverlay<OverlayItem> overlay = new ItemizedIconOverlay<OverlayItem>(getApplicationContext(), items, listener);
		
		this.map.getOverlays().clear();
		this.map.getOverlays().add(overlay);
		this.map.invalidate();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		
		return true;
	}

}
