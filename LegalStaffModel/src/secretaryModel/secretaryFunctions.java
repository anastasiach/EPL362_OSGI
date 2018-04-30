package secretaryModel;

import java.sql.ResultSet;
/**
 * 
 * @author Anastasia Giannaki
 * 		   Marina Pashiali
 * 		   Anastasia Chimona
 * 		   Antonia Savvia
 *
 */
public interface secretaryFunctions {

	ResultSet getClients();
	ResultSet getInfoForClient(int id);

}
