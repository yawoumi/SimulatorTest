package discreteBehaviorSimulator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class DiscreteActionSimulatorTest {
	private DiscreteActionSimulator DAS;

	@BeforeEach
	void setUp() throws Exception {
		DAS = new DiscreteActionSimulator();

	}

	@Test
	void testSetNbLoop() {
		int expectedNbLoop = 3;
		DAS.setNbLoop(expectedNbLoop);
		//assertEquals(DAS.) DEMANDER COMMENT SAVOIR COMBIEN DE FOIS
		//MA BOUCLE A FAIT D'ITERATION
	}

	@Test
	void testAddAction() {
		MyAction a1 = new MyAction();
		DAS.addAction(a1);
		String expected = "------------------\nTestAuto :1"+a1.toString()+"\n"+"---------------------\n";
		assertEquals(expected,DAS.toString());
	}

	@Test
	void testRun() {
		MyAction a1 = new MyAction();
		MyAction a2 = new MyAction();
		DAS.addAction(a1);
		DAS.addAction(a2);
		// On vérifie que Run est bien à true
		assertTrue(DAS.getRunning());
		// On vérifie que la liste des actions n'est pas vide
		assertTrue(a1.hasNext()); // assertFalse(DAS.getActionsList.isEmpty())
	}

	@Test
	void testStart() {
		assertFalse(DAS.getRunning());
		DAS.start();
		assertTrue(DAS.getRunning());
	}

	@Test
	void testStop() {
		DAS.start();
		assertTrue(DAS.getRunning());
		DAS.stop();
		assertFalse(DAS.getRunning());
	}

	@Test
	void testToString() {
		MyAction a1 = new MyAction();
		MyAction a2 = new MyAction();
		DAS.addAction(a1);
		DAS.addAction(a2);
		
		String expected = "------------------\nTestAuto :2"+ a1.toString() + "\n"+ a2.toString() + "\n" + "---------------------\n";
		assertEquals(expected,DAS.toString());
	}

	@Test
	void testGetRunning() {
		DAS.start();
		assertTrue(DAS.getRunning());
		
	}



}
