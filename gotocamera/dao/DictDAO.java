/**
 * DAO Interface for Dict class
 * @author Sandeep
 * @date 08-Feb-2012
 */
package dao;
import model.Term;

public interface DictDAO {
	boolean checkIfTermExists(String term);
	int addTerm(Term term);
	int removeTerm(String termId);
	int updateTerm(Term term);
}
