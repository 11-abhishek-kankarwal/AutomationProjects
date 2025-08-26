package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SwagLabs{

	
	public static WebDriver driver;
	
	
	public static void main(String[] args) throws InterruptedException {
		
		settingUp();
		
		driver.get("https://www.saucedemo.com");
		
		//-----------------------------------------------------
		//login flow
		login("standard_user","secret_sauce");
		
		//-----------------------------------------------------
		//verify login
		verifyLogin();
				
		//-----------------------------------------------------
		//add to cart
		addToCart();
		
		
		//-----------------------------------------------------
		//go to cart
		 Thread.sleep(1000);
		getElement(CartIcon).click();
		
		//-----------------------------------------------------
		//verifying cart
		
		
		List<String> expectedProducts = new ArrayList<>();
	       
		expectedProducts.add("Sauce Labs Backpack");
        expectedProducts.add("Sauce Labs Fleece Jacket");
		
        verifyCart(expectedProducts);
		
	}
	
	
	//======================================================
	//-------setting up the browser------
	
	 private static void settingUp() {

	        ChromeOptions options = new ChromeOptions();



	        // Disable popups & notifications

	        Map<String, Object> prefs = new HashMap<>();

	        prefs.put("credentials_enable_service", false);

	        prefs.put("profile.password_manager_enabled", false);

	        options.setExperimentalOption("prefs", prefs);

	        options.addArguments("--disable-save-password-bubble");

	        options.addArguments("--disable-notifications");



	        driver = new ChromeDriver(options);
	       // driver = new FirefoxDriver();
	       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	        driver.manage().window().maximize();

	    }
	
	 //-------------------------------------------------
	//-------login-------
	
	 public static void login(String user, String PWD) throws InterruptedException
		{
		 Thread.sleep(1000);
		 	getElement(username).sendKeys(user);
			
			getElement(pwd).sendKeys(PWD);
			
			getElement(logBtn).click();
			}
	 
	 
	 //-------------------------------------------------
	//-------verifying login-------	

	 public static void verifyLogin() throws InterruptedException {
		 Thread.sleep(1000);
			WebElement header = getElement(head);
			String text = header.getText();
			
			if(text.contains("Products")){
				
			System.out.println("\nHeader = "+text);
			System.out.println("verified. Login Successfull \n");
			System.out.println("//---------------------");
			System.out.println();
			}
			
		}
	 
	 //-------------------------------------------------
	//-------adding product in cart-------	 
	 
	 public static void addToCart() {
	    
		 getElement(bag).click();
		 getElement(jacket).click();	
	    	
	    	
	    }
	
	
	 //-------------------------------------------------
	//-------verifying cart-------	 
	 
	 private static void verifyCart(List<String> expectedProducts) {
			List<WebElement> cart = driver.findElements(By.xpath("//div[@class='cart_list']//div[@class='cart_item_label']/a"));
			
			List<String> AddList = new ArrayList<>();
			
			for(WebElement e : cart) {
				
				AddList.add(e.getText());}
			
				System.out.println("Product in cart : "+AddList);
				 for (String product : expectedProducts) {
			            if (AddList.contains(product)) {
			                System.out.println(product + " : is verified in cart");
			            } else {
			                System.out.println(product + " : is missing in cart");
			            }
			        }
				 System.out.println("---------------------");
		}

	 
	 
	 
	
	
	
	//===================================================
	 //-------utils-------
	 
	 public static WebElement getElement(By locator) {
		 return driver.findElement(locator);
	 }
	
	 
	 //====================================================
	 //---------locators------
	 
	 private static final By username = By.xpath("//div[@class='login_wrapper']//div[@id='login_button_container']//form//input[@id='user-name']");
	 private static final By pwd = By.xpath("//div[@class='login_wrapper']//div[@id='login_button_container']//form//input[@id='password']");
	 private static final By logBtn = By.xpath("//div[@class='login_wrapper']//div[@id='login_button_container']//form/input[@id='login-button']");
	 
	 private static final By bag = By.id("add-to-cart-sauce-labs-backpack");
	 private static final By jacket = By.id("add-to-cart-sauce-labs-fleece-jacket");
	
	 private static final By head = By.xpath("//div[@id='header_container']//span[@class='title']");
	 
	 private static final By CartIcon = By.xpath("//div[@id='header_container']//div[@class='shopping_cart_container']");
	 
	
	
}
