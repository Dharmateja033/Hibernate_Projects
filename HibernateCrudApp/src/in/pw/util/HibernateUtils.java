package in.pw.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.ineuron.hibernate.Student;

public class HibernateUtils {
  private static SessionFactory sessionFactory=null;
  private static Session session=null;
	
	private HibernateUtils() {
		
	}
	static {
		sessionFactory=new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
	}
	public static Session getSession() {
		if(session == null) 
			session=sessionFactory.openSession();
		    return session;
		
	}
	public static void closeSession(Session session) {
		if(session!=null)
			session.close();
	}
	public static void closeSessionFactory() {
	    if(sessionFactory !=null)
	    	sessionFactory.close();
	}
}
