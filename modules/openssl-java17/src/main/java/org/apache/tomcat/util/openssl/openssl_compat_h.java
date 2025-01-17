/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.tomcat.util.openssl;

import java.lang.invoke.MethodHandle;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;

/**
 * Methods used present in older OpenSSL versions but not in the current major version.
 */
public class openssl_compat_h  {

    // OpenSSL 1.1 FIPS_mode
    static final FunctionDescriptor FIPS_mode$FUNC = FunctionDescriptor.of(C_INT);
    static final MethodHandle FIPS_mode$MH = RuntimeHelper.downcallHandle(
        openssl_h.LIBRARIES, "FIPS_mode",
        "()I",
        FIPS_mode$FUNC, false
    );
    public static MethodHandle FIPS_mode$MH() {
        return RuntimeHelper.requireNonNull(FIPS_mode$MH,"FIPS_mode");
    }
    public static int FIPS_mode () {
        var mh$ = RuntimeHelper.requireNonNull(FIPS_mode$MH, "FIPS_mode");
        try {
            return (int)mh$.invokeExact();
        } catch (Throwable ex$) {
            throw new AssertionError("should not reach here", ex$);
        }
    }

    // OpenSSL 1.1 FIPS_mode_set
    static final FunctionDescriptor FIPS_mode_set$FUNC = FunctionDescriptor.of(C_INT,
            C_INT
        );
        static final MethodHandle FIPS_mode_set$MH = RuntimeHelper.downcallHandle(
            openssl_h.LIBRARIES, "FIPS_mode_set",
            "(I)I",
            FIPS_mode_set$FUNC, false
        );
    public static MethodHandle FIPS_mode_set$MH() {
        return RuntimeHelper.requireNonNull(FIPS_mode_set$MH,"FIPS_mode_set");
    }
    public static int FIPS_mode_set ( int r) {
        var mh$ = RuntimeHelper.requireNonNull(FIPS_mode_set$MH, "FIPS_mode_set");
        try {
            return (int)mh$.invokeExact(r);
        } catch (Throwable ex$) {
            throw new AssertionError("should not reach here", ex$);
        }
    }

}


