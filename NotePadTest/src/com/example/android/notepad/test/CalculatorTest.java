package com.example.android.notepad.test;

import junit.framework.TestCase;

import com.example.android.notepad.Calculator;

public class CalculatorTest extends TestCase {
	Calculator mCalculator;
	int firstNumber, secondNumber;

	public CalculatorTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		firstNumber = 5;
		secondNumber = 20;
		super.setUp();
	}

	public void testNull() {
		assertNull("object should null", mCalculator);
	}

	public void testNotNull() {
		mCalculator = new Calculator();
		assertNotNull("object should not null", mCalculator);
		assertEquals("should be Equals", mCalculator.getFirstNumber(), 999);
		assertEquals("should be Equals", mCalculator.getSecondNumber(), 99);
	}

	public void testAdd() {
		mCalculator = new Calculator(firstNumber, secondNumber);

		assertEquals("should be Equals", mCalculator.getFirstNumber(),
				firstNumber);
		assertEquals("should be Equals", mCalculator.getSecondNumber(),
				secondNumber);

		assertEquals("should be Equals", (firstNumber + secondNumber),
				mCalculator.add());
	}

	public void testMulti() {
		mCalculator = new Calculator(firstNumber, secondNumber);
		assertFalse("should be true",
				(firstNumber * secondNumber) == mCalculator.add());
	}
}
