package lti_project_3_by_hugo_queiros;

public class Node {

    private Polinomio elemento;
    private Node proximo;

    public Node() {
        elemento = null;
        proximo = null;
    }

    public Node(Polinomio elemento, Node proximo) {
        this.elemento = elemento;
        this.proximo = proximo;
    }

    public Polinomio getElemento() {
        return elemento;
    }

    public void setElemento(Polinomio elemento) {
        this.elemento = elemento;
    }

    public Node getProximo() {
        return proximo;
    }

    public void setProximo(Node proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        return "Elemento: " + elemento.getCoeficiente() + "x^" + elemento.getExpoente();
    }
}
