package com.example.examlistview;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	ListView listView1;
	IconTextListAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//버튼클릭 new activity
		Button writeButton = (Button) findViewById(R.id.writeButton);
		writeButton.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent myIntent = new Intent(getApplicationContext(), WriteActivity.class);
				startActivity(myIntent);
			}
		});
		
		
		
		listView1 = (ListView) findViewById(R.id.listView1);
		
		adapter = new IconTextListAdapter(this);
		
		Resources res = getResources();
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.ic_launcher),"영어스터디모집","자기계발","3명"));
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.ic_launcher),"토익 700점","자기계발,외국어","4명"));
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.ic_launcher),"한이음 IT공모전","공모전,IT","5명"));
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.ic_launcher),"땅땅치킨 UCC공모전","UCC","3명"));
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.ic_launcher),"쿠키런 대회 참가","대회","2명"));
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.ic_launcher),"추억의 테트리스","대회","20명"));
		
		listView1.setAdapter(adapter);
		
		listView1.setOnItemClickListener(new OnItemClickListener(){
			
						@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				IconTextItem curItem = (IconTextItem) adapter.getItem(position);
				String[] curData = curItem.getData();
				Toast.makeText(getApplicationContext(), "Selectd : "+ curData[0], 2000).show();
			}
		});
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
