package model;

public class Medal {
	
	private CompetitionGenre competitionGenre;
	private MedalMaterial medalMaterial;
	
	Medal(CompetitionGenre copetitionGenre, MedalMaterial medalMaterial )
	{
		this.competitionGenre = copetitionGenre;
		this.medalMaterial = medalMaterial;
	}

	public CompetitionGenre getCompetitionGenre() {
		return competitionGenre;
	}

	public MedalMaterial getMedalMaterial() {
		return medalMaterial;
	}

	public void setCompetitionGenre(CompetitionGenre competitionGenre) {
		this.competitionGenre = competitionGenre;
	}

	public void setMedalMaterial(MedalMaterial medalMaterial) {
		this.medalMaterial = medalMaterial;
	}

	
}
