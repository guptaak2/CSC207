package driver;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class getURL {
	PathHandler handle = new PathHandler();
	String content = "";

	/**
	 * Get contents from URL and create file containing those contents
	 * @param URL Site from where to get content
	 * @param curDir The current directory
	 * @param dir The root directory
	 */
	public getURL(String URL, File curDir, File dir) {
		try {
			String[] pathList = handle.stringToList(URL);
			Echo addFile;
			String fileName = pathList[pathList.length - 1];
			URL getURL = new URL(URL);

			URLConnection connectURL = getURL.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connectURL.getInputStream()));
			
			String line;
			while ((line = reader.readLine()) != null) {
				this.content += line + "\n";
			}

			addFile = new Echo(this.content, fileName, dir, curDir, ">");
			// System.out.println(content);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
