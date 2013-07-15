/*
 * 			File Abstract
 *  The MainActivity.java file is what puts
 *  the app into motion, the onCreate method 
 *  is called when the app is loaded by the
 *  android os on the mobile device
 */

package com.example.calc;

import android.os.Bundle;
//import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;
import android.view.*;
import android.view.Menu;

public class MainActivity extends Activity {
	OutputDisplay outview;
	Controller con;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		outview = new OutputDisplay((TextView) findViewById(R.id.textView1), (TextView) findViewById(R.id.textView2));
		con = new Controller(outview);
	}

	// This method was generate so I left it as is.
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	/* 			Button Handlers
	 * The click handlers for the buttons
	 * if you look in activity_main.xml file
	 * for each of the buttons there is a
	 * android:onClick properties which
	 * refers to on of these methods by name
	 */
	public void onClick0 (View v) {
		outview.add("0");
		con.add("0");
	}
	public void onClick1 (View v) {
		outview.add("1");
		con.add("1");
	}
	public void onClick2 (View v) {
		outview.add("2");
		con.add("2");
	}
	public void onClick3 (View v) {
		outview.add("3");
		con.add("3");
	}
	public void onClick4 (View v) {
		outview.add("4");
		con.add("4");
	}
	public void onClick5 (View v) {
		outview.add("5");
		con.add("5");
	}
	public void onClick6 (View v) {
		outview.add("6");
		con.add("6");
	}
	public void onClick7 (View v) {
		outview.add("7");
		con.add("7");
	}
	public void onClick8 (View v) {
		outview.add("8");
		con.add("8");
	}
	public void onClick9 (View v) {
		outview.add("9");
		con.add("9");
	}
	public void onClickMulti (View v) {
		outview.add(" * ");
		con.add("*");
	}
	public void onClickDiv (View v) {
		outview.add(" / ");
		con.add("/");
	}
	public void onClickAdd (View v) {
		outview.add(" + ");
		con.add("+");
	}
	public void onClickSub (View v) {
		outview.add(" - ");
		con.add("-");
	}
	public void onClickExp (View v) {
		outview.add(" ^ ");
		con.add("^");
	}
	public void onClickLeftPara (View v) {
		outview.add(" ( ");
		con.add("(");
	}
	public void onClickRightPara (View v) {
		outview.add(" ) ");
		con.add(")");
	}
	public void onClickCompute (View v) {
		outview.add("=");
		//compute
		outview.answer(con.compute());
	}
	
}

