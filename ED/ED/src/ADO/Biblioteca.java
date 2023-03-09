package ADO;

public class Biblioteca {
    private Livro[] livros;
    private int tamanho;

    public Biblioteca(int capacidade) {
        livros = new Livro[capacidade];
        tamanho = 0;
    }

    public void adicionarLivro(Livro livro) {
        if (tamanho == livros.length) {
            Livro[] novaArray = new Livro[livros.length * 2];
            for (int i = 0; i < livros.length; i++) {
                novaArray[i] = livros[i];
            }
            livros = novaArray;
        }
        livros[tamanho] = livro;
        tamanho++;
    }

    public void removerLivro(int id) {
        for (int i = 0; i < tamanho; i++) {
            if (livros[i].getId() == id) {
                for (int j = i; j < tamanho - 1; j++) {
                    livros[j] = livros[j + 1];
                }
                livros[tamanho - 1] = null;
                tamanho--;
                return;
            }
        }
    }

    private void quicksort(Livro[] array, int inicio, int fim) {
        if (inicio < fim) {
            int pivo = particionar(array, inicio, fim);
            quicksort(array, inicio, pivo - 1);
            quicksort(array, pivo + 1, fim);
        }
    }

    private int particionar(Livro[] array, int inicio, int fim) {
        Livro pivo = array[fim];
        int i = inicio - 1;
        for (int j = inicio; j < fim; j++) {
            if (array[j].getId() <= pivo.getId()) {
                i++;
                Livro temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        Livro temp = array[i + 1];
        array[i + 1] = array[fim];
        array[fim] = temp;
        return i + 1;
    }

    public Livro[] buscarLivrosPorTitulo(String titulo) {
        Livro[] resultados = new Livro[tamanho];
        int contador = 0;
        int inicio = 0;
        int fim = tamanho - 1;
        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            if (livros[meio].getTitulo().equals(titulo)) {
                resultados[contador] = livros[meio];
                contador++;
                int esquerda = meio - 1;
                int direita = meio + 1;
                while (esquerda >= 0 && livros[esquerda].getTitulo().equals(titulo)) {
                    resultados[contador] = livros[esquerda];
                    contador++;
                    esquerda--;
                }
                while (direita < tamanho && livros[direita].getTitulo().equals(titulo)) {
                    resultados[contador] = livros[direita];
                    contador++;
                    direita++;
                }
                break;
            } else if (livros[meio].getTitulo().compareTo(titulo) < 0) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        Livro[] resultadoFinal = new Livro[contador];
        for (int i = 0; i < contador; i++) {
            resultadoFinal[i] = resultados[i];
        }
        return resultadoFinal;
    }
}

