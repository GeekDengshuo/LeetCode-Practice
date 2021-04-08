package src.test;

import javax.sound.midi.Soundbank;
import java.util.HashSet;

/**
 * @Author deng shuo
 * @Date 4/7/21 21:35
 * @Version 1.0
 */

class Person{
    String name;
    int age;
    Person(String name,int age){ this.name = name;this.age = age; }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Person p = (Person)obj;
        return this.name == p.name && this.age == p.age;
    }

    @Override
    public String toString() { return "("+name + ", " +age+")";}

    @Override
    public int hashCode() {
        int nameHash =  name.toUpperCase().hashCode();
        return nameHash ^ age;
    }
}
public class HashCodeEquals {
    public static void main(String[] args) {
        Person person1 = new Person("jack",19);
        Person person2 = new Person("rose",17);
        Person person3 = new Person("jack",19);
        Person person4 = new Person("JACK",19);

        HashSet<Person> hashSet = new HashSet<>();
        hashSet.add(person1);
        hashSet.add(person2);
        hashSet.add(person3);
        System.out.println(person1 == person3);       // false
        System.out.println("person1.equals(person2) = "+person1.equals(person2)+"\n"
                        +"person1.hashCode = "+person1.hashCode()+ "\n"
                        +"person2.hashCode = "+person2.hashCode());
        System.out.println();
        System.out.println("person1.equals(person3) ="+ person1.equals(person3)+"\n"
                        +"person1.hashCode = "+person1.hashCode()+"\n"
                        +"person3.hashCode = "+person3.hashCode());

        System.out.println();
        System.out.println("person1.equals(person4) ="+ person1.equals(person4)+"\n"
                +"person1.hashCode = "+person1.hashCode()+"\n"
                +"person4.hashCode = "+person4.hashCode());

        System.out.println();
        System.out.println("hashSet.size() = "+ hashSet.size());
        System.out.printf("hashSet = %s\n",hashSet);

    }
}
