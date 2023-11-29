package com.poly.repository;

import com.poly.entity.Product;
import com.poly.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ProductRepository {
    public List<Product> getAllProduct(){
        Session sessionProduct = HibernateUtil.getSessionFactory().openSession();
        try {
            String sql = "from Product";
            Query<Product> query = sessionProduct.createQuery(sql);
            List<Product> products = query.getResultList();
            return products;
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
        finally {
            sessionProduct.close();
        }
        return null;
    }
    public Product getProductByID(int id){
        Session sessionProduct = HibernateUtil.getSessionFactory().openSession();
        try {
            String sql = "select p from Product p where p.id =:p_id";
            Query<Product> query = sessionProduct.createQuery(sql);
            query.setParameter("p_id", id);
            Product product = query.getSingleResult();
            return product;
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
        finally {
            sessionProduct.close();
        }
        return null;
    }
    public boolean addProduct(Product product){
        Session sessionProduct = HibernateUtil.getSessionFactory().openSession();
        try {
            sessionProduct.getTransaction().begin();
            sessionProduct.save(product);
            sessionProduct.getTransaction().commit();
            return true;
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
        finally {
            sessionProduct.close();
        }
        return false;
    }
    public boolean updateProduct(Product product){
        Session sessionProduct = HibernateUtil.getSessionFactory().openSession();
        try {
            sessionProduct.getTransaction().begin();
            sessionProduct.update(product);
            sessionProduct.getTransaction().commit();
            return true;
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
        finally {
            sessionProduct.close();
        }
        return false;
    }
    public boolean deleteProduct(int id){
        Session sessionProduct = HibernateUtil.getSessionFactory().openSession();
        try {
            sessionProduct.getTransaction().begin();
            Product product = sessionProduct.get(Product.class, id);
            sessionProduct.delete(product);
            sessionProduct.getTransaction().commit();
            return true;
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
        finally {
            sessionProduct.close();
        }
        return false;
    }
}
