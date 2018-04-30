package secretaryFactory;

import secretaryModel.secretaryFunctions;
import secretaryService.secretaryFunctionImpl;
/**
 * Method that get the side effects of strategy 
 * 
 */

public class secretaryServiceFactory {
	
	private static secretaryFunctions secretaryService = new secretaryFunctionImpl();

	public static  secretaryFunctions getFactory() {
	    return secretaryService;
	  }
}
