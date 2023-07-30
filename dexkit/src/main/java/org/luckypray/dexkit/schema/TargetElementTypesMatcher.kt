// automatically generated by the FlatBuffers compiler, do not modify

package org.luckypray.dexkit.schema

import com.google.flatbuffers.Constants
import com.google.flatbuffers.FlatBufferBuilder
import com.google.flatbuffers.Table
import java.nio.ByteBuffer
import java.nio.ByteOrder

@Suppress("unused")
class TargetElementTypesMatcher : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : TargetElementTypesMatcher {
        __init(_i, _bb)
        return this
    }
    val matchType : Byte
        get() {
            val o = __offset(4)
            return if(o != 0) bb.get(o + bb_pos) else 0
        }
    fun mutateMatchType(matchType: Byte) : Boolean {
        val o = __offset(4)
        return if (o != 0) {
            bb.put(o + bb_pos, matchType)
            true
        } else {
            false
        }
    }
    fun types(j: Int) : Byte {
        val o = __offset(6)
        return if (o != 0) {
            bb.get(__vector(o) + j * 1)
        } else {
            0
        }
    }
    val typesLength : Int
        get() {
            val o = __offset(6); return if (o != 0) __vector_len(o) else 0
        }
    val typesAsByteBuffer : ByteBuffer get() = __vector_as_bytebuffer(6, 1)
    fun typesInByteBuffer(_bb: ByteBuffer) : ByteBuffer = __vector_in_bytebuffer(_bb, 6, 1)
    fun mutateTypes(j: Int, types: Byte) : Boolean {
        val o = __offset(6)
        return if (o != 0) {
            bb.put(__vector(o) + j * 1, types)
            true
        } else {
            false
        }
    }
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_23_5_26()
        fun getRootAsTargetElementTypesMatcher(_bb: ByteBuffer): TargetElementTypesMatcher = getRootAsTargetElementTypesMatcher(_bb, TargetElementTypesMatcher())
        fun getRootAsTargetElementTypesMatcher(_bb: ByteBuffer, obj: TargetElementTypesMatcher): TargetElementTypesMatcher {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createTargetElementTypesMatcher(builder: FlatBufferBuilder, matchType: Byte, typesOffset: Int) : Int {
            builder.startTable(2)
            addTypes(builder, typesOffset)
            addMatchType(builder, matchType)
            return endTargetElementTypesMatcher(builder)
        }
        fun startTargetElementTypesMatcher(builder: FlatBufferBuilder) = builder.startTable(2)
        fun addMatchType(builder: FlatBufferBuilder, matchType: Byte) = builder.addByte(0, matchType, 0)
        fun addTypes(builder: FlatBufferBuilder, types: Int) = builder.addOffset(1, types, 0)
        fun createTypesVector(builder: FlatBufferBuilder, data: ByteArray) : Int {
            builder.startVector(1, data.size, 1)
            for (i in data.size - 1 downTo 0) {
                builder.addByte(data[i])
            }
            return builder.endVector()
        }
        fun startTypesVector(builder: FlatBufferBuilder, numElems: Int) = builder.startVector(1, numElems, 1)
        fun endTargetElementTypesMatcher(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
