package com.jielan.dao;

import com.jielan.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by wang on 2016/12/13.
 */
@Repository
public interface UserMapper {

    public void addUser(User user);
    //根据openid查找用户
    public User selectByOpenid(String openid);

    public void updateUser(User user);

    //桃子清零
    public void clearPeach();

    @Update("update tb_hz_sign_user set wx_name=#{wxname},wx_image=#{wximage} where openid=#{openid}")
   public void updateCard(@Param("openid") String openid, @Param("wxname")String wxname, @Param("wximage")String wximage);
    @Select("select openid,wx_image,wx_name from tb_hz_checkin_message")
    public List<Map<String,String>> selectCard();

}
