package timer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;
import timer.RandomTimer.randomDistribution;

class RandomTimerTest {

	@Test
	void RT1() throws Exception {
		RandomTimer rt1 ;
		randomDistribution distribution = RandomTimer.string2Distribution("EXP");
		rt1 = new RandomTimer(distribution,1.1);
		Assert.assertEquals(rt1.getDistribution(), "EXP");
		Assert.assertEquals(rt1.getDistributionParam(),"rate: 1.1");
		Assert.assertEquals(rt1.toString(),"EXP rate:1.1");
		Assert.assertEquals(rt1.getMean(),1/1.1);
		Assert.assertTrue(rt1.hasNext());	
	}
	
	
	@Test
	void RT2() throws Exception {
		RandomTimer rt2 ;
		randomDistribution distribution = RandomTimer.string2Distribution("POISSON");
		rt2 = new RandomTimer(distribution,2.3);
		int nxtTP =  rt2.nextTimePoisson();
		Assert.assertEquals(rt2.getDistribution(), "POISSON");
		Assert.assertTrue(rt2.hasNext());
		Assert.assertEquals(rt2.getDistributionParam(),"mean: 2.3");
		Assert.assertEquals(rt2.toString(),"POISSON mean:2.3");
		Assert.assertEquals(rt2.getMean(), 2.3);		
		Assert.assertEquals(rt2.distribution2String(distribution),"POISSON");
		Assert.assertEquals( rt2.next().toString() ,"5");
		
	}
	
	@Test
	void RT3() throws Exception {
		RandomTimer rt3 ;
		int a = 1;
		randomDistribution distribution = RandomTimer.string2Distribution("POSIBILIST");
		rt3 = new RandomTimer(distribution,1,2);
		Assert.assertEquals(rt3.getDistribution(), "POSIBILIST");
		Assert.assertTrue(rt3.hasNext());
		Assert.assertEquals( rt3.next().toString() ,"1");
		Assert.assertEquals(rt3.toString(),"POSIBILIST LoLim:1.0 HiLim:2.0");
		Assert.assertEquals(rt3.getDistributionParam(),"lolim: 1.0 hilim: 2.0");
		
	
	}
	
	@Test
	void RT4() throws Exception {
		RandomTimer rt4 ;
		randomDistribution distribution = RandomTimer.string2Distribution("GAUSSIAN");
		rt4 = new RandomTimer(distribution,1,2);
		Assert.assertEquals(rt4.getDistribution(), "GAUSSIAN");
		Assert.assertTrue(rt4.hasNext());
		Assert.assertEquals(rt4.getMean(), 1.0);
		Assert.assertEquals(rt4.getDistributionParam(),"lolim: 1.0 hilim: 2.0");
		Assert.assertEquals(rt4.toString(),"GAUSSIAN LoLim:1.0 HiLim:2.0");
		}

}
