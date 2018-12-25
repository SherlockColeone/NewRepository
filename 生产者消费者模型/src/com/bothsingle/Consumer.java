package com.bothsingle;
/*
 * 消费者类
 */
public class Consumer extends Thread {
	private Buffer buffer;
	private int num;
	private int sum;
	
	public Consumer(Buffer buffer, int num, int sum) {
		super();
		this.buffer = buffer;
		this.num = num;
		this.sum = sum;
	}

	public Consumer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		while(sum>0) {
			buffer.doWait();
			System.out.println("Consumer is in ");
			buffer.doSleep(1500);
			buffer.doNotify();
		}
	}
	
}
