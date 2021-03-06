package com.tangzq.service;

import com.tangzq.model.User_me;
import com.tangzq.vo.RegisterUserVo;

/**
 * @author tangzhiqiang
 */
public interface UserService {


    /**
     * 创建用户
     * @param vo
     * @return
     */
    User_me createUser(RegisterUserVo vo);


    /**
     * 获取用户
     * @param uid
     * @return
     */
    User_me getUser(int uid);

    /**
     * 根据用户名和密码查找用户
     * @param username
     * @param password
     * @return
     */
    User_me findUser(String username, String password);

    /**
     * 判断用户是否有效
     * @param username
     * @param password
     * @return
     */
    boolean isUserValid(String username, String password);


    /**
     * 使用用户名查找用户
     * @param username
     * @return
     */
    User_me findByUsername(String username);

    /**
     * 使用邮箱查找用户
     * @param email
     * @return
     */
  //  User_me findUserByEmail(String email);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    User_me updateUserInfo(User_me user);


    /**
     * 修改用户密码
     * @param userId
     * @param newPwd
     * @return
     */
//    User_me updatePwd(String userId, String newPwd);
    User_me updatePwd(int userId, String newPwd);

    /**
     * 更新头像
     * @param userId
     * @param avatarURL
     * @param isUploaded 是否通过上传更新的头像图片
     * @return
     */
//    User_me updateAvatar(String userId, String avatarURL, boolean isUploaded);
    User_me updateAvatar(int userId, String avatarURL, boolean isUploaded);

}
