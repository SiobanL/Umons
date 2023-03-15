public class CompteEpargne extends CompteBancaire
{

	private double soldeMinimum;
	public final double tauxInteret;

	public CompteEpargne(String numero, String proprietaire, double tauxInteret)
	{
		super(numero, proprietaire);
		this.tauxInteret = tauxInteret;
		soldeMinimum = solde;
	}

	@Override
	public void retirer(double montant)
	{
		super.retirer(montant);
		if (solde < soldeMinimum)
			soldeMinimum = solde;
	}

	@Override
	public void traitementMensuel()
	{
		solde += soldeMinimum * tauxInteret / 100;
		soldeMinimum = solde;
	}

}
