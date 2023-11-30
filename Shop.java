
import java.util.ArrayList;
import java.util.List;

public class Shop {
    public static void main(String[] args) {
        Notebook notebook1 = new Notebook("Asus", "15.6", "16", "512", "Windows 11", "i7-12345", "black");
        Notebook notebook2 = new Notebook("Asus", "14", "8", "512", "Windows 11", "i7-12345", "white");
        Notebook notebook3 = new Notebook("Asus", "16", "32", "512", "Windows 11", "i7-12345", "gray");
        Notebook notebook4 = new Notebook("Asus", "15.6", "64", "1024", "Windows 11", "i9-14578", "brown");
        Notebook notebook5 = new Notebook("MSI", "15.6", "16", "512", "Windows 10", "i7-12345", "silver");
        Notebook notebook6 = new Notebook("Acer", "13", "8", "128", "no system", "i5-12345", "black");
        Notebook notebook7 = new Notebook("MSI", "14", "8", "240", "no system", "i3-7512", "white");
        List<Notebook> notebooks = new ArrayList<>();
        notebooks.add(notebook1);
        notebooks.add(notebook2);
        notebooks.add(notebook3);
        notebooks.add(notebook4);
        notebooks.add(notebook5);
        notebooks.add(notebook6);
        notebooks.add(notebook7);

        NotebookFilter notebookFilter = new NotebookFilter();
        notebookFilter.set(notebooks);
        notebookFilter.getFilteredResult().forEach(System.out::println);
    }
}