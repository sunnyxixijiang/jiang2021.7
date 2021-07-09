package cn.dy.test;


import cn.dy.mapper.EmployeeMapper;
import cn.dy.pojo.Employee;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

public class MybatisPlus_Test {
    //采用单元测试  加载spring的配置文件
    private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    private EmployeeMapper employeeMapper = context.getBean("employeeMapper", EmployeeMapper.class);

    //获取mapper对象
    @Test
    public void testDemo() {
        EmployeeMapper employeeMapper = context.getBean("employeeMapper", EmployeeMapper.class);
        System.out.println(employeeMapper);
    }

    //获取数据源对象
    @Test
    public void testDemo02() {
        DataSource datasource = context.getBean("dataSource", DataSource.class);
        System.out.println(datasource);
    }

    //添加Employee对象
    @Test
    public void addEmp() {
        Employee emp = new Employee();
        //emp.setId(5);
        emp.setLastName("meimei");
        emp.setEmail("meimei@qq.com");
        emp.setGender(0);
        //emp.setAge(null);
        //调用mapper方法
        employeeMapper.insertAllColumn(emp);
        /*
        insertAllColumn添加所有的字段 没有设置某个字段值，它会自动添加默认值
        insert 只会添加指定设置的字段值
         */
    }

    //删除emp
    @Test
    public void testDel() {
        Integer row = employeeMapper.deleteById(11);
        System.out.println(row);
    }

    //查询emp
    @Test
    public void findByIdTest() {
        Employee employee = employeeMapper.selectById(1);
        System.out.println(employee);
    }

    //查询emp 调用selectOne
    @Test
    public void selectOneTest() {
        Employee employee = new Employee();
        employee.setId(1);
        Employee emp = employeeMapper.selectOne(employee);
        System.out.println(emp);

    }
    //修改emp
    @Test
    public void updateTest(){
        Employee employee=new Employee();
        employee.setId(3);
        employee.setLastName("yuhao2");
        employee.setGender(1);
        employee.setEmail("yuhao2@126.com");
        Integer row = employeeMapper.updateAllColumnById(employee);
        System.out.println(row);

    }

}
