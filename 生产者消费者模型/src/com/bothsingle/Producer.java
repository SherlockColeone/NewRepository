package com.bothsingle;
/*
 * 生产者类
 */
public class Producer extends Thread {
	private Buffer buffer;
	private int num;//每次生产的数量
	private int sum;//当前货物的总数

	public Producer(Buffer buffer, int num, int sum) {
		super();
		this.buffer = buffer;
		this.num = num;
		this.sum = sum;
	}

	public Producer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		while(sum<0) {
			System.out.println("Producer is in ");
			buffer.doSleep(1500);
			buffer.doNotify();
			buffer.doWait();
		}
	}
	
}
