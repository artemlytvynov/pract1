public class Main {
    public static void main(String[] args){
        try{
            Employee emp=new Employee("Maxim", "Bebronuh", 1000);
            emp.PrintEmpoyee();
        }catch(FieldLengthLimitException ex){
            System.out.println(ex.getMessage());
        }
        try{
            Employee emp=new Employee("Dyadko", "Vuyko", 500);
            emp.PrintEmpoyee();
        }catch(FieldLengthLimitException ex){
            System.out.println(ex.getMessage());
        }
        try{
            Employee emp=new Employee("Danyl", "Zakarpatskiy", 800);
            emp.PrintEmpoyee();
        }catch(FieldLengthLimitException ex){
            System.out.println(ex.getMessage());
        }
    }
}