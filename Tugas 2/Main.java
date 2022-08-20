public class Main {

    public static void main(String[] args) {
        int batas = 20;
        int tamp;
        for ( int a = 1; a <=batas; a++){
            tamp = 0;
            for(int b = 1; b <= a; b ++){
                if(a%b == 0){
                    tamp++;
                }
            }
            if(tamp == 2){
                System.out.println(a + " adalah bilangan prima");
            }else{
                System.out.println(a + " bukan bilangan prima");
            }
        }
    }
}