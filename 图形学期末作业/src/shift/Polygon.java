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

public class Polygon extends JFrame {
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
					Polygon frame = new Polygon();
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
	public Polygon() {
		setTitle("\u591A\u8FB9\u5F62");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 300, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//Polygon frameP = new Polygon();
		//Test frameT = new Test();
		
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
	}
	
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
		for(i=0;i<p.length;i++){
			if(p[i].getX()>left&&p[i].getX()<right             //�жϵ��Ƿ��ڴ����ڣ�Ȼ����б��
					&&p[i].getY()>top&&p[i].getY()<bottom){
				p[i].mark = 0;    //�������ڱ��Ϊ0
			}else {
				p[i].mark = 1;    //����������Ϊ1
			}			
			if(i>=1){
				if(p[i-1].mark==0&&p[i].mark==0){     //�������������ڴ�����
					p[i-1].setY1(p[i-1].getY());
					p[i-1].setX1(p[i-1].getX());
					p[i-1].setY2(p[i].getY());
					p[i-1].setX2(p[i].getX());
				}else if(p[i-1].mark==0&&p[i].mark==1||p[i-1].mark==1&&p[i].mark==0){     //�������һ�����ڣ�һ������
					//���ж��ĵ����ڣ��ĵ�����
					if(p[i-1].mark==0){      //�������ǰһ������
						p[i-1].setX1(p[i-1].getX());
						p[i-1].setY1(p[i-1].getY());
					}else{                   //�����һ������
						p[i-1].setX2(p[i].getX());
						p[i-1].setY2(p[i].getY());
					}
					intersect();
					execute();
				}else if(p[i-1].mark==1&&p[i].mark==1){     //����������������
					intersect();                 //�ȼ��������ֵ
					if(p[i-1].point==2){         //���������������
						execute();               //���жϽ����������߽���
					}                            //�����޽��㣬�������
				}
			}
		}	
	}
	
	public void intersect(){         //���ڼ��㽻�������
		p[i-1].k = (p[i].getY()-p[i-1].getY())/
				(p[i].getX()-p[i-1].getX());    //ͨ������ʽ�����ֱ��б��k
		//x������߽�ֵ���y��ֵ
		p[i-1].yLeft = p[i-1].k * (left-p[i].getX()) + p[i].getY();
		if(p[i-1].yLeft>=p[i-1].getY()&&p[i-1].yLeft<=p[i].getY()
				||p[i-1].yLeft<=p[i-1].getY()&&p[i-1].yLeft>=p[i].getY()){  //�˴��жϵ�����Ϊyֵ�Ƿ�������yֵ�������ڣ�������˵���н��㣬������˵���޽���
			p[i-1].point = p[i-1].point + 1;        //��ǽ����ֵ��һ
			p[i-1].signal1 = 1;
		}
		//x�����ұ߽�ֵ���yֵ
		p[i-1].yRight = p[i-1].k * (right-p[i].getX()) + p[i].getY();
		if(p[i-1].yRight>=p[i-1].getY()&&p[i-1].yRight<=p[i].getY()
				||p[i-1].yRight<=p[i-1].getY()&&p[i-1].yRight>=p[i].getY()){
			p[i-1].point = p[i-1].point + 1;
			if(p[i-1].signal1==1){
				p[i-1].signal2 = 2;
			}else{
				p[i-1].signal1 = 2;
			}
		}
		//y�����ϱ߽�ֵ���x��ֵ
		p[i-1].xTop = (top-p[i].getY()) / p[i-1].k + p[i].getX();
		if(p[i-1].xTop>=p[i-1].getX()&&p[i-1].xTop<=p[i].getX()
				||p[i-1].xTop<=p[i-1].getX()&&p[i-1].xTop>=p[i].getX()){    //�˴��жϵ�����Ϊxֵ�Ƿ��������xֵ��������
			p[i-1].point = p[i-1].point + 1;
			if(p[i-1].signal1==1||p[i-1].signal1==2){
				p[i-1].signal2 = 3;
			}else{
				p[i-1].signal1 = 3;
			}
		}
		//y�����±߽�ֵ���xֵ
		p[i-1].xBottom = (bottom-p[i].getY()) / p[i-1].k + p[i].getX();
		if(p[i-1].xBottom>=p[i-1].getX()&&p[i-1].xBottom<=p[i].getX()
				||p[i-1].xBottom<=p[i-1].getX()&&p[i-1].xBottom>=p[i].getX()){
			p[i-1].point = p[i-1].point + 1;
			if(p[i-1].signal1==1||p[i-1].signal1==2||p[i-1].signal1==3){
				p[i-1].signal2 = 4;
			}else{
				p[i-1].signal1 = 4;
			}
		}
	}
	
	public void execute(){         //intersect()���꽻������ڸ�ֵ
		if(p[i-1].point==1){
			switch(p[i-1].signal1){
			case 1 :                  //��߽�ʱ��ֵ
				assign(1);
				break;
			case 2 :                  //�ұ߽�ʱ��ֵ
				assign(2);
				break;
			case 3 :                  //�ϱ߽�ʱ��ֵ
				assign(3);
				break;
			case 4 :                   //�±߽�ʱ��ֵ
				assign(4);
				break;
			}
		}else if(p[i-1].point==2){
			switch(p[i-1].signal1){
			case 1 :
				assign(1);
				break;
			case 2 :
				assign(2);
				break;
			case 3 :
				assign(3);
				break;
			case 4 :
				assign(4);
				break;
			}
			switch(p[i-1].signal2){
			case 1 :
				assign(1);
				break;
			case 2 :
				assign(2);
				break;
			case 3 :
				assign(3);
				break;
			case 4 :
				assign(4);
				break;
			}
		}
	}
	
	public void assign(int a){        //���ڸ�ֵ
		switch(a){
		case 1 :                  //��߽�ʱ��ֵ
			if(p[i-1].getY1()==0){
				p[i-1].setY1(p[i-1].yLeft);
				p[i-1].setX1(left);
				break;
			}
			else{
				p[i-1].setY2(p[i-1].yLeft);
				p[i-1].setX2(left);
				break;
			}
		case 2 :                  //�ұ߽�ʱ��ֵ
			if(p[i-1].getY1()==0){
				p[i-1].setY1(p[i-1].yRight);
				p[i-1].setX1(right);
				break;
			}
			else{
				p[i-1].setY2(p[i-1].yRight);
				p[i-1].setX2(right);
				break;
			}
		case 3 :                  //�ϱ߽�ʱ��ֵ
			if(p[i-1].getY1()==0){
				p[i-1].setY1(top);
				p[i-1].setX1(p[i-1].xTop);
				break;
			}
			else{
				p[i-1].setY2(top);
				p[i-1].setX2(p[i-1].xTop);
				break;
			}
		case 4 :                   //�±߽�ʱ��ֵ
			if(p[i-1].getY1()==0){
				p[i-1].setY1(bottom);
				p[i-1].setX1(p[i-1].xBottom);
				break;
			}
			else{
				p[i-1].setY2(bottom);
				p[i-1].setX2(p[i-1].xBottom);
				break;
			}
		}
	}
	
	public void paint(Graphics g){    //������߶�
		super.paint(g);
		paintComponents(g);
		//set(1);
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
	
	/*public void set(int c){
		controll = c;
	}*/
	
	public void paintComponents(Graphics g) {
		//super.paintComponents(g);
		//set(controll);
		
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
		
		//���������
		/*for(int i=0;i<p.length-1;i++){
			g.fillOval((int)p[i].getX(), (int)p[i].getY(), 10, 10);      //Ҫ��float��ת��Ϊint��
			g.drawLine((int)p[i].getX(), (int)p[i].getY(), 
					(int)p[i+1].getX(), (int)p[i+1].getY());
		}*/
		
		g.fillOval((int)p[3].getX(), (int)p[3].getY(), 10, 10);   
		g.fillOval((int)p[4].getX(), (int)p[4].getY(), 10, 10);      //Ҫ��float��ת��Ϊint��
		g.drawLine((int)p[3].getX(), (int)p[3].getY(), (int)p[4].getX(), (int)p[4].getY());
	}
}
