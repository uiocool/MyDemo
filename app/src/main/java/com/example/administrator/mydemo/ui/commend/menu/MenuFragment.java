package com.example.administrator.mydemo.ui.commend.menu;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;

import com.example.administrator.mydemo.R;
import com.example.administrator.mydemo.ui.commend.DemandTermActivity;

public class MenuFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.commend_fragment_menu, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ImageButton btn_menu = (ImageButton)getView().findViewById(R.id.btn_menu);
        btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(getActivity(), getView().findViewById(R.id.btn_menu));
                popup.getMenuInflater().inflate(R.menu.menu_commend, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Intent intent;
                        switch (item.getItemId()){
                         /*   case R.id.i1:
                                intent = new Intent(getActivity(), DemandTermActivity.class);
                                intent.putExtra("id", 1);
                                startActivity(intent);
                                System.out.println("i1");
                                break;
                            case R.id.i2:
                                intent = new Intent(getActivity(), DemandTermActivity.class);
                                intent.putExtra("id", 2);
                                startActivity(intent);
                                System.out.println("i2");
                                break;
                            case R.id.i3:
                                intent = new Intent(getActivity(), DemandTermActivity.class);
                                intent.putExtra("id", 3);
                                startActivity(intent);
                                System.out.println("i3");
                                break;
                            case R.id.i4:
                                intent = new Intent(getActivity(), DemandTermActivity.class);
                                intent.putExtra("id", 4);
                                startActivity(intent);
                                System.out.println("i4");
                                break;
                                */
                            case R.id.i:
                                intent = new Intent(getActivity(), DemandTermActivity.class);
                                startActivity(intent);
                        }
                        return false;
                    }
                });
                popup.show();
            }
        });
    }
}
