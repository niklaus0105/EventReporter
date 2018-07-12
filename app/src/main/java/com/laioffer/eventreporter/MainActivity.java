package com.laioffer.eventreporter;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EventFragment mListFragment;
    private CommentFragment mGridFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        // Get ListView object from xml.
//        ListView eventListView = (ListView) findViewById(R.id.event_list);
//
//        // Initialize an adapter.
//        EventAdapter adapter = new EventAdapter(this);
//
//        // Assign adapter to ListView.
//        eventListView.setAdapter(adapter);

//        // Show different fragments based on screen size.
//        if (getSupportFragmentManager().findFragmentById(R.id.fragment_container) == null) {
//            Fragment fragment = isTablet() ? new  CommentFragment() : new EventFragment();
//            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragment).commit();
//        }


        //add list view
        if (getSupportFragmentManager().findFragmentById(R.id.event_container) == null) {
            mListFragment = new EventFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.event_container,     mListFragment).commit();
        }


        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.comment_container);
        //add Gridview
        if (isLandscape()) {

            if (fragment == null) {
                mGridFragment = new CommentFragment();
                getSupportFragmentManager().beginTransaction().add(R.id.comment_container, mGridFragment).commit();
            }
        } else {
            if (fragment != null) {
                getSupportFragmentManager().beginTransaction().remove(fragment).commit();
            }
        }


    }

    private boolean isTablet() {
        return (getApplicationContext().getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) >=
                Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

    private boolean isLandscape() {
        return getResources().getBoolean(R.bool.is_landscape);
    }

    /**
     * A dummy function to get fake event names.
     *
     * @return an array of fake event names.
     */
    private String[] getEventNames() {
        String[] names = {
                "Event1", "Event2", "Event3",
                "Event4", "Event5", "Event6",
                "Event7", "Event8", "Event9",
                "Event10", "Event11", "Event12"};
        return names;
    }


}
