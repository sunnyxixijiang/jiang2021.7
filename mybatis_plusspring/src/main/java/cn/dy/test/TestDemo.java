package cn.dy.test;

import cn.dy.mapper.EmployeeMapper;
import cn.dy.pojo.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class TestDemo {
    @Autowired
    private EmployeeMapper mapper;

    @Test
    public void findById(){
        Employee employee = (Employee) mapper.selectById(3);
        System.out.println(employee);
    }
}
