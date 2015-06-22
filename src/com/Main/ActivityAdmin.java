package com.Main;

import com.Admin.AdapterAdmin;
import com.aa_openstack.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ExpandableListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ActivityAdmin extends Activity {

	private TextView OverView_tv;
	private TextView Admin_tv;

	private RelativeLayout OverView_ly;
	private RelativeLayout project_ly;
	private ExpandableListView AdminListView;

	private String[] groupList;
	private String[][] childItemList;
	private String[][] childDescribeItemList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main_admin);
		
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
		Admin_tv = (TextView) findViewById(R.id.bottom_admin_tv);
		OverView_ly = (RelativeLayout) findViewById(R.id.bottom_overview_layout);
		project_ly = (RelativeLayout) findViewById(R.id.bottom_project_layout);

		OverView_tv.setTextColor(getResources().getColor(R.color.mygrey));
		Admin_tv.setTextColor(getResources().getColor(R.color.myorange));
		AdminListView = (ExpandableListView) findViewById(R.id.main_admin_list);

		AdapterAdmin adapter = new AdapterAdmin(ActivityAdmin.this,
				groupList, childItemList, childDescribeItemList);
		AdminListView.setAdapter(adapter);
		int groupCount = AdminListView.getCount();

		for (int i = 0; i < groupCount; i++) {

			AdminListView.expandGroup(i);

		}
		
		OverView_ly.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(ActivityAdmin.this, ActivityOverView.class);
				ActivityAdmin.this.startActivity(intent);
			}
		});
		
		project_ly.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(ActivityAdmin.this, ActivityProject.class);
				ActivityAdmin.this.startActivity(intent);
			}
		});
	}

}
