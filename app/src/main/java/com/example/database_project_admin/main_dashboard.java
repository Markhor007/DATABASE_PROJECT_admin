package com.example.database_project_admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;

public class main_dashboard extends AppCompatActivity
{

    SpaceNavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dashboard);

        navigationView=findViewById(R.id.space);

        navigationView.initWithSaveInstanceState(savedInstanceState);

        navigationView.addSpaceItem(new SpaceItem("", R.drawable.icons8_add_user_group_woman_man_32px));
        navigationView.addSpaceItem(new SpaceItem("", R.drawable.icons8_add_pie_chart_report_32px));


        navigationView.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {
                Toast.makeText(main_dashboard.this,"onCentreButtonClick", Toast.LENGTH_SHORT).show();
                navigationView.setCentreButtonSelectable(true);
            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {
                Toast.makeText(main_dashboard.this, itemIndex + " " + itemName, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onItemReselected(int itemIndex, String itemName) {
                Toast.makeText(main_dashboard.this, itemIndex + " " + itemName, Toast.LENGTH_SHORT).show();

            }
        });
    }
}
