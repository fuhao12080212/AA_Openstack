package com.Main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ExpandableListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.Project.AdapterProject;
import com.aa_openstack.R;

public class ActivityProject extends Activity {

	private TextView OverView_tv;
	private TextView Project_tv;

	private RelativeLayout OverView_ly;
	private RelativeLayout Admin_ly;
	private ExpandableListView projectListView;

	private String[] groupList;
	private String[][] childItemList;
	private String[][] childDescribeItemList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main_project);

		initData();
		initView();

	}

	private void initData() {
		// TODO Auto-generated method stub

		// 设置组视图的显示文字
		groupList = new String[] { "Compute", "NetWork" };
		// 子视图显示文字
		childItemList = new String[][] {
				{ "Instances", "Images", "Volumes", "Flavors" },
				{ "NetWork TOPO", "Network", "Routers" } };
		childDescribeItemList = new String[][] {
				{ "Instances", "Images", "Volumes", "Flavors" },
				{ "NetWork TOPO", "Network", "Routers" } };
	}

	private void initView() {
		// TODO Auto-generated method stub
		OverView_tv = (TextView) findViewById(R.id.bottom_overview_tv);
		Project_tv = (TextView) findViewById(R.id.bottom_project_tv);
		OverView_ly = (RelativeLayout) findViewById(R.id.bottom_overview_layout);
		Admin_ly = (RelativeLayout) findViewById(R.id.bottom_admin_layout);

		OverView_tv.setTextColor(getResources().getColor(R.color.mygrey));
		Project_tv.setTextColor(getResources().getColor(R.color.myorange));
		projectListView = (ExpandableListView) findViewById(R.id.main_project_list);

		AdapterProject adapter = new AdapterProject(ActivityProject.this,
				groupList, childItemList, childDescribeItemList);
		projectListView.setAdapter(adapter);
		int groupCount = projectListView.getCount();

		for (int i = 0; i < groupCount; i++) {

			projectListView.expandGroup(i);

		}

		OverView_ly.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(ActivityProject.this,
						ActivityOverView.class);
				ActivityProject.this.startActivity(intent);
			}
		});

		Admin_ly.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(ActivityProject.this,
						ActivityAdmin.class);
				ActivityProject.this.startActivity(intent);
			}
		});

	}

}
