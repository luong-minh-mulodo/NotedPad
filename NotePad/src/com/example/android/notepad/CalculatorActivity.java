package com.example.android.notepad;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CalculatorActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.caculator_layout);
	}

	public void onClick(View view) {
		Intent intent = new Intent(this, SecondActivity.class);
		intent.putExtra("URL", "http://www.vogella.com");
		startActivity(intent);
	}

}
