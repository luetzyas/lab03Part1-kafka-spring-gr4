package ch.unisg.kafka.spring.model;


import java.io.Serializable;


public class MetricSystem implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String health;
    private String gpu;
    private int age;
    private boolean active;

    public MetricSystem() { }

    public MetricSystem(String name, String health, String gpu, int age, boolean active) {
        super();
        this.name = name;
        this.health = health;
        this.gpu = gpu;
        this.age = age;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "System metrics [name=" + name + ", health=" + health
                + ", gpu=" + gpu + ", age=" + age + ", active="
                + active + "]";
    }

}