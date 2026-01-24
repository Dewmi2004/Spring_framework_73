package lk.ijse;

import lk.ijse.bean.MyConnection;
import lk.ijse.bean.SpringBean;
import lk.ijse.bean.TestBean;
import lk.ijse.config.AppConfig;
import lk.ijse.newBeans.NewTestBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {
    public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();// Application Context(Spring Container)
    context.register(AppConfig.class); // register the configuration
    context.refresh();// configuration is ready it to use

        //Bean ID - default
        SpringBean springBean = (SpringBean)context.getBean("springBean");//use bean class name with first letter is simple as component name
        System.out.println("Bean ID :"+springBean);

        //Bean ID - with class name
        TestBean testBean = context.getBean(TestBean.class);// we can use only class name
        System.out.println("Bean ID :"+testBean);
        //Bean ID - with component name
        TestBean testBean1 = (TestBean)context.getBean("exampleBean");// if Bean class component has a unique name like @Component("exampleBean"),this name must be it
        System.out.println("Bean ID :"+testBean1);
        //Bean ID - with component name
        TestBean testBean2 = context.getBean("exampleBean", TestBean.class);// if Bean class component has a unique name like @Component("exampleBean"),this name must be it
        System.out.println("Bean ID :"+testBean2);

        NewTestBean newTestBean = context.getBean(NewTestBean.class);
        System.out.println("Bean ID :"+newTestBean);

        MyConnection myConnection = (MyConnection) context.getBean("connection");
        System.out.println("Bean ID :"+myConnection);


    context.registerShutdownHook();// close the context
    }
}

