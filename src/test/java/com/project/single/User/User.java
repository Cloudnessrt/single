package com.project.single.User;

import com.project.single.SingleApplication;
import com.project.single.common.util.QueryPage;
import com.project.single.doentity.common.UserDo;
import com.project.single.service.common.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SingleApplication.class)
public class User {

    @Autowired
    private IUserService userServiceImpl;

    @Test
    public void testShow() throws Exception {
        UserDo userDo=new UserDo();
        userDo.setAccount("123");
        userServiceImpl.insert(userDo);
        userServiceImpl.query(userDo.getId());
        userDo.setAccount("1234");
        userServiceImpl.update(userDo);
        userServiceImpl.queryList(userDo);
        QueryPage<UserDo>page=new QueryPage<UserDo>();
        page.setObject(userDo);
        page.setSize(10);
        page.setPagenum(0);
        userServiceImpl.queryPage(page);
        userServiceImpl.delete(userDo.getId());
        userServiceImpl.query(userDo.getId());
    }
}
