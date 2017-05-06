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
 * Declares the regions that may be read or written during execution of the
 * method or constructor to which this annotation is applied. In general the
 * annotation syntax is
 * <p>
 * <code>&#064;RegionEffects("reads</code> <i>readTarget</i>
 * <code>, ... ; writes</code> <i>writeTarget</i><code>, ... ")</code>
 * <p>
 * The annotation contains <code>reads</code> and <code>writes</code> clauses
 * that each have a list of one or more targets. The <code>reads</code> clause
 * describes the data that may be read by the method/constructor; the
 * <code>writes</code> clause describes the state that may be read or written by
 * the method/constructor. Because writing includes reading, there is no need to
 * list a target in the <code>reads</code> clause if its state is already
 * described in the <code>writes</code> clause.
 * <p>
 * Both the <code>reads</code> and <code>writes</code> clauses are optional: to
 * indicate that there are no effects use
 * <code>&#064;RegionEffects("none")</code>. An unannotated method is assumed to
 * have the annotation <code>&#064;RegionEffects("writes All")</code> which
 * declares that the method could read from or write to any state in the
 * program.
 * <p>
 * A target is an extrinsic syntactic mechanism to name references to regions,
 * and can be one of
 * <dl>
 * <dt>Region
 * <dt>
 * <dd>If <b>region</b> is an instance region, then it is the same as
 * {@code this:region} (see below). If <b>region</b> is a {@code static} region,
 * it must be a region declared in the annotated class or one of its ancestors,
 * and the method affects the given region.
 * <dt>this:Region</dt>
 * <dd><b>Region</b> is an instance region of the class containing the method.
 * The method affects the named region of the receiver object.</dd>
 * <dt>param:Region</dt>
 * <dd><b>param</b> is a parameter of the method that references an object.
 * <b>Region</b> is a region of the class of <b>param</b>'s type. The method
 * affects the named region of the object referenced by <b>param</b> at the
 * start of the method's execution.</dd>
 * <dt>pkg.C.this:Region</dt>
 * <dd><code>pkg.C</code> is an "outer class" of the class that contains the
 * annotated method. That is, the method being annotated is in class
 * <code>D</code>, and <code>D</code> is an inner class of <code>C</code>.
 * <b>Region</b> is a region of <code>pkg.C</code>. The method affects the named
 * region of the given outer class receiver.</dd>
 * <dt>any(pkg.C):Region</dt>
 * <dd><code>pkg.C</code> is a class name and <b>Region</b> is a region of
 * <code>pkg.C</code>. This target indicates that the method affects the given
 * region of any object of class <code>pkg.C</code>.</dd>
 * <dt>pkg.C:Region</dt>
 * <dd><b>Region</b> is a <code>static</code> region of class <code>pkg.C</code>
 * . The method affects the given <code>static</code> region.
 * </dl>
 * 
 * The analysis checks that the actual effects of the method implementation are
 * no greater than its declared effects. There are several fine points to this:
 * <ul>
 * <li>Uses of {@code final} fields produce no effects and do not need to be
 * declared.</li>
 * <li>Effects on local variables are not visible outside of a
 * method/constructor and do not need to be declared.</li>
 * <li>Effects on objects created within a method are not visible outside of a
 * method and do not need to be declared.</li>
 * <li>Constructors do not have to declare the effects on the {@code Instance}
 * region of the object under construction.</li>
 * <li>Region aggregation (see {@link Unique} and {@link UniqueInRegion}) is
 * taken into account.</li>
 * </ul>
 * 
 * <h3>Semantics:</h3>
 * 
 * States the upper-bound effects of an annotated method or constructor on the
 * Java heap. These effects do not include the stack of any thread. An
 * implementation of a method or constructor is consistent with its declared
 * {@link RegionEffects} if all possible executions read and write only to the
 * state specified in the annotation.
 * 
 * <h3>Examples:</h3>
 * 
 * Here is a simple "variable" class with effects annotations.
 * 
 * <pre>
 * &#064;Region(&quot;public ValueRegion&quot;)
 * public class Var {
 * 
 *   &#064;InRegion(&quot;ValueRegion&quot;)
 *   private int value;
 * 
 *   &#064;RegionEffects(&quot;none&quot;)
 *   public Var(int v) {
 *     value = v;
 *   }
 * 
 *   &#064;RegionEffects(&quot;reads ValueRegion&quot;)
 *   public int getValue() {
 *     return value;
 *   }
 * 
 *   &#064;RegionEffects(&quot;writes ValueRegion&quot;)
 *   public void setValue(int v) {
 *     value = v;
 *   }
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
 *  * @annotate Region(&quot;public ValueRegion&quot;)
 *  &#42;/
 * public class Var {
 * 
 *   /**
 *    * @annotate InRegion(&quot;ValueRegion&quot;)
 *    &#42;/
 *   private int value;
 * 
 *   /**
 *    * @annotate RegionEffects(&quot;none&quot;)
 *    &#42;/
 *   public Var(int v) {
 *     value = v;
 *   }
 * 
 *   /**
 *    * @annotate RegionEffects(&quot;reads ValueRegion&quot;)
 *    &#42;/
 *   public int getValue() {
 *     return value;
 *   }
 * 
 *   /**
 *    * @annotate RegionEffects(&quot;writes ValueRegion&quot;)
 *    &#42;/
 *   public void setValue(int v) {
 *     value = v;
 *   }
 * }
 * </pre>
 */
@Documented
@Target({ ElementType.METHOD, ElementType.CONSTRUCTOR })
public @interface RegionEffects {
  /**
   * This attribute is either {@code "none"} to indicate that the
   * method/constructor has no visible effects or divided into separate (and
   * optional) reads and writes clauses. Each clause is a list of
   * comma-separated targets describing the regions that may be read/written.
   * The clauses are separated by a semicolon.
   * 
   * <h3>Examples:</h3>
   * 
   * <pre>
   * &#064;RegionEffects(&quot;reads this:Instance; writes other:Instance&quot;)
   * &#064;RegionEffects(&quot;writes C:StaticRegion, any(D):Instance; reads this:Instance&quot;)
   * &#064;RegionEffects(&quot;reads this:Instance&quot;)
   * &#064;RegionEffects(&quot;writes this:Instance&quot;)
   * &#064;RegionEffects(&quot;none&quot;)
   * </pre>
   * 
   * The value of this attribute must conform to the following grammar (in <a
   * href="http://www.ietf.org/rfc/rfc4234.txt">Augmented Backus&ndash;Naur
   * Form</a>):
   * 
   * <pre>
   * value =
   *   none /  ; No effects
   *   readsEffect [&quot;;&quot; writesEffect] /
   *   writesEffect [&quot;;&quot; readsEffect]
   * 
   * readsEffect = &quot;reads&quot; effectsSpecification
   * 
   * writesEffect = &quot;writes&quot; effectsSpecification
   * 
   * effectsSpecification = &quot;nothing&quot; / effectSpecification *(&quot;,&quot; effectSpecification)
   *   
   * effectSpecification =
   *   simpleEffectExpression &quot;:&quot; simpleRegionSpecification /
   *   IDENTIFIER   ; instance region of &quot;this&quot; or a static region declared in the current class or one of its ancestors 
   * 
   * simpleEffectExpression =
   *   &quot;any&quot; &quot;(&quot; namedType &quot;)&quot; /    ; any instance
   *   namedType &quot;.&quot; &quot;this&quot; /       ; qualified this expression
   *   namedType /                  ; class name 
   *   simpleExpression             ; parameter name
   * 
   * namedType = IDENTIFIER *(&quot;.&quot; IDENTIFIER)
   * 
   * simpleExpression = &quot;this&quot; / IDENTIFIER
   * 
   * simpleRegionSpecification = IDENTIFIER  ; Region of the class being annotated
   * 
   * IDENTIFIER = Legal Java Identifier
   * </pre>
   */
  String value();
}
