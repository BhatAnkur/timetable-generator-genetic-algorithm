package scheduler;

import java.util.*;

public class SchedulerMain {

    private List<Chromosome> firstList;
    private List<Chromosome> newList;
    private int populationSize = 250;
    private int maxGenerations = 100;

    private InputData inputData;
    public static Chromosome finalSon;

    public SchedulerMain() {

        inputData = new InputData();
        inputData.takeInput();

        new TimeTable();          // generate slots
        initializePopulation();  // initial population
        createNewGenerations();  // evolve
    }

    // ================= GENETIC ALGORITHM =================

    public void createNewGenerations() {

        int generation = 0;

        while (generation < maxGenerations) {

            newList = new ArrayList<>();

            Collections.sort(firstList);

            // Elitism (top 10%)
            for (int i = 0; i < populationSize / 10; i++) {
                newList.add(firstList.get(i).deepClone());
            }

            while (newList.size() < populationSize) {

                Chromosome parent1 = selectParent();
                Chromosome parent2 = selectParent();

                Chromosome child = crossover(parent1, parent2);
                mutate(child);

                if (child.getFitness() == 1) {
                    finalSon = child;
                    printTimetable(finalSon);
                    return;
                }

                newList.add(child);
            }

            firstList = newList;
            generation++;
        }

        finalSon = firstList.get(0);
        printTimetable(finalSon);
    }

    public Chromosome selectParent() {
        return firstList.get(new Random().nextInt(populationSize / 10)).deepClone();
    }

    public Chromosome crossover(Chromosome a, Chromosome b) {
        int idx = new Random().nextInt(InputData.noStudentGroups);
        Gene temp = a.gene[idx];
        a.gene[idx] = b.gene[idx];
        b.gene[idx] = temp;
        return (a.getFitness() > b.getFitness()) ? a : b;
    }

    public void mutate(Chromosome c) {
        int geneNo = new Random().nextInt(InputData.noStudentGroups);
        c.gene[geneNo] = new Gene(geneNo);
    }

    public void initializePopulation() {
        firstList = new ArrayList<>();
        for (int i = 0; i < populationSize; i++) {
            firstList.add(new Chromosome());
        }
    }

    // ================= USER-FRIENDLY TIMETABLE =================

    public void printTimetable(Chromosome best) {

        String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri"};

        System.out.println("\n============================================================");
        System.out.println("                    INSTITUTE TIMETABLE");
        System.out.println("============================================================");

        for (int g = 0; g < inputData.getStudentGroups().size(); g++) {

            System.out.println("\nBATCH: " + inputData.getStudentGroups().get(g).getName());

            System.out.println("+------+---------+------------------+------------+----------+");
            System.out.println("| Day  | Time    | Subject          | Teacher    | Room     |");
            System.out.println("+------+---------+------------------+------------+----------+");

            for (int d = 0; d < InputData.daysPerWeek; d++) {

                for (int h = 0; h < InputData.hoursPerDay; h++) {

                    int index = d * InputData.hoursPerDay + h;
                    int slotId = best.gene[g].slotNo[index];
                    Slot slot = TimeTable.getSlot(slotId);

                    String day = (h == 0) ? days[d] : "";
                    String time = String.format("%02d:00", 9 + h);

                    if (slot == null) {
                        System.out.printf("| %-4s | %-7s | %-16s | %-10s | %-8s |\n",
                                day, time, "FREE", "-", "-");
                    } else {
                        System.out.printf("| %-4s | %-7s | %-16s | %-10s | %-8s |\n",
                                day,
                                time,
                                slot.getSubject(),
                                slot.getTeacherId(),
                                slot.getClassroom());
                    }
                }

                System.out.println("+------+---------+------------------+------------+----------+");
            }
        }
    }

    public static void main(String[] args) {
        new SchedulerMain();
    }
}
