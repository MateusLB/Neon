package com.neon.arthurabreu.neon;

import android.content.Context;
import android.graphics.LightingColorFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.neon.arthurabreu.neon.Utils.Constants;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class GenericActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_bar_left_icon);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/OpenSans-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

        if(getIntent().getExtras()!=null && getIntent().hasExtra(Constants.FRAGMENT)){
            try {
                String fragName = getIntent().getStringExtra(Constants.FRAGMENT);
                Class c = Class.forName(fragName);

                Fragment frag = (Fragment) c.newInstance();

                if(getIntent().hasExtra(Constants.EXTRAS)){
                    Bundle bundle = getIntent().getBundleExtra(Constants.EXTRAS);
                    frag.setArguments(bundle);
                }
                changeFragment(frag);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        ImageView back_button = (ImageView) findViewById(R.id.icon);
        back_button.setImageResource(R.drawable.back_icon);
        back_button.setColorFilter(new LightingColorFilter(getResources().getColor(R.color.black), getResources().getColor(R.color.black)));
        back_button.setOnClickListener(this);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null)
            actionBar.hide();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.icon:
                closeFragment();
                break;
        }
    }

    public void changeFragment(Fragment frag){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.replace(R.id.container, frag);
        ft.commit();
    }

    public void selectFragment(Fragment frag){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.addToBackStack("frag");
        ft.replace(R.id.container, frag);
        ft.commit();
    }

    public void setTitle(String title){
        TextView titleView = (TextView) findViewById(R.id.title);
        titleView.setText(title);
    }

    public void closeFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        if(fragmentManager.getBackStackEntryCount()>0)
            fragmentManager.popBackStack();
        else
            finish();
    }
}

