import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
import org.opencv.objdetect.CascadeClassifier;


public class VideoFeed implements Runnable{
	
	private String filename;
	JFrame f = new JFrame();
	Mat frame;
	VideoCapture cap = new VideoCapture(0);
	ColorDetector c = new ColorDetector("output.png");
	
	public VideoFeed(String filename){
		this.filename = filename;
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
    public void run(){
//    			BufferedImage i = null;
//				try {
//					i = ImageIO.read(new URL("http://10.24.21.11/jpg/1/image.jpg"));
//				} catch (MalformedURLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}		
//				
//				byte[] data = ((DataBufferByte) i.getRaster().getDataBuffer()).getData();
//				Mat frame = new Mat(i.getHeight(), i.getWidth(), CvType.CV_8UC3);
//				frame.put(0, 0, data);
    	
    			Mat frame = new Mat();
    			cap.read(frame);
		
				Highgui.imwrite("camera.jpg", frame);
				c.run();
    			try {
    				f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(filename)))));
    			} catch (IOException e) {
    				e.printStackTrace();
    			}
    			f.pack();
    			f.setVisible(true);    
    } 
    


}