package receptionistFactory;

import receptionistModel.receptionistFunctions;
import receptionistService.receptionistService;

public class receptionistFactory {
	
	private static receptionistFunctions r= new receptionistService();
	
	public static receptionistFunctions getFactory(){
		return r;
	}

}
