package shift;

public class Algorithm {
	Point[] p = new Point[6];
	int left,right,top,bottom;     //���������߽�
	int i;
	
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
		
		p[5] = new Point();
		p[5].setX(p[0].getX());
		p[5].setY(p[0].getY());
		p[5].setK(p[0].getK());
		p[5].setMark(p[0].getMark());
		p[5].point = p[0].point;
		
	}
	
	public void setWindow(int l,int r,int t,int b){
		left = l;    //���ñ߽�ֵ
		right = r;
		top = t;
		bottom = b;
	}
	
	public void calculate(int x1,int y1,int x2,int y2){
		float k;
		float X1,X2;
		float Y1,Y2;
		X1 = x1;
		Y1 = y1;
		X2 = x2;
		Y2 = y2;
		k = (Y2-Y1)/(X2-X1);
		System.out.println(k);
	}
	
	public void mark(int x,int y){
		if(x==0&&y==0){
			System.out.println("���1");
		}else if(x==0&&y==1||x==1&&y==0){
			System.out.println("���2");
		}else if(x==1&&y==1){
			System.out.println("���3");
		}
	}
	
	/*public void formulary(){     //�������θ��ߵķ���ʽ		
		p[i-1].k = (p[i].getY()-p[i-1].getY())/
				(p[i].getX()-p[i-1].getX());    //ͨ������ʽ�����ֱ��б��
			
		//x = left;                                           //��ʼ�ж��������߽��н���
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
			
		//x = right;
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
			
		//y = top;
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
			
		//y = bottom;
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
	
	public void assign(int a){
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
	
	public Algorithm(){
		setWindow(140,550,100,300);
		setPolygon();
		judge();
		//calculate(200, 150, 470, 200);
		//mark(0,1);
	}
	
	public static void main(String[] args) {
		new Algorithm();
	}
	
}
