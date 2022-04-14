package timer;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OneShotTimerTest {
    private static Integer at;
    private static boolean hasNext;
    private static OneShotTimer oneShotTimer;


	@Before
	public void setUp() {
		at = 1;
		oneShotTimer = new OneShotTimer(1);
		hasNext=true;
	}
	


	@Test
	public void testOneShotTimer() throws IllegalArgumentException, IllegalAccessException {
		oneShotTimer = new OneShotTimer(1);
		assertTrue(oneShotTimer.hasNext() == hasNext);
		assertTrue(oneShotTimer.next().equals(at));
	
	}

	@Test
	public void testHasNext() {
		
		assertTrue(oneShotTimer.hasNext() == hasNext);
	}

	@Test
	public void testNext() {
	
		assertTrue(oneShotTimer.next().equals(at));
	}
	
	
	
	@Test
	public void OST5()  {
		
		OneShotTimer ost = new OneShotTimer(0);
		assertTrue(ost.hasNext());
		assertTrue(ost.next().equals(0));
		
	}

}
