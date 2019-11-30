package filipash.calculator;

public class MyExeption extends Exception {
    private String message;

    public MyExeption(String message) {
        this.message = message;
    }

    public String getMessage (){
        return this.message;
    }
}
