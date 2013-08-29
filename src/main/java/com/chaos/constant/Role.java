package com.chaos.constant;

public enum Role {
	ADMIN("ROLE_ADMIN"), USER("USER");
	private String roleName;

	private Role(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleName() {
		return roleName;
	}

}
