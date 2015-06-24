package com.example.materialdesigntoolbarexample2;



import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements MyAdapterMain.ClickListener{
	private Toolbar mToolbar;
	DrawerLayout drawerLayout;
	ActionBarDrawerToggle actionBarDrawerToggle;
	/*ListView l;
	String[] alphabits ={"a","b","c","d","e","f"};*/
	
	String TITLES[] = {"Home","Events","Mail","Shop","Travel"};
    int ICONS[] = {R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher};
    String NAME = "Akash Bangad";
    String EMAIL = "akash.bangad@android4devs.com";
    int PROFILE = R.drawable.ic_launcher;

    RecyclerView mRecyclerView, mRecyclerViewMain;                           // Declaring RecyclerView
    RecyclerView.Adapter mAdapter, mAdapterMain;                        // Declaring Adapter For Recycler View
    RecyclerView.LayoutManager mLayoutManager, mLayoutManagerMain;            // Declaring Layout Manager as a linear layout manager
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 mToolbar = (Toolbar) findViewById(R.id.toolbar);
		 setSupportActionBar(mToolbar);
	   //  getSupportActionBar().setDisplayShowHomeEnabled(true);
	     drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
	     
	     mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView); // Assigning the RecyclerView Object to the xml View
	     mRecyclerView.setHasFixedSize(true);                            // Letting the system know that the list objects are of fixed size
	     mAdapter = new MyAdapter(TITLES,ICONS,NAME,EMAIL,PROFILE);       // Creating the Adapter of MyAdapter class(which we are going to see in a bit) And passing the titles,icons,header view name, header view email,and header view profile picture
	     mRecyclerView.setAdapter(mAdapter);                              // Setting the adapter to RecyclerView
	     mLayoutManager = new LinearLayoutManager(this);                 // Creating a layout Manager
	     mRecyclerView.setLayoutManager(mLayoutManager);                 // Setting the layout Manager
		 /*	l=(ListView)findViewById(R.id.left_drawer);
			ArrayAdapter<String> adapter =new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, alphabits);
			l.setAdapter(adapter);*/
			toggleDrawer();
	     
			
			 mRecyclerViewMain = (RecyclerView) findViewById(R.id.RecyclerViewMain); // Assigning the RecyclerView Object to the xml View
		     mRecyclerViewMain.setHasFixedSize(true);                            // Letting the system know that the list objects are of fixed size
		     mAdapterMain = new MyAdapterMain(TITLES,ICONS, this);       // Creating the Adapter of MyAdapter class(which we are going to see in a bit) And passing the titles,icons,header view name, header view email,and header view profile picture
		     mRecyclerViewMain.setAdapter(mAdapterMain);                              // Setting the adapter to RecyclerView
		     mLayoutManagerMain = new LinearLayoutManager(this);                 // Creating a layout Manager
		     mRecyclerViewMain.setLayoutManager(mLayoutManagerMain);                 // Setting the layout Manager
		 
		    
		    /* final GestureDetector mGestureDetector = new GestureDetector(MainActivity.this, new GestureDetector.SimpleOnGestureListener() {

		            @Override public boolean onSingleTapUp(MotionEvent e) {
		                return true;
		            }

		        });*/
		     
		  /*   mRecyclerViewMain.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
		            @Override
		            public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
		                View child = recyclerView.findChildViewUnder(motionEvent.getX(),motionEvent.getY());//identify vertical or horizontal swipe
		 
		 
		                	
		                if(child!=null && mGestureDetector.onTouchEvent(motionEvent)){
		                	//drawerLayout.closeDrawers();
		                    
		                	
		                    return true;
		 
		                }
		              
		              int position =  ((MyAdapterMain) mAdapterMain).getPositionCard();
		              Toast.makeText(MainActivity.this,"The Item Clicked is: "+position,Toast.LENGTH_SHORT).show();
		                return false;
		            }
		 
		            @Override
		            public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
		                 
		            }
		        });
		 */    
		     
		     ((MyAdapterMain) mAdapterMain).setClickListener(this);
		     
		   
	}
	

	private void toggleDrawer() {
		 actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this,drawerLayout,mToolbar,R.string.app_name,R.string.app_name){
	        	@Override
	        	public void onDrawerOpened(View drawerView) {
	        		// TODO Auto-generated method stub
	        		super.onDrawerOpened(drawerView);
	        	}
	        	@Override
	        	public void onDrawerClosed(View drawerView) {
	        		// TODO Auto-generated method stub
	        		super.onDrawerClosed(drawerView);
	        	}
	        };
	       
	        drawerLayout.setDrawerListener(actionBarDrawerToggle);
	        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	        getSupportActionBar().setHomeButtonEnabled(true);

	       actionBarDrawerToggle.syncState();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
	          return true;
	    }
		return super.onOptionsItemSelected(item);
	}


	@Override
	public void itemClicked(View view, int position) {
		// TODO Auto-generated method stub
		Toast.makeText(this,"The Item Clicked is: "+position,Toast.LENGTH_SHORT).show();
	}
}
