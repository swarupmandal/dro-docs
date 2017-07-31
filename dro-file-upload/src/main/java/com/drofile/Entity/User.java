package com.drofile.Entity;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = -5478643022352803739L;

	private String userName;
	private Long userId;
	private Long droOrganizationId;
	private Long droUserRoleId;
	private String firstName;
	private String lastName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getDroOrganizationId() {
		return droOrganizationId;
	}

	public void setDroOrganizationId(Long droOrganizationId) {
		this.droOrganizationId = droOrganizationId;
	}

	public Long getDroUserRoleId() {
		return droUserRoleId;
	}

	public void setDroUserRoleId(Long droUserRoleId) {
		this.droUserRoleId = droUserRoleId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
