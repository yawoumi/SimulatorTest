package actionTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import action.DiscreteActionDependent;
import action.DiscreteActionInterface;
import discreteBehaviorSimulator.Clock;
import timer.OneShotTimer;

class DiscreteActionDependentTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	// Test DAD1
	@Test
	void testAddDependence() {
		Clock clock = Clock.getInstance();
	OneShotTimer oneST1 = new OneShotTimer(5);
	OneShotTimer oneST2 = new OneShotTimer(10);
	DiscreteActionDependent discreteAD = new DiscreteActionDependent(clock,"test avec getInstance",oneST1);
	discreteAD.addDependence(clock,"getTime",oneST2);
	assertTrue(discreteAD.hasNext());
	}

	// Test DAD2
	@Test
	void testNextMethod() throws NoSuchMethodException, SecurityException{
		Clock clock = Clock.getInstance();
	OneShotTimer oneST = new OneShotTimer(5);
	DiscreteActionDependent discreteAD = new DiscreteActionDependent(clock,"test avec getInstance",oneST);
	discreteAD.addDependence(clock,"test avec toString",oneST);
    discreteAD.addDependence(clock,"test avec getTime",oneST);
    discreteAD.nextMethod();
    assertEquals(clock.getClass().getDeclaredMethod("test avec toString", new Class<?>[0]),discreteAD.getMethod());
    discreteAD.nextMethod();
    assertEquals(clock.getClass().getDeclaredMethod("test avec getTime", new Class<?>[0]),discreteAD.getMethod());
    discreteAD.nextMethod();
    assertEquals(clock.getClass().getDeclaredMethod("test avec getInstance", new Class<?>[0]),discreteAD.getMethod());
	}

	// Test DAD3
	@Test
	void testSpendTime() {
		Clock clock = Clock.getInstance();
    OneShotTimer oneST = new OneShotTimer(5);
    DiscreteActionDependent discreteAD = new DiscreteActionDependent(clock,"test avec getInstance",oneST);
    discreteAD.addDependence(clock,"test avec getTime",oneST);
    discreteAD.spendTime(10);
    Integer integer = 5;
	assertEquals(integer,discreteAD.getCurrentLapsTime());
	}

	// Test DAD4
	@Test
	void testUpdateTimeLaps() throws NoSuchMethodException, SecurityException {
		Clock clock = Clock.getInstance();
        OneShotTimer oneST = new OneShotTimer(5);
        DiscreteActionDependent discreteAD = new DiscreteActionDependent(clock,"test avec getInstance",oneST);
        discreteAD.addDependence(clock,"toString",oneST);
        discreteAD.updateTimeLaps();
        assertEquals(clock.getClass().getDeclaredMethod("toString", new Class<?>[0]),discreteAD.getMethod());
	}

	// Test DAD5
	@Test
	void testCompareTo() {
		Clock clock1 = Clock.getInstance();
		Clock clock2 = Clock.getInstance();
        OneShotTimer oneST = new OneShotTimer(5);
        DiscreteActionDependent discreteAD1 = new DiscreteActionDependent(clock1,"test avec getInstance",oneST);
        DiscreteActionDependent discreteAD2 = new DiscreteActionDependent(clock2,"test avec getInstance",oneST);
        assertEquals(1,discreteAD1.compareTo(discreteAD2));
        
	}

	@Test
	void testIsEmpty() {
		Clock clock = Clock.getInstance();
        OneShotTimer oneST1 = new OneShotTimer(5);
        DiscreteActionDependent discreteAD = new DiscreteActionDependent(clock,"test avec getInstance",oneST1);
        assertFalse(discreteAD.isEmpty()); // Test DAD6
        oneST1.next();
        assertTrue(discreteAD.isEmpty()); // Test DAD7
	}

	// Test DAD8
	@Test
	void testNext() {
		Clock clock = Clock.getInstance();
        OneShotTimer oneST = new OneShotTimer(5);
        DiscreteActionDependent discreteAD = new DiscreteActionDependent(clock,"test avec getInstance",oneST);
        DiscreteActionInterface result = discreteAD.next();
        assertEquals(discreteAD,result);
	}

	@Test
	void testHasNext() {
		Clock clock = Clock.getInstance();
        OneShotTimer oneST = new OneShotTimer(5);
        DiscreteActionDependent discreteAD = new DiscreteActionDependent(clock,"test avec getInstance",oneST);
        assertTrue(discreteAD.hasNext()); // Test DAD9
        oneST.next();
        assertFalse(discreteAD.hasNext()); // Test DAD10
        
	}

}
