public class CompteCourant extends CompteBancaire
{

	public static final int NOMBRE_RETRAITS_GRATUITS = 2;
	public static final double FRAIS_PAR_RETRAIT = 0.5;

	private int nombreRetraits;

	public CompteCourant(String numero, String proprietaire)
	{
		super(numero, proprietaire);
		nombreRetraits = 0;
	}

	@Override
	public void retirer(double montant)
	{
		super.retirer(montant);
		nombreRetraits++;
	}

	@Override
	public void traitementMensuel()
	{
		if (nombreRetraits > NOMBRE_RETRAITS_GRATUITS)
			solde -= FRAIS_PAR_RETRAIT * (nombreRetraits - NOMBRE_RETRAITS_GRATUITS);
		nombreRetraits = 0;
	}

}
