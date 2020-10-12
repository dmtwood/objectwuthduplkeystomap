import java.security.Key;
import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.Map;


public class test {
    public static void main(String[] args) {
        Set<String> oneLinerSet = Set.of("a", "b", "z");
//        System.out.println(oneLinerSet);

        Employee e1 = new Employee("a", 1);
        Employee e2 = new Employee("b", 2);
        Employee e3 = new Employee("c", 3);
        Employee e4 = new Employee("a", 4);

        List<Employee> employeesList = Arrays.asList(e1, e2, e3, e4);

        Map<String, Integer> map = new LinkedHashMap<>();

        // foutmelding door duplicate keys
        for (Employee employee : employeesList) {
            int freq = map.get(employee);
            map.put(employee.getName(), (freq == 0)? 1 : map.get(employee.getName()) +1 );
        }

        // werkt maar in twee stappen
        for (Employee employee : employeesList) {
            int freq = map.get(employee);
            map.put(employee.getName(), 0);
        }
        for (Employee employee : employeesList) {
            for (String naam : map.keySet()) {
                if (naam.equalsIgnoreCase(employee.getName())) {
                    map.put(naam, map.get(naam) + 1);
                }
            }
        }
        System.out.println(map);
    }}
