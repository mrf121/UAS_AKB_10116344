package com.example.uas_akb8_10116344;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ilham.uas.model.Preferences;
import com.example.ilham.uas.view.tab.MyAdapter;
import com.example.ilham.uas.view.tab.SlidingTabLayout;

//Nama  : Ilham Maulana Pratama
//NIM   : 10116335
//KLS   : IF 8
//TGL   : 3 Agustus 2019
public class home extends AppCompatActivity
            implements NavigationView.OnNavigationItemSelectedListener  {


        private SlidingTabLayout mSlidingTabLayout;
        private ViewPager mViewPager;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);
            View headerView = navigationView.getHeaderView(0);
            TextView nama = (TextView) headerView.findViewById(R.id.tvUser);
            nama.setText("Hy "+Preferences.getLoggedInUser(getBaseContext()));

            mViewPager=(ViewPager)findViewById(R.id.vp_tabs);
            mViewPager.setAdapter(new MyAdapter(getSupportFragmentManager(), this));

            mSlidingTabLayout=(SlidingTabLayout)findViewById(R.id.stl_tabs);
            mSlidingTabLayout.setDistributeEvenly(true);
            mSlidingTabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            mSlidingTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.colorAccent));
            mSlidingTabLayout.setCustomTabView(R.layout.tab_view, R.id.tv_tab);
            mSlidingTabLayout.setViewPager(mViewPager);




        }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.call) {
            // Handle the camera action

        } else if (id == R.id.message) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void call(View view) {
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);

        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    123);
        } else {
            startActivity(new Intent(Intent.ACTION_CALL).setData(Uri.parse("tel:089656826866")));
        }
    }

    public void onMessage(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto","ilhammaulanpratama@gmail.com", null));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Get it free");
        intent.putExtra(Intent.EXTRA_TEXT, "Hi Ilham let me know you");
        startActivity(Intent.createChooser(intent, "Choose an Email client :"));
    }


    public void oncall(MenuItem item) {
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);

        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    123);
        } else {
            startActivity(new Intent(Intent.ACTION_CALL).setData(Uri.parse("tel:089656826866")));
        }
    }

    public void messageme(MenuItem item) {
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto","ilhammaulanpratama@gmail.com", null));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Get it free");
        intent.putExtra(Intent.EXTRA_TEXT, "Hi Ilham let me know you");
        startActivity(Intent.createChooser(intent, "Choose an Email client :"));
    }

    public void addFriend(View view) {

    }

    public void tweet(View view) {
        Uri uri = Uri.parse("http://twitter.com/pratamailham_");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.chrome.android");
        try
        {
            Toast.makeText(home.this, "Twitter", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }
        catch (ActivityNotFoundException e)
        {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://twitter.com/ilhampratama404")));
        }
    }

    public void instagram(View view) {
        Uri uri = Uri.parse("http://instagram.com/_u/ilhammaulanap");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.instagram.android");
        try
        {
            Toast.makeText(home.this, "Instagram", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }
        catch (ActivityNotFoundException e)
        {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/ilhammaulanap")));
        }
    }

    public void Singout(MenuItem item) {
        Preferences.clearLoggedInUser(getBaseContext());
        startActivity(new Intent(getBaseContext(),LoginActivity.class));
        finish();
    }

    public void about(MenuItem item) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        View view = getLayoutInflater().inflate(R.layout.layout_about, null);
        bottomSheetDialog.setContentView(view);
        bottomSheetDialog.show();
    }
}
