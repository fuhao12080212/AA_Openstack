package com.Admin;

import com.aa_openstack.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterAdmin extends BaseExpandableListAdapter {
	private Context context;
	private LayoutInflater myInflater;
	private String[] groupList;
	private String[][] childItemList;
	private String[][] childDescribeItemList;

	public AdapterAdmin(Context context, String[] groupList,
			String[][] childItemList, String[][] childDescribeItemList) {
		// TODO Auto-generated constructor stub
		this.context = context;
		this.groupList = groupList;
		this.childItemList = childItemList;
		myInflater = LayoutInflater.from(context);
		this.childDescribeItemList = childDescribeItemList;
	}

	// // TODO 自己定义一个获得文字信息的方法
	// @SuppressWarnings("deprecation")
	// TextView getTextView() {
	// AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
	// ViewGroup.LayoutParams.FILL_PARENT, 150);
	// TextView textView = new TextView(context);
	// textView.setLayoutParams(lp);
	// textView.setHeight(100);
	// textView.setGravity(Gravity.CENTER_VERTICAL);
	// textView.setPadding(60, 0, 0, 0);
	// textView.setTextSize(20);
	// textView.setTextColor(Color.BLACK);
	// return textView;
	// }

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return groupList.length;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		return childItemList[groupPosition].length;
	}

	@Override
	public Object getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return groupList[groupPosition];
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return childItemList[groupPosition][childPosition];
	}

	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return groupPosition;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return childPosition;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {

		GroupViewHolder groupViewHolder = null;
		if (convertView == null) {
			convertView = myInflater.inflate(R.layout.admin_list_group, null);

			groupViewHolder = new GroupViewHolder();
			groupViewHolder.group_text = (TextView) convertView
					.findViewById(R.id.admin_list_group_text);
			convertView.setTag(groupViewHolder);
		} else {
			groupViewHolder = (GroupViewHolder) convertView.getTag();
		}

		groupViewHolder.group_text.setText(getGroup(groupPosition).toString());

		return convertView;

	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {

		ChildViewHolder childViewHolder = null;
		if (convertView == null) {
			convertView = myInflater.inflate(R.layout.admin_list_item, null);

			childViewHolder = new ChildViewHolder();
			childViewHolder.Item_logo = (ImageView) convertView
					.findViewById(R.id.admin_item_logo);
			childViewHolder.Item_text = (TextView) convertView
					.findViewById(R.id.admin_list_item_text);
			childViewHolder.Item_describe = (TextView) convertView
					.findViewById(R.id.admin_list_item_describe);
			convertView.setTag(childViewHolder);
		} else {
			childViewHolder = (ChildViewHolder) convertView.getTag();
		}

		childViewHolder.Item_logo
				.setImageResource(R.drawable.admin_compute_logo);
		childViewHolder.Item_text
				.setText(childItemList[groupPosition][childPosition]);
		childViewHolder.Item_describe
				.setText(childDescribeItemList[groupPosition][childPosition]);
		return convertView;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return true;
	}

	static class GroupViewHolder {
		public TextView group_text;
	}

	static class ChildViewHolder {
		public ImageView Item_logo;
		public TextView Item_text;
		public TextView Item_describe;
	}
}
