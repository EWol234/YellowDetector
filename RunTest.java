import org.opencv.core.*;
import org.opencv.highgui.VideoCapture;
 
public class RunTest{
	
	private static String window_name = "Capture - Face detection";
	
   /**
    * @param args
    */
    public static void main(String args[])
    {
      System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
      
	  VideoFeed te = new VideoFeed("output.png");
	  Thread t = new Thread(te);
	  t.setDaemon(true);
	  
      while(true){
    	  t.run();
      }
    }
}
