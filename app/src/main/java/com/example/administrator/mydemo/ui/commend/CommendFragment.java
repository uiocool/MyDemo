package com.example.administrator.mydemo.ui.commend;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mydemo.MainActivity;
import com.example.administrator.mydemo.R;
import com.example.administrator.mydemo.TestOkHttp;
import com.example.administrator.mydemo.commend.ListViewAdapter;
import com.example.administrator.mydemo.entity.TestData;
import com.example.administrator.mydemo.ui.commend.menu.MenuFragment;
import com.example.administrator.mydemo.ui.mine.MineFragment;
import com.example.administrator.mydemo.ui.mine.RegisterActivity;
import com.example.administrator.mydemo.ui.plate.PlateFragment;
import com.example.administrator.mydemo.util.NetUilts;

import junit.framework.Test;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Call;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import android.util.Log;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Call;
import java.io.IOException;

public class CommendFragment extends Fragment{

    private TextView com_offer;
    private  TextView com_require;
    private FrameLayout fl_page;
    private OfferFragment offer;
    private RequireFragment require;
    private  TextView tt;
    private  FrameLayout fl_menu;
    private MenuFragment menu;
    // 管理器
    private FragmentManager fm;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_commend, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        fm = getFragmentManager();
        bindViews();
        com_require.performClick();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
            //相当于Fragment的onPause
            FragmentTransaction fTransaction = fm.beginTransaction();
            hideAllFragment(fTransaction);
            fTransaction.commit();
        } else {
            // 相当于Fragment的onResume
            com_require.performClick();
        }
    }

    private  void bindViews(){
        com_require = (TextView) getView().findViewById(R.id.com_require);
        com_offer = (TextView) getView().findViewById(R.id.com_offer);

        fl_page = (FrameLayout) getView().findViewById(R.id.fl_page);
        fl_menu = (FrameLayout) getView().findViewById(R.id.fl_menu);

        com_require.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fTransaction = fm.beginTransaction();
                hideAllFragment(fTransaction);
                setSelected();
                com_require.setSelected(true);
                if (require == null) {
                    require = new RequireFragment();
                    fTransaction.add(R.id.fl_content, require);
                }
                if (menu == null){
                    menu = new MenuFragment();
                    fTransaction.add(R.id.fl_menu, menu);
                }
                fTransaction.show(require);
                fTransaction.commit();
            }
        });
        com_offer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fTransaction = fm.beginTransaction();
                hideAllFragment(fTransaction);
                setSelected();
                com_offer.setSelected(true);
                if (offer == null) {
                    offer = new OfferFragment();
                    fTransaction.add(R.id.fl_content, offer);
                }
                if (menu == null){
                    menu = new MenuFragment();
                    fTransaction.add(R.id.fl_menu, menu);
                }
                fTransaction.show(offer);
                fTransaction.commit();
            }
        });
    }

    private void setSelected() {
        com_require.setSelected(false);
        com_offer.setSelected(false);
    }

    private void hideAllFragment(FragmentTransaction fragmentTransaction) {
        if (require != null) fragmentTransaction.hide(require);
        if (offer != null) fragmentTransaction.hide(offer);
    }
}
