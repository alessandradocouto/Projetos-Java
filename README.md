![wallpaper Java](images/wallpaper-java.png)

# Projetos Java com Programação Orientada a Objeto
Repositório com a finalidade de salvar trabalhos da faculdade e facilitar estudos posteriores.

## Projeto 1 - Modificar Texto

Nesse projeto vamos substituir palavras, adicionar Frases, analisar tempo de leitura do texto e mais.

Foi usado nesse projeto:

- this;
- adicionar itens no array;
- método de String como contains e replaceAll;
- método Math.ceil();
- método toString();

Aqui usamos o Math.ceil, para arredondar um número pra cima, e acharmos o tempo de leitura que é a divisão da quantidade de palavras do texto pela quantidade de palavras por min dada.

    public int getTempoEstimadoLeitura() {
		int result = (int) Math.ceil(getQuantidadePalavras() / palavrasPorMin);
		return result;
	}

Método que adiciona novas Frases no texto, usei o método 'get' para pegar o valor do atributo e 'set' para alterá-lo.

    public String adicionaFrase(String linha) {
		setLinha(getLinha() + " " + linha);
		return getLinha();
	}

Método que procura a palavra passada como parâmetro na frase e retorna as frases que contêm a palavra procurada.

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




### Obrigada pela visita