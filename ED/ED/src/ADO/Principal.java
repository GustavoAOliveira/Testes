package ADO;
import javax.swing.JOptionPane;
public class Principal {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca(10);
        boolean executando = true;
        while (executando) {
            int escolha = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção:\n"
                    + "1. Adicionar livro\n"
                    + "2. Remover livro\n"
                    + "3. Buscar livros por título\n"
                    + "4. Sair"));
            switch (escolha) {
                case 1:
                    String autor = JOptionPane.showInputDialog("Digite o autor do livro:");
                    String titulo = JOptionPane.showInputDialog("Digite o título do livro:");
                    double preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do livro:"));
                    Livro novoLivro = new Livro(autor, titulo, preco);
                    biblioteca.adicionarLivro(novoLivro);
                    JOptionPane.showMessageDialog(null, "Livro adicionado com sucesso.");
                    break;
                case 2:
                    int idRemover = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do livro a ser removido:"));
                    biblioteca.removerLivro(idRemover);
                    JOptionPane.showMessageDialog(null, "Livro removido com sucesso.");
                    break;
                case 3:
                    String tituloBusca = JOptionPane.showInputDialog("Digite o título do livro a ser buscado:");
                    Livro[] resultadosBusca = biblioteca.buscarLivrosPorTitulo(tituloBusca);
                    if (resultadosBusca.length == 0) {
                        JOptionPane.showMessageDialog(null, "Nenhum livro encontrado com esse título.");
                    } else {
                        String mensagem = "Livros encontrados com o título \"" + tituloBusca + "\":\n";
                        for (Livro livro : resultadosBusca) {
                            mensagem += livro + "\n";
                        }
                        JOptionPane.showMessageDialog(null, mensagem);
                    }
                    break;
                case 4:
                    executando = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
                    break;
            }
        }
    }
}
