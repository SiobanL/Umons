public class TestCompte
{

	public static void main(String [] args)
	{
		CompteBancaire [] comptes = {
			new CompteCourant("BE86532454", "Bilbo"),
			new CompteEpargne("BE86532456", "Frodon", 1.1)
		};

		// --- 1er mois ---
		comptes[0].deposer(100);
		comptes[0].deposer(200);
		comptes[0].retirer(20);
		comptes[0].retirer(15);
		comptes[0].retirer(15);

		comptes[1].deposer(100);
		comptes[1].retirer(20);
		comptes[1].retirer(15);

		for (CompteBancaire compte: comptes) {
			compte.traitementMensuel();
			System.out.println(compte.numero + " " + compte.proprietaire + " : " + compte.getSolde());
		}

		// --- 2ème mois ---
		comptes[0].retirer(10);
		comptes[0].retirer(20);
		comptes[0].retirer(15);
		comptes[0].retirer(15);

		comptes[1].deposer(50);
		comptes[1].retirer(20);
		comptes[1].retirer(45);

		for (CompteBancaire compte: comptes) {
			compte.traitementMensuel();
			System.out.println(compte.numero + " " + compte.proprietaire + " : " + compte.getSolde());
		}
	}

}
