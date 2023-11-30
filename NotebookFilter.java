
import java.util.*;

public class NotebookFilter {
    Map<String, List<String>> presets = new HashMap<>();
    List<Notebook> notebooks;
    Scanner scanner = new Scanner(System.in);

    public void set(List<Notebook> notebooks) {
        this.notebooks = notebooks;
        NotebookFilterOptions notebookFilterOptions = new NotebookFilterOptions();
        notebookFilterOptions.add(notebooks);

        int menu = -1;
        while (menu != 0) {
            System.out.println("Ввыберите параметр 1-7 для задания фильтра и далее выберите 0 для применения фильтра к поиску.");
            System.out.println("Или выберите 0 для вывода всех ноутбуков.");
            System.out.println("1. Производители");
            System.out.println("2. Диагональ экрана");
            System.out.println("3. ОЗУ");
            System.out.println("4. Объем накопителя");
            System.out.println("5. Операционная система");
            System.out.println("6. Процессор");
            System.out.println("7. Цвет");
            System.out.println("0. Поиск по заданному фильтру");

            menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    System.out.println("Введите через запятую номера производителей:");
                    presets.put("producers", getOptions(presets.get("producers"), notebookFilterOptions.getProducers()));
                    break;
                case 2:
                    System.out.println("Введите через запятую номера размеров диагоналей:");
                    presets.put("diagonals", getOptions(presets.get("diagonals"), notebookFilterOptions.getDiagonals()));
                    break;
                case 3:
                    System.out.println("Введите через запятую номера объемов ОЗУ:");
                    presets.put("rams", getOptions(presets.get("rams"), notebookFilterOptions.getRams()));
                    break;
                case 4:
                    System.out.println("Введите через запятую номера оъемов накопителей:");
                    presets.put("hdds", getOptions(presets.get("hdds"), notebookFilterOptions.getHdds()));
                    break;
                case 5:
                    System.out.println("Введите через запятую номера операционных систем:");
                    presets.put("oses", getOptions(presets.get("oses"), notebookFilterOptions.getOses()));
                    break;
                case 6:
                    System.out.println("Введите через запятую номера процессоров:");
                    presets.put("processors", getOptions(presets.get("processors"), notebookFilterOptions.getProcessors()));
                    break;
                case 7:
                    System.out.println("Введите через запятую номера цветов:");
                    presets.put("colors", getOptions(presets.get("colors"), notebookFilterOptions.getColors()));
                    break;
            }
        }
        scanner.close();
    }

    private List<String> getOptions(List<String> presetsOptions, List<String> allOptions) {
        List<String> resultOptions = presetsOptions == null ? new ArrayList<>() : new ArrayList<>(presetsOptions);
        boolean exit = false;
        while (!exit) {
            System.out.println("0. Выход из фильтра");
            for (int i = 0; i < allOptions.size(); i++) {
                System.out.println(i + 1 + ". " + allOptions.get(i));
            }
            if (!resultOptions.isEmpty()) {
                System.out.print ("\nВыбранные значение: ");
            }
            for (int i = 0; i < resultOptions.size(); i++) {
                System.out.print(resultOptions.get(i) + "; ");
            }
            System.out.println();

            String[] stringValues = scanner.next().split(",");
            int[] values = new int[stringValues.length];
            for (int i = 0; i < stringValues.length; i++) {
                values[i] = Integer.parseInt(stringValues[i]);
                if (values[i] == 0) {
                    exit = true;
                } else {
                    if (values[i] <=allOptions.size()) {
                        if (resultOptions.contains(allOptions.get(values[i] - 1))) {
                            resultOptions.remove(allOptions.get(values[i] - 1));
                        } else {
                            resultOptions.add(allOptions.get(values[i] - 1));
                        }
                    }
                }
            }
        }
        return resultOptions;
    }

    public List<Notebook> getFilteredResult() {
        List<Notebook> filteredNotebooks = new ArrayList<>(notebooks);
        for(String preset : presets.keySet()) {
            filteredNotebooks.retainAll(filterNotebooks(preset, presets.get(preset)));
        }
        return filteredNotebooks;
    }

    private List<Notebook> filterNotebooks(String preset, List<String> presetOptions) {
        List<Notebook> foundNotebooks = new ArrayList<>();
        for (Notebook notebook : notebooks) {
            switch (preset) {
                case "producers":
                    for (String option : presetOptions) {
                        if (notebook.getProducer().contains(option)) {
                            foundNotebooks.add(notebook);
                        }
                    }
                    break;
                case "diagonals":
                    for (String option : presetOptions) {
                        if (notebook.getDiagonal().contains(option)) {
                            foundNotebooks.add(notebook);
                        }
                    }
                    break;
                case "rams":
                    for (String option : presetOptions) {
                        if (notebook.getRam().contains(option)) {
                            foundNotebooks.add(notebook);
                        }
                    }
                    break;
                case "hdds":
                    for (String option : presetOptions) {
                        if (notebook.getHdd().contains(option)) {
                            foundNotebooks.add(notebook);
                        }
                    }
                    break;
                case "oses":
                    for (String option : presetOptions) {
                        if (notebook.getOs().contains(option)) {
                            foundNotebooks.add(notebook);
                        }
                    }
                    break;
                case "processors":
                    for (String option : presetOptions) {
                        if (notebook.getProcessor().contains(option)) {
                            foundNotebooks.add(notebook);
                        }
                    }
                    break;
                case "colors":
                    for (String option : presetOptions) {
                        if (notebook.getColor().contains(option)) {
                            foundNotebooks.add(notebook);
                        }
                    }
                    break;
            }
        }
        return foundNotebooks;
    }
}

