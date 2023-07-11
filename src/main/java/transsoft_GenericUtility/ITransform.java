package transsoft_GenericUtility;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

/**
 * This class will re-run failed script 
 * @author mishr
 *
 */
public class ITransform implements IAnnotationTransformer{

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		
		annotation.setRetryAnalyzer(transsoft_GenericUtility.retryAnalyzersImplementation.class);
		
		
	}
	
	
	
	

}
