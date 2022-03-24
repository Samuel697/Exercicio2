

public class Principal {
	
	public static void main(String[] args) {
		
		DAO dao = new DAO();
		
		dao.conectar();

		
		//Inserir um elemento na tabela
		Casa casa = new Casa(11, "varias", "tres","3");
		if(dao.inserirCasa(casa) == true){
			System.out.println("Inserção com sucesso -> " + casa.toString());
		}
		
		System.out.println("==Mostrar casas==");
		Casa[]casas=dao.getCasas();
		for(int i=0;i<casas.length;i++) {
			System.out.println(casas[i].toString());
	}
	//atualizar usuario
	casa.setCamas("Nova cama");
	dao.atualizarCasa(casa);
	casa.setQuartos("Novos quartos");
	dao.atualizarCasa(casa);
	casa.setBanheiros("Novos banheiros");
	dao.atualizarCasa(casa);
		
	System.out.println("==== Mostrar casa === ");
		casas=dao.getCasas();
		for(int i = 0; i < casas.length; i++) {
			System.out.println(casas[i].toString());
		}
		//excluir casa
		dao.excluirCasa(casa.getObjectos());
		//mostrar casas
		for(int i=0;i<casas.length;i++) {
			System.out.println(casas[i].toString());
		}
		dao.close();
	}
}