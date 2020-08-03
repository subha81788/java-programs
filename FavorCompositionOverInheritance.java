public class Person {

    //composition has-a relationship
    private Job job;

    //variables, methods, constructors etobject-oriented3>Inheritance

Inheritance is the design technique in object oriented programming to implement is-a relationship between objects. Inheritance in Java is implemented using extends keyword.

For example, Cat is a Animal relationship in java programming will be implemented like below.


public class Animal {
// variables, methods etc.
}

public class Cat extends Animal{
}
Composition over InheritanceBoth composition and inheritance promotes code reuse through different approaches.
So which one to choose? How to compare composition vs inheritance. You must have heard that in programming you should
favor composition over inheritance. Lets see some of the reasons that will help you in choosing composition vs inheritance.
Inheritance is tightly coupled whereas composition is loosely coupled. Let's assume we have below classes with inheritance.

public class ClassA {

	public void foo(){	
	}
}

class ClassB extends ClassA{
	public void bar(){
		
	}
}
For simplicity we have both the superclass and subclass in single package. But mostly they will be in separate codebase.
There could be many classes extending the superclass ClassA. A very common example of this situation is extending
Exception class.Now let's say ClassA implementation is changed like below, a new method bar() is added.

public class ClassA {

	public void foo(){	
	}
	
	public int bar(){
		return 0;
	}
}
As soon as you start using new ClassA implementation, you will get compile time error in ClassB as The return type
is incompatible with ClassA.bar(). The solution would be to change either the superclass or the subclass bar() method
to make them compatible.If you would have used Composition over inheritance, you will never face this problem.
A simple example of ClassB implementation using Composition can be like below.
class ClassB{
	ClassA classA = new ClassA();
	
	public void bar(){
		classA.foo();
		classA.bar();
	}
}
There is no access control in inheritance whereas access can be restricted in composition. We expose all the superclass
methods to the other classes having access to subclass. So if a new method is introduced or there are security holes
in the superclass, subclass becomes vulnerable. Since in composition we choose which methods to use, it's more secure
than inheritance. For example, we can provide ClassA foo() method exposure to other classes using below code in ClassB.
class ClassB {
	
	ClassA classA = new ClassA();
	
	public void foo(){
		classA.foo();
	}
	
	public void bar(){	
	}
	
}
This is one of the major advantage of composition over inheritance.Composition provides flexibility in invocation of
methods that is useful with multiple subclass scenario. For example, let's say we have below inheritance scenario.
abstract class Abs {
	abstract void foo();
}

public class ClassA extends Abs{

	public void foo(){	
	}
	
}

class ClassB extends Abs{
		
	public void foo(){
	}
	
}

class Test {
	
	ClassA a = new ClassA();
	ClassB b = new ClassB();

	public void test(){
		a.foo();
		b.foo();
	}
}
So what if there are more subclasses, will composition make our code ugly by having one instance for each subclass?
No, we can rewrite the Test class like below.
class Test {
	Abs obj = null;
	
	Test1(Abs o){
		this.obj = o;
	}
	
	public void foo(){
		this.obj.foo();
	}

}
This will give you flexibility to use any subclass based on the object used in the constructor.One more benefit of
composition over inheritance is testing scope. Unit testing is easy in composition because we know what all methods
we are using from other class. We can mock it up for testing whereas in inheritance we depend heavily on superclass
and don’t know what all methods of superclass will be used. So we will have to test all the methods of superclass.
This is an extra work and we need to do it unnecessarily because of inheritance.That's all for composition vs inheritance.
You have got enough reasons to choose composition over inheritance. Use inheritance only when you are sure that
superclass will not be changed, otherwise go for composition.
