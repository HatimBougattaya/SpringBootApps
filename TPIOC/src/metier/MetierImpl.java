package metier;

import dao.Idao;

public class MetierImpl implements Imetier {
	private Idao dao = null;
	@Override
	public double calcul() {
		double d= dao.getValue();
		double res = d*23;
		return res;
	}
	public void setDao(Idao dao) {
		this.dao = dao;
	}

}
