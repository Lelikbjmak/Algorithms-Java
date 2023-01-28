package Strings.Count_Ip_Adress;

public class CountIpAddresses {

    private static final long ipConst = 256;

    public static long ipsBetween(String start, String end) {
        // 77.88.21.8 = 77 * 256^3 + 88 * 256^2 + ...
        return convertIpAddressToLongValue(end) - convertIpAddressToLongValue(start);
    }

    private static long convertIpAddressToLongValue(String ip){

        String[] ips = ip.split("\\.");

        long longIpAddress = 0;

        for (int i = 0; i < 4; i++)  // from end to start 77.88.21.8  8 -> 77
            longIpAddress += Long.parseLong(ips[i]) * Math.pow(ipConst, 4 - 1 -i);

        return longIpAddress;
    }

}
