package loginFactory;
import loginModel.loginFunction;
import loginService.loginImpl;
/**
 * 
 * @author  Anastasia Yiannaki
 * 			Antonia Savvia
 * 			Anastasia Chimona
 * 			Marina Pashiali
 *		Calling the login Functions implementation
 */
public class loginFactory {

	
		
		private static loginFunction login = new loginImpl();
		public static loginFunction getFactory(){
			return login;
		}
	

}


