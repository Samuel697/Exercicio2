
public class Casa{
	private int objectos;
	private String camas;
	private String quartos;
	private String banheiros;
	
	public Casa() {
		this.objectos = -1;
		this.camas = "";
		this.quartos = "";
		this.banheiros = "";
	}
	
	public Casa(int objectos, String camas, String quartos, String banheiros) {
		this.objectos = objectos;
		this.camas = camas;
		this.quartos = quartos;
		this.banheiros = banheiros;
	}

	public int getObjectos() {
		return objectos;
	}

	public void setObjectos(int objectos) {
		this.objectos = objectos;
	}

	public String getCamas() {
		return camas;
	}

	public void setCamas(String camas) {
		this.camas = camas;
	}

	public String getQuartos() {
		return quartos;
	}

	public void setQuartos(String quartos) {
		this.quartos = quartos;
	}

	public String getBanheiros() {
		return banheiros;
	}

	public void setBanheiros(String banheiros) {
		this.banheiros = banheiros;
	}

	@Override
	public String toString() {
		return "Casa [objectos=" + objectos + ", camas=" + camas + ", quartos=" + quartos + ", banheiros=" + banheiros + "]";
	}	
}