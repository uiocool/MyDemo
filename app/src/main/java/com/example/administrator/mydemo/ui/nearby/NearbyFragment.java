package com.example.administrator.mydemo.ui.nearby;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.view.menu.MenuView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.Poi;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.example.administrator.mydemo.R;
import com.example.administrator.mydemo.ui.commend.DemandTermActivity;

import java.util.List;

public class NearbyFragment extends Fragment {

    private MapView mapView;
    private BaiduMap bm;
    public LocationClient mLocationClient = null;
    private MyLocationListener myListener = new MyLocationListener();

    private LocationManager locationManager;
    private String provider;
    private WebView webView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
//        SDKInitializer.initialize(getActivity().getApplicationContext());
  //      mLocationClient=new LocationClient(getActivity().getApplicationContext());
  //      mLocationClient.registerLocationListener(myListener);
        View v = inflater.inflate(R.layout.fragment_nearby, container, false);
    //    mapView =(MapView)v.findViewById(R.id.map);
        return v;
    }

    @SuppressLint("JavascriptInterface")
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

   /*     startLocation();
        bm = mapView.getMap();
        bm.setMyLocationEnabled(true);
*/
        initViews();
        initWeb();
      //  initButton();
        webView.addJavascriptInterface(getActivity(), "android");

   //     webView.loadUrl("javascript:testjs()");
     /*   webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                return super.onJsAlert(view, url, message, result);
            }
        });
*/
    }

    private void initViews(){
        webView = (WebView)getView().findViewById(R.id.map);
    }

    private void initWeb(){
        webView.loadUrl("file:///android_asset/map.html");
        webView.getSettings().setJavaScriptEnabled(true);
    }
/*
    private void initButton(){
        ImageButton nearby_menu = (ImageButton)getView().findViewById(R.id.nearby_menu);
        nearby_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(getActivity(), getView().findViewById(R.id.nearby_menu));
                popup.getMenuInflater().inflate(R.menu.menu_nearby, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Intent intent;
                        switch (item.getItemId()){
                            case R.id.i1:
                                webView.loadUrl("javascript:testjs()");
                                System.out.println("i1");
                                break;
                            case R.id.i2:
                                webView.loadUrl("javascript:testjscz("+"\'sd\'"+")");
                                System.out.println("i2");
                                break;
                            case R.id.i3:
                          //      webView.loadUrl("javascript:testre()");
                          //      webView.addJavascriptInterface(new JsToJava(), "jss");
                                webView.evaluateJavascript("javascript:testre()", new ValueCallback<String>() {
                                    @Override
                                    public void onReceiveValue(String value) {
                                        System.out.println(value);
                                    }
                                });
                                System.out.println("i3");
                                break;
                            case R.id.i4:
                                System.out.println("i4");
                                break;
                        }
                        return false;
                    }
                });
                popup.show();
            }
        });
    }
*/
    private class JsToJava{
        @JavascriptInterface
        public void jsMethod(String paramFromJS){
            System.out.println("js返回结果:" + paramFromJS);//处理返回的结果
        }
    }
