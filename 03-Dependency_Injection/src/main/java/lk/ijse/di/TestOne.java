package lk.ijse.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//interface through injection
@Component
@Scope("prototype")//use prototype instead of singleton
public class TestOne implements DIInterface {
DI di;
@Autowired
    @Override
    public void inject(DI di) {
      this.di = di;
    }
    public void ChatWithTestTwo(){
        di.chat();
    }
}

//setter method through injection
//@Component
//public class TestOne {
//    DI di;
//    public TestOne() {
//        this.setTestOne(di);
//    }
//    @Autowired
//   public void setTestOne(DI di){
//       this.di = di;
//   }
//    public void ChatWithTestTwo(){
//        di.chat();
//   }
// }

//constructor through injection
//@Component
//public class TestOne {
//    DI di;
//
////    @Autowired - this is optional in constructor through Injection
//    public TestOne(DI di) {
//        this.di = di;
//    }
//   public void ChatWithTestTwo(){
//        di.chat();
//   }
//
//}
