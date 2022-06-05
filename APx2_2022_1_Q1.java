import java.util.ArrayList;
import java.util.List;



class Tipo {
	private String titulo;
	private Tema tema;
	private List <Artista> artistas;
	
	Tipo(String titulo, Tema tema){
		this.titulo = titulo;
		this.tema = tema;
		artistas = new ArrayList<Artista>();
	}

	public String getTitulo() {
		return titulo;
	}

	public Tema getTema() {
		return tema;
	}

	public List<Artista> getArtistas() {
		return artistas;
	}
	
	public void adicionaArtista(Artista artista) {
		getArtistas().add(artista);
	}
}


class Filme extends Tipo {
	
	Filme(String titulo, Tema tema) {
		super(titulo,tema);
	}
	
	public String toString() {
		return super.getTitulo() + super.getTema() + "\n";
	}
	
}


class Tema {
	String genero;
	
	Tema(String genero){
		this.genero = genero;
	}
	
	public String toString() {
		return this.genero;
	}
	
}



class Serie extends Tipo{

	private int temporada;
	private int numEpisodio;
	private String tituloEpisodio;
	
	
	public Serie(String titulo, Tema tema, int temporada, int numEpisodio, String tituloEpisodio) {
		super(titulo,tema);
		this.temporada = temporada;
		this.numEpisodio = numEpisodio;
		this.tituloEpisodio = tituloEpisodio;

	}


	public String toString() {
		return super.getTitulo() + super.getTema() + "\n";
	}

	
}


class Artista {
	
	String interprete;
	
	Artista(String interprete){
		this.interprete = interprete;
	}
	
	public String getInterprete() {
		return interprete;
	}


	public String toString() {
		return this.interprete;
	}
}



class Catalogo {

	List <Filme> filmes;
	List <Serie> series;
	
	
	Catalogo(){
		 filmes = new ArrayList<Filme>();
		 series = new ArrayList<Serie>();
	}
	
	
	public Catalogo adiciona(Filme filme) {
		filmes.add(filme);
		return this;
	}
	
	public Catalogo adiciona(Serie serie) {
		series.add(serie);
		return this;
	}
	
	
	public Catalogo filtra( String n ) {
		
		Catalogo catalogoTemp = new Catalogo();
		
		for(Filme f: filmes) {
			if( f.getArtistas().toString().indexOf(n) > -1 ) {
				catalogoTemp.adiciona(f);
			}	
			if( f.getTema().toString().indexOf(n) > -1 ) {
				catalogoTemp.adiciona(f);
			}
		}
		
		for(Serie s: series) {
			if( s.getArtistas().toString().indexOf(n) > -1 ) {
				catalogoTemp.adiciona(s);
			}	
			if( s.getTema().toString().indexOf(n) > -1 ) {
				catalogoTemp.adiciona(s);
			}	
		}
		
		return catalogoTemp;
	}


	public Catalogo uniao(Catalogo outroCatalogo) {
		Catalogo catalogoAuxiliar = new Catalogo();
		
		for(Filme f: this.filmes) {	
			catalogoAuxiliar.adiciona(f);
		}
		for(Filme catFilme: outroCatalogo.filmes) {	
			catalogoAuxiliar.adiciona(catFilme);
		}
		
		for(Serie s: this.series) {	
			catalogoAuxiliar.adiciona(s);
		}
		for(Serie catSerie: outroCatalogo.series) {	
			catalogoAuxiliar.adiciona(catSerie);
		}
		
		return catalogoAuxiliar;
	}


	public String toString() {
		String resp = "";
		for(Filme f: filmes) {
			resp += "Titulo: " +  f.getTitulo() + ", Tema: " + f.getTema() + "\n";
		}
		for(Serie s: series) {
			resp += "Titulo: " + s.getTitulo() + ", Tema: " + s.getTema() + "\n";
		}
		return resp;
	}
	
}





public class APx2_2022_1_Q1 {

	public static void main(String[] args) {
		
		Filme mp = new Filme("Medida Provisoria", new Tema("Ficcao"));
		Filme cd = new Filme("Cidade de Deus", new Tema("Drama"));
		Filme ac = new Filme("Auto da Compadecida", new Tema("Aventura"));
		Serie ir = new Serie("Irmandade", new Tema("Drama"), 1, 1, "O Certo e o Certo");
		Artista tais = new Artista("Tais Araujo");
		Artista jorge = new Artista("Seu Jorge");
		Artista selton = new Artista("Selton Mello");
		mp.adicionaArtista(tais);
		mp.adicionaArtista(jorge);
		ac.adicionaArtista(selton);
		cd.adicionaArtista(jorge);
		ir.adicionaArtista(jorge);
		Catalogo catalogo = new Catalogo();
		catalogo.adiciona(mp).adiciona(cd).adiciona(ac).adiciona(ir);
		System.out.println("Catalogo completo:");
		System.out.println(catalogo);
		System.out.println("Filmes e Series com Seu Jorge:");
		System.out.println(catalogo.filtra("Jorge"));
		System.out.println("Dramas:");
		System.out.println(catalogo.filtra("Drama"));
		System.out.println("Filmes e Series com Tais Araujo e Selton Mello juntos:");
		System.out.println(catalogo.filtra("Tais").filtra("Mello"));
		System.out.println("Filmes e Series com Tais Araujo unidos com os do Selton Mello:");
		System.out.println(catalogo.filtra("Tais").uniao(catalogo.filtra("Mello")));

	}

}
