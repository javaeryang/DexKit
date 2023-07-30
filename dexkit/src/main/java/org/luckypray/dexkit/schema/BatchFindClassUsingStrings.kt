// automatically generated by the FlatBuffers compiler, do not modify

package org.luckypray.dexkit.schema

import com.google.flatbuffers.Constants
import com.google.flatbuffers.FlatBufferBuilder
import com.google.flatbuffers.Table
import java.nio.ByteBuffer
import java.nio.ByteOrder

@Suppress("unused")
class BatchFindClassUsingStrings : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : BatchFindClassUsingStrings {
        __init(_i, _bb)
        return this
    }
    val findPackageName : StringMatcher? get() = findPackageName(StringMatcher())
    fun findPackageName(obj: StringMatcher) : StringMatcher? {
        val o = __offset(4)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    fun matchers(j: Int) : BatchUsingStringsMatcher? = matchers(BatchUsingStringsMatcher(), j)
    fun matchers(obj: BatchUsingStringsMatcher, j: Int) : BatchUsingStringsMatcher? {
        val o = __offset(6)
        return if (o != 0) {
            obj.__assign(__indirect(__vector(o) + j * 4), bb)
        } else {
            null
        }
    }
    val matchersLength : Int
        get() {
            val o = __offset(6); return if (o != 0) __vector_len(o) else 0
        }
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_23_5_26()
        fun getRootAsBatchFindClassUsingStrings(_bb: ByteBuffer): BatchFindClassUsingStrings = getRootAsBatchFindClassUsingStrings(_bb, BatchFindClassUsingStrings())
        fun getRootAsBatchFindClassUsingStrings(_bb: ByteBuffer, obj: BatchFindClassUsingStrings): BatchFindClassUsingStrings {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createBatchFindClassUsingStrings(builder: FlatBufferBuilder, findPackageNameOffset: Int, matchersOffset: Int) : Int {
            builder.startTable(2)
            addMatchers(builder, matchersOffset)
            addFindPackageName(builder, findPackageNameOffset)
            return endBatchFindClassUsingStrings(builder)
        }
        fun startBatchFindClassUsingStrings(builder: FlatBufferBuilder) = builder.startTable(2)
        fun addFindPackageName(builder: FlatBufferBuilder, findPackageName: Int) = builder.addOffset(0, findPackageName, 0)
        fun addMatchers(builder: FlatBufferBuilder, matchers: Int) = builder.addOffset(1, matchers, 0)
        fun createMatchersVector(builder: FlatBufferBuilder, data: IntArray) : Int {
            builder.startVector(4, data.size, 4)
            for (i in data.size - 1 downTo 0) {
                builder.addOffset(data[i])
            }
            return builder.endVector()
        }
        fun startMatchersVector(builder: FlatBufferBuilder, numElems: Int) = builder.startVector(4, numElems, 4)
        fun endBatchFindClassUsingStrings(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
