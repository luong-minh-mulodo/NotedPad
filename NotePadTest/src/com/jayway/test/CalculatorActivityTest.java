package com.jayway.test;

import android.net.Uri;
import android.provider.ContactsContract;
import android.test.AndroidTestCase;

public class CalculatorActivityTest extends AndroidTestCase {

	public CalculatorActivityTest() {
		super();
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testPermissions() throws Exception {
		String packageName = "com.example.android.notepad";
		String className = packageName + ".CalculatorActivity";
		String permission = android.Manifest.permission.RECEIVE_SMS;
		assertActivityRequiresPermission(packageName, className, permission);
	}

	/**
	 * Verify that read and write to contact requires permissions.
	 * <p>
	 * Tests Permission: {@link android.Manifest.permission#READ_CONTACTS}
	 */
	public void testContactsPermissions() throws Exception {
		final Uri URI = ContactsContract.AUTHORITY_URI;
		final String permission = android.Manifest.permission.READ_CONTACTS;
		assertReadingContentUriRequiresPermission(URI, permission);
	}
}
