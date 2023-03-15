public class CompteBancaire
{

	public final String numero;
	public final String proprietaire;
	protected double solde;

	public CompteBancaire(String numero, String proprietaire)
	{
		this.numero = numero;
		this.proprietaire = proprietaire;
		solde = 0;
	}

	public void deposer(double montant)
	{
		solde += montant;
	}

	public void retirer(double montant)
	{
		solde -= montant;
	}

	public double getSolde()
	{
		return solde;
	}

	public void traitementMensuel()
	{
	}

}
