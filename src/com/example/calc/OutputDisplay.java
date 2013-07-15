package com.example.calc;
/*		File Abstract
 * the OutputDisplay simply abstracts out
 * have to have android TextView objects in all the files
 */
import android.widget.TextView;

public class OutputDisplay {

	TextView top;
	TextView bot;

	public OutputDisplay (TextView top, TextView bot){
		this.top = top;
		this.bot = bot;
		
	}
	public void add (String s) {
		this.top.append(s);
		this.bot.setText("");
	}
	public void answer(String s) {
		this.top.setText("");
		bot.append(s);
	}
}
