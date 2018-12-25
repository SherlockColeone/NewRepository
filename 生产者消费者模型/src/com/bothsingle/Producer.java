package com.bothsingle;
/*
 * ��������
 */
public class Producer extends Thread {
	private Buffer buffer;
	private int num;//ÿ������������
	private int sum;//��ǰ���������

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
