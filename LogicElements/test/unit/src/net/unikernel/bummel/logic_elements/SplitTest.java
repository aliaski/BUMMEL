package net.unikernel.bummel.logic_elements;

import org.junit.After;
import org.junit.Before;
import java.util.TreeMap;
import java.util.Map;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author uko
 */
public class SplitTest
{
	public SplitTest()
	{
	}
	@BeforeClass
	public static void setUpClass() throws Exception
	{
	}
	@AfterClass
	public static void tearDownClass() throws Exception
	{
	}
	Split instance;
	@Before
	public void setUp()
	{
		instance = new Split();
	}
	@After
	public void tearDown()
	{
		instance = null;
	}
	/**
	 * Test of process method, of class Split.
	 */
	@Test
	public void testProcess000()
	{
		System.out.println("split_process000");
		Map<Integer, Double> valuesOnPorts = new TreeMap<Integer, Double>();
		valuesOnPorts.put(0, 0.);
		valuesOnPorts.put(1, 0.);
		valuesOnPorts.put(2, 0.);
		Map expResult = new TreeMap<Integer, Double>();
		expResult.put(0, 0.);
		expResult.put(1, 0.);
		expResult.put(2, 0.);
		Map result = instance.process(valuesOnPorts);
		assertEquals(expResult, result);
	}
	
	@Test
	public void testProcess001()
	{
		System.out.println("split_process001");
		Map<Integer, Double> valuesOnPorts = new TreeMap<Integer, Double>();
		valuesOnPorts.put(0, 0.);
		valuesOnPorts.put(1, 0.);
		valuesOnPorts.put(2, 1.);
		Map expResult = new TreeMap<Integer, Double>();
		expResult.put(0, 0.);
		expResult.put(1, 0.);
		expResult.put(2, 0.);
		Map result = instance.process(valuesOnPorts);
		assertEquals(expResult, result);
	}
	
	@Test
	public void testProcess010()
	{
		System.out.println("split_process010");
		Map<Integer, Double> valuesOnPorts = new TreeMap<Integer, Double>();
		valuesOnPorts.put(0, 0.);
		valuesOnPorts.put(1, 1.);
		valuesOnPorts.put(2, 0.);
		Map expResult = new TreeMap<Integer, Double>();
		expResult.put(0, 0.);
		expResult.put(1, 0.);
		expResult.put(2, 0.);
		Map result = instance.process(valuesOnPorts);
		assertEquals(expResult, result);
	}
	
	@Test
	public void testProcess011()
	{
		System.out.println("split_process011");
		Map<Integer, Double> valuesOnPorts = new TreeMap<Integer, Double>();
		valuesOnPorts.put(0, 0.);
		valuesOnPorts.put(1, 1.);
		valuesOnPorts.put(2, 1.);
		Map expResult = new TreeMap<Integer, Double>();
		expResult.put(0, 0.);
		expResult.put(1, 0.);
		expResult.put(2, 0.);
		Map result = instance.process(valuesOnPorts);
		assertEquals(expResult, result);
	}
	
	@Test
	public void testProcess100()
	{
		System.out.println("split_process100");
		Map<Integer, Double> valuesOnPorts = new TreeMap<Integer, Double>();
		valuesOnPorts.put(0, 1.);
		valuesOnPorts.put(1, 0.);
		valuesOnPorts.put(2, 0.);
		Map expResult = new TreeMap<Integer, Double>();
		expResult.put(0, 0.);
		expResult.put(1, 1.);
		expResult.put(2, 1.);
		Map result = instance.process(valuesOnPorts);
		assertEquals(expResult, result);
	}
	
	@Test
	public void testProcess101()
	{
		System.out.println("split_process101");
		Map<Integer, Double> valuesOnPorts = new TreeMap<Integer, Double>();
		valuesOnPorts.put(0, 1.);
		valuesOnPorts.put(1, 0.);
		valuesOnPorts.put(2, 1.);
		Map expResult = new TreeMap<Integer, Double>();
		expResult.put(0, 0.);
		expResult.put(1, 1.);
		expResult.put(2, 1.);
		Map result = instance.process(valuesOnPorts);
		assertEquals(expResult, result);
	}
	
	@Test
	public void testProcess110()
	{
		System.out.println("split_process110");
		Map<Integer, Double> valuesOnPorts = new TreeMap<Integer, Double>();
		valuesOnPorts.put(0, 1.);
		valuesOnPorts.put(1, 1.);
		valuesOnPorts.put(2, 0.);
		Map expResult = new TreeMap<Integer, Double>();
		expResult.put(0, 0.);
		expResult.put(1, 1.);
		expResult.put(2, 1.);
		Map result = instance.process(valuesOnPorts);
		assertEquals(expResult, result);
	}
	
	@Test
	public void testProcess111()
	{
		System.out.println("split_process111");
		Map<Integer, Double> valuesOnPorts = new TreeMap<Integer, Double>();
		valuesOnPorts.put(0, 1.);
		valuesOnPorts.put(1, 1.);
		valuesOnPorts.put(2, 1.);
		Map expResult = new TreeMap<Integer, Double>();
		expResult.put(0, 0.);
		expResult.put(1, 1.);
		expResult.put(2, 1.);
		Map result = instance.process(valuesOnPorts);
		assertEquals(expResult, result);
	}
}