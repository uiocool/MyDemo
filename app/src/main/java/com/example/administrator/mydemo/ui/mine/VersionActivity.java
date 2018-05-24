package com.example.administrator.mydemo.ui.mine;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mydemo.MainActivity;
import com.example.administrator.mydemo.R;

public class VersionActivity extends AppCompatActivity {

    private Context mContext;
    private TextView ver_no;
    private TextView ver_dev;
    private TextView ver_date;
    private Button ver_bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_version);
        mContext = VersionActivity.this;
        initViews();
        int versionCode = getVersionCode(mContext);
        String versionName = getVerName(mContext);
        ver_no.setText(versionName);
        ver_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VersionActivity.this, MainActivity.class);
                intent.putExtra("id", 4);
                startActivity(intent);
            }
        });
    }

    private void initViews(){
        ver_no = (TextView) findViewById(R.id.ver_no);
        ver_dev = (TextView) findViewById(R.id.ver_dev);
        ver_date = (TextView) findViewById(R.id.ver_date);
        ver_bt = (Button) findViewById(R.id.ver_bt);
    }

    public static int getVersionCode(Context mContext) {
        int versionCode = 0;
        try {
            //获取软件版本号，对应AndroidManifest.xml下android:versionCode
            versionCode = mContext.getPackageManager().
                    getPackageInfo(mContext.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }

    /**
     * 获取版本号名称
     *
     * @param context 上下文
     * @return
     */
    public static String getVerName(Context context) {
        String verName = "";
        try {
            verName = context.getPackageManager().
                    getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return verName;
    }

}
