
package dao;

import pojos.Employee;
import org.hibernate.*;
import static utils.HibernateUtils.getFactory;

import java.io.Serializable;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public String addEmpDetails(Employee newEmp) {
		String mesg = "Adding emp failed !!!!!!!!!!!!!!";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
		
			Long empId = (Long) session.save(newEmp);
			tx.commit();
			
			mesg = "Added emp details , ID =" + empId;
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
	
			throw e;
		}
		return mesg;
	}

}