package com.example.flurrytest;


import com.flurry.android.FlurryAdSize;
import com.flurry.android.FlurryAgent;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.FrameLayout;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public void onStart()
    {
    	super.onStart();
		FlurryAgent.onStartSession(this, "ID REMOVED FOR SECURITY");
		FlurryAgent.initializeAds(this);
		FlurryAgent.enableTestAds(true);
		
// Comment out this line to disable ad, the view should not rotate after commenting.
		FlurryAgent.getAd(this, "BannerBottom-Android", (FrameLayout) findViewById(R.id.layout), FlurryAdSize.BANNER_BOTTOM, 15000);

    }
    
    @Override
    public void onStop()
    {
    	super.onStop();
    	FlurryAgent.onEndSession(this);
    }
    
}
