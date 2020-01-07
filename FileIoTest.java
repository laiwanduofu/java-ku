import org.junit.Test;

import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.util.List;

public class FileIoTest {
    @Test
    public  void  T1() throws CloneNotSupportedException {
        Person1 old=new Person1("张三",11);
        Person1 clone1=(Person1)old.clone();
        old.age=12;
        System.out.println("old="+old);
        System.out.println("clone1="+clone1);
    }
    @Test
    public void t2() throws CloneNotSupportedException {
        Person1 old1=new Person1("张三",11);
        Person1 old2=new Person1("李四",14);
        Person1Container container=new Person1Container();
        container.name="hah";
        // 添加一个到list中
        container.person1List.add(old1);
        container.person1List.add(old2);
        Person1Container clone1 =(Person1Container)container.clone();
        // 修改信息
        container.name="abc";
        container.person1List.get(0).age=14;
        System.out.println(container.name+"\n"+container.person1List);
        System.out.println(clone1.name+"\n"+clone1.person1List);

    }

    public static class Person1Container implements Cloneable{
        private String name;
        private List<Person1> person1List=new ArrayList<>();

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public static class Person1 implements Cloneable{
        private String name;
        private Integer age;
        public Person1(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person1{"+"name"+name+"\'"+ "age"+age+"}";
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}
