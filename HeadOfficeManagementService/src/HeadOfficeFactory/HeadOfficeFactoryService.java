package HeadOfficeFactory;

import HeadOfficeManagement.HeadOfficeFunctions;
import HeadOfficeService.headServiceImpl;

/**
 *  Calling the functions implementation
 * 
 */

public class HeadOfficeFactoryService {

	private static HeadOfficeFunctions headOfficeService = new headServiceImpl();

	public static HeadOfficeFunctions getFactory() {
	    return headOfficeService;
	  }
}
