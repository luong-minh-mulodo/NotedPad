package com.example.android.notepad.test;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.Button;

import com.example.android.notepad.CalculatorActivity;

public class CalculatorActivityWithActivityUnitTestCaseTest extends
		ActivityUnitTestCase<CalculatorActivity> {
	private int buttonId;
	private CalculatorActivity activity;

	public CalculatorActivityWithActivityUnitTestCaseTest() {
		super(CalculatorActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		Intent intent = new Intent(getInstrumentation().getTargetContext(),
				CalculatorActivity.class);
		startActivity(intent, null, null);
		activity = getActivity();
	}

	@SmallTest
	public void testLayout() {

		buttonId = com.example.android.notepad.R.id.button1;
		assertNotNull(activity.findViewById(buttonId));
		Button view = (Button) activity.findViewById(buttonId);
		assertEquals("Incorrect label of the button", "Start", view.getText());
	}

	@SmallTest
	public void testIntentTriggerViaOnClick() {
		buttonId = com.example.android.notepad.R.id.button1;
		Button view = (Button) activity.findViewById(buttonId);
		assertNotNull("Button not allowed to be null", view);

		// You would call the method directly via
		getActivity().onClick(view);

		// TouchUtils cannot be used, only allowed in
		// InstrumentationTestCase or ActivityInstrumentationTestCase2

		// Check the intent which was started
		Intent triggeredIntent = getStartedActivityIntent();
		assertNotNull("Intent was null", triggeredIntent);
		String data = triggeredIntent.getExtras().getString("URL");

		assertEquals("Incorrect data passed via the intent",
				"http://www.vogella.com", data);
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}
}
