package comm.framework;

public class Trial {
    public static void main (String []args){
        String input = "52,500.00";
        input = input.replace(",","");
        int x = input.indexOf(".");
        input = input.substring(0,x);
       int integer = Integer.parseInt(input);
        System.out.println(integer);
    }
}
