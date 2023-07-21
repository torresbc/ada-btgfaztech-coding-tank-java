package org.example;

public class Main {
    public static void main(String[] args) {
        String[][] dadosPessoas = carregarDadosPessoas();

        double[] alturas = identificarValores(1, dadosPessoas);
        double[] pesos = identificarValores(2, dadosPessoas);

        imprimirResultados(dadosPessoas, alturas, pesos);
    }

    /**
     * Carrega a matriz com os valores que serão utilizados ao decorrer do código.
     *
     * @return dadosPessoas Matriz com os valores de nome, altura e peso de cada pessoa.
     */
    public static String[][] carregarDadosPessoas(){
        String[][] dadosPessoas = new String[][]{
                {"Ana", "Paulo", "Márcia", "Pedro", "Beatriz"},
                {"1.70", "1.72", "1.62", "1.90", "1.53"},
                {"80", "90", "61", "84", "49"}
        };
        return dadosPessoas;
    }

    /**
     * Mapeia os valores a serem utilizados de acordo com a linha em que estão localizados.
     *
     * @param linha Inteiro utilizado como referência para identificar onde estão os valores na matriz.
     * @param dadosPessoas Matriz completa.
     * @return Os valores mapeados.
     */
    public static double[] identificarValores(int linha, String[][] dadosPessoas){
        double[] valores = new double[dadosPessoas[linha].length];
        valores = converterValoresNumericos(linha, valores, dadosPessoas);
        return valores;
    }

    /**
     * Converte os valores de String para Double.
     *
     * @param linha Inteiro utilizado como referência para identificar onde estão os valores na matriz.
     * @param valores Array com os valores mapeados.
     * @param dadosPessoas Matriz completa.
     * @return Os valores convertidos.
     */
    public static double[] converterValoresNumericos(int linha, double[] valores, String[][] dadosPessoas){
        for (int i = 0; i < dadosPessoas[1].length; i++) {
            valores[i] = Double.parseDouble(dadosPessoas[linha][i]);
        }
        return valores;
    }

    /**
     * Calcula a média dos valores indicados.
     *
     * @param valores Array com os valores utilizados para o cálculo da média.
     * @return Double com o valor da média final já calculada.
     */
    public static double calcularMedia(double[] valores) {
        double soma = 0;
        for (double valor : valores) {
            soma += valor;
        }
        return soma / valores.length;
    }

    /**
     * Calcula o IMC de acordo com os parâmetros enviados.
     *
     * @param altura Double com o valor da altura.
     * @param peso Double com o valor do peso.
     * @return Double com o valor do IMC final já calculado.
     */
    public static double calcularIMC(double altura, double peso) {
        return (altura * altura) / peso;
    }

    /**
     * Executa o cálculo do IMC para todas as pessoas da Matriz, armazenando cada valor separadamente.
     *
     * @param alturas Array com todos os valores de altura da Matriz principal.
     * @param pesos Array com todos os valores de peso da Matriz principal.
     * @return Array com todos os valores de IMC já calculados.
     */
    public static double[] calcularIMCs(double[] alturas, double[] pesos) {
        double[] imcs = new double[alturas.length];
        for (int i = 0; i < alturas.length; i++) {
            imcs[i] = calcularIMC(alturas[i], pesos[i]);
        }
        return imcs;
    }

    /**
     * Encontra o índice do Array com o maior valor numérico.
     *
     * @param valores Array com todos os valores a serem utilizados na comparação.
     * @return Int com o índice mapeado.
     */
    public static int encontrarIndiceMaiorValor(double[] valores) {
        int indice = 0;
        for (int i = 1; i < valores.length; i++) {
            if (valores[i] > valores[indice]) {
                indice = i;
            }
        }
        return indice;
    }

    /**
     * Encontra o índice do Array com o menor valor numérico
     *
     * @param valores Array com todos os valores a serem utilizados na comparação.
     * @return Int com o índice mapeado.
     */
    public static int encontrarIndiceMenorValor(double[] valores) {
        int indice = 0;
        for (int i = 1; i < valores.length; i++) {
            if (valores[i] < valores[indice]) {
                indice = i;
            }
        }
        return indice;
    }

