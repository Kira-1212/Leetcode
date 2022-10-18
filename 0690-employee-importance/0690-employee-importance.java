/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    Map<Integer, Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        for(Employee e: employees){
            map.put(e.id, e);
        }
        return helper(id);
    }
    private int helper(int id){
        int result = map.get(id).importance;
        for(int sub  : map.get(id).subordinates){
            result += helper(sub);
        }
        return result;
    }
}