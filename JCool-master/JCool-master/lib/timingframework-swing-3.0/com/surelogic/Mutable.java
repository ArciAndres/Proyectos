/*
 * Copyright (c) 2011 SureLogic, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.surelogic;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * The class to which this annotation is applied is mutable, that is, has state
 * that is changeable. This annotation primarily exists for clarifying the
 * mutability of a class that might otherwise be assumed to be immutable,
 * despite the fact that it is a bad idea to assume a class is immutable without
 * good reason.
 * <p>
 * This annotation is trusted, i.e., it is <em>not verified</em>. Its use is for
 * documentation.
 * 
 * <h3>Semantics:</h3>
 * 
 * Instances of the type to which this annotation is applied have state that can
 * be seen to change by callers.
 * 
 * <h3>Examples:</h3>
 * 
 * The <tt>Aircraft</tt> class below is declared to be mutable because its
 * position can be changed. Its implementation is also thread-safe, however, not
 * all mutable classes are also thread-safe.
 * 
 * <pre>
 * &#064;Mutable
 * public class Aircraft {
 *   private final Lock stateLock = new ReentrantLock();
 *   ...
 *   &#064;GuardedBy(&quot;stateLock&quot;)
 *   private long x, y;
 *   ...
 *   public void setPosition(long x, long y) {
 *     stateLock.lock();
 *     try {
 *       this.x = x;
 *       this.y = y;
 *     } finally {
 *       stateLock.unlock();
 *     }
 *   }
 *   ...
 * }
 * </pre>
 * 
 * <h3>Javadoc usage notes:</h3>
 * 
 * This annotation may placed in Javadoc, which can be useful for Java 1.4 code
 * which does not include language support for annotations, via the
 * <code>&#064;annotate</code> tag.
 * 
 * <pre>
 * /**
 *  * &#064;annotate Mutable
 *  *&#047;
 * public class Aircraft {
 *   ...
 * }
 * </pre>
 * 
 * @see Immutable
 */
@Documented
@Target(ElementType.TYPE)
public @interface Mutable {
  // Marker annotation
}
