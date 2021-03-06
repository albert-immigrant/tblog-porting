package com.tangzq.repository;

import com.tangzq.model.User_me;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



/**
 * User文档操作类
 * @author tangzhiqiang
 */
@Repository
public interface UserRepository extends CrudRepository<User_me, String> {

    /**
     * 用户名查找用户
     *
     * @param username
     * @return
     */
 @Query( "SELECT u FROM User_me u WHERE u.username=?1")
//    User findByUsername(String username);
    User_me findByUserName(String userName);



    /**
     * 邮件查找用户
     *
     * @param email
     * @return
     */
  //  User_me findByEmail(String email);

    /**
     * 用户名就、密码查找
     *
     * @param username
     * @param password
     * @return
     */
    @Query("select u from User_me u  where u.username=?1 and u.password=?2")
   User_me findByUsernameAndPassword(String username, String password);

    @Query("select  u from User_me u where u.id=?1")
    User_me findById(int id);
}
