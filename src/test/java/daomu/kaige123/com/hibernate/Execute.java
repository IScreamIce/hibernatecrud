package daomu.kaige123.com.hibernate;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.stat.SessionStatistics;
import org.junit.Test;

import java.util.List;

public class Execute {

    //    insert
    @Test
    public void insert() {
        // 加载hibernate.cfg.xml配置
        Configuration config = new Configuration().configure();
        // 获取SessionFactory
        SessionFactory sessionFactory = config.buildSessionFactory();
        // 获得一个session
        Session session = sessionFactory.openSession();
        // 开始事务
        Transaction transaction = session.beginTransaction();

        // 执行保存的操作
        BeanTest01 test01 = new BeanTest01(1024, "icream", "sicuan", "111111");
        session.save(test01);

        // 提交事务
        transaction.commit();

        // 关闭session session.close();
        sessionFactory.close();
    }

    //    select单查
    @Test
    public void select() {
        // 加载hibernate.cfg.xml配置
        Configuration config = new Configuration().configure();
        // 获取SessionFactory
        SessionFactory sessionFactory = config.buildSessionFactory();
        // 获得一个session
        Session session = sessionFactory.openSession();

        // pojo注入对象,要查询的主键,默认传入主键查询,其他字段报错
        BeanTest01 beanTest01 = session.get(BeanTest01.class, 141);
        System.out.println("resulotdata: " + beanTest01.toString());

        // 关闭session session.close();
        sessionFactory.close();
    }

    //    执行sql查询
    @Test
    public void sqlselect() {
        // 加载hibernate.cfg.xml配置
        Configuration config = new Configuration().configure();
        // 获取SessionFactory
        SessionFactory sessionFactory = config.buildSessionFactory();
        // 获得一个session
        Session session = sessionFactory.openSession();
        // 开始事务
        Transaction transaction = session.beginTransaction();

        // 执行sql查询,addEntity注入到实体中,否则类型不匹配,不*全查记录报错字段不存在,POJO映射不匹配
        // 创建createSQLQuery,sql执行查询,才能执行SQL查询
        Query<BeanTest01> query = session.createSQLQuery("select * from test01 where uid=141").addEntity(BeanTest01.class);
        BeanTest01 beanTest01 = query.uniqueResult();
        System.out.println("resulotdata: " + beanTest01.toString());

        transaction.commit();

        // 关闭session session.close();*
        sessionFactory.close();
    }

    //    update 执行SQL更新
    @Test
    public void update() {
        // 加载hibernate.cfg.xml配置
        Configuration config = new Configuration().configure();
        // 获取SessionFactory
        SessionFactory sessionFactory = config.buildSessionFactory();
        // 获得一个session
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // pojo注入对象,要查询的主键,默认传入主键查询,其他字段报错
        BeanTest01 beanTest01 = session.get(BeanTest01.class, 141);
        System.out.println("resulotdata: " + beanTest01.toString());

        // 设置新的字段,此字段要更新
        beanTest01.setPhone("1010110");
        // saveOrUpdate将更新保持到数据库,让数据库更新,但save数据库不会更新
        session.saveOrUpdate(beanTest01);

        // 先查询映射为对象,对象在更新到库,实例对象去更新,会导致除了填写的属性更新了,其他没更新,hibernate整行更新

        transaction.commit();

        // 关闭session session.close();
        sessionFactory.close();
    }

    //    delete 执行SQL删除
    @Test
    public void delete() {
        // 加载hibernate.cfg.xml配置
        Configuration config = new Configuration().configure();
        // 获取SessionFactory
        SessionFactory sessionFactory = config.buildSessionFactory();
        // 获得一个session
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // pojo注入对象,要查询的主键,默认传入主键查询,其他字段报错
        BeanTest01 beanTest01 = session.get(BeanTest01.class, 141);
        System.out.println("resulotdata: " + beanTest01.toString());

        session.delete(beanTest01);

        // 先查询映射为对象,在删除

        transaction.commit();

        // 关闭session session.close();
        sessionFactory.close();
    }

}