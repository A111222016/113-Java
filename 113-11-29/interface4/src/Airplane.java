public abstract class Airplane implements Flyer {
    protected String name;
    
    public Airplane(String name) {
        this.name = name;
    }
    
    @Override
    public void fly() {
        System.out.printf(" %s 在飛%n", name);
    }
}
