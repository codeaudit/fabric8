/**
 *  Copyright 2005-2014 Red Hat, Inc.
 *
 *  Red Hat licenses this file to you under the Apache License, version
 *  2.0 (the "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *  implied.  See the License for the specific language governing
 *  permissions and limitations under the License.
 */
package io.fabric8.utils.jcip;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The field or method to which this annotation is applied can only be accessed
 * when holding a particular lock, which may be a built-in (synchronization) lock,
 * or may be an explicit java.util.concurrent.Lock.
 *
 * The argument determines which lock guards the annotated field or method:
 * <ul>
 * <li>
 * <code>this</code> : The intrinsic lock of the object in whose class the field is defined.
 * </li>
 * <li>
 * <code>class-name.this</code> : For inner classes, it may be necessary to disambiguate 'this';
 * the <em>class-name.this</em> designation allows you to specify which 'this' reference is intended
 * </li>
 * <li>
 * <code>itself</code> : For reference fields only; the object to which the field refers.
 * </li>
 * <li>
 * <code>field-name</code> : The lock object is referenced by the (instance or static) field
 * specified by <em>field-name</em>.
 * </li>
 * <li>
 * <code>class-name.field-name</code> : The lock object is reference by the static field specified
 * by <em>class-name.field-name</em>.
 * </li>
 * <li>
 * <code>method-name()</code> : The lock object is returned by calling the named nil-ary method.
 * </li>
 * <li>
 * <code>class-name.class</code> : The Class object for the specified class should be used as the lock object.
 * </li>
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface GuardedBy {
    String value();
}
