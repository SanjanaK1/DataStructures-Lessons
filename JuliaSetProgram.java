import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.awt.event.ActionListener;

public class JuliaSetProgram extends JPanel implements AdjustmentListener, ActionListener, MouseListener
{
	JFrame frame;
	JPanel scrollerPanel,checkPanel,bigSouthPanel;
	GridLayout boxLayout;
	JCheckBox[] boxes;
	
	int width = 1000;//frame.getWidth();
	int height = 800;//frame.getHeight();
	
	BufferedImage image = new BufferedImage(width,height, BufferedImage.TYPE_INT_RGB);
	
	JScrollBar AvaluescrollerBar, BvaluescrollerBar, satscrollerBar, colorscrollBar, zoomscrollBar;
	int redVal = 0;
	int greenVal = 0;
	int blueVal = 0;
	
	int pixelValue = 1;
	
	double Avalue;
	double Bvalue;
	float satValue;
	float colorValue;
	float zoomValue =1;
	
	GridLayout layout;
	
	float maxIter = 300;
	float iter = maxIter;
	
	public JuliaSetProgram()
	{
		frame = new JFrame("Julia Set Program");
		frame.add(this);
		
		//redBar = new JScrollBar(JScrollBar.HORIZONTAL,0,0,0,255); 
		//redBar.addAdjustmentListener(this);
		
		//greenBar = new JScrollBar(JScrollBar.HORIZONTAL,0,0,0,255); 
		//greenBar.addAdjustmentListener(this);
		
		//blueBar = new JScrollBar(JScrollBar.HORIZONTAL,0,0,0,255); 
		//blueBar.addAdjustmentListener(this);
		
		
		AvaluescrollerBar = new JScrollBar(JScrollBar.HORIZONTAL,0,0,-2000,2000); 
		AvaluescrollerBar.addAdjustmentListener(this);
		AvaluescrollerBar.addMouseListener(this);
		AvaluescrollerBar.setUnitIncrement(0);
		
		
		BvaluescrollerBar = new JScrollBar(JScrollBar.HORIZONTAL,0,0,-2000,2000); 
		BvaluescrollerBar.addAdjustmentListener(this);
		BvaluescrollerBar.addMouseListener(this);
		BvaluescrollerBar.setUnitIncrement(0);
		
		
		satscrollerBar = new JScrollBar(JScrollBar.HORIZONTAL,0,0,0,1000); 
		satscrollerBar.addAdjustmentListener(this);
		satscrollerBar.addMouseListener(this);
		satscrollerBar.setUnitIncrement(0);
		
		
		colorscrollBar = new JScrollBar(JScrollBar.HORIZONTAL,0,0,0,1000); 
		colorscrollBar.addAdjustmentListener(this);
		colorscrollBar.addMouseListener(this);
		colorscrollBar.setUnitIncrement(0);
		
		
		zoomscrollBar = new JScrollBar(JScrollBar.HORIZONTAL,0,0,0,5000); 
		zoomscrollBar.addAdjustmentListener(this);
		zoomscrollBar.addMouseListener(this);
		zoomscrollBar.setUnitIncrement(0);
		
		
		
		
		layout = new GridLayout(3,1);
		scrollerPanel = new JPanel();
		scrollerPanel.setLayout(layout);
		scrollerPanel.add(AvaluescrollerBar);
		scrollerPanel.add(BvaluescrollerBar);
		scrollerPanel.add(satscrollerBar);
		scrollerPanel.add(colorscrollBar);
		scrollerPanel.add(zoomscrollBar);
		
		checkPanel = new JPanel();
		boxes = new JCheckBox[4];
		boxLayout = new GridLayout(2,2);
		checkPanel.setLayout(boxLayout);
		for(int x=0;x<boxes.length;x++)
		{
			boxes[x] = new JCheckBox();
			boxes[x].addActionListener(this);
			checkPanel.add(boxes[x]);
		}
		
		
		
		bigSouthPanel = new JPanel();
		bigSouthPanel.setLayout(new BorderLayout(1,2));
		
		bigSouthPanel.add(scrollerPanel,BorderLayout.CENTER);
	//	bigSouthPanel.add(checkPanel, BorderLayout.EAST);
		
		frame.add(bigSouthPanel,BorderLayout.SOUTH);
		
		//frame.add(scrollerPanel,BorderLayout.SOUTH);
		frame.setSize(1000,800);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		
		
		//g.setColor(new Color(redVal,greenVal,blueVal));
		g.fillRect(0,0,frame.getWidth(), frame.getHeight());
		
		int zoom = 1;
		
		double zy;
		double zx;
		
		//System.out.println(Avalue+"    "+Bvalue);
		
		for(int w= 0; w < width; w+= pixelValue)
		{
			for(int h= 0; h<height;h+= pixelValue)
			{
				iter = maxIter;
				zx = (1.5)*(w - width/2)/ (.5 *(zoom*zoomValue)*width);
				zy = (h-(height/2))/ (.5*(zoom*zoomValue)*height);
				
				
				//pre test loop
				while((zx)*(zx) + (zy)*(zy) < 6.0 && iter >0)
				{
					double complexNum = (zx)*(zx) - (zy)*(zy) + Avalue;
					zy = 2*zx*zy + Bvalue;
					zx = complexNum;
					iter-=1;
				}
				
				int c;
				if(iter>0)
				{
					c = Color.HSBtoRGB(colorValue*(maxIter/iter)%1,satValue,1);
				}
				else
					c = Color.HSBtoRGB(maxIter/iter,1,0);
				
				image.setRGB(w,h,c);
			}
			
		}
		
		g.drawImage(image,0,0,null);
		
	}
	
