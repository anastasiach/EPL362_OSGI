package lawyerFactory;

import lawyersModel.lawyerFunctions;
import lawyersService.lawyerFunctionImpl;
/**
 * 
 * @author Anastasia Giannaki
 * 		   Marina Pashiali
 * 		   Anastasia Chimona
 * 		   Antonia Savvia
 *
 */
public class lawyerServiceFactory {
	private static lawyerFunctions lawyerService = new lawyerFunctionImpl();

	public static lawyerFunctions getFactory() {
	    return lawyerService;
	  }
}
