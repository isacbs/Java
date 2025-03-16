package Projeto;

import java.util.Scanner;

/**
 * Desenvolvedoras:
 *
 *
 * @author Isadora Caetano Brandão de Sousa @ra 10420646
 *
 * @author Luana Fernandes @ra 10439810
 *
 *
 **/

public class Aplicacao {
	private static Cliente[] clientes = new Cliente[10];
	private static int qtdClientes = 0;

	/**
	 * Método principal da aplicação, que exibe o menu e gerencia a interação com o
	 * cliente.
	 * 
	 */
	public static void main(String[] args) {
		Scanner ent = new Scanner(System.in);
		int opcao;

		do {
			System.out.println("\nBem vindo á Nous-allez, somos uma empresa de locação de bicicletas"
					+ " elétricas! \nPara começar seu atendimento, escolha uma das opções do menu abaixo");
			System.out.println("1. Cadastrar novo cliente");
			System.out.println("2. Locar bicicleta");
			System.out.println("3. Devolver bicicleta");
			System.out.println("4. Remover cliente");
			System.out.println("5. Exibir dados do cliente");
			System.out.println("6. Listar clientes em ordem decrescente de gastos");
			System.out.println("7. Exibir cliente mais rentável");
			System.out.println("8. Encerrar");
			System.out.print("Escolha uma opção: ");

			try {
				opcao = ent.nextInt();
				ent.nextLine();

				switch (opcao) {
				case 1:
					if (qtdClientes >= 10) {
						System.out.println("Limite de clientes atingido.");
						break;
					}
					String nome;
					boolean nomeValido = false;
					do {
						System.out.print("Nome: ");
						nome = ent.nextLine();
						try {
							validarNome(nome);
							nomeValido = true;
						} catch (IllegalArgumentException e) {
							System.out.println(e.getMessage());
							nomeValido = false;
						}
					} while (!nomeValido);

					String cpf;
					do {
						System.out.print("CPF(Digite apenas os números): ");
						cpf = ent.nextLine();
						try {
							validarCPF(cpf);
							break;
						} catch (IllegalArgumentException e) {
							System.out.println(e.getMessage());
						}
					} while (true);

					cadastrar(new Cliente(nome, cpf));
					break;

				case 2:
					System.out.print("CPF(Digite apenas os números): ");
					if (!locar(ent.nextLine())) {
						System.out.println(
								"Locação não permitida. O cpf não foi cadastrado ou não existe ou você digitou apenas letras invés de números.");
					} else {
						System.out.println("Bicicleta locada com sucesso.");
					}
					break;

				case 3:
					System.out.print("CPF(Digite apenas os números): ");
					if (!devolver(ent.nextLine())) {
						System.out.println(
								"Devolução não permitida, O cpf não foi cadastrado, já está com uma bicicleta locada ou você digitou apenas letras invés de números ");
					} else {
						System.out.println("Bicicleta devolvida com sucesso.");
					}
					break;

				case 4:
					System.out.print("CPF(Digite apenas os números): ");
					if (remover(ent.nextLine()) == 1) {
						System.out.println("Cliente removido com sucesso.");
					} else {
						System.out.println("Cliente não encontrado.");
					}
					break;

				case 5:
					System.out.print("CPF(Digite apenas os números): ");
					exibirCliente(ent.nextLine());
					break;

				case 6:
					listarClientes();
					break;

				case 7:
					Cliente rentavel = clienteMaisRentavel();
					if (rentavel != null) {
						System.out.println("Cliente mais rentável:\n" + rentavel);
					} else {
						System.out.println("Nenhum cliente está cadastrado.");
					}
					break;

				case 8:
					System.out.println("Integrantes:" + "\nIsadora Caetano Brandão de Sousa - 10420646"
							+ "\nLuana Fernandes - 10439810" + "\nVídeo de apresentação: Link" + "\nFechando...");
					break;
				default:
					System.out.println("Opção inválida.");
				}
			} catch (Exception e) {
				System.out.println("Erro!!! \nDigite apenas números.");
				ent.nextLine();
				opcao = -1;
			}
		} while (opcao != 8);

		ent.close();
	}

	/**
	 * Valida o nome do cliente, garantindo que não seja nulo e que tenha ao menos
	 * dois caracteres.
	 *
	 * @param nome Nome do cliente;
	 * @throws IllegalArgumentException Se o nome for inválido.
	 */
	public static void validarNome(String nome) {
		if (nome == null) {
			throw new IllegalArgumentException("O nome não pode ser nulo.");
		}

		nome = nome.trim();

		if (nome.length() < 2) {
			throw new IllegalArgumentException("O nome deve conter pelo menos dois caracteres.");
		}

		for (int i = 0; i < nome.length(); i++) {
			char c = nome.charAt(i);
			if ((c < 'A' || (c > 'Z' && c < 'a') || c > 'z') && c != ' ') {
				throw new IllegalArgumentException("Nome inválido! O nome deve conter apenas letras e " + "espaços.");
			}
		}
	}

