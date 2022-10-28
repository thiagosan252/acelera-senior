package net.atos.animals.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "tbom_user")
public class UserModel implements UserDetails, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "uuid_userId")
	private UUID userId; 
	
	@Column(name = "vc_userName", nullable = false, unique = true)
	private String userName;
	
	@Column(name = "vc_password", nullable = false)
	private String password;
	
	
	@ManyToMany
	@JoinTable(name = "tbom_users_roles",
		joinColumns = @JoinColumn(name = "uuid_userId"),
		inverseJoinColumns = @JoinColumn(name = "uuid_roleId"))
	private List<RoleModel> roles;


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.roles;
	}


	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}


	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.userName;
	}


	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
