package receptionistFactory;

import receptionistModel.receptionistFunctions;
import receptionistService.receptionistService;
/**
 * Calling the receptionist function implementation
 * @author  Anastasia, Anastasia, Antonia, Marina
 *
 */

public class receptionistFactory {
	
	private static receptionistFunctions r= new receptionistService();
	
	public static receptionistFunctions getFactory(){
		return r;
	}

}
