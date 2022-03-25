import java.util.Random;

class Frase {

	private String linha;
	private String [] palavras;
	
	
	Frase(String linha){
		this.linha = linha;
	}


	public String getLinha() {
		return linha;
	}
	
	public void setLinha(String linha) {
		this.linha = linha;
	}
	
	
	public String [] listaPalavras(){
		
		palavras = new String[getLinha().split(" ").length];
		
		for(int i =0; i < palavras.length; i++) {
			palavras[i] = getLinha().split(" ")[i];
		}
		
        return palavras;
    }


	public String adicionaFrase(String linha) {
		setLinha(getLinha() + " " + linha);
		return getLinha();
	}


	public Frase adicionaFrase(Frase fr) {
		setLinha(getLinha() + fr.getLinha());
		return this;
	}

	
	public String toString() {
		return getLinha();
	}
		
}




class Texto extends Frase {

	private Frase [] frases;
	private int tamMaxFrases;
	private int qtdFrases;
	private String palProcurada;
	private String palSubstituta;
	private double palavrasPorMin = 200;
	
	

	Texto(String linha) {
		super(linha);
		tamMaxFrases = 1000;
		qtdFrases = 0;
		frases = new Frase[tamMaxFrases];
	}
	
	
	public void substitui(String palProcurada, String palSubstituta) {

		String novaLinha = "";
		for(String s: super.listaPalavras()) {
			if(s.contains(palProcurada)) {
				s = s.replaceAll("\\b" + palProcurada + "\\b", palSubstituta);
			}
			novaLinha += s + " ";	
		}
		super.setLinha(novaLinha);
	}
	
	
	public int getQuantidadePalavras() {
		return super.listaPalavras().length;
	}
	
	public int getTempoEstimadoLeitura() {
		int result = (int) Math.ceil(getQuantidadePalavras() / palavrasPorMin);
		return result;
	}
	
	
	public Frase [] separaFrases(){
		if(qtdFrases < tamMaxFrases) {
			for(int i=0; i < super.getLinha().split("\\.").length; i++) {
				frases[qtdFrases] = new Frase(super.getLinha().split("\\.")[i]);
				qtdFrases++;
			}
				
		}
		
		return frases;
	}
	
	
	public String getFrasesCom(String palProcurada) {
		String novaLinha = "";
		for(Frase fr: separaFrases()) {
			if(fr != null) {
				if(fr.toString().contains(palProcurada)){
					novaLinha += fr + ".";
				}
			}
		}
		return novaLinha;
	}
	
	
	public String getFraseAleatoria() {
		String fraseAleatoria = "";
		int numAleatorio = new Random().nextInt(qtdFrases); 
		fraseAleatoria += separaFrases()[numAleatorio] + ".";
		
		return fraseAleatoria;
	}
	

	public String toString() {
		return "\n" + super.getLinha();
	}

}
	

public class AD1_POO_2022_1 {

	public static void main(String[] args) {
		
		Texto teste = new Texto("Diz a sabedoria popular que um homem só tem uma vida completa quando planta uma árvore, escreve um livro e tem um filho. Ao meu ver, não se diz isso pensando de forma literal, mas sim na importância abstrata destes feitos. Ao plantar uma árvore, demonstramos preocupação com o ambiente onde vivemos. Ao ter um filho, amamos ao próximo incondicionalmente. Ao escrever um livro, desejamos compartilhar e \"eternizar\" o conhecimento adquirido.");
		

		teste.substitui("popular", "do povo");
		teste.adicionaFrase(new Frase("Claramente conseguimos realizar estes feitos abstratos de diferentes maneiras.")).adicionaFrase("O importante é ter consciência da importância destes.");	
		System.out.println("Qtd: " + teste.getQuantidadePalavras());
		System.out.println("Tempo: " + teste.getTempoEstimadoLeitura() + " minuto(s)");
		System.out.println("Texto recuperado: " + teste);
		System.out.println("Frases com:\n" + teste.getFrasesCom("livro"));
		System.out.println("Aleatória:\n" + teste.getFraseAleatoria());
				
				
	}
}