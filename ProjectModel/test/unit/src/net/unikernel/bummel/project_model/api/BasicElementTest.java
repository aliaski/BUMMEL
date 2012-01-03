package net.unikernel.bummel.project_model.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.unikernel.bummel.project_model.BasicConnection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mcangel
 */
public class BasicElementTest
{
	BasicElement instance;
	String globalPort = "abstractionHole";
			
	public BasicElementTest()
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
	
	@Before
	public void setUp()
	{
		instance = new BasicElementImpl();
	}
	
	@After
	public void tearDown()
	{
		instance = null;
	}

	/**
	 * Test of getLabel method, of class BasicElement.
	 */
	@Test
	public void testGetLabel()
	{
		System.out.println("getLabel");
		String result = instance.getLabel();
		assertEquals("BasicElementImpl", result);
	}

	/**
	 * Test of setLabel method, of class BasicElement.
	 */
	@Test
	public void testSetLabel()
	{
		System.out.println("setLabel");
		String label = "Turned BasicElementImpl";
		instance.setLabel(label);
		assertTrue(label.equals(instance.getLabel()));
	}

	/**
	 * Test of getState method, of class BasicElement.
	 */
	@Test
	public void testGetState()
	{
		System.out.println("getState");
		int result = instance.getState();
		assertEquals(1, result);
	}

	/**
	 * Test of setState method, of class BasicElement.
	 */
	@Test
	public void testSetState()
	{
		System.out.println("setState");
		int state = 0;
		instance.setState(state);
		assertEquals(instance.getState(), 0);
	}

	/**
	 * Test of getCoords method, of class BasicElement.
	 */
	@Test
	public void testGetCoords()
	{
		fail("I don't understand the purpose of this method.");
	}

	/**
	 * Test of plug method, of class BasicElement.
	 */
	@Test
	public void testPlug2()
			throws Exception
	{
		System.out.println("plug2");
		Connection connection = null;
		instance.plug(connection, "");
	}
	@Test
	public void testCorrectPlug()
	{
		System.out.println("correctPlug");
		Connection connection = new BasicConnection(null, null);
		try
		{
			instance.plug(connection, globalPort);
		} catch (Exception ex)
		{
			Logger.getLogger(BasicElementTest.class.getName()).log(Level.SEVERE, null, ex);
		}
		assertTrue(instance.equals(connection.getFirstElement())
				|| instance.equals(connection.getSecondElement()));
	}
	/**
	 * Test of unplug method, of class BasicElement.
	 */
	@Test
	public void testCorrectUnplug_int()
	{
		System.out.println("correctUnplug_int");
		try
		{
			instance.plug(new BasicConnection(null, null), globalPort);
		} catch (Exception ex)
		{
			Logger.getLogger(BasicElementTest.class.getName()).log(Level.SEVERE, null, ex);
		}
		Connection result = instance.unplug(globalPort);
		assertTrue(!result.getFirstElement().equals(instance)
				&& !result.getSecondElement().equals(instance));
	}

	/**
	 * Test of unplug method, of class BasicElement.
	 */
	@Test
	public void testUnplug_Connection()
	{
		System.out.println("unplug_Connection");
		Connection connection = null;
		assertEquals(false, instance.unplug(connection));
	}
	@Test
	public void testUnplug_Connection2()
	{
		System.out.println("Unplug_Connection2");
		Connection connection = new BasicConnection(null, null);
		try
		{
			instance.plug(connection, globalPort);
		} catch (Exception ex)
		{
			Logger.getLogger(BasicElementTest.class.getName()).log(Level.SEVERE, null, ex);
		}
		assertEquals(true, instance.unplug(connection));
	}
	@Test
	public void testCorrectUnplug_Connection()
	{
		System.out.println("correctUnplug_Connection");
		Connection connection = new BasicConnection(null, null);
		try
		{
			instance.plug(connection, globalPort);
		} catch (Exception ex)
		{
			Logger.getLogger(BasicElementTest.class.getName()).log(Level.SEVERE, null, ex);
		}
		instance.unplug(connection);
		assertTrue(!connection.getFirstElement().equals(instance)
				&& !connection.getSecondElement().equals(instance));
	}

	/**
	 * 
	 * [IMHO]
	 * waiting for confirmation of removing - unnecessary test for the abstract class
	 * 
	 */
//	@Test
//	public void testProcess()
//	{
//		System.out.println("process");
//		ArrayList<Double> connectionsValues = null;
//		ArrayList expResult = null;
//		ArrayList result = instance.process(connectionsValues);
//		assertEquals(expResult, result);
//		// TODO review the generated test code and remove the default call to fail.
//		fail("The test case is a prototype.");
//	}

	/**
	 * Test of step method, of class BasicElement.
	 */
	@Test
	public void testStep()
	{
		System.out.println("step");
		assertEquals(null, instance.step());
	}

	/**
	 * Imagine it's the AND logic element
	 */
	public class BasicElementImpl extends BasicElement
	{
		int ports;
		
		public BasicElementImpl()
		{
			super(new String[]{globalPort});
			setLabel("BasicElementImpl");
			setState(1);
			ports = 3;
			connections = new HashMap<String, Connection>();
		}
		
		@Override
		public ArrayList<Double> process(ArrayList<Double> connectionsValues)
		{
			return null;
		}
	}
}
