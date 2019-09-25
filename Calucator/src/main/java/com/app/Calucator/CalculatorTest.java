package com.app.Calucator;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class CalculatorTest {

	Calculator c = null;
	@Mock
	CalculatorService service;

	@Rule
	public MockitoRule rule = MockitoJUnit.rule();

	/*
	 * CalculatorService service = Mockito.mock(CalculatorService.class);
	 */
	@Before
	public void setUp() {

		c = new Calculator(service);

	}

	@Test
	public void testPerform() {

		Mockito.when(service.add(2, 3)).thenReturn(5);

		assertEquals(10, c.perform(2, 3));

		Mockito.verify(service).add(2, 3);

	}

}
