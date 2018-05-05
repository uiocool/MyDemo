package com.example.administrator.mydemo.ui.nearby;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.view.menu.MenuView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.baidu.location.LocationClient;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;
import com.example.administrator.mydemo.R;

public class NearbyFragment extends Fragment {

    private MapView mapView;
    private BaiduMap bm;
    private LocationClient locationClient;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
   //     locationClient=new LocationClient(getActivity().getApplicationContext());
   //     locationClient.registerLocationListener(new MyLocationListener());

        return inflater.inflate(R.layout.fragment_nearby, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mapView = (MapView) getView().findViewById(R.id.map);
        bm = mapView.getMap();
    }
}
