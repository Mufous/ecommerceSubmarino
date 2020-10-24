package exceptions;

public class ElementNotFoundException extends Exception{
	
	private static final long serialVersionUID = 1L; //necessario a criação de um ID único para identificar o erro;

	public ElementNotFoundException() {
		super("Elemento não encontrado!"); //chama o construtor da classe Mãe (conceito de Herança em Orientação à Objeto)
	}

}
