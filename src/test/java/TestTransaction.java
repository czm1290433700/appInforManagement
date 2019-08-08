import com.app.entity.DevUser;
import com.app.service.DevUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations = {"classpath:spring-mybatis.xml","classpath:spring-mvc.xml"})
public class TestTransaction extends AbstractJUnit4SpringContextTests {
    @Autowired
    private DevUserService devUserService;

    @Test
    public void userInert(){
        DevUser devUser = new DevUser();
        devUser = devUserService.userSelectById(1001);
        return ;
    }
}
