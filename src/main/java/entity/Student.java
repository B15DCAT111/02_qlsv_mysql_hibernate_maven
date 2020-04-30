package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "student")
public class Student {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "sex")
	private boolean sex;

	@Column(name = "bod")
	@Temporal(TemporalType.TIMESTAMP)
	private Date bod;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, boolean sex, Date bod) {
		this.name = name;
		this.sex = sex;
		this.bod = bod;
	}

	public Student(Long id, String name, boolean sex, Date bod) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.bod = bod;
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

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public Date getBod() {
		return bod;
	}

	public void setBod(Date bod) {
		this.bod = bod;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", sex=" + sex + ", bod=" + bod + "]";
	}

}
