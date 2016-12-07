/**
 * 
 */
package com.ocs.ms.entity;

import com.ocs.ms.security.UserSession;

/**
 * @author jin 
 * 2016-12-7
 */

public class UserLoginInfo extends UserSession {

	private static final long serialVersionUID = 5814530928264848151L;
	private String id;
	private String username;
	private String passwd;
	private String displayname;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getDisplayname() {
		return displayname;
	}
	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}
	@Override
	public String toString() {
		return "UserLoginInfo [id=" + id + ", username=" + username + ", passwd=" + passwd + ", displayname="
				+ displayname + "]";
	}
	
	
}
