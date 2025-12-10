package repository;

import java.util.ArrayList;
import java.util.List;
import model.Tipo;

public class TipoRepository {

	private List<Tipo> tipos = new ArrayList<>();

	public void salvar(Tipo tipo) {
		tipos.add(tipo);
	}

	public List<Tipo> listar() {
		return tipos;
	}

	public Tipo buscarPorId(int id) {
		for (Tipo tipo : tipos) {
			if (tipo.getId() == id) {
				return tipo;
			}
		}
		return null;
	}

	public void remover(int id) {
		tipos.removeIf(tipo -> tipo.getId() == id);
	}
}
