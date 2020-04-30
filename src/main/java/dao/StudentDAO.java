package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Student;

public class StudentDAO {
	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

	public void save(Student obj) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(obj);
			session.getTransaction().commit();

		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}

	}

	public void updateName(Long id, String name) {
		Session session = sessionFactory.openSession();
		String sql = "UPDATE student s SET s.name = :newName WHERE s.id = :id";
		session.createQuery(sql).setString("newName", name).setLong("id", id).executeUpdate();
	}

	public void update(Student obj) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(obj);
			session.getTransaction().commit();

		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}

	}

	public void delete(Long id) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			Student obj = session.load(Student.class, id);
			session.delete(obj);
			session.getTransaction().commit();

		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
	}

	public void searchByName(String name) {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Student> list = session.createQuery("FROM student WHERE name LIKE :name")
				.setParameter("name", "%" + name + "%").list();
		for (Student obj : list) {
			System.out.println(obj.toString());
		}
	}

	public Student findById(Long id) {
		Session session = sessionFactory.openSession();
		Student obj = session.load(Student.class, id);
		return obj;
	}

	public List<Student> showAll() {
		List<Student> result = new ArrayList<Student>();
		Session session = sessionFactory.openSession();
		List<Student> list = session.createQuery("FROM Student").list();
		for (Student obj : list) {
			result.add(obj);
		}
		return result;
	}

	public List<Student> search(Student obj) {
		Session session = sessionFactory.openSession();
		StringBuilder query = new StringBuilder();
		query.append("select * from student where 1 = 1 ");
		if (obj.getId() != null) {
			query.append("AND id = :id ");
		}
		if (obj.getName() != null) {
			query.append("AND name = :name ");
		}

		SQLQuery sqlQuery = session.createSQLQuery(query.toString()).addEntity(Student.class);
		if (obj.getId() != null) {
			sqlQuery.setParameter("id", obj.getId());
		}
		if (obj.getName() != null) {
			sqlQuery.setParameter("name", obj.getName());
		}

		return sqlQuery.list();
	}

	public List<Student> searchBySex(boolean sex) {
		Session session = sessionFactory.openSession();
		StringBuilder query = new StringBuilder();
		query.append("select * from student where 1 = 1 ");
		if (sex) {
			query.append("AND sex = 1 ");
		}
		if (!sex) {
			query.append("AND sex = 0 ");
		}
		SQLQuery sqlQuery = session.createSQLQuery(query.toString()).addEntity(Student.class);

		return sqlQuery.list();
	}
}
