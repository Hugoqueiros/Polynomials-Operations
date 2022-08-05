
package lti_project_3_by_hugo_queiros;

public class Polinomio {
    
        private double coeficiente;
    private int expoente;

    public Polinomio() {
        coeficiente = 0;
        expoente = 0;
    }

    public Polinomio(int coeficiente, int expoente) {
        this.coeficiente = coeficiente;
        this.expoente = expoente;
    }

    public double getCoeficiente() {
        return coeficiente;
    }

    public void setCoeficiente(double coeficiente) {
        this.coeficiente = coeficiente;
    }

    public int getExpoente() {
        return expoente;
    }

    public void setExpoente(int expoente) {
        this.expoente = expoente;
    }

    

    @Override
    public String toString() {
        return "" + coeficiente + expoente;
    }
}
