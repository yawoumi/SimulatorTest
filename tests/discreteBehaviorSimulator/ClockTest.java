package discreteBehaviorSimulator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ClockTest {
	
	private Clock c1;
	private Clock c2;
	
	@BeforeEach
	void setUp() throws Exception {
		c1 = new Clock();
		c2 = new Clock();
	}

	@Test
	void testGetInstance() {
		Object ClockInst1 = c1.getInstance();
		Object ClockInst2 = c1.getInstance();
		assertSame(ClockInst1,ClockInst2);
		
	}

	@Test
	void testAddObserver() {
		MyObserver mo1 = new MyObserver();
		
		c1.addObserver(mo1);
		
		try {
			c1.increase(5);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertEquals(5,mo1.getTime());
		
	}

	@Test
	void testRemoveObserver() {
		MyObserver mo1 = new MyObserver();
		c1.addObserver(mo1);
		
		c1.removeObserver(mo1);
		assertNull(mo1.getTime());
		
	}

	@Test
	void testSetVirtual() {
		c1.setVirtual(false);
		assertEquals(false,c1.isVirtual());
	}

	@Test
	void testIsVirtual() {
		c1.setVirtual(true);
		assertEquals(true,c1.isVirtual());
		c1.setVirtual(false);
		assertEquals(false,c1.isVirtual());
	}

	@Test
	void testSetNextJump() {
		MyObserver mo1 = new MyObserver();
		MyObserver mo2 = new MyObserver();
		c1.setNextJump(10);
		
		assertEquals(10,mo1.getNextJump());
		assertEquals(10,mo2.getNextJump());
	}

	@Test
	void testIncrease() {
		MyObserver mo1 = new MyObserver();
		c1.addObserver(mo1);
		try {
			c1.increase(5);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(5,mo1.getTime());
	}

	@Test
	void testGetTime() {
		c1.setVirtual(true);
		assertEquals(0,c1.getTime());
		c1.setVirtual(false);
		assertEquals(new Date().getTime(), c1.getTime());
		}

	@Test
	void testLockReadAccess() {
		MyObserver mo1 = new MyObserver();
		MyObserver mo2 = new MyObserver();
		c1.addObserver(mo1);
		c2.addObserver(mo2);
		c1.lockReadAccess();
		boolean access = false;
		
		if (access == false) {
			// On veut vérifier que c2 ne peut pas lire
			c2.lockReadAccess();
			// On passe access à true si il a pu lire
			access = true;
		}
		// On vérifie que acess n'est jamais passé à true
		assertEquals(false,access);
		
	}

	@Test
	void testUnlockReadAccess() {
		MyObserver mo1 = new MyObserver();
		MyObserver mo2 = new MyObserver();
		c1.addObserver(mo1);
		c2.addObserver(mo2);
		c1.lockReadAccess();
	
		c1.unlockReadAccess();
		boolean access = true;
		
		if (access) {
			// On veut vérifier que c2 peut lire
			c2.lockReadAccess();
			// On passe access à true si il a pu lire
			access = false;
		}
		// On vérifie que acess est bien passé false
		assertEquals(false,access);
	}

	@Test
	void testLockWriteAccess() {
		MyObserver mo1 = new MyObserver();
		MyObserver mo2 = new MyObserver();
		c1.addObserver(mo1);
		c2.addObserver(mo2);
		c1.lockWriteAccess();
		boolean access = false;
		
		if (access==false) {
			// On veut vérifier que c2 ne peut pas écrire
			c2.lockWriteAccess();
			// On passe access à true si il a pu écrire
			access = true;
		}
		// On vérifie que acess n'est jamais passé à true
		assertEquals(false,access);
	}

	@Test
	void testUnlockWriteAccess() {
		MyObserver mo1 = new MyObserver();
		MyObserver mo2 = new MyObserver();
		c1.addObserver(mo1);
		c2.addObserver(mo2);
		c1.lockWriteAccess();
	
		c1.unlockWriteAccess();
		boolean access = true;
		
		if (access) {
			// On veut vérifier que c2 peut écrire
			c2.lockWriteAccess();
			// On passe access à true si il a pu écrire
			access = false;
		}
		// On vérifie que acess est bien passé false
		assertEquals(false,access);
	}

	@Test
	void testToString() {
		String expected = ""+c1.getTime();
		assertEquals(expected,c1.toString());
		
				
	}

}
