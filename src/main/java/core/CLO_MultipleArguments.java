package core;


//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

//@Parameters(separators="^")

public class CLO_MultipleArguments {

	public static final String sLIST="-l";
	public static final String LIST="--list";
	//public static final String sHelp="-h";
	//public static final String Help="--help";
	
	@Parameter(names={"-l", "--list"}, variableArity = true, description = "List",  required = true)
	private static List<String> list;
	
	@Parameter(names="--help", help=true, hidden=true)
	private static boolean help;
	
	public static void main(String[] args)
	{
		JCommander	clo = new JCommander(new CLO_MultipleArguments(), args);	
		if (help){
			clo.usage();
		System.exit(0);
		}
		WebDriver driver = new HtmlUnitDriver();

		for(int i=0;i<list.size();i++){
			String test_case_id = "TC-002.0"+(i+1);
			String param[] = list.get(i).split("\\^");
			String url = param[0];
			String title_expected = param[1];
			
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			String title_actual = driver.getTitle();

			if (title_expected.equals(title_actual)) {
				System.out.println("Test Case ID: " + test_case_id);
				System.out.println("URL: " + url);
				System.out.println("Title Expected: " + title_expected);
				System.out.println("Title Actual: " + title_actual);
				System.out.println("Test Case Result: " + "PASSED");
				System.out.println();
			} else {
				System.out.println("Test Case ID: " + test_case_id);
				System.out.println("URL: " + url);
				System.out.println("Title Expected: " + title_expected);
				System.out.println("Title Actual: " + title_actual);
				System.out.println("Test Case Result: " + "FAILED");
					System.out.println();
			}
		}//for
	driver.quit();
			}//main
}//class