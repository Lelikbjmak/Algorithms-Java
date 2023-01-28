package Strings.Count_Ip_Adress;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountIpAddressesTest {

    @Test
    public void ipsBetween() throws Exception {
        assertEquals( 50, CountIpAddresses.ipsBetween( "10.0.0.0", "10.0.0.50" ) );
        assertEquals( 246, CountIpAddresses.ipsBetween( "20.0.0.10", "20.0.1.0" ) );
        assertEquals( (1l << 32l) - 1l, CountIpAddresses.ipsBetween( "0.0.0.0", "255.255.255.255" ) );
    }

}
