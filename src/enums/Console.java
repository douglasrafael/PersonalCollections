package enums;

/**
 * Representa os tipos de consoles de vídeo game
 * 
 * @author Douglas Rafael
 *
 */
public enum Console {
	PS("PlayStation"), PS2("PlayStation 2"), PS3("PlayStation 3"), PS4("PlayStation 4"), PLAYSTATIONVITA("PlayStation Vita"),
	NINTENDO64("Nintendo 64"), NINTENDODS("Nintendo DS"), NINTENDO3DS("Nintendo 3DS"), NINTENDOWII("Nintendo Wii"),
	XBOX360("Xbox 360"), XBOXONE("Xbox One"), PC("Computador"), OUTRO("Outro");
	
	private String nome;
	
	/**
	 * Método Construtor
	 * 
	 * @param nome
	 */
	Console(String nome) {
		this.nome = nome;
	}

	/**
	 * Recupera o nome do console.
	 * 
	 * @return O nome do console
	 */
	public String getNome() {
		return nome;
	}
}
