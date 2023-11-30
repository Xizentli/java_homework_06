
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NotebookFilterOptions {
    Set<String> producers = new HashSet<>();
    Set<String> diagonals = new HashSet<>();
    Set<String> rams = new HashSet<>();
    Set<String> hdds = new HashSet<>();
    Set<String> oses = new HashSet<>();
    Set<String> processors = new HashSet<>();
    Set<String> colors = new HashSet<>();

    public void add(List<Notebook> notebooks) {
        for(Notebook notebook : notebooks) {
            producers.add(notebook.getProducer());
            diagonals.add(notebook.getDiagonal());
            rams.add(notebook.getRam());
            hdds.add(notebook.getHdd());
            oses.add(notebook.getOs());
            processors.add(notebook.getProcessor());
            colors.add(notebook.getColor());
        }
    }

    public List<String> getProducers() {
        return new ArrayList<>(producers);
    }

    public List<String> getDiagonals() {
        return  new ArrayList<>(diagonals);
    }

    public List<String> getRams() {
        return  new ArrayList<>(rams);
    }

    public List<String> getHdds() {
        return  new ArrayList<>(hdds);
    }

    public List<String> getOses() {
        return  new ArrayList<>(oses);
    }

    public List<String> getProcessors() {
        return  new ArrayList<>(processors);
    }

    public List<String> getColors() {
        return  new ArrayList<>(colors);
    }
}

