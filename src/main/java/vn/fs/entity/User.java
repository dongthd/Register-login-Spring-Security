package vn.fs.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String password;
	private String avatar;
	@Temporal(TemporalType.DATE)
	private Date registerDate;
	private Boolean status;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "users_roles",
		joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))

	private Collection<Role> roles;

	public User() {
		super();
	}

	public User(Long id, String name, String email, String password, String avatar, Date registerDate, Boolean status,
			Collection<Role> roles) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.avatar = avatar;
		this.registerDate = registerDate;
		this.status = status;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	
}
