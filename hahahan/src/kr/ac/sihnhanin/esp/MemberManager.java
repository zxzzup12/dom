package kr.ac.sihnhanin.esp;
import java.util.List; 

 
import javax.jdo.JDOHelper; 
import javax.jdo.PersistenceManager; 
import javax.jdo.Query; 

public class MemberManager {
	
	public static Member HahahanServlet(String name, String socialNumber)
	
	{
		PersistenceManager  pm = JDOHelper.getPersistenceManagerFactory("tansactions-optional").getPersistenceManager();
		Member m = new Member(name,socialNumber);
		pm.makePersistent(m);
		return m;
		
	}
	public static Member getMember(String Key)
	{
		PersistenceManager pm = JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager();
		Member m =pm.getObjectById(Member.class,Key);
		
		return m;
	}
	public static void deletMember(String Key)
	{
		PersistenceManager pm = JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager();
		Member m = MemberManager.getMember(Key);
		pm.deletePersistent(m);
		
	}
	public static List<Member> getAllMembers() 
	 	{ 
		PersistenceManager pm = JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager(); 
			Query qry = pm.newQuery(Member.class); 
			List<Member> memberList = (List<Member>) qry.execute(); 
 
	 
	 		return memberList; 
	 	} 

	
}



