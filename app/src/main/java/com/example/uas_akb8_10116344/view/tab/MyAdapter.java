package com.example.uas_akb8_10116344.view.tab;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;

import com.example.ilham.uas.R;
import com.example.ilham.uas.view.fragment.ContactFragment;
import com.example.ilham.uas.view.fragment.FriendFragment;
import com.example.ilham.uas.view.fragment.ProfileFragment;
import com.example.ilham.uas.view.fragment.addFragment;


//Nama  : Ilham Maulana Pratama
//NIM   : 10116335
//KLS   : IF 8
//TGL   : 4 Agustus 2019

public class MyAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private String[] titles ={"Profile","Contact","Friend","Add Friend"};
    int[] icon = new int[]{R.drawable.person,R.drawable.contact,R.drawable.friend,R.drawable.add};
    private int heightIcon;

    public MyAdapter(FragmentManager fm, Context c){
        super(fm);
        mContext = c;
        double scale = c.getResources().getDisplayMetrics().density;
        heightIcon=(int)(24*scale+0.5f);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag= null;

        if(position ==0){
            frag = new ProfileFragment();
        }else if(position == 1){
            frag = new ContactFragment();
        }else if(position == 2){
            frag = new FriendFragment();
        }else if(position == 3){
            frag = new addFragment();
        }

        Bundle b = new Bundle();
        b.putInt("position", position);
        frag.setArguments(b);
        return frag;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    public CharSequence getPageTitle(int position){
        Drawable d = mContext.getResources().getDrawable(icon[position]);
        d.setBounds(0,0,heightIcon,heightIcon);
        ImageSpan is = new ImageSpan(d);

        SpannableString sp = new SpannableString(" ");
        sp.setSpan(is,0,sp.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return sp;
    }

}