    /**
     * Imprime todos os resultados solicitados no exercício.
     * Para melhor compreensão do código, cada println será identificado com o enunciado do exercício à qual se refere.
     *
     * @param dadosPessoas Matriz completa.
     * @param alturas Array com todas as alturas.
     * @param pesos Array com todos os pesos.
     */
    public static void imprimirResultados(String[][] dadosPessoas, double[] alturas, double[] pesos){
        // A média aritmética de altura
        System.out.println("A média aritmética de altura: " + calcularMedia(alturas));

        // A média aritmética de peso
        System.out.println("A média aritmética de peso: " + calcularMedia(pesos));

        // O nome e IMC de cada uma das pessoas
        System.out.println("\nO nome e IMC de cada uma das pessoas:");
        for (int i = 0; i < dadosPessoas[0].length; i++) {
            String nome = dadosPessoas[0][i];
            double altura = alturas[i];
            double peso = pesos[i];
            double imc = calcularIMC(altura, peso);
            System.out.println(nome + " = " + imc);
        }

        // O nome da pessoa mais alta e sua altura
        int indicePessoaMaisAlta = encontrarIndiceMaiorValor(alturas);
        String pessoaMaisAlta = dadosPessoas[0][indicePessoaMaisAlta];
        double alturaMaisAlta = alturas[indicePessoaMaisAlta];
        System.out.println("\nO nome da pessoa mais alta: " + pessoaMaisAlta + ", e sua altura: " + alturaMaisAlta);

        // O nome da pessoa mais baixa e sua altura
        int indicePessoaMaisBaixa = encontrarIndiceMenorValor(alturas);
        String pessoaMaisBaixa = dadosPessoas[0][indicePessoaMaisBaixa];
        double alturaMaisBaixa = alturas[indicePessoaMaisBaixa];
        System.out.println("O nome da pessoa mais baixa: " + pessoaMaisBaixa + ", e sua altura: " + alturaMaisBaixa);

        // O nome da pessoa mais pesada e seu peso
        int indicePessoaMaisPesada = encontrarIndiceMaiorValor(pesos);
        String pessoaMaisPesada = dadosPessoas[0][indicePessoaMaisPesada];
        double pesoMaisPesada = pesos[indicePessoaMaisPesada];
        System.out.println("\nO nome da pessoa mais pesada: " + pessoaMaisPesada + ", e seu peso: " + pesoMaisPesada);

        // O nome da pessoa mais leve e seu peso
        int indicePessoaMaisLeve = encontrarIndiceMenorValor(pesos);
        String pessoaMaisLeve = dadosPessoas[0][indicePessoaMaisLeve];
        double pesoMaisLeve = pesos[indicePessoaMaisLeve];
        System.out.println("O nome da pessoa mais leve: " + pessoaMaisLeve + ", e seu peso: " + pesoMaisLeve);

        // O nome da pessoa com o maior IMC e seu valor
        int indicePessoaMaiorIMC = encontrarIndiceMaiorValor(calcularIMCs(alturas, pesos));
        String pessoaMaiorIMC = dadosPessoas[0][indicePessoaMaiorIMC];
        double maiorIMC = calcularIMC(alturas[indicePessoaMaiorIMC], pesos[indicePessoaMaiorIMC]);
        System.out.println("\nO nome da pessoa com o maior IMC: " + pessoaMaiorIMC + ", e seu valor: " + maiorIMC);

        // O nome da pessoa com o menor IMC e seu valor
        int indicePessoaMenorIMC = encontrarIndiceMenorValor(calcularIMCs(alturas, pesos));
        String pessoaMenorIMC = dadosPessoas[0][indicePessoaMenorIMC];
        double menorIMC = calcularIMC(alturas[indicePessoaMenorIMC], pesos[indicePessoaMenorIMC]);
        System.out.println("O nome da pessoa com o menor IMC: " + pessoaMenorIMC + ", e seu valor: " + menorIMC);

        // Padrão para o cálculo de IMC solicitado no enunciado do exercício
        System.out.println("\n\nPara todos os cálculos acima, considerou-se: IMC = (altura * altura) / peso");
    }

}