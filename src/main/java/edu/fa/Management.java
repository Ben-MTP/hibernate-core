package edu.fa;

import edu.fa.model.Course;
import edu.fa.model.Syllabus;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * @author ManhKM on 9/12/2022
 * @project hibernate-fpt ----- Để lưu object xuống Database thì cần một Session SessionFactory là
 * một class design theo Factory Pattern + Đối với các properties sau khi parse thành công sẽ là các
 * Map<String>
 */
public class Management {

  public static void main(String[] args) {

    Syllabus syllabus = new Syllabus("Giao trinh Hibernate", 30);
    Course course = new Course("Hibernate Tutorial", new Date(), syllabus);
    SessionFactory sessionFactory = ConnectionUtil.getSessionFactory();
    try {
      Session session = sessionFactory.openSession();     // Tạo ra một Session
      session.beginTransaction();
        session.save(course);   // save object course into Database
        session.getTransaction().commit();
      System.out.println(course);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      ConnectionUtil.getSessionFactory().close(); //close connection to Database
    }
  }
}
