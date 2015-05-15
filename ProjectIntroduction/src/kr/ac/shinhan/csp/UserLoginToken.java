package kr.ac.shinhan.csp;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class UserLoginToken {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY) //아 저장되는 필드구나
	private Long key; //프라이머리
	
	
	
	@PrimaryKey
	private String account;
	
	@PrimaryKey
	private String token;
	
	@PrimaryKey
	private String expireDate;
	
	
	public UserLoginToken(String account,String token, String expireDate)
	{
		this.account = account;
		this.token = token;
		this.expireDate = expireDate;
	}


	public String getAccount() {
		return account;
	}


	public void setAccount(String account) {
		this.account = account;
	}


	public String getExpireDate() {
		return expireDate;
	}


	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}


	public Long getKey() {
		return key;
	}


	public void setToken(String newToken) {
		// TODO Auto-generated method stub
		
	}
}
