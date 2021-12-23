package com.djr.demo;

import com.djr.demo.account.TestCase_DeleteAccount;
import com.djr.demo.account.TestCase_CreateAccount;
import com.djr.demo.account.TestCase_RetrieveAccount;
import com.djr.demo.account.TestCase_UpdateAccount;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({TestCase_CreateAccount.class,
                     TestCase_RetrieveAccount.class,
                     TestCase_UpdateAccount.class,
                     TestCase_DeleteAccount.class})
public class TestSuites {
}
