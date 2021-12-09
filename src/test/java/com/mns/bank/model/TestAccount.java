package com.mns.bank.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Spy;

import com.mns.bank.bean.AppException;

public class TestAccount {
	
	private Account account;
	
	@Before
	public void setUp() {
		account = new Account("Compte courant", 500d, 300d, null);
	}
	
	@Test
	public void testGetNum() {
		Assert.assertNull(account.getNum());
	}
	
	@Test
	public void testSetNum() {
		account.setNum(99l);
		Assert.assertEquals(99l, (long) account.getNum());
	}
	
	@Test
	public void testGetLabel() {
		Assert.assertEquals("Compte courant", account.getLabel());
	}
	
	@Test
	public void testSetLabel() {
		account.setLabel("Livret A");
		Assert.assertEquals("Livret A", account.getLabel());
	}
	
	@Test
	public void testGetSolde() {
		Assert.assertEquals(500d, (double) account.getSolde(), 0);
	}
	
	@Test
	public void testSetSolde() {
		account.setSolde(300d);
		Assert.assertEquals(300d, (double) account.getSolde(), 0);
	}
	
	@Test
	public void testGetOverdraftAllowed() {
		Assert.assertEquals(300d, (double) account.getOverdraftAllowed(), 0);
	}
	
	@Test
	public void testSetOverdraftAllowed() {
		account.setOverdraftAllowed(0d);
		Assert.assertEquals(0d, (double) account.getOverdraftAllowed(), 0);
	}
	
	@Test
	public void testGetClient() {
		Assert.assertNull(account.getClient());
	}
	
	@Test
	public void testSetClient() {
		Client client = new Client("TEST", "test@domain.com", "");
		account.setClient(client);
		Assert.assertSame(client, account.getClient());
	}
	
	@Test(expected = AppException.class) 
	public void testCreditNegativeAmountThrowsAppException() throws AppException {
		account.credit(-100d);
	}
	
	@Test
	public void testCredit() throws AppException {
		account.credit(100d);
		Assert.assertEquals(600d, (double) account.getSolde(), 0);
	}
	
	@Test(expected = AppException.class) 
	public void testWithdrawalNegatifAmountThrowsAppException() throws AppException {
		account.withdrawal(-100d);
	}
	
	@Test
	public void testWithdrawal() throws AppException {
		account.withdrawal(100d);
		Assert.assertEquals(400d, (double) account.getSolde(), 0);
	}
	
	@Test(expected = AppException.class)
	public void testWithdrawalOverLimitOverdraftAllowed() throws AppException {
		account.withdrawal(801d);
	}
	
	@Test
	public void testWithdrawalWithinLimitOverdraftAllowed() throws AppException {
		account.withdrawal(800);
		Assert.assertEquals(-300d, (double) account.getSolde(), 0);
	}
}
