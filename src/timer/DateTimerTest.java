package timer;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class DateTimerTest {
	private static Field[] reflexionFields;
	private DateTimer  treeTimer ;
	private TreeSet<Integer> treeSet=new TreeSet<Integer>();
	private TreeSet<Integer> testTreeSet=new TreeSet<Integer>();
	private Vector<Integer> vector=new Vector<Integer>();
	private Vector<Integer> testVector=new Vector<Integer>();
    private DateTimer vectorTimer ;
    private Iterator<Integer> testIt;
    
	
	@Before
	public void setUp() throws Exception{
		
		treeSet.add(3);
		treeSet.add(1);
		treeSet.add(4);	
		vector.add(3);
		vector.add(1);
		vector.add(4);
		vectorTimer= new DateTimer(vector);
	    treeTimer= new DateTimer(treeSet);
	    testIt=treeTimer.it;
	    
	    Class<?> reflexionPeriodicTimer = treeTimer.getClass();
		reflexionFields = reflexionPeriodicTimer.getDeclaredFields();

		for (Field field: reflexionFields) {
			field.setAccessible(true);
		}
	    
	    
	    }

	@Test
	public void testDateTimerTreeSetOfInteger() {
		testVector.add(1);
		testVector.add(2);
		testVector.add(1);
		
		testTreeSet.add(3);
		testTreeSet.add(1);
		testTreeSet.add(4);
		DateTimer testTreeTimer = new  DateTimer(testTreeSet);
		assertTrue(testTreeTimer.lapsTimes.equals(testVector));
		assertTrue(testTreeTimer.next().equals(testVector.iterator().next()));
		
		
	}

	@Test
	public void testDateTimerVectorOfInteger() {
		
		testVector.add(3);
		testVector.add(1);
		testVector.add(4);
		DateTimer testVectorTimer = new  DateTimer(testVector);
		assertTrue(testVectorTimer.lapsTimes.equals(vector));
		assertTrue(testVectorTimer.next().equals(testVector.iterator().next()));

	}

	@Test
	public void testHasNext() {
		testIt = vector.iterator();
		assertEquals(vectorTimer.lapsTimes.iterator().hasNext(),testIt.hasNext());

	}

	@Test
	public void testNext() {
		testIt = vector.iterator();
		assertEquals(vectorTimer.lapsTimes.iterator().next(),testIt.next());

	}
	
	@Test
	public void DT3()  {
		TreeSet t = new TreeSet<Integer>();
		t.add(0);
		t.add(0);
		t.add(0);
		DateTimer dt = new DateTimer(t);
		// hasNext does not return Exception 
		dt.hasNext();	
		dt.next();
		
		
	}
	
	@Test
	public void DT4()  {
		TreeSet t = new TreeSet<Integer>();
		t.add(0);
		t.add(1);
		t.add(4);
		DateTimer dt = new DateTimer(t);
		// hasNext does not return Exception 
		dt.hasNext();	
		dt.next();
		
		
	}
	
	
	@Test
	public void DT5() throws Exception {
		
		assertThrows(Exception.class , () -> {
			Vector v = new Vector<Integer>();
			v.add("2");
			v.add(1);
			v.add(1);
			DateTimer dt = new DateTimer(v);
			// hasNext does not return Exception 
			dt.hasNext();	
			dt.next();
	});
		
		
	}
	
	
	@Test
	public void DT6() throws Exception {
		
		assertThrows(Exception.class , () -> {
			TreeSet t = new TreeSet<String>();
			t.add("2");
			t.add("1");
			t.add("1");
			DateTimer dt = new DateTimer(t);
			// hasNext does not return Exception 
			dt.hasNext();	
			dt.next();
	});
		
		
	}
	
	@Test
	public void DT7() throws Exception {
		
		assertThrows(Exception.class , () -> {
			Vector v = new Vector<Integer>();
			v.add(1.5);
			v.add(1);
			v.add(4);
			DateTimer dt = new DateTimer(v);
			// hasNext does not return Exception 
			dt.hasNext();	
			dt.next();
	});
		
		
	}
	
	@Test
	public void DT8() throws Exception {
		
		assertThrows(Exception.class , () -> {
			TreeSet t = new TreeSet<Double>();
			t.add(1.4);
			t.add(1.0);
			t.add(4.0);
			DateTimer dt = new DateTimer(t);
			dt.hasNext();	
			dt.next();
	});
		
		
	}
	
	
	
	
	

}
