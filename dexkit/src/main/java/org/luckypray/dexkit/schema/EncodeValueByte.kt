// automatically generated by the FlatBuffers compiler, do not modify

package org.luckypray.dexkit.schema

import com.google.flatbuffers.Constants
import com.google.flatbuffers.FlatBufferBuilder
import com.google.flatbuffers.Table
import java.nio.ByteBuffer
import java.nio.ByteOrder

@Suppress("unused")
class EncodeValueByte : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : EncodeValueByte {
        __init(_i, _bb)
        return this
    }
    val value : Byte
        get() {
            val o = __offset(4)
            return if(o != 0) bb.get(o + bb_pos) else 0
        }
    fun mutateValue(value: Byte) : Boolean {
        val o = __offset(4)
        return if (o != 0) {
            bb.put(o + bb_pos, value)
            true
        } else {
            false
        }
    }
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_23_5_26()
        fun getRootAsEncodeValueByte(_bb: ByteBuffer): EncodeValueByte = getRootAsEncodeValueByte(_bb, EncodeValueByte())
        fun getRootAsEncodeValueByte(_bb: ByteBuffer, obj: EncodeValueByte): EncodeValueByte {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createEncodeValueByte(builder: FlatBufferBuilder, value: Byte) : Int {
            builder.startTable(1)
            addValue(builder, value)
            return endEncodeValueByte(builder)
        }
        fun startEncodeValueByte(builder: FlatBufferBuilder) = builder.startTable(1)
        fun addValue(builder: FlatBufferBuilder, value: Byte) = builder.addByte(0, value, 0)
        fun endEncodeValueByte(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
