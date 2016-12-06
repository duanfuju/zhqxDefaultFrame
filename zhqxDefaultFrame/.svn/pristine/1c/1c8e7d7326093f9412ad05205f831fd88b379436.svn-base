package cn.com.oking.util;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ChangeImage {
 
	public static void changeZdImg(InputStream imageIn,String path)
			throws IOException{
		Image  oldimg = ImageIO.read(imageIn);

		int o_width = oldimg.getWidth(null); // 
		int o_height = oldimg.getHeight(null); // 

		int width = 1080;
		if(o_width <1080){
			width = o_width;
		}
		
		int height = 1080 * o_height / o_width;
		
		Image image = oldimg.getScaledInstance(width, height,
				Image.SCALE_SMOOTH);
		BufferedImage tag = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics g = tag.getGraphics();
		g.drawImage(image, 0, 0, null); // 
		g.dispose();
		FileOutputStream imageOut = new FileOutputStream(new File(
				path));
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(imageOut);
		
		JPEGEncodeParam jep = encoder.getDefaultJPEGEncodeParam(tag);
		jep.setQuality(0.9f, true);
		encoder.setJPEGEncodeParam(jep);
		encoder.encode(tag);
		imageIn.close();
		imageOut.close();
		// ImageIO.write(tag, "JPEG", new File("c://1.jpg"));
	}
	
	
	public static void getSmallImg(InputStream imageIn,String path)
			throws IOException{
		Image  oldimg = ImageIO.read(imageIn);

		int o_width = oldimg.getWidth(null); // 
		int o_height = oldimg.getHeight(null); // 

		int width = 180;
		
		int height = 240 * o_height / o_width;
		if(height>240){
			height = 240;
		}
		
		Image image = oldimg.getScaledInstance(width, height,
				Image.SCALE_SMOOTH);
		BufferedImage tag = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics g = tag.getGraphics();
		g.drawImage(image, 0, 0, null); // 
		g.dispose();
		FileOutputStream imageOut = new FileOutputStream(new File(
				path));
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(imageOut);
		
		JPEGEncodeParam jep = encoder.getDefaultJPEGEncodeParam(tag);
		jep.setQuality(0.9f, true);
		encoder.setJPEGEncodeParam(jep);
		encoder.encode(tag);
		imageIn.close();
		imageOut.close();
		
	}
	
	
	
	
	public static void main(String[] args) {
		/*File f1 = new File("C:\\Users\\Administrator\\Desktop\\test\\13863021444192742723.jpg");
		String newPath = "C:\\Users\\Administrator\\Desktop\\test\\s-13863021444192742723.jpg";
		
		try {
			getSmallImg(new FileInputStream(f1),newPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		File root = new File("G:\\QXSCGL");
		File[] files = root.listFiles();
		for (File f : files) {
			if (f.isFile()) {
				String name = f.getName();
				if(name.equals("Thumbs.db")){
					continue;
				}
				String path ="G:\\QXSCGL\\small\\"+name;
				try {
					getSmallImg(new FileInputStream(f),path);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
}
