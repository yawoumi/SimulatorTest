package discreteBehaviorSimulator;

public class MyObserver implements ClockObserver{
	private int time;
	private int nextJump;


	@Override
	public void clockChange(int time) {
		// TODO Auto-generated method stub
		this.time = time;
		
	}

	@Override
	public void nextClockChange(int nextJump) {
		// TODO Auto-generated method stub
		this.nextJump = nextJump;
	}
	
	
	public int getTime() {
		return this.time;
	}
	
	public int getNextJump() {
		return this.nextJump;
	}

}
