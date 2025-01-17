@file:Suppress("MemberVisibilityCanBePrivate", "unused", "INVISIBLE_REFERENCE", "INVISIBLE_MEMBER")

package org.luckypray.dexkit.query

import org.luckypray.dexkit.query.base.IQuery
import org.luckypray.dexkit.query.enums.StringMatchType
import org.luckypray.dexkit.query.matchers.BatchUsingStringsMatcher
import org.luckypray.dexkit.query.matchers.FieldMatcher
import org.luckypray.dexkit.query.matchers.UsingFieldMatcher
import org.luckypray.dexkit.query.matchers.base.NumberEncodeValueMatcher
import org.luckypray.dexkit.query.matchers.base.StringMatcher
import org.luckypray.dexkit.result.ClassData
import org.luckypray.dexkit.result.FieldData
import org.luckypray.dexkit.result.MethodData

class StringMatcherList : ArrayList<StringMatcher>, IQuery {
    constructor(): super()
    constructor(initialCapacity: Int): super(initialCapacity)
    constructor(elements: Collection<StringMatcher>): super(elements)

    @JvmOverloads
    fun add(
        value: String,
        matchType: StringMatchType = StringMatchType.Contains,
        ignoreCase: Boolean = false
    ) = also {
        add(StringMatcher(value, matchType, ignoreCase))
    }

    @kotlin.internal.InlineOnly
    inline fun add(init: StringMatcher.() -> Unit) = also {
        add(StringMatcher().apply(init))
    }
}

class FieldMatcherList : ArrayList<FieldMatcher>, IQuery {
    constructor(): super()
    constructor(initialCapacity: Int): super(initialCapacity)
    constructor(elements: Collection<FieldMatcher>): super(elements)

    fun add(init: FieldMatcher.() -> Unit) = also {
        add(FieldMatcher().apply(init))
    }

    @JvmOverloads
    fun addForType(
        typeName: String,
        matchType: StringMatchType = StringMatchType.Equals,
        ignoreCase: Boolean = false
    ) = also {
        add(FieldMatcher().apply { type(typeName, matchType, ignoreCase) })
    }

    fun addForName(name: String) = also {
        add(FieldMatcher().apply { name(name) })
    }
}

class UsingFieldMatcherList : ArrayList<UsingFieldMatcher>, IQuery {
    constructor(): super()
    constructor(initialCapacity: Int): super(initialCapacity)
    constructor(elements: Collection<UsingFieldMatcher>): super(elements)

    @kotlin.internal.InlineOnly
    inline fun add(init: UsingFieldMatcher.() -> Unit) = also {
        add(UsingFieldMatcher().apply(init))
    }
}

class NumberEncodeValueMatcherList : ArrayList<NumberEncodeValueMatcher>, IQuery {
    constructor(): super()
    constructor(initialCapacity: Int): super(initialCapacity)
    constructor(elements: Collection<NumberEncodeValueMatcher>): super(elements)

    // TODO add Object
    fun addByte(value: Byte) = also {
        add(NumberEncodeValueMatcher.createByte(value))
    }

    fun addShort(value: Short) = also {
        add(NumberEncodeValueMatcher.createShort(value))
    }

    fun addInt(value: Int) = also {
        add(NumberEncodeValueMatcher.createInt(value))
    }

    fun addLong(value: Long) = also {
        add(NumberEncodeValueMatcher.createLong(value))
    }

    fun addFloat(value: Float) = also {
        add(NumberEncodeValueMatcher.createFloat(value))
    }

    fun addDouble(value: Double) = also {
        add(NumberEncodeValueMatcher.createDouble(value))
    }

    @kotlin.internal.InlineOnly
    inline fun add(init: NumberEncodeValueMatcher.() -> Unit) = also {
        add(NumberEncodeValueMatcher().apply(init))
    }
}

