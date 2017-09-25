import com.jielan.model.SignRecord;
import com.jielan.model.User;
import com.jielan.model.query.SignRecordQuery;
import com.jielan.util.DateUtil;
import com.jielan.util.HttpUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wang on 2016/12/28.
 */
public class test3 {
    public static void main(String[] args){
        try {
            HttpUtil.get("http://jhhd.jielanwx.com/sendmsg/sendmsg.do?mobile=18557519445&message=haha555");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
