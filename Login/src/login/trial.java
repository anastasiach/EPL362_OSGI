package login;



import loginModel.loginFunction;
import loginFactory.loginFactory;
/**
 * 
 * @author 	Anastasia Yiannaki
 *			Anastasia Chimona
 *			Antonia Savvia
 *			Marina Pashiali
 *
 *		login trial with specific id and password
 */
public class trial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		loginFunction factory = loginFactory.getFactory();
		int a[] =factory.login("ayiann02", "123");
		System.out.println(a[0]+" "+a[1]);
	}

}