class BatchUsingStringsMatcherList : ArrayList<BatchUsingStringsMatcher>, IQuery {
    constructor(): super()
    constructor(initialCapacity: Int): super(initialCapacity)
    constructor(elements: Collection<BatchUsingStringsMatcher>): super(elements)

    fun add(
        unionKey: String,
        matchers: List<StringMatcher>
    ) = also {
        add(BatchUsingStringsMatcher(unionKey, matchers))
    }

    fun add(
        unionKey: String,
        vararg matchers: StringMatcher
    ) = also {
        add(BatchUsingStringsMatcher(unionKey, matchers.toList()))
    }

    fun add(
        unionKey: String,
        ignoreCase: Boolean,
        vararg strings: String
    ) = also {
        add(BatchUsingStringsMatcher(unionKey, strings.map { StringMatcher(it, StringMatchType.SimilarRegex, ignoreCase) }))
    }

    fun add(
        unionKey: String,
        vararg strings: String
    ) = also {
        add(BatchUsingStringsMatcher(unionKey, strings.map { StringMatcher(it, StringMatchType.SimilarRegex, false) }))
    }

    @kotlin.internal.InlineOnly
    inline fun add(
        unionKey: String,
        init: StringMatcherList.() -> Unit
    ) = also {
        add(BatchUsingStringsMatcher(unionKey, StringMatcherList().apply(init)))
    }
}

class ClassDataList : ArrayList<ClassData>, IQuery {
    constructor(): super()
    constructor(initialCapacity: Int): super(initialCapacity)
    constructor(elements: Collection<ClassData>): super(elements)

    fun findClass(findClass: FindClass): ClassDataList {
        if (isEmpty()) return ClassDataList()
        val bridge = first().getBridge()
        findClass.searchInClass(this)
        return bridge.findClass(findClass)
    }

    @kotlin.internal.InlineOnly
    inline fun findClass(init: FindClass.() -> Unit): ClassDataList {
        return findClass(FindClass().apply(init))
    }

    fun findMethod(findMethod: FindMethod): MethodDataList {
        if (isEmpty()) return MethodDataList()
        val bridge = first().getBridge()
        findMethod.searchInClass(this)
        return bridge.findMethod(findMethod)
    }

    @kotlin.internal.InlineOnly
    inline fun findMethod(init: FindMethod.() -> Unit): MethodDataList {
        return findMethod(FindMethod().apply(init))
    }

    fun findField(findField: FindField): FieldDataList {
        if (isEmpty()) return FieldDataList()
        val bridge = first().getBridge()
        findField.searchInClass(this)
        return bridge.findField(findField)
    }

    @kotlin.internal.InlineOnly
    inline fun findField(init: FindField.() -> Unit): FieldDataList {
        return findField(FindField().apply(init))
    }
}

class MethodDataList : ArrayList<MethodData>, IQuery {
    constructor(): super()
    constructor(initialCapacity: Int): super(initialCapacity)
    constructor(elements: Collection<MethodData>): super(elements)

    fun findMethod(findMethod: FindMethod): MethodDataList {
        if (isEmpty()) return MethodDataList()
        val bridge = first().getBridge()
        findMethod.searchInMethod(this)
        return bridge.findMethod(findMethod)
    }

    @kotlin.internal.InlineOnly
    inline fun findMethod(init: FindMethod.() -> Unit): MethodDataList {
        return findMethod(FindMethod().apply(init))
    }
}

class FieldDataList : ArrayList<FieldData>, IQuery {
    constructor(): super()
    constructor(initialCapacity: Int): super(initialCapacity)
    constructor(elements: Collection<FieldData>): super(elements)
    fun findField(findField: FindField): FieldDataList {
        if (isEmpty()) return FieldDataList()
        val bridge = first().getBridge()
        findField.searchInField(this)
        return bridge.findField(findField)
    }

    @kotlin.internal.InlineOnly
    inline fun findField(init: FindField.() -> Unit): FieldDataList {
        return findField(FindField().apply(init))
    }
}
