package org.xdgdg.tripguide_xidian;

import net.tsz.afinal.FinalDb;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.TabContentFactory;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

import com.baidu.map_tool.mapActivity;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {
	private TabHost mTabHost;
	private FinalDb db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mTabHost = (TabHost) findViewById(android.R.id.tabhost);
		mTabHost.setup();
		View tabview1 = createTabView(mTabHost.getContext(), "目的地");
		View tabview2 = createTabView(mTabHost.getContext(), "我的路线");
		// mTabHost.getTabWidget().setDividerDrawable(R.drawable.tab_divider);
		//setupTab(new TextView(this), "目的地");
		//setupTab(new TextView(this), "我的路线");
		mTabHost.addTab(mTabHost.newTabSpec("目的地").setIndicator(tabview1).setContent(new Intent(this,DestinationActivity.class)));
		mTabHost.addTab(mTabHost.newTabSpec("我的路线").setIndicator(tabview2).setContent(new Intent(this,MyRouteActivity.class)));
//		mTabHost.addTab(mTabHost.newTabSpec("我的地图").setIndicator(tabview2).setContent(new Intent(this,mapActivity.class)));
	//	db = FinalDb.create(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void setupTab(final View view, final String tag) {
		View tabview = createTabView(mTabHost.getContext(), tag);

		TabSpec setContent = mTabHost.newTabSpec(tag).setIndicator(tabview)
				.setContent(new TabContentFactory() {
					public View createTabContent(String tag) {
						return view;
					}
				});
		mTabHost.addTab(setContent);

	}

	private static View createTabView(final Context context, final String text) {
		View view = LayoutInflater.from(context)
				.inflate(R.layout.tabs_bg, null);
		TextView tv = (TextView) view.findViewById(R.id.tabsText);
		tv.setText(text);
		return view;
	}

	
}
