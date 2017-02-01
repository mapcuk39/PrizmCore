/******************************************************************************
 * Copyright © 2013-2016 The Nxt Core Developers.                             *
 *                                                                            *
 * See the AUTHORS.txt, DEVELOPER-AGREEMENT.txt and LICENSE.txt files at      *
 * the top-level directory of this distribution for the individual copyright  *
 * holder information and the developer policies on copyright and licensing.  *
 *                                                                            *
 * Unless otherwise agreed in a custom licensing agreement, no part of the    *
 * Nxt software, including this file, may be copied, modified, propagated,    *
 * or distributed except according to the terms contained in the LICENSE.txt  *
 * file.                                                                      *
 *                                                                            *
 * Removal or modification of this copyright notice is prohibited.            *
 *                                                                            *
 ******************************************************************************/

package prizm;

public final class Genesis {

    public static final long GENESIS_BLOCK_ID = 8120160751476308816L;
    public static final long CREATOR_ID = 1925839945128282178L;
    public static final byte[] CREATOR_PUBLIC_KEY = {
        -122, -110, 127, -2, -12, 113, 96, 1, -9, 9, 29, 17, -35, 22, -51, 54,
        -60, 86, -110, 50, 6, 29, -63, 52, 62, -53, -116, -30, 11, -21, 123, 50
    };

    public static final long[] GENESIS_RECIPIENTS = {
            Long.parseUnsignedLong("8934997148161768414"),
            Long.parseUnsignedLong("2392307672873401310"),
            Long.parseUnsignedLong("4598282270264000511"),
            Long.parseUnsignedLong("8573896484901059550"),
            Long.parseUnsignedLong("4374989088324811742")
    };


    public static final int[] GENESIS_AMOUNTS = {
            2000000,
            2000000,
            2000000,
            2000000,
            2000000
    };

    public static final byte[][] GENESIS_SIGNATURES = {
            {65, -87, 26, -37, -73, 62, -45, 30, 106, -58, -66, 10, 5, 47, -111, -39, 94, 41, 78, -102, -3, -53, 103, -13, -21, -33, 25, -91, 91, -52, 7, 5, 0, 12, 107, 57, 16, -81, 106, -97, -11, 37, 90, -71, -87, -91, 33, -124, -27, -22, -100, 107, 20, -115, -122, -80, -108, 2, 64, -9, 32, -80, -112, 0},
            {-79, -89, -19, -40, 4, -90, 102, -103, 67, -6, 94, 110, 119, -78, -102, -83, -55, 15, -82, 66, 50, 64, -9, -123, -34, -68, -28, 56, 101, 94, -105, 1, 31, -83, -37, 94, 44, 13, -91, -54, -88, -90, -117, 88, -20, -112, 45, 33, -97, -97, -13, 63, 55, -77, -126, -26, -96, 20, -102, 31, -79, -113, 15, 12},
            {-15, 52, 10, 1, -16, -80, 4, -96, -4, 42, 26, 61, -75, -24, 22, -119, -35, 35, -56, 103, 50, -8, -90, 122, 0, 109, 0, -75, -12, -44, -98, 2, -19, 118, 82, -126, -62, 43, -107, -8, 19, 93, -10, -28, -13, 56, 119, -103, 22, 60, -125, -72, -34, 49, 88, -61, 69, -90, 51, -21, -1, 78, 12, 96},
            {81, -24, 26, -109, -58, -36, -44, -70, -75, 81, -108, 39, -86, -7, 51, 28, 102, 126, 81, 107, 54, 86, 112, -96, -120, 64, 63, -109, 31, 4, -74, 15, -110, -45, -35, -18, -88, 62, 44, 18, 85, -89, -14, 100, -3, 41, -122, -108, 70, 73, 90, -91, 108, 30, 4, -59, 73, 84, -92, -69, 125, 51, -104, -38},
            {61, -72, -38, 90, -29, -7, 83, -11, -106, 125, 58, -101, 41, 34, 50, 30, -22, -67, 55, 84, -16, 94, -79, 11, -99, -96, 83, -27, -69, 56, 79, 10, -101, 31, -128, 48, -90, 98, -105, -113, -91, -88, -104, 108, -88, 41, 115, -124, -26, 114, 43, -37, -18, 66, -70, -8, 44, 78, 60, -62, -60, -71, 107, 79},
        };

    public static final byte[] GENESIS_BLOCK_SIGNATURE = new byte[]{
    	    11, 114, -110, 113, 102, 11, -110, -58, 0, -123, 40, 104, 26, 26, -116, 89, -102, -48, -35, 76, 35, 45, 57, 125, 81, 10, -62, -109, 77, -8, -121, 12, 31, 127, 86, -8, 0, -37, 71, -89, 67, 32, 56, 123, -79, 55, -40, 109, 47, -8, 48, 60, -96, -88, 54, -29, -4, -76, -11, 39, 33, -117, -19, 78
    };

    private Genesis() {} // never

}
