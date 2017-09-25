import com.alibaba.fastjson.JSONObject;
import com.jielan.dao.PassWordMapper;
import com.jielan.dao.UserMapper;
import com.jielan.model.PassWord;
import com.jielan.model.User;
import com.jielan.model.query.PassWordQuery;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by wang on 2017/2/25.
 */
public class PasswordMapperTest extends BaseTest{
    /*
    INSERT INTO
    `db_jhhdapi`.`tb_hz_sign_user`
            (`openid`, `phone`, `wx_image`, `wx_name`, `createDate`, `sigin_count`, `siginDate`, `peach`, `retroactiveCard`, `signoffDate`, `nextpeach`)
    VALUES
            ('123123', '13295530310', 'http://wx.qlogo.cn/mmopen/0H1Z1q6go3eB8lEGFFXSKGelxD7TwjcMF4u47uEicjQ3XzqOsJvefVKlme9QS0HTqUUMObIgFibjYIjOoNkFQT9Q/0', 'U', '2016-12-31 05:26:15', '0', '2017-02-15 10:03:28', '280.0', '46', NULL, '1.0');

    */
    @Resource
    private PassWordMapper passWordMapper;

    @Resource
    private UserMapper userMapper;

    private static final String OPEN_ID = "123123";
    @Test
    @Sql(config = @SqlConfig(dataSource = "dataSource"),statements = "    INSERT INTO \n" +
            "    `db_jhhdapi`.`tb_hz_sign_user` \n" +
            "            (`openid`, `phone`, `wx_image`, `wx_name`, `createDate`, `sigin_count`, `siginDate`, `peach`, `retroactiveCard`, `signoffDate`, `nextpeach`) \n" +
            "    VALUES \n" +
            "            ('123123', '13295530310', 'http://wx.qlogo.cn/mmopen/0H1Z1q6go3eB8lEGFFXSKGelxD7TwjcMF4u47uEicjQ3XzqOsJvefVKlme9QS0HTqUUMObIgFibjYIjOoNkFQT9Q/0', 'U', '2016-12-31 05:26:15', '0', '2017-02-15 10:03:28', '280.0', '46', NULL, '1.0');\n" +
            "    ")
    @Transactional("transactionManager")
    @Rollback
    public void  acquireTest(){
        User user = userMapper.selectByOpenid(OPEN_ID);
        Assert.assertNotNull(user);

    }

}
