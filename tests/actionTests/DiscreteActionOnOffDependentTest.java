package actionTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import action.DiscreteActionInterface;
import action.DiscreteActionOnOffDependent;
import discreteBehaviorSimulator.Clock;
import timer.DateTimer;
import timer.OneShotTimer;
import timer.Timer;

class DiscreteActionOnOffDependentTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testNextAction() throws NoSuchMethodException, SecurityException {
		Clock clock = Clock.getInstance();
	OneShotTimer oneST_ON = new OneShotTimer(1);
    OneShotTimer oneST_OFF = new OneShotTimer(5);
	DiscreteActionOnOffDependent discreteA_OnOff = new DiscreteActionOnOffDependent(clock,"test on",oneST_ON,"test off",oneST_OFF);
	discreteA_OnOff.nextAction();
	assertEquals(clock.getClass().getDeclaredMethod("test avec getInstance", new Class<?>[0]),discreteA_OnOff.getMethod());
	discreteA_OnOff.nextAction();
	assertEquals(clock.getClass().getDeclaredMethod("test avec getTime", new Class<?>[0]),discreteA_OnOff.getMethod());
	}

	@Test
	void testSpendTime() {
		Clock clock = Clock.getInstance();
	OneShotTimer oneST_ON = new OneShotTimer(1);
	OneShotTimer oneST_OFF = new OneShotTimer(5);
	DiscreteActionOnOffDependent discreteA_OnOff = new DiscreteActionOnOffDependent(clock,"test avec getInstance",oneST_ON,"test getTime",oneST_OFF);
	discreteA_OnOff.spendTime(5);
	Integer integer = 10;
	assertEquals(integer,discreteA_OnOff.getCurrentLapsTime());
	}


	@Test
	void testCompareTo() {
		Clock clock1 = Clock.getInstance();
	OneShotTimer oneST_ON1 = new OneShotTimer(5);
	OneShotTimer oneST_OFF1 = new OneShotTimer(15);
	DiscreteActionOnOffDependent discreteA_OnOff1 = new DiscreteActionOnOffDependent(clock1,"test avec getInstance",oneST_ON1,"test avec getTime",oneST_OFF1);
	Clock clock2 = Clock.getInstance();
	OneShotTimer oneST_ON2 = new OneShotTimer(10);
	OneShotTimer oneST_OFF2 = new OneShotTimer(20);
	DiscreteActionOnOffDependent discreteA_OnOff2 = new DiscreteActionOnOffDependent(clock2,"test avec getInstance",oneST_ON2,"test avec getTime",oneST_OFF2);
	assertEquals(1,discreteA_OnOff1.compareTo(discreteA_OnOff2));
	}

	@Test
	void testNext() throws NoSuchMethodException, SecurityException {
		Clock clock = Clock.getInstance();
	OneShotTimer oneST_ON = new OneShotTimer(1);
	OneShotTimer oneST_OFF = new OneShotTimer(5);
	DiscreteActionOnOffDependent discreteA_OnOff = new DiscreteActionOnOffDependent(clock,"test avec getInstance",oneST_ON,"test avec getTime",oneST_OFF);
	DiscreteActionInterface result = discreteA_OnOff.next();
	assertEquals(clock.getClass().getDeclaredMethod("test avec getInstance", new Class<?>[0]),result.getMethod());
	}

	@Test
	void testHasNext() {
		Clock clock = Clock.getInstance();
		OneShotTimer oneST_ON = new OneShotTimer(1);
		OneShotTimer oneST_OFF = new OneShotTimer(5);
		DiscreteActionOnOffDependent discreteA_OnOff = new DiscreteActionOnOffDependent(clock,"test avec getInstance",oneST_ON,"test avecgetTime",oneST_OFF);
		assertTrue(discreteA_OnOff.hasNext());
		oneST_ON.next();
		assertTrue(discreteA_OnOff.hasNext());
		oneST_OFF.next();
		assertFalse(discreteA_OnOff.hasNext());
	}

}
