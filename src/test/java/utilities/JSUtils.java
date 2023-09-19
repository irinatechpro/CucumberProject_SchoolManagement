package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import java.util.List;
public class JSUtils {
    /*
    JAVASCRIPT EXECUTOR METHODS
    @param WebElement
    scrolls into that element
    */
    public static void scrollIntoViewJS(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }
    /*
    scroll all the way down
    */
    public static void scrollAllTheWayDownJS(){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
    /*
    scroll all the way up
    */
    public static void scrollAllTheWayUpJS(){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }
    /**
     * Clicks on an element using JavaScript
     * EXPLICITLY WAIT FOR ELEMENT TO BE VISIBLE, SCROLL INTO THE ELEMENT, THEN CLICK BY JS
     * @param element
     */
    public static void clickWithTimeoutByJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", WaitUtils.waitForVisibility(element,5));
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }
     /**
     * Clicks on an element using JavaScript
     *
     * @param element
     */
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }
    /**
     * Clicks on a list of element using JavaScript
     *
     * @param elements
     */
    public static void clickWithJSAsList(List<WebElement> elements) {
        for (WebElement each : elements) {
            ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", WaitUtils.waitForVisibility(each, 5));
            ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", each);
        }
    }
    /*
    @param String id of the webelement that we want to locate
    locating element using javascript executor
    and returns that WebElement
    Note that this is NOT common, we should use 8 locators that we learned in selenium
    */
    public WebElement locateElementsByJS(String idOfElement){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        return ((WebElement)js.executeScript("return document.getElementById('"+idOfElement+"')"));
    }
    /*
    @param1 WebElement, @param2 String
    type the string in that web element
    */
    public static void setValueByJS(WebElement inputElement,String text){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].setAttribute('value','"+text+"')",inputElement);
    }
    /*
    param : ID of the element
    */
    public static String getValueByJS(String idOfElement){
        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
        String value=js.executeScript("return document.getElementById('"+idOfElement+"').value").toString();
        System.out.println(value);
        return value;
    }
    //The amount is in pixels (px)
    //Recommended amount (500), but this may vary
    //Positive number = scroll down
    //Negative Number = scroll up
    /**
     * This method is useful when locating element to scroll to,
     * but then something gets in the way and element is not visible on screen
     * E.g. the navbar comes over on top of the element you scrolled to
     */
    public static void scrollToElementThenScrollByAmount(WebElement element, int scrollAmount) {

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        WaitUtils.waitFor(2);

        //Scroll up by a certain amount (e.g. 100 pixels)
        js.executeScript("window.scrollBy(0, arguments[0])", scrollAmount);
        WaitUtils.waitFor(2);
    }
    public static void scrollByAmount(int scrollAmount) {

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        //Scroll up by a certain amount (e.g. 100 pixels)
        js.executeScript("window.scrollBy(0, arguments[0])", scrollAmount);
        WaitUtils.waitFor(2);
    }
    //to get the page title with JS
    public static String getTitleByJS() {
        JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
        String title = js.executeScript("return document.title;").toString();
        return title;
    }
    public static void changeColor(String color, WebElement element) {
        JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) Driver.getDriver());
        javascriptExecutor.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //Flashing teh background color
    public static void flash(WebElement element) {
        String bgColor = element.getCssValue("backgroundcolor");
        for (int i = 0; i < 5; i++) {
            changeColor("rgb(0,200,0", element);
            changeColor(bgColor, element);
        }
    }
    //public static void highlightElement(WebDriver driver, WebElement element){
    //    JavascriptExecutor javascript=(JavascriptExecutor)driver;
    //    javascript.executeScript("arguments[0].setAttribute('style', 'background: red; border: 2px solid black;');", element);
    //    try
    //    {
    //        Thread.sleep(500);
    //    }
    //    catch (InterruptedException e) {
    //
    //        System.out.println(e.getMessage());
    //    }
    //    javascript.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);
    //}
    //this will generate an alert when needed
    public static void generateAlert(String message) throws InterruptedException {
        JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) Driver.getDriver());
        javascriptExecutor.executeScript("alert('" + message + "')");
        Thread.sleep(3000);
    }
    /*
     * executes the given JavaScript command on given web element
     */
    public static void executeJScommand(WebElement element, String command) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript(command, element);
    }
    /*
     * executes the given JavaScript command on given web element
     */
    public static void executeJScommand(String command) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript(command);
    }
}