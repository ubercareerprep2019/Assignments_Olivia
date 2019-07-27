package Part1;

import java.util.*;

/** OrganizationStructure class that has a similar structure to the standard Tree
 *  class provided in this package. This class includes breadth
 *  first search traversal methods.
 *
 * @author olivialee
 * */
public class OrganizationStructure {

    public Employee ceo;

    public static class Employee {
        public String name;
        public String title;
        public List<Employee> directReports;
        public int level = 1;

        Employee(String name, String title, List<Employee> empLst) {
            this.name = name;
            this.title = title;
            directReports = empLst;
        }
    }

    //BFS traversal printing
    void printLevelByLevel() {
        if (ceo == null) {
            return;
        }
        Queue<Employee> tracker = new LinkedList<>();
        tracker.add(ceo);
        int trackLevel = ceo.level;

        while (!tracker.isEmpty()) {
            Employee emp = tracker.poll();
            int currLevel = emp.level;
            List<Employee> reporters = emp.directReports;

            if (reporters != null) {
                for (Employee e : reporters) {
                    e.level = currLevel + 1;
                    tracker.add(e);
                }
            }
            if (trackLevel != currLevel) {
                System.out.println();
                trackLevel = currLevel;
            }
            System.out.println("Name:" + emp.name + ", Title: " + emp.title);
        }
    }

    void printNumLevels() {
        if (ceo == null) {
            return;
        }
        Queue<Employee> tracker = new LinkedList<>();
        tracker.add(ceo);
        int trackLevel = ceo.level;

        while (!tracker.isEmpty()) {
            Employee emp = tracker.poll();
            int currLevel = emp.level;
            List<Employee> reporters = emp.directReports;

            if (reporters != null) {
                for (Employee e : reporters) {
                    e.level = currLevel + 1;
                    tracker.add(e);
                }
            }
            if (trackLevel < currLevel) {
                trackLevel = currLevel;
            }
        }
        System.out.println(trackLevel);
    }

    void initOrganization() {
        Employee k = new Employee("K", "Sales Intern", null);

        List<Employee> jReporters = new ArrayList();
        jReporters.add(k);
        Employee j = new Employee("J", "Sales Representative", jReporters);

        List<Employee> iReporters = new ArrayList();
        iReporters.add(j);
        Employee i = new Employee("I", "Director", iReporters);

        Employee h = new Employee("H", "Engineer", null);
        Employee g = new Employee("G", "Engineer", null);
        Employee f = new Employee("F", "Engineer", null);

        List<Employee> dReporters = new ArrayList();
        dReporters.add(h);
        dReporters.add(g);
        dReporters.add(f);
        Employee e = new Employee("E", "Manager", null);
        Employee d = new Employee("D", "Manager", dReporters);

        List<Employee> cReporters = new ArrayList<>();
        cReporters.add(e);
        cReporters.add(d);
        Employee c = new Employee("C", "CTO", cReporters);

        List<Employee> bReporters = new ArrayList<>();
        bReporters.add(i);
        Employee b = new Employee("B", "CFO", bReporters);

        List<Employee> aReporters = new ArrayList<>();
        aReporters.add(b);
        aReporters.add(c);
        ceo = new Employee("A", "CEO", aReporters);
    }

    public static void main(String[] args) {
        OrganizationStructure company = new OrganizationStructure();
        company.initOrganization();
//        company.printLevelByLevel();

        company.printNumLevels();
    }
}
