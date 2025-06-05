package edu.ifms.br.empresa.domain;

public enum UF {
	
	AC("AC","Acre"),
	AL("AL","Alagoas"),
	AM("AM","Amazonas"),
	AP("AP","Amapá"),
	BA("BA","Bahia"),
	CE("CE","Ceará"),
	DF("DF","Distrito Federal"),
	ES("ES","Espírito Santo"),
	GO("GO","Goiás"),
	MA("MA","Maranhão"),
	MT("MT","Mato Grosso"),
	MS("MS","Mato Grosso do Sul"),
	MG("MG","Minas Gerais"),
	PA("PA","Pará"),
	PB("PB","Paraíba"),
	PE("PE","Pernambuco"),
	PI("PI","Piauí"),
	PR("PR","Paraná"),
	RJ("RJ","Rio de Janeiro"),
	RN("RN","Rio Grande do Norte"),
	RO("RO","Rondônia"),
	RR("RR","Roraima"),
	RS("RS","Rio Grande do Sul"),
	SC("SC","Santa Catarina"),
	SE("SE","Sergipe"),
	SP("SP","São Paulo"),
	TO("TO","Tocantins");

	
	private String sigla;
	private String descricao;
	
	UF(String sigla, String descricao){
		this.sigla = sigla;
		this.descricao = descricao;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
