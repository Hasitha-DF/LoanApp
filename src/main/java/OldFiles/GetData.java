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
//public class GetData {
//
//    public  <T> T getData(Class<T> o,int ID ){
//        StandardServiceRegistryBuilder ssr = new StandardServiceRegistryBuilder();
//        StandardServiceRegistryBuilder ssr1 = ssr.configure();
//        StandardServiceRegistry ssr2 = ssr1.build();
//        Metadata meta = new MetadataSources(ssr2).getMetadataBuilder().build();
//
//        SessionFactory factory = meta.getSessionFactoryBuilder().build();
//        Session session = factory.openSession();
//        Transaction t = session.beginTransaction();
//
//        T entity  = session.get(o , ID);
//        t.commit();
//        System.out.println("successfully saved");
//        factory.close();
//        session.close();
//
//        return entity;
//    }
//}
