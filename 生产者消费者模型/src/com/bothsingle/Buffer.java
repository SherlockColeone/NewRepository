package com.bothsingle;
/*
 * »º³åÇø
 */
public class Buffer {
	public synchronized void doWait() {
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized void doNotify() {
		notify();
	}
	
	public void doSleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
