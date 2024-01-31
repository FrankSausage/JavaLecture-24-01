package test;

public class testQ1 {

    public static void main(String[] args) {
        int sum = 0;
        for(int i = 1 ; i <= 100; i++){
            if(i % 3 == 0){
                sum += i;
            }
        }
        System.out.printf("1에서 100까지의 3의 배수의 합: %d%n",sum);

        sum = 0;
        for(int i = 1; i <= 20; i+=2) {
            sum += i * i;
        }
        System.out.printf("1에서 20까지 홀수 제곱의 합: %d%n",sum);

        sum = 0;
        for(int i = 2; i <= 100; i++){
            if(isPrime(i)){
                sum += i;
            }
        }
        System.out.printf("2에서부터 100까지 소수의 합: %d%n",sum);

    }
    static Boolean isPrime(int num){
        if(num <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
