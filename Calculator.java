package filipash.calculator;

import javax.swing.*;

public class Calculator {
    public static void main(String[] args){
        int summ;
        String summRim="";

        String expression = JOptionPane.showInputDialog(null,"Введите выражение для калькулятора");
        MatchSymbol Calc = new MatchSymbol(expression);
        try {
            Calc.find();
            if (Calc.isArabic()){
                summ = Calc.getCalc();
                JOptionPane.showMessageDialog(null, "Выражение: "+Calc.getA()+" "+ Calc.getSymbol()+" "+Calc.getB()+" равно: "+ summ);
            }
            else {
                Calc.SetA(Calc.findRim(Calc.getMatchA()));
                Calc.SetB(Calc.findRim(Calc.getMatchB()));
                summ = Calc.getCalc();
                if (summ < 11) {
                    summRim = Calc.findRim(summ);
                }
                else
                    {
                    while (summ>10){
                        summRim += "X";
                        summ -= 10;
                    }
                    summRim += Calc.findRim(summ);
                }
                JOptionPane.showMessageDialog(null, "Выражение: "+Calc.getMatchA()+" "+ Calc.getSymbol()+" "+Calc.getMatchB()+" равно: "+ summRim);
            }
        }
        catch (MyExeption ex){
            System.out.println(ex.getMessage());
        }

    }



}
