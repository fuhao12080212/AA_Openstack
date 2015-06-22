package com.Main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.RelativeLayout;

import com.aa_openstack.R;

public class ActivityOverView extends Activity {

	private RelativeLayout Project_ly;
	private RelativeLayout Admin_ly;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main_overview);
		Project_ly = (RelativeLayout) findViewById(R.id.bottom_project_layout);
		Admin_ly = (RelativeLayout) findViewById(R.id.bottom_admin_layout);
		
		Project_ly.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(ActivityOverView.this, ActivityProject.class);
				ActivityOverView.this.startActivity(intent);
			}
		});
		
		Admin_ly.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(ActivityOverView.this, ActivityAdmin.class);
				ActivityOverView.this.startActivity(intent);
			}
		});
	}

}