	public static void main(String args[])
	{
		JuliaSetProgram app=new JuliaSetProgram(); 
	}
	
	
	public void adjustmentValueChanged(AdjustmentEvent e) 
	{
		DecimalFormat df = new DecimalFormat(".###");
		
		if(e.getSource()==AvaluescrollerBar && !boxes[0].isSelected()) 
		{
			//AvaluescrollerBar.setMinimum(0);
			//AvaluescrollerBar.setMaximum(6000);
			Avalue = AvaluescrollerBar.getValue()/1000.0;
			df.format(Avalue);
			System.out.println("A Val: "+Avalue);
		}
		
		if(e.getSource()==BvaluescrollerBar && !boxes[1].isSelected()) 
		{
			
			//BvaluescrollerBar.setMinimum(0);
			//BvaluescrollerBar.setMaximum(6000);
			Bvalue = BvaluescrollerBar.getValue()/1000.0;
			df.format(Bvalue);
			System.out.println("B Val: "+Bvalue);
			
		}
		//repaint();
		
		if(e.getSource()==satscrollerBar  && !boxes[2].isSelected()) 
		{
			satValue = satscrollerBar.getValue()/1000.0f;
		}
		
		if(e.getSource()==colorscrollBar ) 
		{
			colorValue = colorscrollBar.getValue()/1000.0f;
		}
		
		if(e.getSource()== zoomscrollBar ) 
		{
			zoomValue = zoomscrollBar.getValue()/1000.0f;
		}
		
		
		repaint(); 
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(boxes[0].isSelected())
		{
			Avalue = 0;
		}
		else if(!boxes[0].isSelected())
			Avalue = AvaluescrollerBar.getValue();
		
		if(boxes[1].isSelected())
		{
			Bvalue = 0;
		}
		else if(!boxes[1].isSelected())
			Bvalue = BvaluescrollerBar.getValue();
		
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) 
	{	
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void mousePressed(MouseEvent arg0) 
	{	
		pixelValue = 3;
	}

	@Override
	public void mouseReleased(MouseEvent arg0) 
	{
		pixelValue = 1;	
	}
	
}
