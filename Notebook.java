
public class Notebook {
    private String producer;
    private String diagonal;
    private String ram;
    private String hdd;
    private String os;
    private String processor;
    private String color;

    public Notebook(String producer, String diagonal, String ram, String hdd, String os, String processor, String color) {
        this.producer = producer;
        this.diagonal = diagonal;
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.processor = processor;
        this.color = color;
    }

    public String getProducer() {
        return producer;
    }

    public String getDiagonal() {
        return diagonal;
    }

    public String getRam() {
        return ram;
    }

    public String getHdd() {
        return hdd;
    }

    public String getOs() {
        return os;
    }

    public String getProcessor() {
        return processor;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "\nNotebook: " +
                "\nПроизводитель: " + producer + 
                "\nдиагональ экрана: " + diagonal + 
                "\nоперативная память: " + ram + 
                "\nHDD: " + hdd + 
                "\nоперационная система: " + os +
                "\nпроцессор: " + processor + 
                "\nцвет: " + color;
    }
}
