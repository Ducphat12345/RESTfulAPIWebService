package com.poly.repository;

import com.poly.entity.Category;
import com.poly.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CategoryRepository {
    public List<Category> getAllCategory(){
        Session sessionCategory = HibernateUtil.getSessionFactory().openSession();
        try {
            String sql = "from Category";
            Query<Category> query = sessionCategory.createQuery(sql);
            List<Category> categories = query.getResultList();
            return categories;
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
        finally {
            sessionCategory.close();
        }
        return null;
    }
    public Category getCategoryByID(int id){
        Session sessionCategory = HibernateUtil.getSessionFactory().openSession();
        try {
            String sql = "select c from Category c where c.id =:c_id";
            Query<Category> query = sessionCategory.createQuery(sql);
            query.setParameter("c_id", id);
            Category category = query.getSingleResult();
            return category;
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
        finally {
            sessionCategory.close();
        }
        return null;
    }
    public boolean addCategory(Category category){
        try(Session sessionCategory = HibernateUtil.getSessionFactory().openSession()) {
            sessionCategory.getTransaction().begin();
            sessionCategory.save(category);
            sessionCategory.getTransaction().commit();
            return true;
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
        return false;
    }
    public boolean updateCategory(Category category){
        try(Session sessionCategory = HibernateUtil.getSessionFactory().openSession()) {
            sessionCategory.getTransaction().begin();
            sessionCategory.update(category);
            sessionCategory.getTransaction().commit();
            return true;
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
        return false;
    }
    public boolean deleteCategory(int id){
        Session sessionCategory = HibernateUtil.getSessionFactory().openSession();
        try {
            sessionCategory.getTransaction().begin();
            Category category = sessionCategory.get(Category.class, id);
            sessionCategory.delete(category);
            sessionCategory.getTransaction().commit();
            return true;
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
        finally {
            sessionCategory.close();
        }
        return false;
    }
}