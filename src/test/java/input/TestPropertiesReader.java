package input;

import org.junit.Assert;
import org.junit.Test;

import util.PropertiesReader;

public class TestPropertiesReader {

	@Test
	public void readProperties(){
		PropertiesReader pr = new PropertiesReader();
		String user = pr.getUser();
		Assert.assertEquals(user, "alamm");
	}
}
