
public class Dog implements Animal{

    @Override
    public void locomotion() {
        System.out.println("I run on four legs.");
    }

    @Override
    public void eat() {
        System.out.println("I eat kibble.");      
    }
    
}
