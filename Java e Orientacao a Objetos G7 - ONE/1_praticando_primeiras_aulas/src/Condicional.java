public class Condicional {
    public static void main(String[] args) {
        int anoDeLancamento = 1986;
        boolean incluidoNoPlano = false;
        double notaDoFilme = 8.1;
        String tipoPlano = "plus";

        if (anoDeLancamento >= 2022)
            System.out.println("Lançamentos que os clientes estão curtindo!");
        else
            System.out.println("Filme retro que vale a pena assistir!");

        if (incluidoNoPlano && tipoPlano.equals("plus"))
            System.out.println("Filme liberado.");
        else
            System.out.println("Pagar alocação.");
    }
}
