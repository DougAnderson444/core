/*
 * Copyright (c) 2012-2020 MIRACL UK Ltd.
 *
 * This file is part of MIRACL Core
 * (see https://github.com/miracl/core).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/* test driver and function exerciser for KYBER API Functions */

package org.miracl.core;

import java.util.Scanner;
import junit.framework.TestCase;       //
import org.miracl.core.KYBER;

public class TestKYBER extends TestCase {
    public static void testKYBER() {
        int i;
        byte[] R64 = new byte[64];
        byte[] R32 = new byte[32];
		byte[] SK= new byte[KYBER.SECRET_CCA_SIZE_768];
		byte[] PK= new byte[KYBER.PUBLIC_SIZE_768];
		byte[] SS=new byte[KYBER.SHARED_SECRET_768];
		byte[] CT=new byte[KYBER.CIPHERTEXT_SIZE_768];
        for (i = 0; i < 64; i++) R64[i] = (byte)(i + 2);
        for (i = 0; i < 32; i++) R32[i] = (byte)(i + 3);

		KYBER.keypair768(R64,SK,PK);

		System.out.printf("Secret Key length= %d\n",SK.length);

        System.out.printf("Secret key= 0x");
        for (i = 0; i < SK.length; i++)
            System.out.printf("%02x", SK[i]);
        System.out.println();


        System.out.printf("Public key= 0x");
        for (i = 0; i < PK.length; i++)
            System.out.printf("%02x", PK[i]);
        System.out.println();

		KYBER.encrypt768(R32,PK,SS,CT);

		System.out.printf("Ciphertext= 0x");
		for (i=0;i<CT.length;i++ )
			System.out.printf("%02x",CT[i]);
        System.out.println();


        System.out.printf("Shared secret= 0x");
        for (i = 0; i < SS.length; i++)
            System.out.printf("%02x", SS[i]);	
        System.out.println();

		KYBER.decrypt768(SK,CT,SS);

        System.out.printf("Shared secret= 0x");
        for (i = 0; i < SS.length; i++)
            System.out.printf("%02x", SS[i]);	
        System.out.println();

    }
}
