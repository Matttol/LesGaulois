package personnages;
public class Gaulois {
	private String nom;
	private int force;
	private Village village;
	private int effetPotion = 1;
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	public String getNom() {
		return nom;
	}
	public void setVillage(Village village) {
		this.village = village;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}
	private String prendreParole() {
		return "Le Gaulois " + nom + " : ";
	}
	public void sePresenter() {
		StringBuilder chaine = new StringBuilder("Bonjour, je m'appelle " + nom + ". ");
		if (village == null) {
			chaine.append("Je voyage de villages en villages.");
		} else {
			if (village.getChef().equals(this)) {
				chaine.append("Je suis le chef ");
			} else {
				chaine.append("J'habite ");
			}
			chaine.append("le village " + village.getNom() + ".");
		}
		parler(chaine.toString());
		}
	@Override
	public String toString() {
	return nom;
	}
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		romain.recevoirCoup(force * effetPotion / 3);
		effetPotion--;
		if (effetPotion < 1) {
			effetPotion = 1;
		}
	}
	public void boirePotion(int forcePotion) {
		this.effetPotion = forcePotion;
	}
}