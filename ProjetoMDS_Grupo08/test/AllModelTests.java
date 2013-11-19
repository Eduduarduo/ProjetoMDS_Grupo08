package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DadoTest.class, UnidadeFederativaTest.class, BrasilTest.class, RegiaoMetropolitanaTest.class })
public class AllModelTests {

}
