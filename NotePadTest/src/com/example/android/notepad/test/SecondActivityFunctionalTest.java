package com.example.android.notepad.test;

import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.widget.TextView;

import com.example.android.notepad.SecondActivity;

public class SecondActivityFunctionalTest extends
		ActivityInstrumentationTestCase2<SecondActivity> {
	private static final String NEW_TEXT = "new text";

	public SecondActivityFunctionalTest() {
		super(SecondActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testSetText() throws Exception {

		SecondActivity activity = getActivity();
		
		// search for the textView
		final TextView textView = (TextView) activity
				.findViewById(com.example.android.notepad.R.id.resultText);

		// set text
		getActivity().runOnUiThread(new Runnable() {

			@Override
			public void run() {
				textView.setText(NEW_TEXT);
			}
		});

		getInstrumentation().waitForIdleSync();
		assertEquals("Text incorrect", NEW_TEXT, textView.getText().toString());

	}

	@UiThreadTest
	public void testSetTextWithAnnotation() throws Exception {

		SecondActivity activity = getActivity();

		// search for the textView
		final TextView textView = (TextView) activity
				.findViewById(com.example.android.notepad.R.id.resultText);

		textView.setText(NEW_TEXT);
		assertEquals("Text incorrect", NEW_TEXT, textView.getText().toString());

	}
}
