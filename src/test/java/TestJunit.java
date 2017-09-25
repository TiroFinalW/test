import com.jielan.dao.UserMapper;
import com.jielan.model.User;
import com.jielan.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by wang on 2017/1/10.
 */

public class TestJunit {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @Test
    @Sql(config = @SqlConfig(dataSource=""),statements="insert into quan (quanname,deadline) values (1,1) ")
    @Transactional()
    @Rollback
    public void addCard(){
        User user = new User();
        user.setOpenid("111");
        userMapper.addUser(user);
    }
}
