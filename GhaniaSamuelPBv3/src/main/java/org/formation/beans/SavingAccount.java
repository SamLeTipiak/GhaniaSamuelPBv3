package org.formation.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * <b>SavingAccount repr�sente les comptes �pargne ouverts chez ProxiBanque.</b>
 * <p>Chaque compte �pargne est caract�ris� par :
 * <ul>
 * <li>SAVINGRATE : la r�mun�ration du compte</li>
 * </ul>
 * </p>
 * <p>Chaque compte �pargne est aussi associ� � un client.</p>
 * @author Bouchet Samuel - Ghania Bouzemame
 * @version 3.0
 *
 */
@Entity
public class SavingAccount extends Account {
	private static float SAVINGRATE = 0.03f;

	@OneToOne(mappedBy = "savingAccount", cascade = CascadeType.ALL)
	@JoinColumn(name = "account_id")
	private Client client;

	public SavingAccount() {
		super();
	}

	public SavingAccount(double sold, String openDate) {
		super(sold, openDate);
		super.accountRate = SAVINGRATE;
	}

	public SavingAccount(long accountNumber, double sold, String openDate) {
		super(accountNumber, sold, openDate);
		super.accountRate = SAVINGRATE;
	}

	public SavingAccount(long idAccount, long accountNumber, double sold, String openDate) {
		super(idAccount, accountNumber, sold, openDate);
		super.accountRate = SAVINGRATE;
	}

	public SavingAccount(long accountNumber, double sold, String openDate, float accountRate) {
		super(accountNumber, sold, openDate);
		super.accountRate = SAVINGRATE;
	}

	public double getAccountRate() {
		return accountRate;
	}

	public void setAccountRate(float accountRate) {
		this.accountRate = accountRate;
	}

	public static float getSAVINGRATE() {
		return SAVINGRATE;
	}

	public static void setSAVINGRATE(float sAVINGRATE) {
		SAVINGRATE = sAVINGRATE;
	}

}