	/**
	 * Valida o CPF do cliente, garantindo que seja composto apenas por números e
	 * tenha exatamente 11 dígitos.
	 *
	 * @param cpf CPF do cliente.
	 * @throws IllegalArgumentException Se o CPF for inválido.
	 */
	public static void validarCPF(String cpf) {
		if (cpf == null) {
			throw new IllegalArgumentException("O CPF não pode ser nulo.");
		}

		cpf = cpf.trim();

		if (cpf.length() != 11) {
			throw new IllegalArgumentException("CPF inválido! O CPF deve conter exatamente " + "11 dígitos numéricos.");
		}

		for (int i = 0; i < cpf.length(); i++) {
			char c = cpf.charAt(i);
			if (c < '0' || c > '9') {
				throw new IllegalArgumentException(
						"CPF inválido! Todos os caracteres devem " + "ser dígitos numéricos.");
			}
		}
	}

	/**
	 * Cadastra um novo cliente na lista de clientes.
	 *
	 * @param c Cliente a ser cadastrado.
	 */
	public static void cadastrar(Cliente c) {
		clientes[qtdClientes++] = c;
		System.out.println("Cliente cadastrado com sucesso.");
	}

	/**
	 * Realiza a locação de uma bicicleta, se o cliente estiver cadastrado e não
	 * tiver uma bicicleta alugada.
	 *
	 * @param cpf CPF do cliente.
	 * @return true se a locação for executada, false caso não seja possível a
	 *         locação.
	 */
	public static boolean locar(String cpf) {
		for (int i = 0; i < qtdClientes; i++) {
			if (clientes[i].getCpf().equals(cpf)) {
				if (clientes[i].isBicicletaAlugada()) {
					return false;
				}
				clientes[i].locarBicicleta();
				return true;
			}
		}
		return false;
	}

	/**
	 * Realiza a devolução de uma bicicleta, se o cliente estiver cadastrado e tiver
	 * uma bicicleta alugada.
	 *
	 * @param cpf CPF do cliente.
	 * @return true se a devolução for bem-sucedida, false caso não encontre o
	 *         cliente nos dados.
	 */
	public static boolean devolver(String cpf) {
		for (int i = 0; i < qtdClientes; i++) {
			if (clientes[i].getCpf().equals(cpf)) {
				if (!clientes[i].isBicicletaAlugada()) {
					return false;
				}
				clientes[i].devolverBicicleta();
				return true;
			}
		}
		return false;
	}

	/**
	 * Remove um cliente da lista com base no CPF.
	 *
	 * @param cpf CPF do cliente a ser removido.
	 * @return 1 se o cliente foi removido, 0 se ele não foi encontrado.
	 */
	public static int remover(String cpf) {
		for (int i = 0; i < qtdClientes; i++) {
			if (clientes[i].getCpf().equals(cpf)) {
				for (int j = i; j < qtdClientes - 1; j++) {
					clientes[j] = clientes[j + 1];
				}
				clientes[--qtdClientes] = null;
				return 1;
			}
		}
		return 0;
	}

	/**
	 * Exibe os dados de um cliente com base no CPF.
	 *
	 * @param cpf CPF do cliente.
	 */
	public static void exibirCliente(String cpf) {
		for (Cliente cliente : clientes) {
			if (cliente != null && cliente.getCpf().equals(cpf)) {
				System.out.println(cliente);
				return;
			}
		}
		System.out.println("Cliente não encontrado.");
	}

	/**
	 * Lista todos os clientes ordenados pelo total gasto em ordem decrescente.
	 * 
	 */
	public static void listarClientes() {
		ordenarClientesPorGasto();
		for (int i = 0; i < qtdClientes; i++) {
			System.out.println(clientes[i]);
		}
	}

	/**
	 * Retorna o cliente mais rentável, o que mais gastou dinheiro.
	 *
	 * @return Cliente mais rentável.
	 */
	public static Cliente clienteMaisRentavel() {
		if (qtdClientes == 0)
			return null;
		Cliente r = clientes[0];
		for (int i = 1; i < qtdClientes; i++) {
			if (clientes[i].getTotalGasto() > r.getTotalGasto()) {
				r = clientes[i];
			}
		}
		return r;
	}

	/**
	 * Ordena os clientes por total gasto em ordem decrescente, usando o método de
	 * ordenação Bubble Sort.
	 * 
	 */
	private static void ordenarClientesPorGasto() {
		for (int i = 0; i < qtdClientes - 1; i++) {
			for (int j = 0; j < qtdClientes - 1 - i; j++) {
				if (clientes[j].getTotalGasto() < clientes[j + 1].getTotalGasto()) {
					Cliente t = clientes[j];
					clientes[j] = clientes[j + 1];
					clientes[j + 1] = t;
				}
			}
		}
	}
}
