package discreteBehaviorSimulator;

import java.lang.reflect.Method;

import action.DiscreteActionInterface;

public class MyAction implements DiscreteActionInterface{
	private int time;
	private Method method;
	private Object object;
	
	public void spendTime(int t) {
		this.time = t;
	}
	

	public Method getMethod() {
		return this.method;
	}
	

	/*
	 * get the object on which the method must be invoked
	 */
	public Object getObject() {
		return this.object;
	}


	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Integer getCurrentLapsTime() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int compareTo(DiscreteActionInterface c) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public DiscreteActionInterface next() {
		// TODO Auto-generated method stub
		return null;
	}
	

	

}
