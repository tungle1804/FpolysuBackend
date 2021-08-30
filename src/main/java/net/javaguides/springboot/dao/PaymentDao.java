package net.javaguides.springboot.dao;

import net.javaguides.springboot.entity.Modal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository("PaymentDao")
@Transactional
public class PaymentDao  {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }
//    public void updateValueInput(Modal modal){
//        Session session = this.getSession();
//        Transaction transaction = null;
//        try {
//            transaction = session.beginTransaction();
//            modal.setInputValue(modal.getInputValue());
//            this.getSession().update(modal);
//            transaction.commit();
//        }catch (Exception e){
//            e.printStackTrace();
//            if ( transaction != null) {
//                transaction.rollback();
//            }
//        }
//    }
    public int updateValueInput(Modal modal) {
        try {
            String sql = "update modal SET input_value = ? where id = ?";
            int result = 0;
            result = jdbcTemplate.update(sql, modal.getInputValue(), modal.getId());

            return result;
        } catch (Exception e) {
            return 0;
        }
    }//end method
}
