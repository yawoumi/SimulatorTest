package timer;

import static org.junit.Assert.*;

import java.util.TreeSet;
import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MergedTimerTest {
	private Timer timer1;
	private Timer timer2;

	@Before
	public void setUp() throws Exception {
		
	}

	

	@Test
	public void testMergedTimer() {
		timer1 = new OneShotTimer(1);
		timer2 = new OneShotTimer(2);
		MergedTimer timer = new MergedTimer(timer1,timer2);
		assertTrue(timer.hasNext());
		assertTrue(timer.next() == 3);
		
		
	}

	@Test
	public void testHasNext() {
		timer1 = new OneShotTimer(1);
		timer2 = new OneShotTimer(2);
		MergedTimer timer = new MergedTimer(timer1,timer2);
		assertTrue(timer.hasNext());
		timer.next();
		assertFalse(timer.hasNext());

	}

	@Test
	public void testNext() {
		timer1 = new OneShotTimer(1);
		timer2 = new OneShotTimer(2);
		MergedTimer timer = new MergedTimer(timer1,timer2);
		assertTrue(timer.next() == 3);
		assertTrue(timer.next() == null);
	}
	
	@Test
	public void MT2()  {
		
		Vector t = new Vector<Double>();
			t.add(1);
			t.add(1);
			t.add(1);
			DateTimer timer1 = new DateTimer(t);
			timer2 = new OneShotTimer(1);
			
			MergedTimer timer = new MergedTimer(timer1,timer2);
			// hasNext does not return Exception 
			assertTrue(timer.hasNext());	
			assertTrue(timer.next()== 2);
			assertTrue(timer.next()== null);

		
		
	}
	
	@Test
	public void MT3()  {
		
			Vector t = new Vector<Integer>();
			t.add(1);
			t.add(1);
			t.add(1);
			Vector t1 = new Vector<Integer>();
			t1.add(2);
			t1.add(2);
			t1.add(2);
			timer1 = new DateTimer(t);
			timer2 = new DateTimer(t1);
			
			MergedTimer timer = new MergedTimer(timer1,timer2);
			// hasNext does not return Exception 
			assertTrue(timer.hasNext());
			assertTrue(timer.next()== 3);
			assertTrue(timer.hasNext());
			assertTrue(timer.next()== 3);
			assertTrue(timer.hasNext());
			assertTrue(timer.next()== 3);
			assertFalse(timer.hasNext());
			assertTrue(timer.next()== null);

		
		
	}
	
	
	@Test
	public void MT4()  {
		
			timer1 = new OneShotTimer(1);
			timer2 = new OneShotTimer(1);
			OneShotTimer timer3 = new OneShotTimer(1);
			
			MergedTimer timer = new MergedTimer(timer1,timer2);
			MergedTimer timer2 = new MergedTimer(timer,timer3);

			// hasNext does not return Exception 
			assertTrue(timer2.hasNext() == true);
			assertTrue(timer2.next()==3);
			
		
	}
	
	@Test
	public void MT45()  {
		
			assertThrows(Exception.class , () -> {
				timer1 = new OneShotTimer(1);
				
				MergedTimer timer = new MergedTimer(timer1,null);

				// hasNext does not return Exception 
				timer.hasNext();
				timer.next() ;
		});
			
		
	}

}
