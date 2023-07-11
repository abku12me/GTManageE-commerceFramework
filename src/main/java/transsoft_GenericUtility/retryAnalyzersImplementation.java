package transsoft_GenericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class will re-run the script only if the script is failed
 * @author abhishek
 *
 */
public class retryAnalyzersImplementation implements IRetryAnalyzer{
	
	int count=0;
	int incount=3;

	@Override
	public boolean retry(ITestResult result) {
		while(count<incount)
		{
			count++;
			return true;
		}
		return false;
	}
	
	
	

}
