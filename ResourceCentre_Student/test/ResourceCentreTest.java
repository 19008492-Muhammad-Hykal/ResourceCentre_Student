import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ResourceCentreTest {
	private Camcorder cc1;
	private Camcorder cc2;
	private Chromebook cb1;
	private Chromebook cb2;
	
	private ArrayList<Camcorder> camcorderList;
	private ArrayList<Chromebook> chromebookList;
	
	public ResourceCentreTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		// prepare test data
		cc1 = new Camcorder("CC0011", "Nikon HDSLR", 40);
		cc2 = new Camcorder("CC0012", "Sony DSC-RX100M7", 20);
		cb1 = new Chromebook("CB0011", "My Google Chromebook 1st", "Mac OS");
		cb2 = new Chromebook("CB0012", "SAMSUNG Chromebook 4+", "Win 10");

		camcorderList= new ArrayList<Camcorder>();
		chromebookList= new ArrayList<Chromebook>();
	}

	
	@Test
	public void addCamcorderTest() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1
		ResourceCentre.addCamcorder(camcorderList, cc1);		
		assertEquals("Test if that Camcorder arraylist size is 1?", 1, camcorderList.size());
		
		//The item just added is as same as the first item of the list
		assertSame("Test that Camcorder is added same as 1st item of the list?", cc1, camcorderList.get(0));
		
		//Add another item. test The size of the list is 2?
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test that Camcorder arraylist size is 2?", 2, camcorderList.size());
	}
	@Test
//	To be done by Hykal 22/7/2020
	public void addChromebookTest() {
		//fail("Not yet implemented");
		// write your code here
		
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Chromebook arraylist to add to", chromebookList);

		// Given an empty list, after adding 1 item, the size of the list is 1
		ResourceCentre.addChromebook(chromebookList, cb1);
		assertEquals("Test if that Chromebook arraylist size is 1?", 1, chromebookList.size());

		// The item just added is as same as the first item of the list
		assertSame("Test that Chromebook is added same as 1st item of the list?", cb1, chromebookList.get(0));

		// Add another item. test The size of the list is 2?
		ResourceCentre.addChromebook(chromebookList, cb2);
		assertEquals("Test that Chromebook arraylist size is 2?", 2, chromebookList.size());

	}
	
	@Test
	public void retrieveAllCamcorderTest() {
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
		
		//test if the list of camcorders retrieved from the SourceCentre is empty
				String allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);
				String testOutput = "";
				assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);
				
		//Given an empty list, after adding 2 items, test if the size of the list is 2
		ResourceCentre.addCamcorder(camcorderList, cc1);
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test if that Camcorder arraylist size is 2?", 2, camcorderList.size());
		
		//test if the expected output string same as the list of camcorders retrieved from the SourceCentre
		allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);

		testOutput = String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0011", "Nikon HDSLR", "Yes", "", 40);
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0012", "Sony DSC-RX100M7", "Yes", "", 20);
	
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);
		
	}
	//Changed by Kaiqi
	@Test
	public void retrieveAllChromebookTest() {
		//fail("Not yet implemented");
		// write your code here
				assertNotNull("Test if there is valid Chromebook arraylist to add to", chromebookList);
				
				//test if the list of chromebook retrieved from the SourceCentre is empty
						String allChromebook= ResourceCentre.retrieveAllChromebook(chromebookList);
						String testOutput = "";
						
						
				//Given an empty list, after adding 2 items, test if the size of the list is 2
				ResourceCentre.addChromebook(chromebookList, cb1);
				ResourceCentre.addChromebook(chromebookList, cb2);
				
				
				//test if the expected output string same as the list of chromebook retrieved from the SourceCentre
				allChromebook= ResourceCentre.retrieveAllChromebook(chromebookList);

				testOutput = String.format("%-10s %-30s %-10s %-10s %-20s\n","CB0011", "My Google Chromebook 1st","","", "Mac OS");
				testOutput += String.format("%-10s %-30s %-10s %-10s %-20s\n","CB0012", "SAMSUNG Chromebook 4+","","", "Win 10");
			
				
	}

	@Test
	//Done By Bryent
	public void doLoanCamcorderTest() {
		//fail("Not yet implemented");
		// write your code here
		//Test if there is valid Camcorder arraylist to loan from
				assertNotNull("Test if there is valid Camcorder arraylist to loan from", camcorderList);
				
				
	}
	
	@Test
	//Done by Bryent
	public void doLoanChromebookTest() {
		//fail("Not yet implemented");
		// write your code here
		//Test if there is valid Chromebook arraylist to loan from
				assertNotNull("Test if there is valid Chromebook arraylist to loan from", chromebookList);
	
		
	}
	
	@Test
	//Done by Bryent
	public void doReturnCamcorderTest() {
		//fail("Not yet implemented");
		// write your code here
		ResourceCentre.addCamcorder(camcorderList, cc1);
		//Test if there is valid Camcorder arraylist to return to
		assertNotNull("Test if there is valid camcorder arraylist to loan from", camcorderList);
		//Check that available Camcorder CC0011 is returned - False (not return yet)
		Boolean isReturned = ResourceCentre.doReturnCamcorder(camcorderList, "CB0011");
		assertFalse("Is available Chromebook CB0011 returned (false)?", isReturned);
		
	}
	
	
	//Done By Hykal 22/7/20202
	@Test
	public void doReturnChromebookTest() {
		//fail("Not yet implemented");
		// write your code here
		
		//Let's load the list!!
		assertNotNull("Is the list of Chromebooks available?", chromebookList);
		ResourceCentre.addChromebook(chromebookList, cb1);
		ResourceCentre.addChromebook(chromebookList, cb2);
						
		//Error Condition
		Boolean isReturned = ResourceCentre.doReturnChromebook(chromebookList, "CB0011");
		assertFalse("Is available Chromebook CB0011 returned (false)?", isReturned);
						
		//Normal Condition
		cb2.setIsAvailable(false);
		isReturned = ResourceCentre.doReturnChromebook(chromebookList, "CB0012");
		assertTrue("Is borrowed Chromebook CB0012 returned (true)?", isReturned);
						
			}

	
	@After
	public void tearDown() throws Exception {
		cc1 = null;
		cc2 = null;
		cb1 = null;
		cb2 = null;
		camcorderList = null;
		chromebookList = null;

	}

}
