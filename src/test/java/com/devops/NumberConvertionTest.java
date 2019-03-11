package com.devops;

import org.junit.*;

public class NumberConvertionTest {
	private NumberConvertion converter;

	@Before
	public void setup() {
		converter = new NumberConvertion();
	}

	@Test
	public void ReturnsOne() {
		Assert.assertEquals("One", "one", converter.convert(1));
	}

	@Test
	public void ReturnsNotInRange() {
		Assert.assertEquals("Not in range", "not in range", converter.exitcallverification(-1));
	}

	@Test
	public void ReturnsInvalid() {
		Assert.assertEquals("Invalid", "not in range", converter.convert(1000));
	}

	@Test
	public void ReturnsThirteen() {
		Assert.assertEquals("Thirteen", "thirteen", converter.convert(13));
	}

	@Test
	public void ReturnsTen() {
		Assert.assertEquals("Ten", "ten", converter.convert(10));
	}

	@Test
	public void ReturnsHundred() {
		Assert.assertEquals("Hundred", "two hundred", converter.convert(200));
	}

	@Test
	public void ReturnsNintyNine() {
		Assert.assertEquals("Ninty Nine", "ninty nine", converter.exitcallverification(99));
	}

	@Test
	public void ReturnsNineHundredAndNintyNine() {
		Assert.assertEquals("Nine Hundred and Ninty Nine", "nine hundred and ninty nine", converter.convert(999));
	}

	@Test
	public void ReturnsExit() {
		Assert.assertNotEquals("Zero", "zero", converter.exitcallverification("0"+""));
	}
	
	@Test
	public void InvokeMain() {
		NumberConvertion.main(100);
	}
}
