import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class ImageMove extends Frame implements ActionListener, KeyListener, WindowListener
{
	//...사용자의 마우스 좌표
	private int x=200;
	private int y=200; 
	private JButton newBtn, leftBtn, rightBtn, topBtn, bottomBtn;
	
	public void init(){
		//버튼 5개 생성
		newBtn = new JButton("New");
		leftBtn = new JButton("Left");
		rightBtn = new JButton("Right");
		topBtn = new JButton("Top");
		bottomBtn = new JButton("Bottom");
		
		//...패널에 버튼 넣기
		Panel p = new Panel(new GridLayout(1,5,5,5));
		p.add(newBtn); p.add(leftBtn); p.add(rightBtn);p.add(topBtn);p.add(bottomBtn);
		add("North", p);

		//윈도우 창 설정
		setBounds(900,100,500,500);
		setVisible(true);
		setResizable(false);

		//....이벤트
		newBtn.addActionListener(this);
		leftBtn.addActionListener(this);
		rightBtn.addActionListener(this);
		topBtn.addActionListener(this);
		bottomBtn.addActionListener(this);
		this.addKeyListener(this);
		this.addWindowListener(this);
	}

	//...paint메소드
	public void paint(Graphics g){
		Toolkit t = Toolkit.getDefaultToolkit();
		Image image = t.getImage("airplane.png");
		Image image2 = t.getImage("sky.jpg");
		g.drawImage(image2,0,0,null);
		g.drawImage(image, x,y,this);
	}

	//...KeyListner의 추상메소드
	public void	keyPressed(KeyEvent e){
		if(e.getKeyCode()==e.VK_LEFT){
			if(x<-50){ x=520;} 
			else { x-=10; }
		} else if(e.getKeyCode()==e.VK_RIGHT){
			if(x>520){ x=-50; } 
			else { x+=10; }
		} else if(e.getKeyCode()==e.VK_UP){
			if(y<-50){ y=510; } 
			else { y-=10; }
		} else if(e.getKeyCode()==e.VK_DOWN){
			if(y>520){ y=-50; }
			else { y+=10; }
		}
		repaint();
	}
	public void	keyReleased(KeyEvent e){}
	public void	keyTyped(KeyEvent e){}	
	
	//...ActionListner의 추상메소드
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand()=="New"){ x=200; y=200; } 
		else if(e.getActionCommand()=="Left"){
			if(x<-50){ x=520;} 
			else { x-=10; }
		} else if(e.getActionCommand()=="Right"){
			if(x>520){ x=-50; } 
			else { x+=10; }
		} else if(e.getActionCommand()=="Top"){
			if(y<-50){ y=510; } 
			else { y-=10; }
		} else if(e.getActionCommand()=="Bottom"){
			if(y>520){ y=-50; }
			else { y+=10; }
		}
		repaint();
		//Keyistener에 포커스가 오지않는 문제 개선을 위한 포커스 처리
		requestFocus();
	}
	//...windowListener의 추상메소드
	public void windowActivated(WindowEvent e){}
	public void windowClosed(WindowEvent e){} //창을 닫은 뒤 사후처리
	public void windowClosing(WindowEvent e){ System.exit(0); }  //x를 누르는 시정
	public void windowDeactivated(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}

	//...메인메소드
	public static void main(String[] args) 
	{	
		new ImageMove().init();
	}
}