/*
    private void getLocation() {
        //获取定位服务
        locationManager = (LocationManager) getActivity().getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
        //获取当前可用的位置控制器
        List<String> list = locationManager.getProviders(true);
        if (list.contains(LocationManager.GPS_PROVIDER)) {
            //是否为GPS位置控制器
            provider = LocationManager.GPS_PROVIDER;
        } else if (list.contains(LocationManager.NETWORK_PROVIDER)) {
            //是否为网络位置控制器
            provider = LocationManager.NETWORK_PROVIDER;
        } else {
            Toast.makeText(getActivity(), "请检查网络或GPS是否打开",
                    Toast.LENGTH_LONG).show();
            return;
        }
     System.out.println(provider);
        @SuppressLint("MissingPermission")
        Location location = locationManager.getLastKnownLocation(provider);
        if (location != null) {
            //获取当前位置，这里只用到了经纬度
            String string = "纬度为：" + location.getLatitude() + ",经度为："
                    + location.getLongitude();
            System.out.println(string);
        }
    }
*/
    private void startLocation(){
        initLocation();
        System.out.println("startLocation");
        mLocationClient.start();
        System.out.println(mLocationClient.isStarted());
    }

    public void showIsStrart(){
        System.out.println(mLocationClient.isStarted());
    }

    private void initLocation(){
        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true);// 打开gps
        option.setCoorType("bd09ll"); // 设置坐标类型
        option.setScanSpan(5000);
        System.out.println("initLocation");
        mLocationClient.setLocOption(option);
    }

    public class MyLocationListener extends BDAbstractLocationListener {

        @Override
        public void onReceiveLocation(BDLocation location) {
            System.out.println("onReceiveLocation");
            LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
            // 构造定位数据
            MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(location.getRadius())
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(100).latitude(location.getLatitude())
                    .longitude(location.getLongitude()).build();
            // 设置定位数据
            bm.setMyLocationData(locData);
            // 当不需要定位图层时关闭定位图层
            //mBaiduMap.setMyLocationEnabled(false);
            StringBuffer sb = new StringBuffer(256);
            sb.append("time : ");
            sb.append(location.getTime());
            sb.append("\nerror code : ");
            sb.append(location.getLocType());
            sb.append("\nlatitude : ");
            sb.append(location.getLatitude());
            sb.append("\nlontitude : ");
            sb.append(location.getLongitude());
            sb.append("\nradius : ");
            sb.append(location.getRadius());
            if (location.getLocType() == BDLocation.TypeGpsLocation) {// GPS定位结果
                sb.append("\nspeed : ");
                sb.append(location.getSpeed());// 单位：公里每小时
                sb.append("\nsatellite : ");
                sb.append(location.getSatelliteNumber());
                sb.append("\nheight : ");
                sb.append(location.getAltitude());// 单位：米
                sb.append("\ndirection : ");
                sb.append(location.getDirection());// 单位度
                sb.append("\naddr : ");
                sb.append(location.getAddrStr());
                sb.append("\ndescribe : ");
                sb.append("gps定位成功");

            } else if (location.getLocType() == BDLocation.TypeNetWorkLocation) {// 网络定位结果
                sb.append("\naddr : ");
                sb.append(location.getAddrStr());
                //运营商信息
                sb.append("\noperationers : ");
                sb.append(location.getOperators());
                sb.append("\ndescribe : ");
                sb.append("网络定位成功");
            } else if (location.getLocType() == BDLocation.TypeOffLineLocation) {// 离线定位结果
                sb.append("\ndescribe : ");
                sb.append("离线定位成功，离线定位结果也是有效的");
            } else if (location.getLocType() == BDLocation.TypeServerError) {
                sb.append("\ndescribe : ");
                sb.append("服务端网络定位失败，可以反馈IMEI号和大体定位时间到loc-bugs@baidu.com，会有人追查原因");
            } else if (location.getLocType() == BDLocation.TypeNetWorkException) {
                sb.append("\ndescribe : ");
                sb.append("网络不同导致定位失败，请检查网络是否通畅");
            } else if (location.getLocType() == BDLocation.TypeCriteriaException) {
                sb.append("\ndescribe : ");
                sb.append("无法获取有效定位依据导致定位失败，一般是由于手机的原因，处于飞行模式下一般会造成这种结果，可以试着重启手机");
            }
            sb.append("\nlocationdescribe : ");
            sb.append(location.getLocationDescribe());// 位置语义化信息
            List<Poi> list = location.getPoiList();// POI数据
            if (list != null) {
                sb.append("\npoilist size = : ");
                sb.append(list.size());
                for (Poi p : list) {
                    sb.append("\npoi= : ");
                    sb.append(p.getId() + " " + p.getName() + " " + p.getRank());
                }
            }
            Log.i("BaiduLocationApiDem", sb.toString());
            System.out.println(sb.toString());
        }


        public void onConnectHotSpotMessage(String s, int i) {
            System.out.println("onConnectHotSpotMessage");

        }

        public void onLocDiagnosticMessage(int locType, int diagnosticType, java.lang.String diagnosticMessage) {
            System.out.println("onLocDiagnosticMessage");

        }
    }
}
