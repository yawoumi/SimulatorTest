package actionTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import action.DiscreteAction;
import discreteBehaviorSimulator.Clock;

import static org.junit.jupiter.api.Assertions.*;
import timer.OneShotTimer;

class DiscreteActionTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testSpendTime() {
		Clock clock = Clock.getInstance();
	OneShotTimer oneST = new OneShotTimer(5);
	DiscreteAction discreteA = new DiscreteAction(clock,"test avec getInstance",oneST);
		discreteA.spendTime(3);
		Integer integer =3;
		assertEquals(integer,discreteA.getCurrentLapsTime());
	}

	@Test
	void testCompareTo() {
		Clock clock1 = Clock.getInstance();
		Clock clock2 = Clock.getInstance();
	OneShotTimer oneST = new OneShotTimer(5);
	DiscreteAction discreteA1 = new DiscreteAction(clock1,"test1 avec getInstance",oneST);
	DiscreteAction discreteA2 = new DiscreteAction(clock2,"test2 avec getInstance",oneST);
	assertEquals(1,discreteA1.compareTo(discreteA2));
	}

	@Test
	void testNext() {
		Clock clock = Clock.getInstance();
	OneShotTimer oneST = new OneShotTimer(5);
	DiscreteAction discreteA = new DiscreteAction(clock,"test avec getInstance",oneST);
	assertEquals(discreteA,discreteA.next());
	}

	@Test
	void testHasNext() {
		Clock clock = Clock.getInstance();
	OneShotTimer oneST = new OneShotTimer(5);
	DiscreteAction discreteA = new DiscreteAction(clock,"test avec getInstance",oneST);
	assertTrue(discreteA.hasNext());
	oneST.next();
    assertFalse(discreteA.hasNext());
	}
	
	@Test
	void testToString() {
		Clock clock = Clock.getInstance();
	OneShotTimer oneST = new OneShotTimer(5);
	DiscreteAction discreteA = new DiscreteAction(clock,"test avec getInstance",oneST);
	assertEquals("Objet : "+ discreteA.getObject().getClass().getName()+"\n"
    		+ " Methode : "+discreteA.getMethod().getName()+"\n"
    		+ " Stat. : "+oneST+"\n"
    		+ " Delai: "+ discreteA.getCurrentLapsTime(),discreteA.toString());
	}
	
	@Test
	void testGetCurrentLapsTime() {
		Clock clock = Clock.getInstance();
        OneShotTimer oneST = new OneShotTimer(5);
        DiscreteAction discreteA = new DiscreteAction(clock,"getInstance",oneST);
        assertEquals(null,discreteA.getCurrentLapsTime());
	}
	
	@Test
	void testGetObject() {
		Clock clock = Clock.getInstance();
        OneShotTimer oneST = new OneShotTimer(5);
        DiscreteAction discreteA = new DiscreteAction(clock,"getInstance",oneST);
        assertSame(clock,discreteA.getObject());
	}
	

}
