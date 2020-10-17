package exceptions;

public class ElementNotFoundException extends Exception{
	
	private static final long serialVersionUID = 1L; //necessario a cria��o de um ID �nico para identificar o erro;

	public ElementNotFoundException() {
		super("Elemento n�o encontrado!"); //chama o construtor da classe M�e (conceito de Heran�a em Orienta��o � Objeto)
	}

}
