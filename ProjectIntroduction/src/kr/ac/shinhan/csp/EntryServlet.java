package kr.ac.shinhan.csp;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.datanucleus.metadata.PersistenceUnitMetaData;









import com.sun.net.httpserver.HttpServer;

public class EntryServlet  extends HttpServlet{
	      
	
	public void doGet(HttpServletRequest req,  HttpServletResponse  resp ) throws IOException
	{
		Cookie[] cookie =req.getCookies();
		if(cookie == null)
		{
			resp.sendRedirect("login.html");
		}
		String token = "";
		for(Cookie c : cookie)
		{
			if(c.getName().equals("login_token"))
			{
				token = c.getValue();
			}
		}
		PersistenceManager manager = MyPersistenceManager.getManager();
		Query q = manager.newQuery(UserLoginToken.class);
		q.setFilter("token == tokenParam");
		q.declareParameters("String tokenParam");
		List<UserLoginToken> tokenList =(List<UserLoginToken>) q.execute();
				
				if(tokenList.size() == 0 || token.equals(""))
				{
					resp.sendRedirect("login.html");
					
				}
				else
				{
					UserLoginToken ult = tokenList.get(0);
					String expDate = ult.getExpireDate();
					String today = new Date().toString();
					if(expDate.compareTo(today) >0)
					{
						HttpSession session = req.getSession();
						session.setAttribute("id",ult.getAccount() );
						resp.sendRedirect("index.html");
						
						String newToken = UUID.randomUUID().toString();
						Cookie c =new Cookie("login_token",newToken);
						c.setMaxAge(60*60*24*30);
						resp.addCookie(c);
						
						ult.setToken(newToken);
						manager.makePersistent(ult);
						
						
						
						
					}
				}
		
			
				
			
		
			
	}
}
