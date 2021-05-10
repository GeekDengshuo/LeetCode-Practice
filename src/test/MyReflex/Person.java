package src.test.MyReflex;

/**
 * @Author deng shuo
 * @Date 5/4/21 07:51
 * @Version 1.0
 */
public class Person {

    private String name = "jobs";

    public int age = 56;

    public Person(){

    }

    public int getAge(){
        return age;
    }

    public String getName(){
        return name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setName(String name){
        this.name = name;
    }
}
