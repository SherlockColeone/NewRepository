package shift;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Test extends JFrame {
	int left,right,top,bottom;     //���������߽�
	Graphics g;
	Point[] p = new Point[6];      //����������飬��СΪ����ε�����һ
	int i;
	//int controll;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	public Test() {
		setTitle("\u5B9E\u9A8C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 300, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button�ü� = new JButton("\u5F00\u59CB\u88C1\u526A");
		button�ü�.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//controll = 1;
				//System.out.println(controll);
				//Test frame = new Test();
				Polygon frameP = new Polygon();
				Test frameT = new Test();
				frameT.setVisible(true);
				frameP.setVisible(false);
			}
		});
		button�ü�.setBounds(379, 353, 130, 37);
		contentPane.add(button�ü�);
		
		JButton button���� = new JButton("\u8FD4\u56DE\u539F\u591A\u8FB9\u5F62");
		button����.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//controll = 0;
				//System.out.println(controll);
				//Polygon frame = new Polygon();
				Polygon frameP = new Polygon();
				Test frameT = new Test();
				frameP.setVisible(true);
				frameT.setVisible(false);
			}
		});
		button����.setBounds(172, 353, 130, 37);
		contentPane.add(button����);
		setWindow(140,550,100,300);
		setPolygon();
		judge();
	}
	
	public void setWindow(int l,int r,int t,int b){
		left = l;    //���ñ߽�ֵ
		right = r;
		top = t;
		bottom = b;
	}
	
	public void setPolygon(){     //������εĵ㸳ֵ���γɶ����
		p[0] = new Point();
		p[0].setX(200);    //��X��ֵ
		p[0].setY(150);    //��Y��ֵ
		
		p[1] = new Point();
		p[1].setX(470);
		p[1].setY(200);
		
		p[2] = new Point();
		p[2].setX(400);
		p[2].setY(350);
		
		p[3] = new Point();
		p[3].setX(250);
		p[3].setY(320);
		
		p[4] = new Point();
		p[4].setX(100);
		p[4].setY(250);
		
		p[5] = new Point();         //�������һ������������ʱ���ֿ����������
		p[5].setX(p[0].getX());     //��һ�������x��y�������һ������
		p[5].setY(p[0].getY());
		//p[5].setK(p[0].getK());
		//p[5].setMark(p[0].getMark());
		//p[5].point = p[0].point;
	}
	
	/*public void formulary(){     //�������θ��ߵķ���ʽ		
		p[i-1].k = (p[i].getY()-p[i-1].getY())/
				(p[i].getX()-p[i-1].getX());    //ͨ������ʽ�����ֱ��б��
			
		//��ʼ�ж��������߽��н���
		p[i-1].yLeft = p[i-1].k * (left-p[i].getX()) + p[i].getY();     //���y��ֵ
		if(p[i-1].yLeft>=top&&p[i-1].yLeft<=bottom){
			p[i-1].point = p[i-1].point + 1;        //��ǽ����ֵ��һ
			if(p[i-1].getY1()==0){
				p[i-1].setY1(p[i-1].yLeft);
				p[i-1].setX1(left);
				System.out.println("Left:x��ֵ��"+p[i-1].getX1());
				System.out.println("Left:y��ֵ��"+p[i-1].getY1());
			}
			else{
				p[i-1].setY2(p[i-1].yLeft);
				p[i-1].setX2(left);
				System.out.println("Left:x��ֵ��"+p[i-1].getX2());
				System.out.println("Left:y��ֵ��"+p[i-1].getY2());
			}
		}
			
		p[i-1].yRight = p[i-1].k * (right-p[i].getX()) + p[i].getY();
		if(p[i-1].yRight>=top&&p[i-1].yRight<=bottom){
			p[i-1].point = p[i-1].point + 1;
			if(p[i-1].getY1()==0){
				p[i-1].setY1(p[i-1].yRight);
				p[i-1].setX1(right);
				System.out.println("Right:x��ֵ��"+p[i-1].getX1());
				System.out.println("Right:y��ֵ��"+p[i-1].getY1());
			}
			else{
				p[i-1].setY2(p[i-1].yRight);
				p[i-1].setX2(right);
				System.out.println("Right:x��ֵ��"+p[i-1].getX2());
				System.out.println("Right:y��ֵ��"+p[i-1].getY2());
			}
		}
			
		p[i-1].xTop = (top-p[i].getY()) / p[i-1].k + p[i].getX();     //���x��ֵ
		if(p[i-1].xTop>=left&&p[i-1].xTop<=right){
			p[i-1].point = p[i-1].point + 1;
			if(p[i-1].getY1()==0){
				p[i-1].setY1(top);
				p[i-1].setX1(p[i-1].xTop);
				System.out.println("Top:x��ֵ��"+p[i-1].getX1());
				System.out.println("Top:y��ֵ��"+p[i-1].getY1());
			}
			else{
				p[i-1].setY2(top);
				p[i-1].setX2(p[i-1].xTop);
				System.out.println("Top:x��ֵ��"+p[i-1].getX2());
				System.out.println("Top:y��ֵ��"+p[i-1].getY2());
			}
		}
			
		p[i-1].xBottom = (bottom-p[i].getY()) / p[i-1].k + p[i].getX();
		if(p[i-1].xBottom>=left&&p[i-1].xBottom<=right){
			p[i-1].point = p[i-1].point + 1;
			if(p[i-1].getY1()==0){
				p[i-1].setY1(bottom);
				p[i-1].setX1(p[i-1].xBottom);
				System.out.println("Bottom:x��ֵ��"+p[i-1].getX1());
				System.out.println("Bottom:y��ֵ��"+p[i-1].getY1());
			}
			else{
				p[i-1].setY2(bottom);
				p[i-1].setX2(p[i-1].xBottom);
				System.out.println("Bottom:x��ֵ��"+p[i-1].getX2());
				System.out.println("Bottom:y��ֵ��"+p[i-1].getY2());
			}
		}
			
		System.out.println();
		//System.out.println("i��ֵ��"+(i-1));
		System.out.println(" k��ֵ��"+p[i-1].k);
		//System.out.println("y��ֵ��"+y);
		//System.out.println("x��ֵ��"+x);
		System.out.println("left:"+left);
		System.out.println("right:"+right);
		System.out.println("top:"+top);
		System.out.println("bottom:"+bottom);
		System.out.println("����"+(i-1)+"��y1��ֵ��"+p[i-1].getY1());
		System.out.println("����"+(i-1)+"��x1��ֵ��"+p[i-1].getX1());
		System.out.println("����"+(i-1)+"��y2��ֵ��"+p[i-1].getY2());
		System.out.println("����"+(i-1)+"��x2��ֵ��"+p[i-1].getX2());			
		System.out.println("������ٸ���"+p[i-1].point);	
	}*/
	
	/*
	* һ�߶��봰�������������
	* 1���߶�������ڴ����ڣ���ʱ�޽���
	* �µ��߶�ͨ��������������
	* 2���߶�һ���ڴ����ڣ�һ�����⣬��ʱ����һ������
    * �µ��߶�ͨ�������ڵĵ��뽻����������
	* 3���߶�������ڴ��������޽���
	* ���軭���µ��߶�
	* 4���߶�������ڴ���������������
	* �µ��߶�ͨ����������������
	*/	
	
	public void judge(){    //�ж϶������Щ���ڴ����ڣ���Щ�ڴ����⣬�����������
		System.out.println("����judge");
		for(i=0;i<p.length;i++){
			System.out.println("i��ֵ"+i);
			if(p[i].getX()>left&&p[i].getX()<right             //�жϵ��Ƿ��ڴ����ڣ�Ȼ����б��
					&&p[i].getY()>top&&p[i].getY()<bottom){
				p[i].mark = 0;    //�������ڱ��Ϊ0
			}else {
				p[i].mark = 1;    //����������Ϊ1
			}
			
			if(i>=1){
				System.out.println("����"+(i-1)+"markΪ��"+p[i-1].mark);
				System.out.println("����"+i+"markΪ��"+p[i].mark);
				if(p[i-1].mark==0&&p[i].mark==0){     //�������������ڴ�����
					p[i-1].setY1(p[i-1].getY());
					p[i-1].setX1(p[i-1].getX());
					p[i-1].setY2(p[i].getY());
					p[i-1].setX2(p[i].getX());
					System.out.println("x1��ֵ��"+p[i-1].getX1());
					System.out.println("y1��ֵ��"+p[i-1].getY1());
					System.out.println("x2��ֵ��"+p[i-1].getX2());
					System.out.println("y2��ֵ��"+p[i-1].getY2());				
					System.out.println("�������������ڴ�����");
					System.out.println();
				}else if(p[i-1].mark==0&&p[i].mark==1||p[i-1].mark==1&&p[i].mark==0){     //�������һ�����ڣ�һ������
					//���ж��ĵ����ڣ��ĵ�����
					if(p[i-1].mark==0){      //�������ǰһ������
						p[i-1].setX1(p[i-1].getX());
						p[i-1].setY1(p[i-1].getY());
						System.out.println("�������ǰһ������");
						System.out.println("x1��ֵ��"+p[i-1].getX1());
						System.out.println("y1��ֵ��"+p[i-1].getY1());
					}else{      //�����һ������
						p[i-1].setX2(p[i].getX());
						p[i-1].setY2(p[i].getY());
						System.out.println("������º�һ������");
						System.out.println("x2��ֵ��"+p[i-1].getX2());
						System.out.println("y2��ֵ��"+p[i-1].getY2());
					}
					intersect();
					execute();
					
					System.out.println("�������һ�����ڣ�һ������");
					System.out.println();
				}else if(p[i-1].mark==1&&p[i].mark==1){     //����������������
					intersect();               //�ȼ��������ֵ
					if(p[i-1].point==2){       //���������������
						//���жϽ����������߽���
						execute();
						
						System.out.println("���������������");
						System.out.println();
					}else if(p[i-1].point==0){     //��������޽���
						//�������
						
						System.out.println("��������޽���");
						System.out.println();
					}
				}
			}
		}	
	}
	
	public void intersect(){         //���ڼ��㽻�������
		System.out.println("����intersect");
		p[i-1].k = (p[i].getY()-p[i-1].getY())/
				(p[i].getX()-p[i-1].getX());    //ͨ������ʽ�����ֱ��б��
		
		p[i-1].yLeft = p[i-1].k * (left-p[i].getX()) + p[i].getY();     //x������߽�ֵ���y��ֵ
		if(p[i-1].yLeft>=p[i-1].getY()&&p[i-1].yLeft<=p[i].getY()
				||p[i-1].yLeft<=p[i-1].getY()&&p[i-1].yLeft>=p[i].getY()){  //�˴��жϵ�����Ϊyֵ�Ƿ�������������ڣ�������˵���н��㣬������˵���޽���
			p[i-1].point = p[i-1].point + 1;        //��ǽ����ֵ��һ
			p[i-1].signal1 = 1;
			System.out.println("intersect:Left��ִ��");
		}
		
		p[i-1].yRight = p[i-1].k * (right-p[i].getX()) + p[i].getY();   //x�����ұ߽�ֵ���yֵ
		if(p[i-1].yRight>=p[i-1].getY()&&p[i-1].yRight<=p[i].getY()
				||p[i-1].yRight<=p[i-1].getY()&&p[i-1].yRight>=p[i].getY()){
			p[i-1].point = p[i-1].point + 1;
			if(p[i-1].signal1==1){
				p[i-1].signal2 = 2;
			}else{
				p[i-1].signal1 = 2;
			}
			System.out.println("intersect:Right��ִ��");
		}
		
		p[i-1].xTop = (top-p[i].getY()) / p[i-1].k + p[i].getX();     //y�����ϱ߽�ֵ���x��ֵ
		if(p[i-1].xTop>=p[i-1].getX()&&p[i-1].xTop<=p[i].getX()
				||p[i-1].xTop<=p[i-1].getX()&&p[i-1].xTop>=p[i].getX()){    //�˴��жϵ�����Ϊxֵ�Ƿ��������������
			p[i-1].point = p[i-1].point + 1;
			if(p[i-1].signal1==1||p[i-1].signal1==2){
				p[i-1].signal2 = 3;
			}else{
				p[i-1].signal1 = 3;
			}
			System.out.println("intersect:Top��ִ��");
		}
		
		p[i-1].xBottom = (bottom-p[i].getY()) / p[i-1].k + p[i].getX(); //y�����±߽�ֵ���xֵ
		if(p[i-1].xBottom>=p[i-1].getX()&&p[i-1].xBottom<=p[i].getX()
				||p[i-1].xBottom<=p[i-1].getX()&&p[i-1].xBottom>=p[i].getX()){
			p[i-1].point = p[i-1].point + 1;
			if(p[i-1].signal1==1||p[i-1].signal1==2||p[i-1].signal1==3){
				p[i-1].signal2 = 4;
			}else{
				p[i-1].signal1 = 4;
			}
			System.out.println("intersect:Bottom��ִ��");
		}
		
		System.out.println("б��k��ֵ��"+p[i-1].k);
		System.out.println("������ٸ���"+p[i-1].point);
		System.out.println("signal1Ϊ��"+p[i-1].signal1);
		System.out.println("signal2Ϊ��"+p[i-1].signal2);
	}
	
	public void execute(){         //intersect()���꽻������ڸ�ֵ
		System.out.println("����execute");
		if(p[i-1].point==1){
			switch(p[i-1].signal1){
			case 1 :                  //��߽�ʱ��ֵ
				System.out.println("����x2��ֵ��"+p[4].getX2());
				System.out.println("����y2��ֵ��"+p[4].getY2());
				assign(1);
				System.out.println("assgin1��ִ��");
				System.out.println("����x2��ֵ��"+p[4].getX2());
				System.out.println("����y2��ֵ��"+p[4].getY2());
				break;
			case 2 :                  //�ұ߽�ʱ��ֵ
				assign(2);
				System.out.println("assgin2��ִ��");
				break;
			case 3 :                  //�ϱ߽�ʱ��ֵ
				assign(3);
				System.out.println("assgin3��ִ��");
				break;
			case 4 :                   //�±߽�ʱ��ֵ
				assign(4);
				System.out.println("assgin4��ִ��");
				System.out.println("����x2��ֵ��"+p[4].getX2());
				System.out.println("����y2��ֵ��"+p[4].getY2());
				break;
			}
			System.out.println("signal1!");
			System.out.println("����"+(i-1)+"��x1��ֵ��"+p[i-1].getX1());
			System.out.println("����"+(i-1)+"��y1��ֵ��"+p[i-1].getY1());
			System.out.println("����"+(i-1)+"��x2��ֵ��"+p[i-1].getX2());
			System.out.println("����"+(i-1)+"��y2��ֵ��"+p[i-1].getY2());
		}else if(p[i-1].point==2){
			switch(p[i-1].signal1){
			case 1 :
				assign(1);
				System.out.println("assgin1��ִ��");
				break;
			case 2 :
				assign(2);
				System.out.println("assgin2��ִ��");
				break;
			case 3 :
				assign(3);
				System.out.println("assgin3��ִ��");
				break;
			case 4 :
				assign(4);
				System.out.println("assgin4��ִ��");
				break;
			}
			System.out.println("signal 1,2:signal 1!");
			System.out.println("����"+(i-1)+"��x1��ֵ��"+p[i-1].getX1());
			System.out.println("����"+(i-1)+"��y1��ֵ��"+p[i-1].getY1());
			System.out.println("����"+(i-1)+"��x2��ֵ��"+p[i-1].getX2());
			System.out.println("����"+(i-1)+"��y2��ֵ��"+p[i-1].getY2());
			
			switch(p[i-1].signal2){
			case 1 :
				assign(1);
				System.out.println("assgin1��ִ��");
				break;
			case 2 :
				assign(2);
				System.out.println("assgin2��ִ��");
				break;
			case 3 :
				assign(3);
				System.out.println("assgin3��ִ��");
				break;
			case 4 :
				assign(4);
				System.out.println("assgin4��ִ��");
				break;
			}
			System.out.println("signal 1,2:signal 2!");
			System.out.println("����"+(i-1)+"��x1��ֵ��"+p[i-1].getX1());
			System.out.println("����"+(i-1)+"��y1��ֵ��"+p[i-1].getY1());
			System.out.println("����"+(i-1)+"��x2��ֵ��"+p[i-1].getX2());
			System.out.println("����"+(i-1)+"��y2��ֵ��"+p[i-1].getY2());
		}
		/*System.out.println("�߽�left:"+left);
		System.out.println("�߽�right:"+right);
		System.out.println("�߽�top:"+top);
		System.out.println("�߽�bottom:"+bottom);*/
		/*System.out.println("����"+(i-1)+"��x1��ֵ��"+p[i-1].getX1());
		System.out.println("����"+(i-1)+"��y1��ֵ��"+p[i-1].getY1());
		System.out.println("����"+(i-1)+"��x2��ֵ��"+p[i-1].getX2());
		System.out.println("����"+(i-1)+"��y2��ֵ��"+p[i-1].getY2());*/
	}
	
	public void assign(int a){        //���ڸ�ֵ
		System.out.println("����assgin");
		switch(a){
		case 1 :                  //��߽�ʱ��ֵ
			if(p[i-1].getY1()==0){
				p[i-1].setY1(p[i-1].yLeft);
				p[i-1].setX1(left);
				System.out.println("Left:x��ֵ��"+p[i-1].getX1());
				System.out.println("Left:y��ֵ��"+p[i-1].getY1());
				System.out.println("x2��ֵ��"+p[4].getX2());
				System.out.println("y2��ֵ��"+p[4].getY2());
				break;
			}
			else{
				p[i-1].setY2(p[i-1].yLeft);
				p[i-1].setX2(left);
				System.out.println("Left:x��ֵ��"+p[i-1].getX2());
				System.out.println("Left:y��ֵ��"+p[i-1].getY2());
				System.out.println("x2��ֵ��"+p[4].getX2());
				System.out.println("y2��ֵ��"+p[4].getY2());
				break;
			}
		case 2 :                  //�ұ߽�ʱ��ֵ
			if(p[i-1].getY1()==0){
				p[i-1].setY1(p[i-1].yRight);
				p[i-1].setX1(right);
				System.out.println("Right:x��ֵ��"+p[i-1].getX1());
				System.out.println("Right:y��ֵ��"+p[i-1].getY1());
				break;
			}
			else{
				p[i-1].setY2(p[i-1].yRight);
				p[i-1].setX2(right);
				System.out.println("Right:x��ֵ��"+p[i-1].getX2());
				System.out.println("Right:y��ֵ��"+p[i-1].getY2());
				break;
			}
		case 3 :                  //�ϱ߽�ʱ��ֵ
			if(p[i-1].getY1()==0){
				p[i-1].setY1(top);
				p[i-1].setX1(p[i-1].xTop);
				System.out.println("Top:x��ֵ��"+p[i-1].getX1());
				System.out.println("Top:y��ֵ��"+p[i-1].getY1());
				break;
			}
			else{
				p[i-1].setY2(top);
				p[i-1].setX2(p[i-1].xTop);
				System.out.println("Top:x��ֵ��"+p[i-1].getX2());
				System.out.println("Top:y��ֵ��"+p[i-1].getY2());
				break;
			}
		case 4 :                   //�±߽�ʱ��ֵ
			if(p[i-1].getY1()==0){
				p[i-1].setY1(bottom);
				p[i-1].setX1(p[i-1].xBottom);
				System.out.println("Bottom:x��ֵ��"+p[i-1].getX1());
				System.out.println("Bottom:y��ֵ��"+p[i-1].getY1());
				System.out.println("x2��ֵ��"+p[4].getX2());
				System.out.println("y2��ֵ��"+p[4].getY2());
				break;
			}
			else{
				p[i-1].setY2(bottom);
				p[i-1].setX2(p[i-1].xBottom);
				System.out.println("Bottom:x��ֵ��"+p[i-1].getX2());
				System.out.println("Bottom:y��ֵ��"+p[i-1].getY2());
				System.out.println("x2��ֵ��"+p[4].getX2());
				System.out.println("y2��ֵ��"+p[4].getY2());
				break;
			}
		}
	}
	
	public void paint(Graphics g){    //������߶�
		super.paint(g);
		paintComponents(g);
		/* 
		//��������		
		g.drawLine(left,top,left,bottom);    //�������ڵ�������
		g.drawLine(left,top,right,top);
		g.drawLine(left,bottom,right,bottom);
		g.drawLine(right,top,right,bottom);
		
		switch(controll){
		case 0 :
			//���������
			for(int i=0;i<p.length-1;i++){
				g.fillOval((int)p[i].getX(), (int)p[i].getY(), 10, 10);      //Ҫ��float��ת��Ϊint��
				g.drawLine((int)p[i].getX(), (int)p[i].getY(), 
						(int)p[i+1].getX(), (int)p[i+1].getY());
			}
		case 1 :
			//�γɽ��㲢�γ��µ��߶�
			for(int i=0;i<p.length-1;i++){
				g.fillOval((int)p[i].getX1(), (int)p[i].getY1(), 10, 10);
				g.fillOval((int)p[i].getX2(), (int)p[i].getY2(), 10, 10);
				g.drawLine((int)p[i].getX1(), (int)p[i].getY1(), 
						(int)p[i].getX2(), (int)p[i].getY2());
			}
		}
		
		if(controll==0){
			for(int i=0;i<p.length-1;i++){
				g.fillOval((int)p[i].getX(), (int)p[i].getY(), 10, 10);      //Ҫ��float��ת��Ϊint��
				g.drawLine((int)p[i].getX(), (int)p[i].getY(), 
						(int)p[i+1].getX(), (int)p[i+1].getY());
			}
		}else{
			for(int i=0;i<p.length-1;i++){
				g.fillOval((int)p[i].getX(), (int)p[i].getY(), 10, 10);      //Ҫ��float��ת��Ϊint��
				g.drawLine((int)p[i].getX(), (int)p[i].getY(), 
						(int)p[i+1].getX(), (int)p[i+1].getY());
			}
		}*/
	}
	
	public void paintComponents(Graphics g) {
		//super.paintComponents(g);
		
		//��������		
		g.drawLine(left,top,left,bottom);    //�������ڵ�������
		g.drawLine(left,top,right,top);
		g.drawLine(left,bottom,right,bottom);
		g.drawLine(right,top,right,bottom);
		
		/*switch(controll){
		case 0 :
			//���������
			for(int i=0;i<p.length-1;i++){
				g.fillOval((int)p[i].getX(), (int)p[i].getY(), 10, 10);      //Ҫ��float��ת��Ϊint��
				g.drawLine((int)p[i].getX(), (int)p[i].getY(), 
						(int)p[i+1].getX(), (int)p[i+1].getY());
			}
			break;
		case 1 :
			//�γɽ��㲢�γ��µ��߶Σ���ɲü�
			for(int i=0;i<p.length-1;i++){
				g.fillOval((int)p[i].getX1(), (int)p[i].getY1(), 10, 10);
				g.fillOval((int)p[i].getX2(), (int)p[i].getY2(), 10, 10);
				g.drawLine((int)p[i].getX1(), (int)p[i].getY1(), 
						(int)p[i].getX2(), (int)p[i].getY2());
			}
			break;
		}*/
		
		//�γɽ��㲢�γ��µ��߶Σ���ɲü�
		for(int i=0;i<p.length-1;i++){
			g.fillOval((int)p[i].getX1(), (int)p[i].getY1(), 10, 10);
			g.fillOval((int)p[i].getX2(), (int)p[i].getY2(), 10, 10);
			g.drawLine((int)p[i].getX1(), (int)p[i].getY1(), 
					(int)p[i].getX2(), (int)p[i].getY2());
		}
	}
}
