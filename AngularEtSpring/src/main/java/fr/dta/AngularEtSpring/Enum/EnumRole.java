package fr.dta.AngularEtSpring.Enum;

public enum EnumRole {
	ROLE_ADMIN("ROLE_ADMIN"),
	ROLE_USER("ROLE_USER");
	
	private String role;
	
	private EnumRole(String nom)
	{
		this.role = nom;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
