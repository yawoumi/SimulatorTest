package timer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;
import timer.RandomTimer.randomDistribution;

class PeriodicTimerTest {

	

	

	@Test
	void PT1() {
		PeriodicTimer pt1 = new PeriodicTimer(1);
		Assert.assertEquals(pt1.getPeriod(), 1);
		Assert.assertTrue(pt1.hasNext());
		Assert.assertEquals(pt1.next(), 1,0.1);
	}
	
	
	@Test
	void PT2() {
		PeriodicTimer pt2 = new PeriodicTimer(1,2);
		Assert.assertEquals(pt2.getPeriod(), 1);
		Assert.assertTrue(pt2.hasNext());
		Assert.assertEquals(pt2.next(),2,0.1);
	}
	
	@Test
	void PT3() throws Exception {
		RandomTimer RT ;
		randomDistribution distribution = RandomTimer.string2Distribution("EXP");
		RT = new RandomTimer(distribution,2.0);
		double testvalue= RT.next() - RT.getMean() +1;
		PeriodicTimer pt3 = new PeriodicTimer(1,RT);
		Assert.assertEquals(pt3.getPeriod(), 1);
		Assert.assertTrue(pt3.hasNext());
		Assert.assertEquals(pt3.next(),testvalue,0.1);
	}

	@Test
	void PT4() throws Exception {
		RandomTimer RT ;
		randomDistribution distribution = RandomTimer.string2Distribution("EXP");
		RT = new RandomTimer(distribution,2);
		double testvalue= RT.next() - RT.getMean() +1;
		PeriodicTimer pt4 = new PeriodicTimer(1,2,RT);
		Assert.assertEquals(pt4.getPeriod(), 1);
		Assert.assertTrue(pt4.hasNext());
		Assert.assertEquals(pt4.next(),testvalue,0.1);
	}
	
	@Test
	void PT5() {
		PeriodicTimer pt5 = new PeriodicTimer(0);
		Assert.assertEquals(pt5.getPeriod(), 0);
		Assert.assertTrue(pt5.hasNext());
		Assert.assertEquals(pt5.next(), 0,0.1);
	}
	
	
	@Test
	void PT6() {
		PeriodicTimer pt6 = new PeriodicTimer(0,0);
		Assert.assertEquals(pt6.getPeriod(), 0);
		Assert.assertTrue(pt6.hasNext());
		Assert.assertEquals(pt6.next(),0,0.1);
	}
	
	@Test
	void PT7() throws Exception {
		RandomTimer RT ;
		randomDistribution distribution = RandomTimer.string2Distribution("EXP");
		RT = new RandomTimer(distribution,2.0);
		double testvalue= RT.next() - RT.getMean() +1;
		PeriodicTimer pt7 = new PeriodicTimer(0,RT);
		Assert.assertEquals(pt7.getPeriod(), 0);
		Assert.assertTrue(pt7.hasNext());
		Assert.assertEquals(pt7.next(),testvalue,0.1);
	}

	@Test
	void PT8() throws Exception {
		RandomTimer RT ;
		randomDistribution distribution = RandomTimer.string2Distribution("EXP");
		RT = new RandomTimer(distribution,2);
		double testvalue= RT.next() - RT.getMean() +1;
		PeriodicTimer pt8 = new PeriodicTimer(0,0,RT);
		Assert.assertEquals(pt8.getPeriod(), 0);
		Assert.assertTrue(pt8.hasNext());
		Assert.assertEquals(pt8.next(),testvalue,0.1);
	}

	@Test
	void PT9() {
		Assert.assertThrows(Exception.class , () -> {
			PeriodicTimer pt9 = new PeriodicTimer(-1);
			
	});
	
	
	@Test
	void PT10() {
	Assert.assertThrows(Exception.class , () -> {
		PeriodicTimer pt10 = new PeriodicTimer(-1,-1);

	});
	
	@Test
	void PT11() {
		Assert.assertThrows(Exception.class , () -> {
			PeriodicTimer pt10 = new PeriodicTimer(-1,null);

		});

	@Test
	void PT12()  {
		Assert.assertThrows(Exception.class , () -> {
			PeriodicTimer pt10 = new PeriodicTimer(-1,-1,null);

		});
	
	

}
