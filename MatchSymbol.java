package filipash.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchSymbol {
    final public String regex = "^([0-9]+|[VIX]+)([\\+\\-\\/\\*])([0-9]+|[VIX]+)";
    private String match;
    private String matchA;
    private String matchB;
    private String symbol;
    private int a,b;
    private boolean isArabicA, isArabicB, isArabicMain;


    public MatchSymbol(String match){
        this.match = match;
    }

    public boolean find() throws MyExeption {
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(this.match);
        if (matcher.find()) {
            this.matchA = matcher.group(1);
            this.matchB = matcher.group(3);
            this.symbol = matcher.group(2);
            return true;
        }
        else {
            throw new MyExeption("Символы должны быть Арабскими либо Римскими от 1 до 10");
        }

    }
    public boolean isArabic() throws MyExeption {
            if (isNumeric(this.matchA)) {
                this.isArabicA=true;
            }
            if (isNumeric(this.matchB)) {
                this.isArabicB=true;
            }
            if (this.isArabicA & this.isArabicB) {
                // решаем арабскими
                System.out.println("Решаем арабскими");
                this.isArabicMain = true;
                //получаем числа
                this.a = Integer.parseInt(this.matchA);
                this.b = Integer.parseInt(this.matchB);
                if ((this.a <1) || (this.a>10) || (this.b<1) || (this.b>10)){
                    throw new MyExeption("Число должно быть в диапазоне от 1 до 10");
                }

            }
            else if ((!isArabicA) & (!isArabicB)) {
                //Решаем римскими
                isArabicMain = false;
                System.out.println("Решаем римскими");

            }
            else {
                throw new MyExeption("Уравнение должно быть либо в арабских либо в римских");
            }

        return this.isArabicMain;

    }

    public static boolean isNumeric(String str)
    {
        try
        {
            int d = Integer.parseInt(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

    public int findRim (String rim) throws MyExeption {
        int arabic;
        switch (rim){
            case "I":
                arabic=1;
                break;
            case "II":
                arabic=2;
                break;
            case "III":
                arabic=3;
                break;
            case "IV":
                arabic=4;
                break;
            case "V":
                arabic=5;
                break;
            case "VI":
                arabic=6;
                break;
            case "VII":
                arabic=7;
                break;
            case "VIII":
            case "IIX":
                arabic=8;
                break;
            case "IX":
                arabic=9;
                break;
            case "X":
                arabic=10;
                break;
            default:
                throw new MyExeption("Число должно находиться в пределах от 1 до 10");
        }

        return arabic;
    }

    public String findRim (int arabic) throws MyExeption {
        String rim;
        switch (arabic) {
            case 1:
                rim = "I";
                break;
            case 2:
                rim = "II";
                break;
            case 3:
                rim = "III";
                break;
            case 4:
                rim = "IV";
                break;
            case 5:
                rim = "V";
                break;
            case 6:
                rim = "VI";
                break;
            case 7:
                rim = "VII";
                break;
            case 8:
                rim = "IIX";
                break;
            case 9:
                rim = "IX";
                break;
            case 10:
                rim = "X";
                break;
            default:
                throw new MyExeption("ноль или ниже нуля");
        }
        return rim;
    }

    public int getCalc() throws MyExeption {
        int a = this.a;
        int b = this.b;
        String symbol = this.symbol;
        int result;
        switch(symbol){
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "/":
                result = a / b;
                break;
            case "*":
                result = a * b;
                break;
            default:
                throw new MyExeption("Возможны только следующие действия: сложение, вычитание, деление, умножение");
        }
        return result;
    }


    public int getA(){
        return this.a;
    }
    public int getB(){
        return this.b;
    }

    public String getMatchA(){
        return this.matchA;
    }
    public String getMatchB(){
        return this.matchB;
    }

    public void SetA (int A){
        this.a=A;
    }

    public void SetB (int B){
        this.b=B;
    }
    public String getSymbol (){
        return this.symbol;
    }
}
