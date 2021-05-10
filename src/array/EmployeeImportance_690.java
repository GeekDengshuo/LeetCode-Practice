package src.array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author deng shuo
 * @Date 5/2/21 10:17
 * @Version 1.0
 */
public class EmployeeImportance_690 {

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };

    public int getImportance(List<Employee> employees, int id) {

        //recursive
        int curImportance =0;
        if(employees.get(id) == null) return 0;
        for( Employee employee: employees){
            if(employee.id == id){
                curImportance = employee.importance;

                for(int subordinate: employee.subordinates){
                    curImportance += getImportance(employees,subordinate);
                }
            }
        }
        return curImportance;

    }

    Map<Integer,Employee> map = new HashMap<>();
    private int getImportance2(List<Employee> employees,int id){
        // dfs
        for(Employee employee:employees){
            map.put(employee.id,employee);
        }
        return dfs(id);

    }
    private int dfs(int id){

        int resImportance = map.get(id).importance;
        for(int subId:map.get(id).subordinates){
            resImportance += dfs(subId);
        }
        return resImportance;

    }

    public static void main(String[] args) {

    }
}
