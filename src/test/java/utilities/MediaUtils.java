package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class MediaUtils {
    /*
    This method captures sscreenshot of the entire page
    */
    public static void takeScreenshotOfTheEntirePage() throws IOException {
// 1. TakeScreenShot class with getScreenShotAs method to capture the screenshot
        File image = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.FILE);
// 2. Create a path to save the image
// Create a date for giving dynamic name otherwise the screenshots overrides
        String now = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());//getting local date in this format
// CURRENT PROJECT FOLDER foldername subfoldername imagename
        String path = System.getProperty("user.dir")+"/test-output/Screenshots/"+now+"image.png";
// 3. Save the image in the path as a file
        FileUtils.copyFile(image,new File(path));
// FileUtils.copyFile(FILE,FILE PATH); COPY FILE TO THAT FILE PATH
    }
    /*
    This method captures screenshot of specific elements
    this method accepts an elements and saves the screenshot of that element in the test-output folder
    */
    public static void takeScreenshotOfThisElement(WebElement element) throws IOException {
        File image = element.getScreenshotAs(OutputType.FILE);
        String now = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/ElementScreenshot/"+now+"image.png";
        FileUtils.copyFile(image,new File(path));
    }
    /*
    This method captures the image and returns the path of that image
    RETURN TYPE : static String
    return new File(path).getAbsolutePath();
    */
    public static String takeScreenshotOfTheEntirePageAsString() {
        try {
// 1. TakeScreenShot class with getScreenShotAs method to capture the screenshot
            File image = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.FILE);
// 2. Create a path to save the image
// Create a date for giving dynamic name otherwise the screenshots overrides
            String now = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());//getting local date in this format
// CURRENT PROJECT FOLDER foldername subfoldername imagename
            String path = System.getProperty("user.dir")+"/test-output/Reports/Screenshots/"+now+"image.png";
// 3. Save the image in the path as a file
            FileUtils.copyFile(image,new File(path));
            return new File(path).getAbsolutePath();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String takeScreenshotAllScreen(String name){
//        THIS METHOD TAKES SCREENSHOT AND STORE IN /test-output FOLDER
//        NAME OF THE SCREEN IS BASED ON THE CURRENT TIME
//        SO THAN WE CAN HAVE UNIQUE NAME
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//        public static final String path = date.toString();
        // TakesScreenshot is an interface of selenium that takes the screenshot. SAME IS IN THE HOOKS
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/testOutput/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return target;
    }
    public static void takeScreenshotAllScreen(){
//        1. TakeScreenShot class with getScreenShotAs method to capture the screenshot
        File image = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.FILE);
//        2. Create a path to save the image
//        Create a date for giving dynamic name otherwise the screenshots overrides
        String now = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());//getting local date in this format
//                     CURRENT PROJECT FOLDER         foldername   subfoldername imagename
        String path = System.getProperty("user.dir") +"/testOutput/Screenshots/" + now + "image.png";
//        3. Save the image in the path as a file
        try {
            FileUtils.copyFile(image,new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
