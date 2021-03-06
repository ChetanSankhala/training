package com.hibernate.training.mappings.onetomany;


/*
 * Author : RAJ 
 */
import com.hibernate.training.mappings.onetoone.pojo.Pupil;
import com.hibernate.training.mappings.onetoone.pojo.Result;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
public class HibernateEngine_Delete { 
 
    public static void main(String[] javaPlanet)
    {
 
       	System.out.println(" ....... ENGINE START ............");
    	System.out.println(" .. ONE TO ONE ANNOTATION DELETE LESSON ..\n");
        Configuration configurationObj = new Configuration();
        configurationObj.configure("hibernate.cfg.xml"); 
        configurationObj.addAnnotatedClass(Result.class);
        configurationObj.addAnnotatedClass(Pupil.class);
        SessionFactory sessionFactoryObj = configurationObj.buildSessionFactory();
        Session sessionObj = sessionFactoryObj.openSession();
         
        Result resultObj = (Result) sessionObj.get(Result.class, new Integer(4));
        Transaction transactionObj = sessionObj.beginTransaction();        
        sessionObj.delete(resultObj);                
        transactionObj.commit();
        
        System.out.println("\n....... DATA DELETED SUCCESSFULLY ..........");
        sessionObj.close();
        sessionFactoryObj.close();
        
        System.out.println("\n....... ENGINE STOP ..........");
    } 
}
