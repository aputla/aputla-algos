package std.math.traverse_nsteps;

public class Main {                                                                                                                     
    private static int F(int n) {                                                                                                       
        return (int) Math.pow(2, n - 1);                                                                                                
    }                                                                                                                                   
                                                                                                                                        
    public static void main(String[] args) {                                                                                            
        System.out.println(F(4));                                                                                                       
    }                                                                                                                                   
}                                                                                                                                       
