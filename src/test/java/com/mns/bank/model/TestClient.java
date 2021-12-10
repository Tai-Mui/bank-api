package com.mns.bank.model;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestClient {
	
	private Client client;
	
	@Before
	public void setUp() {
		client = new Client("Test", "test@domain.com", "pwd");
	}
	
	@Test
	public void testGetNumClient() {
		Assert.assertNull(client.getNumClient());
	}
	
	@Test
	public void testSetNumClient() {
		client.setNumClient(99l);
		Assert.assertEquals(99l, (long) client.getNumClient());
	}

	@Test
	public void testGetName() {
		Assert.assertEquals("Test", client.getName());
	}
	
	@Test
	public void testSetName() {
		client.setName("Toto");
		Assert.assertEquals("Toto", client.getName());
	}
	
	
	@Test
	public void testGetEmail() {
		Assert.assertEquals("test@domain.com", client.getEmail());
	}
	
	@Test
	public void testSetEmail() {
		client.setEmail("another@domain.com");
		Assert.assertEquals("another@domain.com", client.getEmail());
	}
	
	@Test
	public void testGetPassword() {
		Assert.assertEquals("pwd", client.getPassword());
	}
	
	@Test
	public void testSetPassword() {
		client.setPassword("NewPassword");
		Assert.assertEquals("NewPassword", client.getPassword());
	}
	
	@Test
	public void testGetAccounts() {
		Assert.assertNull("pwd", client.getAccounts());
	}
	
	@Test
	public void testSetAccounts() {
		List<Account> accounts = new ArrayList<>();
		Account account1 = new Account("Compte courant", 500d, 300d, null);
		Account account2 = new Account("PEL", 10000d, 0d, null);
		accounts.add(account1);
		accounts.add(account2);
		client.setAccounts(accounts);
		Assert.assertEquals(accounts, client.getAccounts());
	}
}
