//package org.example.services;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.boot.Metadata;
//import org.hibernate.boot.MetadataSources;
//import org.hibernate.boot.registry.StandardServiceRegistry;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//
//public class SaveData {
//    public void saveData(Object entity){
//        StandardServiceRegistryBuilder ssr = new StandardServiceRegistryBuilder();
//        StandardServiceRegistryBuilder ssr1 = ssr.configure();
//        StandardServiceRegistry ssr2 = ssr1.build();
//        Metadata meta = new MetadataSources(ssr2).getMetadataBuilder().build();
//
//        SessionFactory factory = meta.getSessionFactoryBuilder().build();
//        Session session = factory.openSession();
//        Transaction t = session.beginTransaction();
//
//        session.save(entity);
//        t.commit();
//        System.out.println("successfully saved");
//        factory.close();
//        session.close();
//
//    }
//}
//
//
