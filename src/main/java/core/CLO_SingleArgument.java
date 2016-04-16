package core;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;



public class CLO_SingleArgument {
	
	public static final String sURL="-u";
	public static final String URL="--url";
	
	public static final String sTitleExpected="-t";
	public static final String TitleExpected="--title";
	
	public static final String sTest_case_id="-c";
	public static final String Test_case_id="--case";
	
	public static final String Help="--help";
	
	
	@Parameter(names={"-u", "--url"}, description ="URL of Web site")
	private static String url="https://www.google.com";

	@Parameter(names={"-t", "--title"}, description ="Expected title of Page")
	private static String title_expected="Google";	
	
	@Parameter(names={"-c", "--case"}, description ="Test case ID")
	private static String test_case_id="TC-001.01";
	
	@Parameter(names="--help", help=true, hidden=true)
	private static boolean help;
	
	public static void main(String args[]) 
	{
		JCommander	clo = new JCommander(new CLO_SingleArgument(), args);	
		if (help){clo.usage();
		System.exit(0);}
		
		WebDriver driver = new HtmlUnitDriver();
		
				
		        driver.get(url);
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				String title_actual = driver.getTitle();
		
		if (title_expected.equals(title_actual)) {
			System.out.println("Test Case ID: "+test_case_id);
			System.out.println("URL: "+url);
			System.out.println("Title Expected: "+title_expected);
			System.out.println("Title Actual: "+title_actual);
			System.out.println("Test Case Result: "+"PASSED");
			System.out.println();
		} else {
			System.out.println("Test Case ID: "+test_case_id);
			System.out.println("URL: "+url);
			System.out.println("Title Expected: "+title_expected);
			System.out.println("Title Actual: "+title_actual);
			System.out.println("Test Case Result: "+"FAILED");
			}
	}
	
	
//END Class
}
