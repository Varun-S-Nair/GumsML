import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;

public class JavaRunCommand {

	public static void main(String args[]) throws IOException {
		File directory = new File("TensorFlowDemo/test_images");

		// Get all files in directory

		File[] files = directory.listFiles();
		for (File file : files)
		{
		   // Delete each file

		   if (!file.delete())
		   {
		       // Failed to delete file

		       System.out.println("Failed to delete "+file);
		   }
		} 
		
		BufferedImage img = ImageIO.read(new File("C:/Users/Varun/Desktop/TensorFlow Demo/test_images/pug.jpg"));
		
		File outputfile = new File("TensorFlowDemo/test_images/image.jpg");
		ImageIO.write(img, "jpg", outputfile);
		String s = null;

		try {

			Process p = Runtime.getRuntime().exec("python TensorFlowDemo/test.py");

			BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

			BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

			// read the output from the command
			System.out.println("Here is the standard output of the command:\n");
			while ((s = stdInput.readLine()) != null) {
				System.out.println(s);
			}

			// read any errors from the attempted command
//			System.out.println("Here is the standard error of the command (if any):\n");
//			while ((s = stdError.readLine()) != null) {
//				System.out.println(s + "\n\n");
//			}

			System.exit(0);
		} catch (IOException e) {
			System.out.println("exception happened - here's what I know: ");
			e.printStackTrace();
			System.exit(-1);
		}
	}
}